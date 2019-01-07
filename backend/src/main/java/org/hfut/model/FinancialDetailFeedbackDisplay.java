package org.hfut.model;

import org.hfut.pojo.SelectFinancialdetailFeedback;

/**
 * FinancialDetailFeedbackDisplay
 *
 * @author WeiXin
 * @date 2019/1/4
 **/
public class FinancialDetailFeedbackDisplay extends SelectFinancialdetailFeedback {

    private String reviewerName;

    public FinancialDetailFeedbackDisplay() {}

    public FinancialDetailFeedbackDisplay(SelectFinancialdetailFeedback father) {
        this.setProjectpeopleid(father.getProjectpeopleid());
        this.setProjectpeoplename(father.getProjectpeoplename());
        this.setProjectid(father.getProjectid());
        this.setDetailid(father.getDetailid());
        this.setDetailtitle(father.getDetailtitle());
        this.setDetailtype(father.getDetailtype());
        this.setRequesttime(father.getRequesttime());
        this.setState(father.getState());
        this.setDescription(father.getDescription());
        this.setAudittime(father.getAudittime());
        this.setReviewerid(father.getReviewerid());
    }

    public String getReviewerName() {
        return reviewerName;
    }

    public void setReviewerName(String reviewerName) {
        this.reviewerName = reviewerName;
    }
}
