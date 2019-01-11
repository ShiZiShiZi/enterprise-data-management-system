package org.hfut.controller.departmentmanager;

import org.hfut.annotation.Log;
import org.hfut.service.departmentmanager.SelectProjectManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * SelectProjectManagerController
 *
 * @author WeiXin
 * @date 2019/1/10
 **/
@Controller
public class SelectProjectManagerController {

    private SelectProjectManagerService selectProjectManagerService;

    @Autowired
    public SelectProjectManagerController(SelectProjectManagerService selectProjectManagerService) {
        this.selectProjectManagerService = selectProjectManagerService;
    }

    @Log(needLog = false, serviceDescription = "查询项目负责人", permission = 2)
    @RequestMapping(value = "/departmentManager/getProjectManager", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> selectProjectManager(@RequestParam(name = "projectId") Integer projectId) {
        Map<String, Object> resultMap = new HashMap<>(1);

        resultMap.put("projectManagerList", selectProjectManagerService.selectProjectManager(projectId));
        return resultMap;
    }
}
