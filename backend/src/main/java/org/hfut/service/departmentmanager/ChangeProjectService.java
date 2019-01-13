package org.hfut.service.departmentmanager;

import org.hfut.mapper.ProjectMapper;
import org.hfut.pojo.Project;
import org.hfut.pojo.ProjectExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 卅果果
 * @date 2019/1/11
 **/
@Service
public class ChangeProjectService {
    @Autowired
    private ProjectMapper projectMapper;

    public String changeProject(Integer projectId, String newTitle, String newFinishTime, String newDescription) throws ParseException {
        String msg = "更改失败";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date newFinishTimeDate  = simpleDateFormat.parse(newFinishTime);
        ProjectExample projectExample = new ProjectExample();
        ProjectExample.Criteria criteria = projectExample.createCriteria();
        criteria.andIdEqualTo(projectId);

        Project project = new Project();
        project.setTitle(newTitle);
        project.setFinishTime(newFinishTimeDate);
        project.setDescription(newDescription);
        projectMapper.updateByExampleSelective(project,projectExample);
        msg = "更改成功";
        return msg;
    }

}
