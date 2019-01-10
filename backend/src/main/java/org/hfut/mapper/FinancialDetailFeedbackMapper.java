package org.hfut.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.hfut.pojo.FinancialDetailFeedback;
import org.hfut.pojo.FinancialDetailFeedbackExample;

public interface FinancialDetailFeedbackMapper {

    long countByExample(FinancialDetailFeedbackExample example);

    int deleteByExample(FinancialDetailFeedbackExample example);

    int deleteByPrimaryKey(Integer financialDetailId);

    int insert(FinancialDetailFeedback record);

    int insertSelective(FinancialDetailFeedback record);

    List<FinancialDetailFeedback> selectByExample(FinancialDetailFeedbackExample example);

    FinancialDetailFeedback selectByPrimaryKey(Integer financialDetailId);

    int updateByExampleSelective(@Param("record") FinancialDetailFeedback record,
                                 @Param("example") FinancialDetailFeedbackExample example);

    int updateByExample(@Param("record") FinancialDetailFeedback record,
                        @Param("example") FinancialDetailFeedbackExample example);

    int updateByPrimaryKeySelective(FinancialDetailFeedback record);

    int updateByPrimaryKey(FinancialDetailFeedback record);
}