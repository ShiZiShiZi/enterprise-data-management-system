package org.hfut.controller.developer;

import org.hfut.annotation.Log;
import org.hfut.service.developer.AddCostService;
import org.hfut.tool.global.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class AddCostController {
    @Autowired
    AddCostService acs;

    @Log(needLog = true, serviceDescription = "添加应收", permission = 1)
    @ResponseBody
    @RequestMapping(value = "/developer/addCostCtrl", method = RequestMethod.POST)
    public boolean selectCloseProject(@RequestParam(value = "title", required = false) String title,
                                      @RequestParam(value = "ReceiveType", required = false) String ReceiveType,
                                      @RequestParam(value = "receive", required = false) String receive,
                                      @RequestParam(value = "infor", required = false) String[] infor,
                                      Model model, HttpServletRequest request) {
        List<byte[]> contracts = new ArrayList<>();
        for (int j = 0; j < infor.length; j++) {
            contracts.add(infor[j].getBytes());
        }
        String token = request.getHeader("token");
        double r = Double.parseDouble(receive);
        int rt = Integer.parseInt(ReceiveType);
        int id = Token.getProjectPeopleId(token);
        int fdid = acs.insertFinancialDetail(title, r, id, rt);
        int num[] = new int[50];
        for (int i = 0; i < contracts.size(); i++) {
            num[i] = acs.insertContract(contracts.get(i));
        }
        for (int j = 0; j < num.length; j++) {
            acs.insertFinancialdetailcontract(fdid, num[j]);
        }
        return true;
    }
}
