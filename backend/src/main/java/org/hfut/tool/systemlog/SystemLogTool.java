package org.hfut.tool.systemlog;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.hfut.annotation.Log;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * SystemLogTool
 *
 * @author WeiXin
 * @date 2019/1/13
 **/
public class SystemLogTool {

    public static Boolean isLoginMethod(String methodName) {
        switch(methodName) {
            case "login":
                return true;
            default:
                return false;
        }
    }

    public static Log getMethodLogInfo(ProceedingJoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        Log log = method.getDeclaredAnnotation(Log.class);
        if(log == null) {
            throw new RuntimeException("NullLogInfoError");
        }
        return log;
    }

    public static String getLogMsg(ProceedingJoinPoint joinPoint) {
        Map<String, Object> logMsgMap = new HashMap<>(2);
        Map<String, Object> paraMap = new HashMap<>(11);
        ObjectMapper objectMapper = new ObjectMapper();

        getParaMap(joinPoint, paraMap);
        logMsgMap.put("Method", joinPoint.getSignature().getDeclaringType() + "." + joinPoint.getSignature().getName());
        logMsgMap.put("Parameters", paraMap);

        try {
            return objectMapper.writeValueAsString(logMsgMap);
        } catch(JsonProcessingException e) {
            e.printStackTrace();
            return "Serialization Failure";
        }
    }

    private static void getParaMap(ProceedingJoinPoint joinPoint, Map<String, Object> paraMap) {
        Object[] args = joinPoint.getArgs();
        String[] paraNames = ((MethodSignature) joinPoint.getSignature()).getParameterNames();
        Class[] paraTypes = ((MethodSignature) joinPoint.getSignature()).getParameterTypes();

        for(int i = 0; i < args.length; i++) {
            if(needLogParaType(paraTypes[i])) {
                paraMap.put(paraNames[i], args[i]);
            }
        }
    }

    private static Boolean needLogParaType(Class paraType) {
        switch(paraType.getSimpleName()) {
            case "HttpSession":
            case "HttpServletRequest":
            case "HttpServletResponse":
            case "Model":
                return false;
            default:
                return true;
        }
    }

    public static boolean isCommonMethod(String methodName) {
        return "registerCheck".equals(methodName);
    }
}
