package org.hfut.controller.superadmin;

import org.hfut.annotation.Log;
import org.hfut.pojo.Department;
import org.hfut.service.superadmin.SelectDepartmentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class SelectDepartmentInfoController {
    @Autowired
    private SelectDepartmentInfoService selectDepartmentInfoService;
    @Log(needLog = false, serviceDescription = "获取所有部门列表", permission = 8)
    @RequestMapping(value = "/superAdmin/selectDepartmentCtrl", method = RequestMethod.GET)
    @ResponseBody
    public List<Department> getDepartmentList(HttpServletRequest request){
        return selectDepartmentInfoService.getAllDepartmentInfo();
    }
}
