package org.hfut.controller.financialstaff;

import jdk.nashorn.internal.parser.Token;
import org.hfut.service.financialstaff.AddFinancialLogService;
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
 * @author 卅果果
 * @date 2019/1/11
 **/
@Controller
public class AddFinancialLogController {
    @Autowired
    private AddFinancialLogService addFinancialLogService;
    @RequestMapping(value = "/financial/insertFinancialLog", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> addFinancialLog(HttpServletRequest request,
                                               @RequestParam(name = "projectPeopleId", required = false)Integer projectPeopleId,
                                               @RequestParam(name = "amount",required = false) Double amount,
                                               @RequestParam(name = "taxRate",required = false) Float taxRate,
                                               @RequestParam(name = "type",required = false) Byte type,
                                               @RequestParam(name = "financialDetailld",required = false) Integer financialDetailld,
                                               @RequestParam(name = "contractList",required = false) byte[] contract,
                                               @RequestParam(name = "name", required = false) String name) {


        Map<String, Object> map = new HashMap<>(10);
        String msg = addFinancialLogService.addFinancialLog(projectPeopleId, amount, taxRate, type, financialDetailld, contract, name);
        map.put("msg", msg);
        return map;
    }
}
