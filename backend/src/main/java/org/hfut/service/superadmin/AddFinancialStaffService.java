package org.hfut.service.superadmin;

import org.hfut.mapper.ProjectpeopleMapper;
import org.hfut.pojo.Projectpeople;
import org.hfut.pojo.ProjectpeopleExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddFinancialStaffService {
    @Autowired
    private ProjectpeopleMapper projectpeopleMapper;
    //               第一个模块


    public void addFinanceStaff(Integer departmentid,
                                String phone,
                                String Email,
                                String password,
                                Boolean flag,
                                String name){
        Projectpeople projectpeople = new Projectpeople();
        projectpeople.setDepartmentid(departmentid);
        projectpeople.setPhonenum(phone);
        projectpeople.setEmail(Email);
        projectpeople.setPassword(password);
        projectpeople.setAcrossdepartment(flag);
        projectpeople.setName(name);
        Byte b = 4;//permission为4说明是财务人员
        projectpeople.setPermissions(b);
        projectpeopleMapper.insertSelective(projectpeople);
    }
    //               第一个模块结束
}
