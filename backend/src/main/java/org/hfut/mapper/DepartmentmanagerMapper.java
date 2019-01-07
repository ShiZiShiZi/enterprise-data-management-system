package org.hfut.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.hfut.pojo.DepartmentmanagerExample;
import org.hfut.pojo.DepartmentmanagerKey;

public interface DepartmentmanagerMapper {
    long countByExample(DepartmentmanagerExample example);

    int deleteByExample(DepartmentmanagerExample example);

    int deleteByPrimaryKey(DepartmentmanagerKey key);

    int insert(DepartmentmanagerKey record);

    int insertSelective(DepartmentmanagerKey record);

    List<DepartmentmanagerKey> selectByExample(DepartmentmanagerExample example);

    int updateByExampleSelective(@Param("record") DepartmentmanagerKey record, @Param("example") DepartmentmanagerExample example);

    int updateByExample(@Param("record") DepartmentmanagerKey record, @Param("example") DepartmentmanagerExample example);
}