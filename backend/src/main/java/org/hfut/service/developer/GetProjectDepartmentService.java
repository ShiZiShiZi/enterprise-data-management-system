package org.hfut.service.developer;

import org.hfut.mapper.SelectPeopleProjectDepartmentMapper;
import org.hfut.pojo.Department;
import org.hfut.pojo.SelectPeopleProjectDepartment;
import org.hfut.pojo.SelectPeopleProjectDepartmentExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author panbaoqiang
 * @date 2019/1/15
 **/
@Service
public class GetProjectDepartmentService {
    @Autowired
    private SelectPeopleProjectDepartmentMapper selectPeopleProjectDepartmentMapper;

    public List<Department> getProjectDepartment(Integer  projectPeopleId){
        SelectPeopleProjectDepartmentExample selectPeopleProjectDepartmentExample = new SelectPeopleProjectDepartmentExample();
        SelectPeopleProjectDepartmentExample.Criteria criteria = selectPeopleProjectDepartmentExample.createCriteria();
        criteria.andProjectPeopleIdEqualTo(projectPeopleId);
        List<Department> departmentList = new ArrayList<>();
        List<SelectPeopleProjectDepartment> selectPeopleProjectDepartmentList = selectPeopleProjectDepartmentMapper.selectByExample(selectPeopleProjectDepartmentExample);
        for(SelectPeopleProjectDepartment selectPeopleProjectDepartment:selectPeopleProjectDepartmentList){
            Department department = getDepartment(selectPeopleProjectDepartment.getId(),selectPeopleProjectDepartment.getName());
            if(!departmentList.contains(department)) {departmentList.add(department);}
        }
        return departmentList;
    }
    private Department getDepartment(Integer  id,String name){
        Department department = new Department();
        department.setId(id);
        department.setName(name);
        return department;
    }
}
