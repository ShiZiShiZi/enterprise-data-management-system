package org.hfut.controller.superadmin;

import org.hfut.annotation.Log;
import org.hfut.service.superadmin.RenewLogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Lee
 * @date 2019/1/14
 **/
@Controller
public class RenewLogoController {
    @Autowired
    private RenewLogoService renewLogoService;

    @Log(needLog = true, serviceDescription = "更新企业logo", permission = 8)
    @RequestMapping(value = "/renewLogo", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> updateLogo(@RequestBody Map<String, Object> parameters) {
        Map<String, Object> map = new HashMap<>(1);
        String logo = (String) parameters.get("logo");
        String msg = renewLogoService.renewLogo(logo);
        map.put("msg", msg);
        return map;
    }
}
