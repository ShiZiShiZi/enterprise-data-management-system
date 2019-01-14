package org.hfut.controller.developer;

import org.hfut.annotation.Log;
import org.hfut.service.developer.AddFinancialDetailService;
import org.hfut.tool.global.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Lee
 * @date 2019/1/13
 **/
@Controller
public class AddFinancialDetailController {
    @Autowired
    private AddFinancialDetailService addFinancialDetailService;

    @Log(needLog = true, serviceDescription = "项目人员添加应收和费用", permission = 3)
    @RequestMapping(value = "/developer/addFinancialDetail", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> insetFinancialDetail(@RequestBody Map<String, Object> parameters,
                                                    HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>(2);
        String token = request.getHeader("token");
        Integer id = Token.getProjectPeopleId(token);
        Integer financialModelId = (Integer) parameters.get("financialModelId");
        String title = (String) parameters.get("title");
        Integer type = (Integer) parameters.get("type");
        Double num = (Double) parameters.get("num");
        List<String> fileNameList = (List<String>) parameters.get("fileNameList");
        List<String> fileByteList = (List<String>) parameters.get("fileByteList");
        String msg = addFinancialDetailService.addFinancialDetail(financialModelId, title, type, num, id, fileNameList, fileByteList);
        map.put("msg", msg);
        return map;
    }
}
