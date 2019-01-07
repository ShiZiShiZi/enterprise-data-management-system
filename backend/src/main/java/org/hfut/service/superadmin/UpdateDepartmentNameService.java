package org.hfut.service.superadmin;

import org.hfut.mapper.DepartmentMapper;
import org.hfut.pojo.Department;
import org.hfut.pojo.DepartmentExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UpdateDepartmentNameService {
    @Autowired
    private DepartmentMapper departmentMapper;

    public void updateDepartmentName(Integer id, String name){
        //  更新部门名字
        DepartmentExample departmentExample = new DepartmentExample();
        DepartmentExample.Criteria criteria = departmentExample.createCriteria();
        criteria.andIdEqualTo(id);
        Department department = new Department();
        department.setId(id);
        department.setName(name);
        departmentMapper.updateByExampleSelective(department, departmentExample);
    }

}
