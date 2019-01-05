package org.hfut.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.hfut.pojo.Projectpeople;
import org.hfut.pojo.ProjectpeopleExample;

public interface ProjectpeopleMapper {
    long countByExample(ProjectpeopleExample example);

    int deleteByExample(ProjectpeopleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Projectpeople record);

    int insertSelective(Projectpeople record);

    List<Projectpeople> selectByExample(ProjectpeopleExample example);

    Projectpeople selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Projectpeople record, @Param("example") ProjectpeopleExample example);

    int updateByExample(@Param("record") Projectpeople record, @Param("example") ProjectpeopleExample example);

    int updateByPrimaryKeySelective(Projectpeople record);

    int updateByPrimaryKey(Projectpeople record);
}