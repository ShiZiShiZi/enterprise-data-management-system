package org.hfut.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.hfut.pojo.DepartmentManagerExample;
import org.hfut.pojo.DepartmentManagerKey;

public interface DepartmentManagerMapper {

    long countByExample(DepartmentManagerExample example);

    int deleteByExample(DepartmentManagerExample example);

    int deleteByPrimaryKey(DepartmentManagerKey key);

    int insert(DepartmentManagerKey record);

    int insertSelective(DepartmentManagerKey record);

    List<DepartmentManagerKey> selectByExample(DepartmentManagerExample example);

    int updateByExampleSelective(@Param("record") DepartmentManagerKey record,
                                 @Param("example") DepartmentManagerExample example);

    int updateByExample(@Param("record") DepartmentManagerKey record,
                        @Param("example") DepartmentManagerExample example);
}