package org.hfut.controller.developer;

import org.hfut.annotation.Log;
import org.hfut.model.CloseProjectInfo;
import org.hfut.service.developer.CloseProjectInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CloseProjectInfoController {
    @Autowired
    private CloseProjectInfoService cpis;

    @Log(needLog = false, serviceDescription = "查找已关闭项目信息", permission = 1)
    @ResponseBody
    @RequestMapping(value = "/superAdmin/closeProjectInfoCtrl", method = RequestMethod.POST)
    public List<CloseProjectInfo> selectCloseProject(@RequestParam(value = "id", required = false) String id,
                                                     Model model) {
        int d = Integer.parseInt(id);
        List<CloseProjectInfo> list = new ArrayList<>();
        list = cpis.listCloseProject(d);
        return list;
    }

}
