package org.hfut.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.hfut.pojo.ProjectPeople;
import org.hfut.pojo.ProjectPeopleExample;

public interface ProjectPeopleMapper {

    long countByExample(ProjectPeopleExample example);

    int deleteByExample(ProjectPeopleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ProjectPeople record);

    int insertSelective(ProjectPeople record);

    List<ProjectPeople> selectByExample(ProjectPeopleExample example);

    ProjectPeople selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ProjectPeople record, @Param("example") ProjectPeopleExample example);

    int updateByExample(@Param("record") ProjectPeople record, @Param("example") ProjectPeopleExample example);

    int updateByPrimaryKeySelective(ProjectPeople record);

    int updateByPrimaryKey(ProjectPeople record);
}