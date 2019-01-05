package org.hfut.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.hfut.pojo.Financialmodel;
import org.hfut.pojo.FinancialmodelExample;

public interface FinancialmodelMapper {
    long countByExample(FinancialmodelExample example);

    int deleteByExample(FinancialmodelExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Financialmodel record);

    int insertSelective(Financialmodel record);

    List<Financialmodel> selectByExample(FinancialmodelExample example);

    Financialmodel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Financialmodel record, @Param("example") FinancialmodelExample example);

    int updateByExample(@Param("record") Financialmodel record, @Param("example") FinancialmodelExample example);

    int updateByPrimaryKeySelective(Financialmodel record);

    int updateByPrimaryKey(Financialmodel record);
}