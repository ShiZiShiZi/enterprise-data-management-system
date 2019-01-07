package org.hfut.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.hfut.pojo.SelectPersonProject;
import org.hfut.pojo.SelectPersonProjectExample;

public interface SelectPersonProjectMapper {
    long countByExample(SelectPersonProjectExample example);

    int deleteByExample(SelectPersonProjectExample example);

    int insert(SelectPersonProject record);

    int insertSelective(SelectPersonProject record);

    List<SelectPersonProject> selectByExample(SelectPersonProjectExample example);

    int updateByExampleSelective(@Param("record") SelectPersonProject record, @Param("example") SelectPersonProjectExample example);

    int updateByExample(@Param("record") SelectPersonProject record, @Param("example") SelectPersonProjectExample example);
}