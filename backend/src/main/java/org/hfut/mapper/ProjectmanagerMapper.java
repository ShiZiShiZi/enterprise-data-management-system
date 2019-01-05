package org.hfut.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.hfut.pojo.ProjectmanagerExample;
import org.hfut.pojo.ProjectmanagerKey;

public interface ProjectmanagerMapper {
    long countByExample(ProjectmanagerExample example);

    int deleteByExample(ProjectmanagerExample example);

    int deleteByPrimaryKey(ProjectmanagerKey key);

    int insert(ProjectmanagerKey record);

    int insertSelective(ProjectmanagerKey record);

    List<ProjectmanagerKey> selectByExample(ProjectmanagerExample example);

    int updateByExampleSelective(@Param("record") ProjectmanagerKey record, @Param("example") ProjectmanagerExample example);

    int updateByExample(@Param("record") ProjectmanagerKey record, @Param("example") ProjectmanagerExample example);
}