package org.hfut.controller.superadmin;

import org.hfut.annotation.Log;
import org.hfut.pojo.Project;
import org.hfut.service.superadmin.SelectCloseProjectService;
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
public class SelectCloseProjectController {

    @Autowired
    private SelectCloseProjectService scps;

    @Log(needLog = false, serviceDescription = "查找已关闭项目", permission = 1)
    @ResponseBody
    @RequestMapping(value = "/superAdmin/selectCloseProjectCtrl", method = RequestMethod.POST)
    public List<Project> selectCloseProject(@RequestParam(value = "year", required = false) String year,
                                            @RequestParam(value = "month", required = false) String month,
                                            Model model) {
        List<Project> list = new ArrayList<>();
        list = scps.listProjectName(year, month);
        return list;
    }
}
