package org.hfut.aop;

import com.auth0.jwt.interfaces.Claim;
import org.aspectj.lang.ProceedingJoinPoint;
import org.hfut.annotation.Log;
import org.hfut.mapper.SystemLogMapper;
import org.hfut.tool.global.SystemContent;
import org.hfut.tool.global.Token;
import org.hfut.tool.systemlog.SystemLogTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * SystemLog
 *
 * @author WeiXin
 * @date 2019/1/13
 **/
@Component
public class SystemLog {

    private final static byte FAILURE = 0;
    private final static byte SUCCESS = 1;
    private final static byte REFUSED = 2;

    private SystemLogMapper systemLogMapper;
    private ProceedingJoinPoint joinPoint;
    private String methodName;
    private Map<String, Object> resultMap;
    private org.hfut.pojo.SystemLog systemLog;
    private boolean passInspection = false;
    private String token;
    private Integer projectPeopleId;
    private Byte permissions;
    private Log log;
    private boolean forceWrite;
    private boolean stopWrite;

    @Autowired
    public SystemLog(SystemLogMapper systemLogMapper) {
        this.systemLogMapper = systemLogMapper;
    }


    public Object doSystemLog(ProceedingJoinPoint joinPoint) {

        try {
            return joinPoint.proceed();
        } catch(Throwable throwable) {
            throwable.printStackTrace();
        }


        init(joinPoint);
        if(SystemLogTool.isLoginMethod(methodName)) {
            doLoginLog();
        } else {
            verifyToken();
            doCommonLog();
            if(passInspection) {
                execute();
            } else {
                setResultState(FAILURE, "TokenCheckFailed");
            }
        }
        writeLog();
        return resultMap;
    }

    private void init(ProceedingJoinPoint joinPoint) {
        systemLog = new org.hfut.pojo.SystemLog();
        resultMap = new HashMap<>(3);
        this.joinPoint = joinPoint;
        methodName = joinPoint.getSignature().getName();
        HttpServletRequest request = SystemContent.getRequest();
        token = request.getHeader("token");
        log = SystemLogTool.getMethodLogInfo(joinPoint);
        forceWrite = false;
        stopWrite = false;

        systemLog.setErrorMsg(null);
        resultMap.put("data", null);
        resultMap.put("result", FAILURE);
        resultMap.put("msg", null);
    }

    private void doLoginLog() {
        execute();
        token = (String) ((Map<String, Object>) resultMap.get("data")).get("token");
        if(token != null) {
            verifyToken();
            doCommonLog();
            forceWrite = true;
        }
        stopWrite = true;
    }

    private void execute() {
        if(verifyPermission()) {
            try {
                resultMap.put("data", joinPoint.proceed());
                setResultState(SUCCESS, "success");
            } catch(Throwable throwable) {
                setResultState(FAILURE, "SystemError");
                writeErrorMsg(throwable);
            }
        } else {
            setResultState(REFUSED, "PermissionCheckFailed");
        }
    }

    private void verifyToken() {
        Object tokenVerifyResult = Token.verifyToken(token);
        Map<String, Claim> claimMap;
        if(tokenVerifyResult.getClass().equals(Boolean.class)) {
            passInspection = false;
            stopWrite = true;
        } else {
            claimMap = (Map<String, Claim>) tokenVerifyResult;
            projectPeopleId = claimMap.get("projectPeopleId").asInt();
            permissions = claimMap.get("permissions").asInt().byteValue();
            passInspection = true;
        }
    }

    private Boolean verifyPermission() {
        return (permissions & log.permission()) != 0;
    }

    private void doCommonLog() {
        systemLog.setLogTime(new Date());
        systemLog.setAction(log.serviceDescription());
        systemLog.setActionPeopleId(projectPeopleId);
        systemLog.setLogMsg(SystemLogTool.getLogMsg(joinPoint));
    }

    private void setResultState(byte state, String msg) {
        systemLog.setResult(state);
        resultMap.put("result", state);
        resultMap.put("msg", msg);
    }

    private void writeErrorMsg(Throwable throwable) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);

        throwable.printStackTrace(pw);
        systemLog.setErrorMsg(sw.toString());
        pw.close();
        try {
            sw.close();
        } catch(IOException e) {
            systemLog.setErrorMsg(systemLog.getErrorMsg() + ",StringWriterCloseError");
        }

        forceWrite = true;
    }

    private void writeLog() {
        if(canWrite()) {
            systemLogMapper.insert(systemLog);
        }
    }

    private boolean canWrite() {
        if(stopWrite) {
            return false;
        } else if(forceWrite) {
            return true;
        } else {
            return log.needLog();
        }
    }
}
