package org.hfut.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.hfut.pojo.FinancialModel;
import org.hfut.pojo.FinancialModelExample;

public interface FinancialModelMapper {

    long countByExample(FinancialModelExample example);

    int deleteByExample(FinancialModelExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FinancialModel record);

    int insertSelective(FinancialModel record);

    List<FinancialModel> selectByExample(FinancialModelExample example);

    FinancialModel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FinancialModel record,
                                 @Param("example") FinancialModelExample example);

    int updateByExample(@Param("record") FinancialModel record, @Param("example") FinancialModelExample example);

    int updateByPrimaryKeySelective(FinancialModel record);

    int updateByPrimaryKey(FinancialModel record);
}