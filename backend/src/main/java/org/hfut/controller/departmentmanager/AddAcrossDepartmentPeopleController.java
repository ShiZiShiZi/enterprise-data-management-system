package org.hfut.controller.departmentmanager;

import org.hfut.service.departmentmanager.AddAcrossDepartmentPeopleService;
import org.hfut.tool.global.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author panbaoqiang
 * @date 2019/1/11
 **/
@Controller
public class AddAcrossDepartmentPeopleController {
    @Autowired
    private AddAcrossDepartmentPeopleService addAcrossDepartmentPeopleService;

    //@Log(needLog = true, serviceDescription = "为项目添加跨部门人员申请", permission = 1)
    @ResponseBody
    @RequestMapping(value = "/departmentManager/addAcrossDepartmentPeople", method = RequestMethod.GET)
    public Map<String, Object> addAcrossDepartmentPeople(HttpServletRequest request,
                                                         @RequestParam(name = "peopleIdList ", required = false) List<Integer> peopleIdList ,
                                                         @RequestParam(name = "projectId", required = false) Integer  projectId,
                                                         @RequestParam(name = "departmentId", required = false) Integer  departmentId) {
        String token = request.getHeader("token");
        Integer requestPeopleId = Token.getProjectPeopleId(token);
        Map<String, Object> msgMap = new HashMap<>(1);
        msgMap.put("msg",addAcrossDepartmentPeopleService.addAcrossDepartmentPeople(peopleIdList,projectId,departmentId,requestPeopleId));
        return msgMap;
    }
}
