package org.hfut.controller.superadmin;

import org.hfut.annotation.Log;
import org.hfut.pojo.Department;
import org.hfut.service.superadmin.UpdateDepartmentNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class UpdateDepartmentNameController {
    @Autowired
    private UpdateDepartmentNameService updateDepartmentNameService;




    @Log(needLog = false, serviceDescription = " 通过id 更新部门名字", permission = 8)
    @RequestMapping(value = "/superAdmin/updataDepartmentNameCtrl", method = RequestMethod.POST)
    @ResponseBody
    public String updateDepartmentBy(HttpServletRequest request,
                                     @RequestParam(value = "id", required = false) Integer id,
                                     @RequestParam(value = "name", required = false) String name){
        updateDepartmentNameService.updateDepartmentName(id,name);
        return "yes";
    }
}
