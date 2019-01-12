package org.hfut.controller.departmentmanager;

import org.hfut.service.departmentmanager.ChangeProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 卅果果
 * @date 2019/1/11
 **/
@Controller
public class ChangeProjectController {
    @Autowired
    private ChangeProjectService changeProjectService;

    @RequestMapping(value = "/departmentManager/changeProject", method = RequestMethod.GET)
    @ResponseBody

    public Map<String, Object> changeProject(HttpServletRequest request,
                             @RequestParam(name = "projectId", required = false) Integer projectId,
                             @RequestParam(name = "newTitle", required = false) String newTitle,
                             @RequestParam(name = "newFinishTime", required = false) String newFinishTime,
                             @RequestParam(name = "newDescription", required = false) String newDescription) throws ParseException {
        String msg = changeProjectService.changeProject(projectId, newTitle, newFinishTime, newDescription);
        Map<String, Object> map = new HashMap<>(10);
        map.put("msg",msg);
        return map;
    }
}
