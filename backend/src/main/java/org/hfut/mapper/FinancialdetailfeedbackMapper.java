package org.hfut.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.hfut.pojo.Financialdetailfeedback;
import org.hfut.pojo.FinancialdetailfeedbackExample;

public interface FinancialdetailfeedbackMapper {
    long countByExample(FinancialdetailfeedbackExample example);

    int deleteByExample(FinancialdetailfeedbackExample example);

    int deleteByPrimaryKey(Integer financialdetailid);

    int insert(Financialdetailfeedback record);

    int insertSelective(Financialdetailfeedback record);

    List<Financialdetailfeedback> selectByExample(FinancialdetailfeedbackExample example);

    Financialdetailfeedback selectByPrimaryKey(Integer financialdetailid);

    int updateByExampleSelective(@Param("record") Financialdetailfeedback record,
                                 @Param("example") FinancialdetailfeedbackExample example);

    int updateByExample(@Param("record") Financialdetailfeedback record,
                        @Param("example") FinancialdetailfeedbackExample example);

    int updateByPrimaryKeySelective(Financialdetailfeedback record);

    int updateByPrimaryKey(Financialdetailfeedback record);
}