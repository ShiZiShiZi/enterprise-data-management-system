package org.hfut.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.hfut.pojo.SelectProjectFinancialmodeldetail;
import org.hfut.pojo.SelectProjectFinancialmodeldetailExample;

public interface SelectProjectFinancialmodeldetailMapper {
    long countByExample(SelectProjectFinancialmodeldetailExample example);

    int deleteByExample(SelectProjectFinancialmodeldetailExample example);

    int insert(SelectProjectFinancialmodeldetail record);

    int insertSelective(SelectProjectFinancialmodeldetail record);

    List<SelectProjectFinancialmodeldetail> selectByExample(SelectProjectFinancialmodeldetailExample example);

    int updateByExampleSelective(@Param("record") SelectProjectFinancialmodeldetail record, @Param("example") SelectProjectFinancialmodeldetailExample example);

    int updateByExample(@Param("record") SelectProjectFinancialmodeldetail record, @Param("example") SelectProjectFinancialmodeldetailExample example);
}