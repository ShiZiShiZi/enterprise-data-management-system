package org.hfut.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.hfut.pojo.SelectCloseprojectinfo;
import org.hfut.pojo.SelectCloseprojectinfoExample;

public interface SelectCloseprojectinfoMapper {
    long countByExample(SelectCloseprojectinfoExample example);

    int deleteByExample(SelectCloseprojectinfoExample example);

    int insert(SelectCloseprojectinfo record);

    int insertSelective(SelectCloseprojectinfo record);

    List<SelectCloseprojectinfo> selectByExample(SelectCloseprojectinfoExample example);

    int updateByExampleSelective(@Param("record") SelectCloseprojectinfo record, @Param("example") SelectCloseprojectinfoExample example);

    int updateByExample(@Param("record") SelectCloseprojectinfo record, @Param("example") SelectCloseprojectinfoExample example);
}