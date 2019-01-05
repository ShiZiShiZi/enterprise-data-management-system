package org.hfut.controller.superadmin;

import org.hfut.annotation.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.hfut.service.superadmin.ExitService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ExitController {
    @Autowired
    private ExitService exitService;

    @Log(needLog = false, serviceDescription = "查看电话或者Email是否存在", permission = 8)
    @RequestMapping(value = "/superAdmin/isExitFinancePhoneOrEmailCtrl", method = RequestMethod.POST)
    @ResponseBody
    public String isExitFinancePhoneOrEmail(HttpServletRequest request,
                                            @RequestParam(value = "phoneOrEmail", required = false) String phoneOrEmail){
        return exitService.isPhoneOrEmailExitBy(phoneOrEmail);
    }

    @Log(needLog = false, serviceDescription = "通过部门名判断部门信息是否存在", permission = 8)
    @RequestMapping(value = "/superAdmin/isExitDepartmentCtrl", method = RequestMethod.POST)
    @ResponseBody
    public String isExitDepartmentByName(HttpServletRequest request,
                                         @RequestParam(value = "name", required = false) String name){
        return exitService.isExitDepartmentByName(name);
    }
}
