package org.hfut.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.hfut.pojo.SelectAllFinancialInformation;
import org.hfut.pojo.SelectAllFinancialInformationExample;

public interface SelectAllFinancialInformationMapper {
    long countByExample(SelectAllFinancialInformationExample example);

    int deleteByExample(SelectAllFinancialInformationExample example);

    int insert(SelectAllFinancialInformation record);

    int insertSelective(SelectAllFinancialInformation record);

    List<SelectAllFinancialInformation> selectByExample(SelectAllFinancialInformationExample example);

    int updateByExampleSelective(@Param("record") SelectAllFinancialInformation record, @Param("example") SelectAllFinancialInformationExample example);

    int updateByExample(@Param("record") SelectAllFinancialInformation record, @Param("example") SelectAllFinancialInformationExample example);
}