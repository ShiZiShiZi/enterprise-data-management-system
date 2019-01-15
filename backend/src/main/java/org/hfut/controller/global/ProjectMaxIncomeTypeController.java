package org.hfut.controller.global;

import org.hfut.annotation.Log;
import org.hfut.service.global.ProjectMaxIncomeTypeService;
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
 * @date 2019/1/15
 **/
@Controller
public class ProjectMaxIncomeTypeController {
    @Autowired
    private ProjectMaxIncomeTypeService projectMaxIncomeTypeService;

    @Log(needLog = false, serviceDescription = "获得项目收入种类", permission = 15)
    @ResponseBody
    @RequestMapping(value = "/projectMaxIncomeType", method = RequestMethod.GET)
    public Map<String, Object> selectProjectMaxIncomeType(@RequestParam(name = "projectId", required = false) Integer projectId,
                                                          @RequestParam(name = "chooseDate", required = false) List<String> chooseDate) {
        Map<String, Object> map = new HashMap<>(1);
        List<Map> list = projectMaxIncomeTypeService.searchProjectMaxIncomeType(projectId, chooseDate);
        map.put("incomePart", list);
        return map;
    }
}
