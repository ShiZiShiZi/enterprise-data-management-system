package org.hfut.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.hfut.pojo.SelectProjectMaxIncomeType;
import org.hfut.pojo.SelectProjectMaxIncomeTypeExample;

public interface SelectProjectMaxIncomeTypeMapper {
    long countByExample(SelectProjectMaxIncomeTypeExample example);

    int deleteByExample(SelectProjectMaxIncomeTypeExample example);

    int insert(SelectProjectMaxIncomeType record);

    int insertSelective(SelectProjectMaxIncomeType record);

    List<SelectProjectMaxIncomeType> selectByExample(SelectProjectMaxIncomeTypeExample example);

    int updateByExampleSelective(@Param("record") SelectProjectMaxIncomeType record, @Param("example") SelectProjectMaxIncomeTypeExample example);

    int updateByExample(@Param("record") SelectProjectMaxIncomeType record, @Param("example") SelectProjectMaxIncomeTypeExample example);
}