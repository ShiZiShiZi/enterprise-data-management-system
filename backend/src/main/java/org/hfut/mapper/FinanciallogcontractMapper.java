package org.hfut.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.hfut.pojo.FinanciallogcontractExample;
import org.hfut.pojo.FinanciallogcontractKey;

public interface FinanciallogcontractMapper {
    long countByExample(FinanciallogcontractExample example);

    int deleteByExample(FinanciallogcontractExample example);

    int deleteByPrimaryKey(FinanciallogcontractKey key);

    int insert(FinanciallogcontractKey record);

    int insertSelective(FinanciallogcontractKey record);

    List<FinanciallogcontractKey> selectByExample(FinanciallogcontractExample example);

    int updateByExampleSelective(@Param("record") FinanciallogcontractKey record, @Param("example") FinanciallogcontractExample example);

    int updateByExample(@Param("record") FinanciallogcontractKey record, @Param("example") FinanciallogcontractExample example);
}