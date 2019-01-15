package org.hfut.controller.superadmin;

import org.hfut.annotation.Log;
import org.hfut.service.superadmin.RenameDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author panbaoqiang
 * @date 2019/1/14
 **/
@Controller
public class RenameDepartmentController {
    @Autowired
    private RenameDepartmentService renameDepartmentService;
    @Log(needLog = true, serviceDescription = "更改部门名字", permission = 8)
    @ResponseBody
    @RequestMapping(value = "/superAdmin/renameDepartment", method = RequestMethod.GET)
    public Map<String, Object>  renameDepartment(@RequestParam(name = "id", required = false) Integer id,
                                                 @RequestParam(name = "name", required = false) String  name){
	    Map<String, Object> map = new HashMap<>(1);
		map.put("msg",renameDepartmentService.renameDepartment(id,name));
        return map;
    }
}
