package org.hfut.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.hfut.pojo.ProjectPeopleFeedback;
import org.hfut.pojo.ProjectPeopleFeedbackExample;

public interface ProjectPeopleFeedbackMapper {

    long countByExample(ProjectPeopleFeedbackExample example);

    int deleteByExample(ProjectPeopleFeedbackExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ProjectPeopleFeedback record);

    int insertSelective(ProjectPeopleFeedback record);

    List<ProjectPeopleFeedback> selectByExample(ProjectPeopleFeedbackExample example);

    ProjectPeopleFeedback selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ProjectPeopleFeedback record,
                                 @Param("example") ProjectPeopleFeedbackExample example);

    int updateByExample(@Param("record") ProjectPeopleFeedback record,
                        @Param("example") ProjectPeopleFeedbackExample example);

    int updateByPrimaryKeySelective(ProjectPeopleFeedback record);

    int updateByPrimaryKey(ProjectPeopleFeedback record);
}