package org.hfut.controller.developer;

import org.hfut.pojo.Department;
import org.hfut.service.developer.GetProjectDepartmentService;
import org.hfut.service.financialstaff.GetFinancialDetailsService;
import org.hfut.tool.global.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @author panbaoqiang
 * @date 2019/1/14
 **/
@Controller
public class GetProjectDepartmentController {
    @Autowired
    private GetProjectDepartmentService getProjectDepartmentService;
    @RequestMapping(value = "/developer/getDepartmentList", method = RequestMethod.GET)
    @ResponseBody
    public List<Department> getProjectDepartment(HttpServletRequest request){
        String token = request.getHeader("token");
        Integer projectPeopleId = Token.getProjectPeopleId(token);
        return getProjectDepartmentService.getProjectDepartment(projectPeopleId);
    }
}
