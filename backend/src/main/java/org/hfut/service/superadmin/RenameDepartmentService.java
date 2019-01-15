package org.hfut.service.superadmin;

import org.hfut.mapper.DepartmentMapper;
import org.hfut.pojo.Department;
import org.hfut.pojo.DepartmentExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author panbaoqiang
 * @date 2019/1/14
 **/
@Service
public class RenameDepartmentService {
    @Autowired
    private DepartmentMapper departmentMapper;
    public String renameDepartment(Integer departmentId,
                                   String name){
        DepartmentExample departmentExample = new DepartmentExample();
        DepartmentExample.Criteria criteria = departmentExample.createCriteria();
        criteria.andIdEqualTo(departmentId);
        Department department = new Department();
        department.setName(name);
        try {
            departmentMapper.updateByExampleSelective(department, departmentExample);
        }catch(Exception e){
            return "Updated Failed";
        }
        return "Updated Success";
    }
}
