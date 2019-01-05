package org.hfut.controller.developer;

import org.hfut.annotation.Log;
import org.hfut.pojo.SelectProjectFinancialmodeldetail;
import org.hfut.service.developer.GetProjectFinancialDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * GetProjectFinancialDetailController
 *
 * @author WeiXin
 * @date 2019/1/3
 **/
@Controller
public class GetProjectFinancialDetailController {
    @Autowired
    GetProjectFinancialDetailService financialDetailService;

    @Log(needLog = false, serviceDescription = "获取项目费用模型", permission = 1)
    @RequestMapping(value = "/developer/getCostTypeCtrl", method = RequestMethod.POST)
    @ResponseBody
    public List<SelectProjectFinancialmodeldetail> getProjectCostFinancialDetail(@RequestParam(name = "id") String id) {
        Integer projectId = Integer.valueOf(id);
        return financialDetailService.getFinancialModelDetail(projectId);
    }
}
