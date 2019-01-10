package org.hfut.service.departmentmanager;

import org.hfut.mapper.ProjectMapper;
import org.hfut.mapper.ProjectPeopleMapper;
import org.hfut.pojo.Project;
import org.hfut.pojo.ProjectPeople;
import org.hfut.pojo.ProjectPeopleExample;
import org.hfut.tool.global.StringConvertToDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author panbaoqiang
 * @date 2019/1/10
 **/
@Service
public class InsertProjectService {
    @Autowired
    private ProjectMapper projectMapper;
    @Autowired
    private ProjectPeopleMapper projectPeopleMapper;

    public Integer insertProject(String title,
                                 String description,
                                 String startTime,
                                 Integer projectPeopleId,
                                 String finishTime) {
        Project project = new Project();
        project.setTitle(title);
        project.setDescription(description);
        project.setStartTime(StringConvertToDate.getNewDate(startTime));
        project.setFinishTime(StringConvertToDate.getNewDate(finishTime));
        project.setActive(true);
        project.setDepartmentId(getDepartmentId(projectPeopleId));
        project.setCloseTime(StringConvertToDate.getNewDate(StringConvertToDate.initializedDateStr));
        projectMapper.insertSelective(project);
        return project.getId();
        //不知道为什么，插入项目到数据库后，数据库自动生成的id就更新到这个临时Project变量去了
    }

    private Integer getDepartmentId(Integer projectPeopleId) {
        ProjectPeopleExample projectPeopleExample = new ProjectPeopleExample();
        ProjectPeopleExample.Criteria criteria = projectPeopleExample.createCriteria();
        criteria.andIdEqualTo(projectPeopleId);
        List<ProjectPeople> projectPeopleList = projectPeopleMapper.selectByExample(projectPeopleExample);
        return projectPeopleList.get(0).getDepartmentId();
    }
}
