package org.hfut.service.global;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.hfut.mapper.ProjectMapper;
import org.hfut.pojo.Project;
import org.hfut.pojo.ProjectExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * ProjectSearchService
 *
 * @author WeiXin
 * @date 2019/1/8
 **/
@Service
public class ProjectSearchService {

    @Autowired
    private ProjectMapper projectMapper;

    public void selectProject(ProjectExample projectExample, Integer currentPage, Integer pageSize,
                              Map<String, Object> resultMap) {
        List<Project> projects;
        PageInfo<Project> projectPageInfo;

        PageHelper.startPage(currentPage, pageSize);
        projects = projectMapper.selectByExample(projectExample);
        projectPageInfo = new PageInfo<>(projects);

        resultMap.put("projectList", projects);
        resultMap.put("maxPage", projectPageInfo.getPages());
    }

    public void selectByProjectId(ProjectExample.Criteria criteria, List<Integer> projectIds) {
        if(projectIds != null) {
            criteria.andIdIn(projectIds);
        }
    }

    public void selectByTitle(ProjectExample.Criteria criteria, String title) {
        if(title != null && title.length() > 0) {
            title = "%" + title;
            title += "%";
            criteria.andTitleLike(title);
        }
    }

    public void selectByStartTime(ProjectExample.Criteria criteria, List<String> startTimes) {
        final int timeLength = 2;
        if(startTimes != null && startTimes.size() == timeLength) {

        }
    }
}
