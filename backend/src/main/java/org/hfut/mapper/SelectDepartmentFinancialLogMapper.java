package org.hfut.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.hfut.pojo.SelectDepartmentFinancialLog;
import org.hfut.pojo.SelectDepartmentFinancialLogExample;

public interface SelectDepartmentFinancialLogMapper {
    long countByExample(SelectDepartmentFinancialLogExample example);

    int deleteByExample(SelectDepartmentFinancialLogExample example);

    int insert(SelectDepartmentFinancialLog record);

    int insertSelective(SelectDepartmentFinancialLog record);

    List<SelectDepartmentFinancialLog> selectByExample(SelectDepartmentFinancialLogExample example);

    int updateByExampleSelective(@Param("record") SelectDepartmentFinancialLog record, @Param("example") SelectDepartmentFinancialLogExample example);

    int updateByExample(@Param("record") SelectDepartmentFinancialLog record, @Param("example") SelectDepartmentFinancialLogExample example);
}