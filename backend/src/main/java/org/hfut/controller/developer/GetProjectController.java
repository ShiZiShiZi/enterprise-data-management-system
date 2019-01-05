package org.hfut.controller.developer;

import org.hfut.annotation.Log;
import org.hfut.pojo.SelectPersonProject;
import org.hfut.service.developer.GetProjectService;
import org.hfut.tool.global.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class GetProjectController {
    @Autowired
    private GetProjectService gps;

    @Log(needLog = false, serviceDescription = "获取项目人员参与的项目", permission = 1)
    @ResponseBody
    @RequestMapping(value = "/superAdmin/selectCloseProjectCtrl", method = RequestMethod.GET)
    public List<SelectPersonProject> selectProject(Model model, HttpServletRequest request) {
        List<SelectPersonProject> list = new ArrayList<>();
        String token = request.getHeader("token");
        int id = Token.getProjectPeopleId(token);
        list = gps.listProject(id);
        return list;
    }
}
