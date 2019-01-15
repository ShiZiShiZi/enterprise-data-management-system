package org.hfut.controller.superadmin;

import org.hfut.annotation.Log;
import org.hfut.service.superadmin.GetLogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
public class GetLogoController {
    @Autowired
    private GetLogoService getLogoService;

    @Log(needLog = false, serviceDescription = "获得企业logo", permission = 8)
    @RequestMapping(value = "/getLogo", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> takeLogo() {
        Map<String, Object> map = new HashMap<>(1);
        map.put("logo", getLogoService.getLogo());
        return map;
    }
}
