package org.hfut.controller.financialstaff;


import org.hfut.annotation.Log;
import org.hfut.pojo.FinancialDetail;
import org.hfut.service.financialstaff.GetFinancialDetailsService;
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
 * @date 2019/1/8
 **/
@Controller
public class GetFinancialDetailsController {

    @Autowired
    private GetFinancialDetailsService getFinancialDetailsService;

    @Log(needLog = false, serviceDescription = "根据项目ID查询财务细节", permission = 1)
    @ResponseBody
    @RequestMapping(value = "/financial/getFinancialDetails", method = RequestMethod.GET)
    public Map<String, Object> selectFinancialDetails(
            @RequestParam(name = "projectId", required = false) Integer projectId,
            @RequestParam(name = "financialDetailType", required = false) Integer financialDetailType, Model model) {
        Map<String, Object> map = new HashMap<>(10);
        List<FinancialDetail> list;
        list = getFinancialDetailsService.listFinancialDetails(projectId, financialDetailType);
        map.put("financialDetailList", list);
        return map;
    }
}
