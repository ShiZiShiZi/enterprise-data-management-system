package org.hfut.service.departmentmanager;

import org.hfut.mapper.ProjectPeopleFeedbackMapper;
import org.hfut.pojo.ProjectPeopleFeedback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author panbaoqiang
 * @date 2019/1/11
 **/
@Service
public class AddAcrossDepartmentPeopleService {
    @Autowired
    private ProjectPeopleFeedbackMapper projectPeopleFeedbackMapper;
    public String  addAcrossDepartmentPeople(List<Integer> peopleIdList,
                                             Integer projectId,
                                             Integer departmentId,
                                             Integer requestPeopleId){
        //为projectId这个项目申请peopleId的人的使用，departmentId为请求发出的部门
        //requestPeopleId请求人Id
        ProjectPeopleFeedback projectPeopleFeedback = new ProjectPeopleFeedback();
        projectPeopleFeedback.setRequestPeopleId(requestPeopleId);
        projectPeopleFeedback.setRequestTime(new Date());
        Byte state = 0;
        projectPeopleFeedback.setState(state);
        projectPeopleFeedback.setTargetDepartmentId(departmentId);
        projectPeopleFeedback.setTargetProjectId(projectId);
        for(Integer projectPeopleId : peopleIdList){
            projectPeopleFeedback.setTargetPeopleId(projectPeopleId);
            projectPeopleFeedbackMapper.insertSelective(projectPeopleFeedback);
        }
        return "Success";
    }
}
