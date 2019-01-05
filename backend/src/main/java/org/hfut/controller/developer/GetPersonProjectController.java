package org.hfut.controller.developer;

import org.hfut.annotation.Log;
import org.hfut.pojo.SelectPersonProject;
import org.hfut.service.developer.GerPersonProjectService;
import org.hfut.tool.global.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * ProjectController
 *
 * @author WeiXin
 * @date 2019/1/1
 **/
@Controller
public class GetPersonProjectController {

    @Autowired
    private GerPersonProjectService projectService;

    @Log(needLog = false, serviceDescription = "获取个人参加的项目", permission = 1)
    @RequestMapping(value = "/developer/getProjectCtrl", method = RequestMethod.GET)
    @ResponseBody
    public List<SelectPersonProject> getDeveloperProject(HttpServletRequest request) {
        List<SelectPersonProject> projectList;
        String token = request.getHeader("token");
        Integer projectPeopleId;

        projectPeopleId = Token.getProjectPeopleId(token);
        projectList = projectService.getPersonProjectByPersonId(projectPeopleId);

        return projectList;
    }


}
