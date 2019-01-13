package org.hfut.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.hfut.pojo.SelectGetFeedbackList;
import org.hfut.pojo.SelectGetFeedbackListExample;

public interface SelectGetFeedbackListMapper {
    long countByExample(SelectGetFeedbackListExample example);

    int deleteByExample(SelectGetFeedbackListExample example);

    int insert(SelectGetFeedbackList record);

    int insertSelective(SelectGetFeedbackList record);

    List<SelectGetFeedbackList> selectByExample(SelectGetFeedbackListExample example);

    int updateByExampleSelective(@Param("record") SelectGetFeedbackList record, @Param("example") SelectGetFeedbackListExample example);

    int updateByExample(@Param("record") SelectGetFeedbackList record, @Param("example") SelectGetFeedbackListExample example);
}