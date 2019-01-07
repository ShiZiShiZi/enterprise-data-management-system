package org.hfut.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.hfut.pojo.ProjectmemberExample;
import org.hfut.pojo.ProjectmemberKey;

public interface ProjectmemberMapper {
    long countByExample(ProjectmemberExample example);

    int deleteByExample(ProjectmemberExample example);

    int deleteByPrimaryKey(ProjectmemberKey key);

    int insert(ProjectmemberKey record);

    int insertSelective(ProjectmemberKey record);

    List<ProjectmemberKey> selectByExample(ProjectmemberExample example);

    int updateByExampleSelective(@Param("record") ProjectmemberKey record, @Param("example") ProjectmemberExample example);

    int updateByExample(@Param("record") ProjectmemberKey record, @Param("example") ProjectmemberExample example);
}