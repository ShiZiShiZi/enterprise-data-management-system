package org.hfut.controller.departmentmanager;

//import org.hfut.annotation.Log;
import org.hfut.service.departmentmanager.AddFinancialModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Lee
 * @date 2019/1/9
 **/
@Controller
public class AddFinancialModelController {
    @Autowired
    private AddFinancialModelService addFinancialModelService;

    //@Log(needLog = true, serviceDescription = "添加财务模型", permission = 1)
    @ResponseBody
    @RequestMapping(value = "/departmentManager/addFinancialModel", method = RequestMethod.GET)
    public Map<String, Object> addCloseProject(@RequestParam(name = "projectId", required = false) Integer projectId,
                                               @RequestParam(name = "name", required = false) String name,
                                               @RequestParam(name = "amount", required = false) Double amount,
                                               @RequestParam(name = "modelDetailType", required = false) Integer modelDetailType,
                                               Model model) {
        Map<String, Object> map = new HashMap<>(10);
        String msg = addFinancialModelService.insertFinancialModel(projectId, name, amount, modelDetailType);
        map.put("msg", msg);
        return map;
    }
}

