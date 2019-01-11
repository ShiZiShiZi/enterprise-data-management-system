package org.hfut.service.departmentmanager;

import org.hfut.mapper.ProjectManagerMapper;
import org.hfut.mapper.ProjectPeopleMapper;
import org.hfut.pojo.ProjectManagerExample;
import org.hfut.pojo.ProjectManagerKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * SelectProjectManagerService
 *
 * @author WeiXin
 * @date 2019/1/10
 **/
@Service
public class SelectProjectManagerService {

    private ProjectManagerMapper projectManagerMapper;
    private ProjectPeopleMapper projectPeopleMapper;

    @Autowired
    public SelectProjectManagerService(ProjectManagerMapper projectManagerMapper,
                                       ProjectPeopleMapper projectPeopleMapper) {
        this.projectManagerMapper = projectManagerMapper;
        this.projectPeopleMapper = projectPeopleMapper;
    }

    public List<Integer> selectProjectManager(Integer projectId) {
        ProjectManagerExample projectManagerExample = new ProjectManagerExample();
        ProjectManagerExample.Criteria criteria = projectManagerExample.createCriteria();
        List<ProjectManagerKey> projectManagerKeys;
        List<Integer> projectManagerIds = new ArrayList<>();

        criteria.andProjectIdEqualTo(projectId);
        projectManagerKeys = projectManagerMapper.selectByExample(projectManagerExample);
        for(ProjectManagerKey projectManagerKey : projectManagerKeys) {
            projectManagerIds.add(projectManagerKey.getProjectPeopleId());
        }

        return projectManagerIds;
    }
}
