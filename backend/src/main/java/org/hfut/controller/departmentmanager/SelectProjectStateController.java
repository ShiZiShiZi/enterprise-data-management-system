package org.hfut.controller.departmentmanager;
import org.hfut.service.departmentmanager.SelectProjectStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author panbaoqiang
 * @date 2019/1/11
 **/
@Controller
public class SelectProjectStateController {
    @Autowired
    private SelectProjectStateService selectProjectStateService;

    //@Log(needLog = false, serviceDescription = "项目运行情况", permission = 4)
    @RequestMapping(value = "/departmentManager/projectState", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getProjectList(HttpServletRequest request,
                                             @RequestParam(name = "projectIdList ", required = false ) List<Integer> projectIdList){
        Map<Integer, List<Integer>> projectIdFinancialMap = selectProjectStateService.getProjectFinancialDetail(projectIdList);
        Map<String,Object> projectFinancialMap = new HashMap<>(1);
        projectFinancialMap.put("projectStateMap", projectIdFinancialMap);
        return projectFinancialMap;
    }
}
