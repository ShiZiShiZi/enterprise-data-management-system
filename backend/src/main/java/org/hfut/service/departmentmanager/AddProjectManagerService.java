package org.hfut.service.departmentmanager;

import org.hfut.mapper.ProjectManagerMapper;
import org.hfut.pojo.ProjectManagerExample;
import org.hfut.pojo.ProjectManagerKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author panbaoqiang
 * @date 2019/1/11
 **/
@Service
public class AddProjectManagerService {
    @Autowired
    private ProjectManagerMapper projectManagerMapper;

    public void updateProjectManager(Integer projectId, List<Integer> projectPeopleIdList){
        //先删除这个项目之前的负责人
        ProjectManagerExample projectManagerExample = new ProjectManagerExample();
        ProjectManagerExample.Criteria criteria = projectManagerExample.createCriteria();
        criteria.andProjectIdEqualTo(projectId);
        projectManagerMapper.deleteByExample(projectManagerExample);
        //在遍历一遍将项目负责人插入,默认插入的项目负责人不会重复
        for(Integer projectPeopleId:projectPeopleIdList){
            ProjectManagerKey projectManagerKey = new ProjectManagerKey();
            projectManagerKey.setProjectId(projectId);
            projectManagerKey.setProjectPeopleId(projectPeopleId);
            projectManagerMapper.insert(projectManagerKey);
        }
    }
}
