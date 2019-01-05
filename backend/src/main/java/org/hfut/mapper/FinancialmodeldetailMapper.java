package org.hfut.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.hfut.pojo.Financialmodeldetail;
import org.hfut.pojo.FinancialmodeldetailExample;

public interface FinancialmodeldetailMapper {
    long countByExample(FinancialmodeldetailExample example);

    int deleteByExample(FinancialmodeldetailExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Financialmodeldetail record);

    int insertSelective(Financialmodeldetail record);

    List<Financialmodeldetail> selectByExample(FinancialmodeldetailExample example);

    Financialmodeldetail selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Financialmodeldetail record, @Param("example") FinancialmodeldetailExample example);

    int updateByExample(@Param("record") Financialmodeldetail record, @Param("example") FinancialmodeldetailExample example);

    int updateByPrimaryKeySelective(Financialmodeldetail record);

    int updateByPrimaryKey(Financialmodeldetail record);
}