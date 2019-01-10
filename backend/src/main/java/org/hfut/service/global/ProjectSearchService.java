package org.hfut.service.global;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.hfut.mapper.ProjectMapper;
import org.hfut.pojo.Project;
import org.hfut.pojo.ProjectExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
        if(projectIds != null && projectIds.size() > 0) {
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

    public void selectByTime(ProjectExample.Criteria criteria, List<String> times, Integer type) throws ParseException {
        final int timeLength = 2;
        final int startTime = 1;
        final int finishTime = 2;
        final int closeTime = 3;

        if(times != null && times.size() == timeLength) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
            Date startDate = dateFormat.parse(times.get(0));
            Date endDate = dateFormat.parse(times.get(1));

            switch(type) {
                case startTime:
                    criteria.andStartTimeBetween(startDate, endDate);
                    break;
                case finishTime:
                    criteria.andFinishTimeBetween(startDate, endDate);
                    break;
                case closeTime:
                    criteria.andCloseTimeBetween(startDate, endDate);
                    break;
                default:
            }
        }
    }

    public void selectByDepartmentId(ProjectExample.Criteria criteria, Integer departmentId) {
        if(departmentId != null) {
            criteria.andDepartmentIdEqualTo(departmentId);
        }
    }

    public void selectByActive(ProjectExample.Criteria criteria, Integer isActive) {
        if(isActive != null) {
            if(isActive == 1) {
                criteria.andActiveEqualTo(true);
            } else {
                criteria.andActiveEqualTo(false);
            }
        }
    }

    public void sortBy(ProjectExample projectExample, String sortColumn, Integer sortOrder) {
        String sortOrderString;
        if(sortOrder == 1) {
            sortOrderString = " ASC";
        } else {
            sortOrderString = " DESC";
        }
        projectExample.setOrderByClause(sortColumn + sortOrderString);
    }

}
