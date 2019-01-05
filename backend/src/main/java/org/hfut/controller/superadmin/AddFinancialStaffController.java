package org.hfut.controller.superadmin;

import org.hfut.annotation.Log;
import org.hfut.service.superadmin.AddFinancialStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AddFinancialStaffController {
    @Autowired
    private AddFinancialStaffService addFinancialStaffService;



    @Log(needLog = false, serviceDescription = "增加财务人员", permission = 8)
    @RequestMapping(value = "/superAdmin/addFinanceCtrl", method = RequestMethod.POST)
    @ResponseBody
    public String addFinanceStaff(HttpServletRequest request,
                                  @RequestParam(value = "departmentid", required = false) Integer departmentid,
                                  @RequestParam(value = "phone", required = false) String phone,
                                  @RequestParam(value = "Email", required = false) String Email,
                                  @RequestParam(value = "password", required = false) String password,
                                  @RequestParam(value = "flag", required = false) Boolean flag,
                                  @RequestParam(value = "name", required = false) String name){
        /*增加财务人员,之前要进行判断邮箱和电话是否重合*/
        addFinancialStaffService.addFinanceStaff(departmentid,phone,Email,password,flag,name);
        return "yes";
    }
}
