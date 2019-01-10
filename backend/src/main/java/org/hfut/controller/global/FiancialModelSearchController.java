package org.hfut.controller.global;

import org.hfut.pojo.FinancialModelExample;
import org.hfut.service.global.FinancialModelSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * FiancialModelSearchController
 *
 * @author WeiXin
 * @date 2019/1/9
 **/
@Controller
public class FiancialModelSearchController {

    @Autowired
    FinancialModelSearchService financialModelSearchService;

    @RequestMapping(value = "/financialModelSearch", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> financialModelSearch(@RequestParam(name = "projectId") Integer projectId,
                                                    @RequestParam(name = "type") Integer type,
                                                    @RequestParam(name = "isActive") Integer active) {
        FinancialModelExample financialModelExample = new FinancialModelExample();
        FinancialModelExample.Criteria criteria = financialModelExample.createCriteria();
        Map<String, Object> resultMap = new HashMap<>(1);

        financialModelSearchService.selectByProjectId(criteria, projectId);
        financialModelSearchService.selectByType(criteria, type);
        financialModelSearchService.selectByActive(criteria, active);
        financialModelSearchService.selectFinancialModel(financialModelExample, resultMap);

        return resultMap;
    }
}
