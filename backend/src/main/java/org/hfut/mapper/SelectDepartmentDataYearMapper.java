package org.hfut.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.hfut.pojo.SelectDepartmentDataYear;
import org.hfut.pojo.SelectDepartmentDataYearExample;

public interface SelectDepartmentDataYearMapper {
    long countByExample(SelectDepartmentDataYearExample example);

    int deleteByExample(SelectDepartmentDataYearExample example);

    int insert(SelectDepartmentDataYear record);

    int insertSelective(SelectDepartmentDataYear record);

    List<SelectDepartmentDataYear> selectByExample(SelectDepartmentDataYearExample example);

    int updateByExampleSelective(@Param("record") SelectDepartmentDataYear record, @Param("example") SelectDepartmentDataYearExample example);

    int updateByExample(@Param("record") SelectDepartmentDataYear record, @Param("example") SelectDepartmentDataYearExample example);
}