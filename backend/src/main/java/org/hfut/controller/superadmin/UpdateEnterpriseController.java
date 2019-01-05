package org.hfut.controller.superadmin;

import org.hfut.annotation.Log;
import org.hfut.pojo.Enterprise;
import org.hfut.service.superadmin.UpdateEnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class UpdateEnterpriseController {
    @Autowired
    private UpdateEnterpriseService updateEnterpriseService;

    @Log(needLog = false, serviceDescription = "获取企业信息", permission = 8)
    @RequestMapping(value = "/superAdmin/getEnterpriseInfoCtrl", method = RequestMethod.GET)
    @ResponseBody
    public List<Enterprise> getEnterpriseInfoGet(HttpServletRequest request){
        List<Enterprise> enterprisesList = updateEnterpriseService.getEnterpriseInfo();
        return enterprisesList;
    }

    @Log(needLog = false, serviceDescription = "更新企业信息", permission = 8)
    @RequestMapping(value = "/superAdmin/updateInfoCtrl", method = RequestMethod.POST)
    @ResponseBody
    public void updateEnterpriseInfoPost(HttpServletRequest request,
                                         @RequestParam(value = "name", required = false) String name,
                                         @RequestParam(value = "logo", required = false)  byte[] logo){
        updateEnterpriseService.updateEnterpriseInfo(name, logo);
    }
}
