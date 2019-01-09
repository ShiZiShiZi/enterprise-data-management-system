package org.hfut.service.departmentmanager;

import org.hfut.mapper.ProjectMemberMapper;
import org.hfut.pojo.ProjectMemberKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Lee
 * @date 2019/1/8
 **/
@Service
public class AddProjectPeopleService {
    @Autowired
    private ProjectMemberMapper projectMemberMapper;

    public String insertProjectPeople(Integer projectId, List<Integer> projectPeopleList) {
        String msg = "插入失败";
        for (int i = 0; i < projectPeopleList.size(); i++) {
            ProjectMemberKey projectMemberKey = new ProjectMemberKey();
            projectMemberKey.setProjectId(projectId);
            projectMemberKey.setProjectPeopleId(projectPeopleList.get(i));
            if (projectMemberMapper.insert(projectMemberKey) == 0) {
                break;
            } else {
                msg = "插入成功";
            }
        }
        return msg;
    }
}
