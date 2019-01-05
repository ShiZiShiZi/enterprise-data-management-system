package org.hfut.controller.developer;

import org.hfut.annotation.Log;
import org.hfut.model.FinancialDetailFeedbackDisplay;
import org.hfut.service.developer.GetFinancialDetailFeedbackService;
import org.hfut.tool.global.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * GetFinancialDetailFeedbackController
 *
 * @author WeiXin
 * @date 2019/1/4
 **/
@Controller
public class GetFinancialDetailFeedbackController {

    @Autowired
    GetFinancialDetailFeedbackService getFinancialDetailFeedbackService;

    @Log(needLog = false, serviceDescription = "查看项目反馈进度", permission = 5)
    @RequestMapping(value = "/developer/reportCtrl", method = RequestMethod.POST)
    @ResponseBody
    public List<FinancialDetailFeedbackDisplay> getFinancialDetailFeedback(
            @RequestParam(name = "projectId") Integer projectId,
            @RequestParam(name = "financialDetailId") Integer financialDetailId, HttpServletRequest request) {
        Integer requestPeopleId = Token.getProjectPeopleId(request.getHeader("token"));

        return getFinancialDetailFeedbackService.getFeedback(requestPeopleId, projectId, financialDetailId);
    }

}
