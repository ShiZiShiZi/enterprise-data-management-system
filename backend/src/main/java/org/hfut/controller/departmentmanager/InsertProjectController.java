package org.hfut.controller.departmentmanager;

import org.hfut.service.departmentmanager.InsertProjectService;
import org.hfut.tool.global.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author panbaoqiang
 * @date 2019/1/10
 **/
@Controller
public class InsertProjectController {
    @Autowired
    private InsertProjectService insertProjectService;

    //@Log(needLog = false, serviceDescription = "创建项目", permission = 8)
    @RequestMapping(value = "/departmentManager/insertProject", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> addProject(HttpServletRequest request,
                                          @RequestParam(name = "title", required = false) String title,
                                          @RequestParam(name = "description", required = false) String description,
                                          @RequestParam(name = "startTime", required = false) String startTime,
                                          @RequestParam(name = "finishTime", required = false) String finishTime) {
        String token = request.getHeader("token");
        Integer projectPeopleId = Token.getProjectPeopleId(token);
        Map<String, Object> projectMap = new HashMap<>(1);
        projectMap.put("projectId", insertProjectService.insertProject(title, description, startTime, projectPeopleId, finishTime));
        return projectMap;
    }
}
