package org.hfut.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.hfut.pojo.FinancialLog;
import org.hfut.pojo.FinancialLogExample;

public interface FinancialLogMapper {

    long countByExample(FinancialLogExample example);

    int deleteByExample(FinancialLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FinancialLog record);

    int insertSelective(FinancialLog record);

    List<FinancialLog> selectByExample(FinancialLogExample example);

    FinancialLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FinancialLog record, @Param("example") FinancialLogExample example);

    int updateByExample(@Param("record") FinancialLog record, @Param("example") FinancialLogExample example);

    int updateByPrimaryKeySelective(FinancialLog record);

    int updateByPrimaryKey(FinancialLog record);
}