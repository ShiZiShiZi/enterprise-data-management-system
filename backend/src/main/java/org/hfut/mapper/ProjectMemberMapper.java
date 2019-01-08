package org.hfut.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.hfut.pojo.ProjectMemberExample;
import org.hfut.pojo.ProjectMemberKey;

public interface ProjectMemberMapper {

    long countByExample(ProjectMemberExample example);

    int deleteByExample(ProjectMemberExample example);

    int deleteByPrimaryKey(ProjectMemberKey key);

    int insert(ProjectMemberKey record);

    int insertSelective(ProjectMemberKey record);

    List<ProjectMemberKey> selectByExample(ProjectMemberExample example);

    int updateByExampleSelective(@Param("record") ProjectMemberKey record,
                                 @Param("example") ProjectMemberExample example);

    int updateByExample(@Param("record") ProjectMemberKey record, @Param("example") ProjectMemberExample example);
}