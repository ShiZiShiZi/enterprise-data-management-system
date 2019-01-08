package org.hfut.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.hfut.pojo.FinancialLogContractExample;
import org.hfut.pojo.FinancialLogContractKey;

public interface FinancialLogContractMapper {

    long countByExample(FinancialLogContractExample example);

    int deleteByExample(FinancialLogContractExample example);

    int deleteByPrimaryKey(FinancialLogContractKey key);

    int insert(FinancialLogContractKey record);

    int insertSelective(FinancialLogContractKey record);

    List<FinancialLogContractKey> selectByExample(FinancialLogContractExample example);

    int updateByExampleSelective(@Param("record") FinancialLogContractKey record,
                                 @Param("example") FinancialLogContractExample example);

    int updateByExample(@Param("record") FinancialLogContractKey record,
                        @Param("example") FinancialLogContractExample example);
}