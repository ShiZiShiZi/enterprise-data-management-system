package org.hfut.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.hfut.pojo.ProjectManagerExample;
import org.hfut.pojo.ProjectManagerKey;

public interface ProjectManagerMapper {

    long countByExample(ProjectManagerExample example);

    int deleteByExample(ProjectManagerExample example);

    int deleteByPrimaryKey(ProjectManagerKey key);

    int insert(ProjectManagerKey record);

    int insertSelective(ProjectManagerKey record);

    List<ProjectManagerKey> selectByExample(ProjectManagerExample example);

    int updateByExampleSelective(@Param("record") ProjectManagerKey record,
                                 @Param("example") ProjectManagerExample example);

    int updateByExample(@Param("record") ProjectManagerKey record, @Param("example") ProjectManagerExample example);
}