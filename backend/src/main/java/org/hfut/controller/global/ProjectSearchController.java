package org.hfut.controller.global;

import org.hfut.annotation.Log;
import org.hfut.pojo.ProjectExample;
import org.hfut.service.global.ProjectSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ProjectSearchController
 *
 * @author WeiXin
 * @date 2019/1/8
 **/
@Controller
public class ProjectSearchController {

    @Autowired
    private ProjectSearchService projectSearchService;

    @Log(needLog = false, serviceDescription = "项目筛选", permission = 15)
    @RequestMapping(value = "/projectSearch", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> projectSearch(@RequestParam(name = "currentPage") Integer currentPage,
                                             @RequestParam(name = "pageSize") Integer pageSize,
                                             @RequestParam(name = "projectId") List<Integer> projectIds,
                                             @RequestParam(name = "projectTitle") String title,
                                             @RequestParam(name = "startTime") List<String> startTime,
                                             @RequestParam(name = "finishTime") List<String> finishTime,
                                             @RequestParam(name = "departmentId") Integer departmentId,
                                             @RequestParam(name = "active") Integer active,
                                             @RequestParam(name = "closeTime") List<String> closeTime,
                                             @RequestParam(name = "sortColumn") String sortColumn,
                                             @RequestParam(name = "sortOrder") Integer sortOrder) throws ParseException {
        Map<String, Object> resultMap = new HashMap<>(2);
        ProjectExample projectExample = new ProjectExample();
        ProjectExample.Criteria criteria = projectExample.createCriteria();

        projectSearchService.selectByProjectId(criteria, projectIds);
        projectSearchService.selectByTitle(criteria, title);
        projectSearchService.selectByTime(criteria, startTime, 1);
        projectSearchService.selectByTime(criteria, finishTime, 2);
        projectSearchService.selectByTime(criteria, closeTime, 3);
        projectSearchService.selectByDepartmentId(criteria, departmentId);
        projectSearchService.selectByActive(criteria, active);
        projectSearchService.sortBy(projectExample, sortColumn, sortOrder);
        projectSearchService.selectProject(projectExample, currentPage, pageSize, resultMap);

        return resultMap;
    }
}
