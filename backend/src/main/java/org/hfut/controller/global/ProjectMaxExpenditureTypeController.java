package org.hfut.controller.global;

import org.hfut.annotation.Log;
import org.hfut.service.global.ProjectMaxExpenditureTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Lee
 * @date 2019/1/10
 **/
@Controller
public class ProjectMaxExpenditureTypeController {
    @Autowired
    private ProjectMaxExpenditureTypeService projectMaxExpenditureTypeService;

    @Log(needLog = false, serviceDescription = "获得项目支出种类", permission = 15)
    @ResponseBody
    @RequestMapping(value = "/projectMaxExpenditureType", method = RequestMethod.GET)
    public Map<String, Object> selectProjectMaxExpenditureType(@RequestParam(name = "projectId", required = false) Integer projectId,
                                                               @RequestParam(name = "chooseDate", required = false) List<String> chooseDate) {
        Map<String, Object> map = new HashMap<>(1);
        List<Map> list = projectMaxExpenditureTypeService.searchProjectMaxExpenditureType(projectId, chooseDate);
        map.put("expenditurePart", list);
        return map;
    }
}
