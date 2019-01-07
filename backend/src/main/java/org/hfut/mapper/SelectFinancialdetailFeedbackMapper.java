package org.hfut.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.hfut.pojo.SelectFinancialdetailFeedback;
import org.hfut.pojo.SelectFinancialdetailFeedbackExample;

public interface SelectFinancialdetailFeedbackMapper {

    long countByExample(SelectFinancialdetailFeedbackExample example);

    int deleteByExample(SelectFinancialdetailFeedbackExample example);

    int insert(SelectFinancialdetailFeedback record);

    int insertSelective(SelectFinancialdetailFeedback record);

    List<SelectFinancialdetailFeedback> selectByExample(SelectFinancialdetailFeedbackExample example);

    int updateByExampleSelective(@Param("record") SelectFinancialdetailFeedback record,
                                 @Param("example") SelectFinancialdetailFeedbackExample example);

    int updateByExample(@Param("record") SelectFinancialdetailFeedback record,
                        @Param("example") SelectFinancialdetailFeedbackExample example);
}