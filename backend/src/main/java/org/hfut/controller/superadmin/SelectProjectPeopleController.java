package org.hfut.controller.superadmin;

import org.hfut.annotation.Log;
import org.hfut.pojo.SelectProjectPeopleInfo;
import org.hfut.service.superadmin.SelectProjectPeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class SelectProjectPeopleController {
    @Autowired
    private SelectProjectPeopleService selectProjectPeopleService;

    @Log(needLog = false, serviceDescription = "获取所有人员信息列表", permission = 8)
    @RequestMapping(value = "/superAdmin/selectMemberCtrl", method = RequestMethod.GET)
    @ResponseBody
    public List<SelectProjectPeopleInfo> getAllProjectPeople(HttpServletRequest request){
        //获取ProjectPeople所有人的信息
        return selectProjectPeopleService.getAllProjectPeople();
    }
}
