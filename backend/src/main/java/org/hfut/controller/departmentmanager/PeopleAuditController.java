package org.hfut.controller.departmentmanager;

import org.hfut.annotation.Log;
import org.hfut.service.departmentmanager.PeopleAuditService;
import org.hfut.tool.global.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author panbaoqiang
 * @date 2019/1/10
 **/
@Controller
public class PeopleAuditController {
    @Autowired
    private PeopleAuditService peopleAuditService;

    @Log(needLog = false, serviceDescription = "审核人员请求", permission = 8)
    @RequestMapping(value = "/departmentManager/peopleAudit", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> auditPeople(HttpServletRequest request,
                                           @RequestParam(name = "feedbackId", required = false ) Integer feedbackId,
                                           @RequestParam(name = "state", required = false ) Integer state,
                                           @RequestParam(name = "description ", required = false ) String description ){
        String token = request.getHeader("token");
        Integer projectPeopleId = Token.getProjectPeopleId(token);
        Map<String,Object> auditMap = new HashMap<>(1);
        auditMap.put("msg",peopleAuditService.auditing(feedbackId,state,description,projectPeopleId));
        return auditMap;
    }
}
