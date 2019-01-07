package org.hfut.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.hfut.pojo.Financiallog;
import org.hfut.pojo.FinanciallogExample;

public interface FinanciallogMapper {
    long countByExample(FinanciallogExample example);

    int deleteByExample(FinanciallogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Financiallog record);

    int insertSelective(Financiallog record);

    List<Financiallog> selectByExample(FinanciallogExample example);

    Financiallog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Financiallog record, @Param("example") FinanciallogExample example);

    int updateByExample(@Param("record") Financiallog record, @Param("example") FinanciallogExample example);

    int updateByPrimaryKeySelective(Financiallog record);

    int updateByPrimaryKey(Financiallog record);
}