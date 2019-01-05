package org.hfut.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.hfut.pojo.FinancialdetailcontractExample;
import org.hfut.pojo.FinancialdetailcontractKey;

public interface FinancialdetailcontractMapper {
    long countByExample(FinancialdetailcontractExample example);

    int deleteByExample(FinancialdetailcontractExample example);

    int deleteByPrimaryKey(FinancialdetailcontractKey key);

    int insert(FinancialdetailcontractKey record);

    int insertSelective(FinancialdetailcontractKey record);

    List<FinancialdetailcontractKey> selectByExample(FinancialdetailcontractExample example);

    int updateByExampleSelective(@Param("record") FinancialdetailcontractKey record, @Param("example") FinancialdetailcontractExample example);

    int updateByExample(@Param("record") FinancialdetailcontractKey record, @Param("example") FinancialdetailcontractExample example);
}