package org.hfut.service.global;

import org.hfut.mapper.ProjectPeopleMapper;
import org.hfut.pojo.ProjectPeople;
import org.hfut.pojo.ProjectPeopleExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author panbaoqiang
 * @date 2019/1/15
 **/
@Service
public class LoginService {
    @Autowired
    private ProjectPeopleMapper projectPeopleMapper;
    public Object getProjectPeopleByEmailOrPhone(String account,Boolean status){
        //如果status为true,则返回他是否为空（true或者false）status 为false,返回一个list数组
        List<ProjectPeople> projectPeopleList = projectPeopleMapper.selectByExample(getProjectPeopleExampleAboutEmailOrPhone(account));
        if(status) {
            return projectPeopleList.isEmpty();
        }
        return projectPeopleList;
    }
    private ProjectPeopleExample getProjectPeopleExampleAboutEmailOrPhone(String account){
        //获取一个email等于account或者phone等于account的条件Exam
        ProjectPeopleExample projectPeopleExample =new ProjectPeopleExample();
        ProjectPeopleExample.Criteria criteria = projectPeopleExample.createCriteria();
        criteria.andPhoneNumberEqualTo(account);
        ProjectPeopleExample projectPeopleExampleOne = new ProjectPeopleExample();
        ProjectPeopleExample.Criteria criteria1= projectPeopleExampleOne.createCriteria();
        criteria1.andEmailEqualTo(account);
        projectPeopleExample.or(criteria1);
        return projectPeopleExample;
    }
}
