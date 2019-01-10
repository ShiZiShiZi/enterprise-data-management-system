package org.hfut.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.hfut.pojo.SelectProjectMaxExpenditureType;
import org.hfut.pojo.SelectProjectMaxExpenditureTypeExample;

public interface SelectProjectMaxExpenditureTypeMapper {
    long countByExample(SelectProjectMaxExpenditureTypeExample example);

    int deleteByExample(SelectProjectMaxExpenditureTypeExample example);

    int insert(SelectProjectMaxExpenditureType record);

    int insertSelective(SelectProjectMaxExpenditureType record);

    List<SelectProjectMaxExpenditureType> selectByExample(SelectProjectMaxExpenditureTypeExample example);

    int updateByExampleSelective(@Param("record") SelectProjectMaxExpenditureType record, @Param("example") SelectProjectMaxExpenditureTypeExample example);

    int updateByExample(@Param("record") SelectProjectMaxExpenditureType record, @Param("example") SelectProjectMaxExpenditureTypeExample example);
}