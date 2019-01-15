package org.hfut.controller.departmentmanager;

import org.hfut.annotation.Log;
import org.hfut.service.departmentmanager.AddProjectPeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Lee
 * @date 2019/1/8
 **/
@Controller
public class AddProjectPeopleController {

    @Autowired
    private AddProjectPeopleService addProjectPeopleService;

    @Log(needLog = false, serviceDescription = "查找已关闭项目", permission = 2)
    @ResponseBody
    @RequestMapping(value = "/departmentManager/addProjectPeople", method = RequestMethod.GET)
    public Map<String, Object> addProjectPeople(@RequestParam(name = "projectId", required = false) Integer projectId,
                                                @RequestParam(name = "projectPeopleList", required = false) List<Integer> projectPeopleList) {
        Map<String, Object> map = new HashMap<>(10);
        String msg = addProjectPeopleService.insertProjectPeople(projectId, projectPeopleList);
        map.put("msg", msg);
        return map;
    }
}
