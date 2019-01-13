package org.hfut.controller.developer;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.hfut.annotation.Log;
import org.hfut.pojo.SelectGetFeedbackList;
import org.hfut.service.developer.GetFeedbackListService;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Lee
 * @date 2019/1/13
 **/
@Controller
public class GetFeedbackListController {
    @Autowired
    private GetFeedbackListService getFeedbackListService;

    @Log(needLog = false, serviceDescription = "项目人员查看添加费用之后的反馈", permission = 3)
    @RequestMapping(value = "/developer/getFeedbackList", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> selectFeedbackList(@RequestParam(name = "currentPage", required = false) Integer currentPage,
                                                  @RequestParam(name = "pageSize", required = false) Integer pageSize,
                                                  HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>(2);
        List<SelectGetFeedbackList> list;
        String token = request.getHeader("token");
        int id = Token.getProjectPeopleId(token);
        list = getFeedbackListService.listFeedbackList(id);
        PageHelper.startPage(currentPage, pageSize);
        PageInfo pageInfo = new PageInfo(list);
        int maxPage = pageInfo.getPages();
        map.put("feedbackList", list);
        map.put("maxPage", maxPage);
        return map;
    }
}
