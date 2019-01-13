package org.hfut.controller.departmentmanager;

import org.hfut.annotation.Log;
import org.hfut.service.departmentmanager.ProjectPeopleFeedbackStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ProjectPeopleFeedbackStateController
 *
 * @author WeiXin
 * @date 2019/1/12
 **/
@Controller
public class ProjectPeopleFeedbackStateController {

    private ProjectPeopleFeedbackStateService projectPeopleFeedbackStateService;

    @Autowired
    public ProjectPeopleFeedbackStateController(ProjectPeopleFeedbackStateService projectPeopleFeedbackStateService) {
        this.projectPeopleFeedbackStateService = projectPeopleFeedbackStateService;
    }

    @Log(needLog = false, serviceDescription = "查询人员反馈状态", permission = 2)
    @RequestMapping(value = "/departmentManager/acrossDepartmentState", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> selectProjectPeopleFeedbackState(
            @RequestParam(name = "projectPeopleIdList") List<Integer> projectPeopleIds,
            @RequestParam(name = "projectId") Integer projectId) {
        Map<String, Object> resultMap = new HashMap<>(1);

        projectPeopleFeedbackStateService.selectStateByPeopleId(projectPeopleIds, projectId, resultMap);
        return resultMap;
    }
}
