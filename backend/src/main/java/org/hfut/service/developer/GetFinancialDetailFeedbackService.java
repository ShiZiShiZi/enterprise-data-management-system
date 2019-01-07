package org.hfut.service.developer;

import org.hfut.mapper.ProjectpeopleMapper;
import org.hfut.mapper.SelectFinancialdetailFeedbackMapper;
import org.hfut.model.FinancialDetailFeedbackDisplay;
import org.hfut.pojo.Projectpeople;
import org.hfut.pojo.SelectFinancialdetailFeedback;
import org.hfut.pojo.SelectFinancialdetailFeedbackExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * GetFinancialDetailFeedbackService
 *
 * @author WeiXin
 * @date 2019/1/4
 **/
@Service
public class GetFinancialDetailFeedbackService {

    @Autowired
    private ProjectpeopleMapper projectpeopleMapper;
    @Autowired
    private SelectFinancialdetailFeedbackMapper financialdetailFeedbackMapper;

    private String getProjectPeopleName(Integer projectPeopleId) {
        Projectpeople projectpeople = projectpeopleMapper.selectByPrimaryKey(projectPeopleId);
        return projectpeople.getName();
    }

    public List<FinancialDetailFeedbackDisplay> getFeedback(Integer requestPeopleId, Integer projectId,
                                                            Integer financialDetailId) {
        List<SelectFinancialdetailFeedback> feedbackList;
        List<FinancialDetailFeedbackDisplay> feedbackDisplayList = new ArrayList<>();
        FinancialDetailFeedbackDisplay feedbackDisplay;
        SelectFinancialdetailFeedbackExample feedbackExample = new SelectFinancialdetailFeedbackExample();
        SelectFinancialdetailFeedbackExample.Criteria criteria;

        criteria = feedbackExample.createCriteria();
        criteria.andProjectidEqualTo(requestPeopleId);
        if(financialDetailId != null) {
            criteria.andDetailidEqualTo(financialDetailId);
        }
        if(projectId != null) {
            criteria.andProjectidEqualTo(projectId);
        }
        feedbackList = financialdetailFeedbackMapper.selectByExample(feedbackExample);

        for(SelectFinancialdetailFeedback feedback : feedbackList) {
            feedbackDisplay = new FinancialDetailFeedbackDisplay(feedback);
            if(feedbackDisplay.getReviewerid() != null) {
                feedbackDisplay.setReviewerName(getProjectPeopleName(feedbackDisplay.getReviewerid()));
            }
            feedbackDisplayList.add(feedbackDisplay);
        }

        return feedbackDisplayList;
    }
}
