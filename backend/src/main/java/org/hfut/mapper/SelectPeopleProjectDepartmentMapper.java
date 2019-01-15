package org.hfut.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.hfut.pojo.SelectPeopleProjectDepartment;
import org.hfut.pojo.SelectPeopleProjectDepartmentExample;

public interface SelectPeopleProjectDepartmentMapper {
    long countByExample(SelectPeopleProjectDepartmentExample example);

    int deleteByExample(SelectPeopleProjectDepartmentExample example);

    int insert(SelectPeopleProjectDepartment record);

    int insertSelective(SelectPeopleProjectDepartment record);

    List<SelectPeopleProjectDepartment> selectByExample(SelectPeopleProjectDepartmentExample example);

    int updateByExampleSelective(@Param("record") SelectPeopleProjectDepartment record, @Param("example") SelectPeopleProjectDepartmentExample example);

    int updateByExample(@Param("record") SelectPeopleProjectDepartment record, @Param("example") SelectPeopleProjectDepartmentExample example);
}