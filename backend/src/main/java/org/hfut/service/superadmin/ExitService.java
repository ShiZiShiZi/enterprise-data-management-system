package org.hfut.service.superadmin;

import org.hfut.mapper.DepartmentMapper;
import org.hfut.mapper.ProjectpeopleMapper;
import org.hfut.pojo.Department;
import org.hfut.pojo.DepartmentExample;
import org.hfut.pojo.Projectpeople;
import org.hfut.pojo.ProjectpeopleExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExitService {
    @Autowired
    private ProjectpeopleMapper projectpeopleMapper;
    @Autowired
    private DepartmentMapper departmentMapper;
    public String isPhoneOrEmailExitBy(String phone_email){
        /*查看财务人员电话是否存在，是：返回Yes,不是：返回no*/
        ProjectpeopleExample projectpeopleExample =new ProjectpeopleExample();
        ProjectpeopleExample.Criteria criteria = projectpeopleExample.createCriteria();
        criteria.andPhonenumEqualTo(phone_email);
        ProjectpeopleExample projectpeopleExample1 = new ProjectpeopleExample();
        ProjectpeopleExample.Criteria criteria1= projectpeopleExample1.createCriteria();
        criteria1.andEmailEqualTo(phone_email);
        projectpeopleExample.or(criteria1);
        List<Projectpeople> projectpeopleList = projectpeopleMapper.selectByExample(projectpeopleExample);
        return (projectpeopleList == null || projectpeopleList.isEmpty()) ? "no" : "yes";
    }

    public String isExitDepartmentByName(String name){
        //  部门名是否存在
        DepartmentExample departmentExample = new DepartmentExample();
        DepartmentExample.Criteria criteria = departmentExample.createCriteria();
        criteria.andNameEqualTo(name);
        List<Department> departmentList = departmentMapper.selectByExample(departmentExample);
        return (departmentList ==null || departmentList.isEmpty()) ? "no" : "yes";
    }

}
