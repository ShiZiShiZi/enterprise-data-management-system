package org.hfut.controller.global;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
//import org.hfut.annotation.Log;
import org.hfut.pojo.ProjectPeople;
import org.hfut.service.global.ProjectPeopleSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Lee
 * @date 2019/1/7
 **/
@Controller
public class ProjectPeopleSearchController {
    @Autowired
    private ProjectPeopleSearchService projectPeopleSearchService;

//    @Log(needLog = false, serviceDescription = "项目人员筛选以及分页", permission = 1)
    @ResponseBody
    @RequestMapping(value = "/projectPeopleSearch", method = RequestMethod.GET)
    public Map<String, Object> selectProjectPeople(@RequestParam(name = "currentPage", required = false) Integer currentPage,
                                                   @RequestParam(name = "pageSize", required = false) Integer pageSize,
                                                   @RequestParam(name = "projectId", required = false) List<Integer> projectId,
                                                   @RequestParam(name = "name", required = false) String name,
                                                   @RequestParam(name = "isAcrossDepartment", required = false) Integer isAcrossDepartment,
                                                   @RequestParam(name = "departmentId", required = false) Integer departmentId,
                                                   @RequestParam(name = "sortColumn", required = false) String sortColumn,
                                                   @RequestParam(name = "sortOrder", required = false) Integer sortOrder,
                                                   Model model) {
        Map<String, Object> map = new HashMap<>(10);
        List<ProjectPeople> list = new ArrayList<>();
        if (projectId == null) {
            projectId = new ArrayList<>();
        }
        if (name == null) {
            name = "0";
        }
        if (isAcrossDepartment == null) {
            isAcrossDepartment = 2;
        }
        if (departmentId == null) {
            departmentId = -1;
        }
        list = projectPeopleSearchService.listProjectPeople(projectId, name, isAcrossDepartment, departmentId, sortColumn, sortOrder);
        PageHelper.startPage(currentPage, pageSize);
        PageInfo pageInfo = new PageInfo(list);
        int maxPage = pageInfo.getPages();
        map.put("maxPage", maxPage);
        map.put("projectPeopleList", list);
        return map;
    }
}
