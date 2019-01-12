package org.hfut.controller.departmentmanager;
import org.hfut.service.departmentmanager.ProjectDataTotalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @author panbaoqiang
 * @date 2019/1/11
 **/
@Controller
public class ProjectDataTotalController {
    @Autowired
    private ProjectDataTotalService projectDataTotalService;
    //@Log(needLog = false, serviceDescription = "查看项目36个月的支出数据", permission = 8)
    @RequestMapping(value = "/projectDataTotal", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> projectData(HttpServletRequest request,
                                          @RequestParam(name = "projectId", required = false ) Integer projectId){
        Map<String,Object> projectFinanceMap = new HashMap<>(4);
        Double totalInput= projectDataTotalService.getTotalInputBy(projectId);
        Double totalOutput = -1 * projectDataTotalService.getTotalOutputBy(projectId);
        Double grossProfit = totalInput + totalOutput;
        projectFinanceMap.put("totalInput",totalInput);
        projectFinanceMap.put("totalOutput",totalOutput);
        projectFinanceMap.put("grossProfit",grossProfit);
        projectFinanceMap.put("financialPart",projectDataTotalService.getProjectDataTotal(projectId));
        return projectFinanceMap;
    }
}
