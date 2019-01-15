package org.hfut.controller.departmentmanager;
import org.hfut.annotation.Log;
import org.hfut.service.departmentmanager.SelectDepartmentDataTotalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.Map;

/**
 * @author panbaoqiang
 * @date 2019/1/15
 **/
@Controller
public class SelectDepartmentDataTotalController {
    @Autowired
    private SelectDepartmentDataTotalService selectDepartmentDataTotalService;

    @Log(needLog = true, serviceDescription = "部门总体数据查询", permission = 2)
    @RequestMapping(value = "/departmentDataTotal", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> selectDepartmentDataTotal(@RequestParam(name = "departmentId ") Integer departmentId ){
        return selectDepartmentDataTotalService.getDepartmentDataTotal(departmentId);
    }
}
