package org.hfut.controller.global;

import org.hfut.annotation.Log;
import org.hfut.service.global.DepartmentDataYearService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @author Lee
 * @date 2019/1/10
 **/
@Controller
public class DepartmentDataYearController {
    @Autowired
    DepartmentDataYearService departmentDataYearService;

    @Log(needLog = false, serviceDescription = "部门年数据查询", permission = 15)
    @ResponseBody
    @RequestMapping(value = "/departmentDataYear", method = RequestMethod.GET)
    public Map<String, Object> selectDepartmentDataYear(@RequestParam(name = "departmentId", required = false) Integer departmentId,
                                                        @RequestParam(name = "year", required = false) String year) {
        return departmentDataYearService.searchDepartmentDataYear(departmentId, year);
    }
}
