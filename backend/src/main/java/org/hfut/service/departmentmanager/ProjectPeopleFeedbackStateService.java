package org.hfut.service.departmentmanager;

import org.hfut.mapper.model.ProjectPeopleStateMapper;
import org.hfut.model.ProjectPeopleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ProjectPeopleFeedbackStateService
 *
 * @author WeiXin
 * @date 2019/1/12
 **/
@Service
public class ProjectPeopleFeedbackStateService {

    private ProjectPeopleStateMapper projectPeopleStateMapper;

    @Autowired
    public ProjectPeopleFeedbackStateService(ProjectPeopleStateMapper projectPeopleStateMapper) {
        this.projectPeopleStateMapper = projectPeopleStateMapper;
    }

    public void selectStateByPeopleId(List<Integer> projectPeopleIds, Integer projectId,
                                      Map<String, Object> resultMap) {
        List<ProjectPeopleState> projectPeopleStates;
        Byte[] stateList = new Byte[projectPeopleIds.size()];
        Map<String, Object> exampleMap = new HashMap<>(2);
        Integer projectPeopleId;

        exampleMap.put("projectPeopleIds", projectPeopleIds);
        exampleMap.put("projectId", projectId);
        projectPeopleStates = projectPeopleStateMapper.selectByTargetPeopleId(exampleMap);
        for(ProjectPeopleState peopleState : projectPeopleStates) {
            projectPeopleId = peopleState.getProjectPeopleId();
            stateList[projectPeopleIds.indexOf(projectPeopleId)] = peopleState.getState();
        }

        final int accessible = -1;
        for(int i = 0; i < stateList.length; i++) {
            if(stateList[i] == null) {
                stateList[i] = accessible;
            }
        }

        resultMap.put("projectPeopleStateList", Arrays.asList(stateList));
    }
}
