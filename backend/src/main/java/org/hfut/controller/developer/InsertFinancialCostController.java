package org.hfut.controller.developer;

import org.hfut.annotation.Log;
import org.hfut.service.developer.InsertFinancialCostService;
import org.hfut.tool.global.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * InsertFinancialCostController
 *
 * @author WeiXin
 * @date 2019/1/4
 **/
@Controller
public class InsertFinancialCostController {

    @Autowired
    private InsertFinancialCostService financialCostService;

    @Log(needLog = true, serviceDescription = "添加费用", permission = 1)
    @RequestMapping(value = "/developer/addCostCtrl", method = RequestMethod.POST)
    @ResponseBody
    public boolean insertFinancialCoset(@RequestParam(name = "modelDetailId") Integer modelDetailId,
                                        @RequestParam(name = "title") String title,
                                        @RequestParam(name = "num") Double num,
                                        @RequestParam(name = "contractList") String[] contracts,
                                        HttpServletRequest request) {
        String token = request.getHeader("token");
        Integer projectPeopleId = Token.getProjectPeopleId(token);
        Integer financialDetailId;
        Integer contractId;

        if(financialCostService.isFinancialModelDetailActive(modelDetailId)) {
            financialDetailId = financialCostService.insertFinancialDetail(title, num, modelDetailId, projectPeopleId);
            financialCostService.insertFinancialDetailFeedback(financialDetailId);
            for(String contract : contracts) {
                contractId = financialCostService.insertContract(contract.getBytes());
                financialCostService.insertFinancialDetailContract(financialDetailId, contractId);
            }
            return true;
        } else {
            return false;
        }
    }

}
