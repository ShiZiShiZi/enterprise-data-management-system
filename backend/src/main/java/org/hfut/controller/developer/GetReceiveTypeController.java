package org.hfut.controller.developer;

import org.hfut.annotation.Log;
import org.hfut.pojo.SelectProjectFinancialmodeldetail;
import org.hfut.service.developer.GetProjectService;
import org.hfut.service.developer.GetReceiveTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class GetReceiveTypeController {
    @Autowired
    private GetReceiveTypeService grts;

    @Log(needLog = false, serviceDescription = "获取应收类型", permission = 1)
    @ResponseBody
    @RequestMapping(value = "/developer/getReceiveTypeCtrl", method = RequestMethod.POST)
    public List<SelectProjectFinancialmodeldetail> selectCloseProject(@RequestParam(value = "id", required = false) String id,
                                                                      Model model) {
        int d = Integer.parseInt(id);
        List<SelectProjectFinancialmodeldetail> list = new ArrayList<>();
        list = grts.listProjectFinancialmodeldetail(d);
        return list;
    }
}
