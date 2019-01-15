package org.hfut.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.hfut.pojo.WaitingRegisterPeople;
import org.hfut.pojo.WaitingRegisterPeopleExample;

public interface WaitingRegisterPeopleMapper {

    long countByExample(WaitingRegisterPeopleExample example);

    int deleteByExample(WaitingRegisterPeopleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WaitingRegisterPeople record);

    int insertSelective(WaitingRegisterPeople record);

    List<WaitingRegisterPeople> selectByExample(WaitingRegisterPeopleExample example);

    WaitingRegisterPeople selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WaitingRegisterPeople record,
                                 @Param("example") WaitingRegisterPeopleExample example);

    int updateByExample(@Param("record") WaitingRegisterPeople record,
                        @Param("example") WaitingRegisterPeopleExample example);

    int updateByPrimaryKeySelective(WaitingRegisterPeople record);

    int updateByPrimaryKey(WaitingRegisterPeople record);
}