package org.hfut.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.hfut.pojo.FinancialDetail;
import org.hfut.pojo.FinancialDetailExample;

public interface FinancialDetailMapper {

    long countByExample(FinancialDetailExample example);

    int deleteByExample(FinancialDetailExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FinancialDetail record);

    int insertSelective(FinancialDetail record);

    List<FinancialDetail> selectByExample(FinancialDetailExample example);

    FinancialDetail selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FinancialDetail record,
                                 @Param("example") FinancialDetailExample example);

    int updateByExample(@Param("record") FinancialDetail record, @Param("example") FinancialDetailExample example);

    int updateByPrimaryKeySelective(FinancialDetail record);

    int updateByPrimaryKey(FinancialDetail record);
}