package org.hfut.controller.global;

import org.hfut.annotation.Log;
import org.hfut.service.global.MaxProjectDataService;
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
 * MaxIncomeDataQueryController
 *
 * @author WeiXin
 * @date 2019/1/11
 **/
@Controller
public class MaxDataQueryController {

    private MaxProjectDataService maxProjectDataService;

    @Autowired
    public MaxDataQueryController(MaxProjectDataService maxProjectDataService) {
        this.maxProjectDataService = maxProjectDataService;
    }

    @Log(needLog = false, serviceDescription = "获取部门15个最高收入项目", permission = 10)
    @RequestMapping(value = "/departmentMaxIncomeProject", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> MaxIncomeDataQuery(@RequestParam(name = "departmentId") Integer departmentId,
                                                  @RequestParam(name = "selectDate") List<String> queryDate) throws ParseException {
        final int incomeQuery = 0;
        Map<String, Object> resultMap = new HashMap<>(1);

        maxProjectDataService.maxDataQuery(departmentId, queryDate, incomeQuery, resultMap);

        return resultMap;
    }
}
