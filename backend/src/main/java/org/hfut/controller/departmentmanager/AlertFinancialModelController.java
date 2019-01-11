package org.hfut.controller.departmentmanager;

import org.hfut.annotation.Log;
import org.hfut.pojo.FinancialModel;
import org.hfut.service.departmentmanager.AlertFinancialModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * AlertFinancialModelController
 *
 * @author WeiXin
 * @date 2019/1/10
 **/
@Controller
public class AlertFinancialModelController {

    private AlertFinancialModelService alertFinancialModelService;

    @Autowired
    public AlertFinancialModelController(AlertFinancialModelService alertFinancialModelService) {
        this.alertFinancialModelService = alertFinancialModelService;
    }

    @Log(needLog = true, serviceDescription = "修改财务模型", permission = 2)
    @RequestMapping(value = "/departmentManager/changeFinancialModel", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> alertFinancialModel(@RequestParam(name = "modelId") Integer modelId,
                                                   @RequestParam(name = "name") String name,
                                                   @RequestParam(name = "amount") Double amount,
                                                   @RequestParam(name = "isClose") Integer isClose) {
        Map<String, Object> resultMap = new HashMap<>(1);
        FinancialModel financialModel = alertFinancialModelService.selectModelById(modelId);

        alertFinancialModelService.alertName(financialModel, name);
        alertFinancialModelService.alertAmount(financialModel, amount);
        alertFinancialModelService.alertActive(financialModel, isClose);
        alertFinancialModelService.alertFinancialmodel(financialModel);

        resultMap.put("msg", "修改完成");
        return resultMap;
    }

}
