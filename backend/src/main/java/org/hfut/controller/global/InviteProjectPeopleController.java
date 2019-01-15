package org.hfut.controller.global;

import org.hfut.annotation.Log;
import org.hfut.mapper.ProjectPeopleMapper;
import org.hfut.pojo.ProjectPeople;
import org.hfut.pojo.WaitingRegisterPeople;
import org.hfut.service.global.InviteProjectPeopleService;
import org.hfut.tool.global.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * AddProjectPeopleController
 *
 * @author WeiXin
 * @date 2019/1/14
 **/
@Controller
public class InviteProjectPeopleController {

    private InviteProjectPeopleService inviteProjectPeopleService;
    private DataSourceTransactionManager transactionManager;
    private ProjectPeopleMapper projectPeopleMapper;

    @Autowired
    public InviteProjectPeopleController(InviteProjectPeopleService inviteProjectPeopleService,
                                         DataSourceTransactionManager transactionManager,
                                         ProjectPeopleMapper projectPeopleMapper) {
        this.inviteProjectPeopleService = inviteProjectPeopleService;
        this.transactionManager = transactionManager;
        this.projectPeopleMapper = projectPeopleMapper;
    }

    @Log(needLog = true, serviceDescription = "邀请人员", permission = 12)
    @RequestMapping(value = "/addUser", method = RequestMethod.GET)
    @ResponseBody
    @Transactional
    public Map<String, Object> invitePeople(@RequestParam(name = "name") String name,
                                            @RequestParam(name = "email") String email,
                                            @RequestParam(name = "phoneNum") String phoneNumber,
                                            @RequestParam(name = "type") Integer type,
                                            @RequestParam(name = "departmentId") Integer departmentId,
                                            HttpServletRequest request) {
        DefaultTransactionDefinition defaultTransactionDefinition = new DefaultTransactionDefinition();
        defaultTransactionDefinition.setName("transactionManager");
        defaultTransactionDefinition.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        TransactionStatus status = transactionManager.getTransaction(defaultTransactionDefinition);

        Map<String, Object> resultMap = new HashMap<>(1);
        Map<String, Object> peopleInfoMap = new HashMap<>(2);
        Integer inviterId = Token.getProjectPeopleId(request.getHeader("token"));
        ProjectPeople inviter = projectPeopleMapper.selectByPrimaryKey(inviterId);
        WaitingRegisterPeople waitingRegisterPeople;

        peopleInfoMap.put("phoneNumber", phoneNumber);
        peopleInfoMap.put("email", email);
        if(inviteProjectPeopleService.canInvite(peopleInfoMap)) {
            waitingRegisterPeople = inviteProjectPeopleService
                    .addWaitingRegisterPeople(inviter, name, phoneNumber, email, type, departmentId);
            if(inviteProjectPeopleService.invitePeople(inviter, waitingRegisterPeople, type)) {
                resultMap.put("msg", "success");
                transactionManager.commit(status);
            } else {
                resultMap.put("msg", "SendEmailError");
                transactionManager.rollback(status);
            }
        } else {
            resultMap.put("msg", "EmailOrPhoneNumberRepeat");
        }
        return resultMap;
    }

    @Log(needLog = false, serviceDescription = "注册前token验证", permission = 15)
    @RequestMapping(value = "/tokenConfirm", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> registerCheck(@RequestParam(name = "token") String token) {
        Map<String, Object> resultMap = new HashMap<>(1);
        Object verifyResult;

        verifyResult = Token.verifyToken(token);
        if(verifyResult.getClass().equals(Boolean.class)) {
            resultMap.put("msg", "refuse");
        } else {
            resultMap.put("msg", "success");
        }
        return resultMap;
    }
}
