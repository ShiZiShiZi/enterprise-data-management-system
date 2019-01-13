package org.hfut.service.developer;

import org.hfut.mapper.SelectGetFeedbackListMapper;
import org.hfut.pojo.SelectGetFeedbackList;
import org.hfut.pojo.SelectGetFeedbackListExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Lee
 * @date 2019/1/13
 **/
@Service
public class GetFeedbackListService {
    @Autowired
    private SelectGetFeedbackListMapper selectGetFeedbackListMapper;

    public List<SelectGetFeedbackList> listFeedbackList(int id) {
        List<SelectGetFeedbackList> list;
        SelectGetFeedbackListExample selectGetFeedbackListExample = new SelectGetFeedbackListExample();
        SelectGetFeedbackListExample.Criteria criteria = selectGetFeedbackListExample.createCriteria();
        criteria.andProjectPeopleIdEqualTo(id);
        selectGetFeedbackListExample.setOrderByClause("request_time DESC");
        list = selectGetFeedbackListMapper.selectByExample(selectGetFeedbackListExample);
        return list;
    }
}
