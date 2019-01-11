package org.hfut.controller.departmentmanager;

import org.hfut.service.departmentmanager.AddProjectManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author panbaoqiang
 * @date 2019/1/11
 **/
@Controller
public class AddProjectManagerController {
    @Autowired
    private AddProjectManagerService addProjectManagerService;
    //@Log(needLog = false, serviceDescription = "添加项目负责人", permission = 8)
    @RequestMapping(value = "/departmentManager/addProjectManager", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> addProjectManager(HttpServletRequest request,
                                                 @RequestParam(name = "projectId", required = false ) Integer projectId,
                                                 @RequestParam(name = "projectPeopleId", required = false ) List<Integer> projectPeopleId){
        addProjectManagerService.updateProjectManager(projectId,projectPeopleId);
        Map<String,Object> addProjectMap = new HashMap<>(1);
        addProjectMap.put("msg","Success");
        return addProjectMap;
    }
}
