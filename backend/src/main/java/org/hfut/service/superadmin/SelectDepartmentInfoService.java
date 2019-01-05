package org.hfut.service.superadmin;

import org.hfut.mapper.DepartmentMapper;
import org.hfut.pojo.Department;
import org.hfut.pojo.DepartmentExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SelectDepartmentInfoService {
    @Autowired
    private DepartmentMapper departmentMapper;

    public List<Department> getAllDepartmentInfo(){
        //  获取所有的部门列表
        DepartmentExample departmentExample = new DepartmentExample();
        List<Department> departmentList = departmentMapper.selectByExample(departmentExample);
        return departmentList;
    }
}
