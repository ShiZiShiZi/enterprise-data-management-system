package org.hfut.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.hfut.pojo.SelectProjectPeopleInfo;
import org.hfut.pojo.SelectProjectPeopleInfoExample;

public interface SelectProjectPeopleInfoMapper {
    long countByExample(SelectProjectPeopleInfoExample example);

    int deleteByExample(SelectProjectPeopleInfoExample example);

    int insert(SelectProjectPeopleInfo record);

    int insertSelective(SelectProjectPeopleInfo record);

    List<SelectProjectPeopleInfo> selectByExample(SelectProjectPeopleInfoExample example);

    int updateByExampleSelective(@Param("record") SelectProjectPeopleInfo record, @Param("example") SelectProjectPeopleInfoExample example);

    int updateByExample(@Param("record") SelectProjectPeopleInfo record, @Param("example") SelectProjectPeopleInfoExample example);
}