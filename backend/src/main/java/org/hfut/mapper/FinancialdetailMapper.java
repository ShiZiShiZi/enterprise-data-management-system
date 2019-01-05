package org.hfut.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.hfut.pojo.Financialdetail;
import org.hfut.pojo.FinancialdetailExample;

public interface FinancialdetailMapper {
    long countByExample(FinancialdetailExample example);

    int deleteByExample(FinancialdetailExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Financialdetail record);

    int insertSelective(Financialdetail record);

    List<Financialdetail> selectByExample(FinancialdetailExample example);

    Financialdetail selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Financialdetail record, @Param("example") FinancialdetailExample example);

    int updateByExample(@Param("record") Financialdetail record, @Param("example") FinancialdetailExample example);

    int updateByPrimaryKeySelective(Financialdetail record);

    int updateByPrimaryKey(Financialdetail record);
}