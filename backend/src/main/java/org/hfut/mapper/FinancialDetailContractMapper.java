package org.hfut.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.hfut.pojo.FinancialDetailContractExample;
import org.hfut.pojo.FinancialDetailContractKey;

public interface FinancialDetailContractMapper {

    long countByExample(FinancialDetailContractExample example);

    int deleteByExample(FinancialDetailContractExample example);

    int deleteByPrimaryKey(FinancialDetailContractKey key);

    int insert(FinancialDetailContractKey record);

    int insertSelective(FinancialDetailContractKey record);

    List<FinancialDetailContractKey> selectByExample(FinancialDetailContractExample example);

    int updateByExampleSelective(@Param("record") FinancialDetailContractKey record,
                                 @Param("example") FinancialDetailContractExample example);

    int updateByExample(@Param("record") FinancialDetailContractKey record,
                        @Param("example") FinancialDetailContractExample example);
}