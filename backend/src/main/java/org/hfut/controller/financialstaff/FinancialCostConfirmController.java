package org.hfut.controller.financialstaff;

import org.hfut.annotation.Log;
import org.hfut.pojo.FinancialDetail;
import org.hfut.pojo.FinancialDetailFeedback;
import org.hfut.service.financialstaff.FinancialCostConfirmService;
import org.hfut.tool.global.Token;
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
 * FinancialCostConfirmController
 *
 * @author WeiXin
 * @date 2019/1/10
 **/
@Controller
public class FinancialCostConfirmController {

    private FinancialCostConfirmService financialCostConfirmService;

    @Autowired
    public FinancialCostConfirmController(FinancialCostConfirmService financialCostConfirmService) {
        this.financialCostConfirmService = financialCostConfirmService;
    }

    @Log(needLog = true, serviceDescription = "确认/驳回支出请求", permission = 4)
    @RequestMapping(value = "/financial/costConfirm", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> financialCostConfirm(@RequestParam(name = "financialDetailId") Integer financialDetailId,
                                                    @RequestParam(name = "state") Integer state,
                                                    @RequestParam(name = "description") String description,
                                                    @RequestParam(name = "contractList") List<char[]> contracts,
                                                    @RequestParam(name = "contractNameList") List<String> contractNameList,
                                                    HttpServletRequest request) {
        final int accept = 1;
        Map<String, Object> resultMap = new HashMap<>(1);
        FinancialDetail financialDetail = financialCostConfirmService.selectFinancialDetailById(financialDetailId);
        FinancialDetailFeedback financialDetailFeedback = financialCostConfirmService.selectFinancialDetailFeedbackByFinancialDetailId(financialDetailId);
        Integer projectPeopleId = Token.getProjectPeopleId(request.getHeader("token"));


        financialCostConfirmService.updateFeedback(state, projectPeopleId, financialDetailFeedback, description);
        if(state == accept) {
            financialCostConfirmService.insertFinancialLog(projectPeopleId, financialDetail, contracts, contractNameList);
        }
        resultMap.put("msg", "成功");
        return resultMap;
    }
}
