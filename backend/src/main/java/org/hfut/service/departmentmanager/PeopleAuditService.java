package org.hfut.service.departmentmanager;

import org.hfut.mapper.ProjectPeopleFeedbackMapper;
import org.hfut.pojo.ProjectPeopleFeedback;
import org.hfut.pojo.ProjectPeopleFeedbackExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author panbaoqiang
 * @date 2019/1/10
 **/
@Service
public class PeopleAuditService {
    @Autowired
    private ProjectPeopleFeedbackMapper projectPeopleFeedbackMapper;
    public String auditing(Integer feedbackId,
                           Integer state,
                           String description,
                           Integer projectPeopleId){
        ProjectPeopleFeedbackExample projectPeopleFeedbackExample = new ProjectPeopleFeedbackExample();
        ProjectPeopleFeedbackExample.Criteria criteria = projectPeopleFeedbackExample.createCriteria();
        criteria.andIdEqualTo(feedbackId);
        ProjectPeopleFeedback projectPeopleFeedback = new ProjectPeopleFeedback();
        projectPeopleFeedback.setState((byte)state.intValue());
        projectPeopleFeedback.setDescription(description);
        projectPeopleFeedback.setReesponseTime(new Date());
        //下面这句话就是将部门管理员的id更新feedback表的ResponsePeopleId
        //但是想到一开始插入一条feedback必须指定好ResponsePeopleId，不然插不进去
        //那么既然一开始指定了ResponsePeopleId也就没有必要更新ResponsePeopleId
        //有点矛盾  projectPeopleFeedback.setResponsePeopleId(projectPeopleId);可能不需要
        projectPeopleFeedback.setResponsePeopeleId(projectPeopleId);
        projectPeopleFeedbackMapper.updateByExampleSelective(projectPeopleFeedback,projectPeopleFeedbackExample);
        return "Success";
    }
}
