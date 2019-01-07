package org.hfut.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SelectFinancialdetailFeedbackExample {

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SelectFinancialdetailFeedbackExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if(oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {

        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if(condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if(value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if(value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andProjectpeopleidIsNull() {
            addCriterion("projectpeopleid is null");
            return (Criteria) this;
        }

        public Criteria andProjectpeopleidIsNotNull() {
            addCriterion("projectpeopleid is not null");
            return (Criteria) this;
        }

        public Criteria andProjectpeopleidEqualTo(Integer value) {
            addCriterion("projectpeopleid =", value, "projectpeopleid");
            return (Criteria) this;
        }

        public Criteria andProjectpeopleidNotEqualTo(Integer value) {
            addCriterion("projectpeopleid <>", value, "projectpeopleid");
            return (Criteria) this;
        }

        public Criteria andProjectpeopleidGreaterThan(Integer value) {
            addCriterion("projectpeopleid >", value, "projectpeopleid");
            return (Criteria) this;
        }

        public Criteria andProjectpeopleidGreaterThanOrEqualTo(Integer value) {
            addCriterion("projectpeopleid >=", value, "projectpeopleid");
            return (Criteria) this;
        }

        public Criteria andProjectpeopleidLessThan(Integer value) {
            addCriterion("projectpeopleid <", value, "projectpeopleid");
            return (Criteria) this;
        }

        public Criteria andProjectpeopleidLessThanOrEqualTo(Integer value) {
            addCriterion("projectpeopleid <=", value, "projectpeopleid");
            return (Criteria) this;
        }

        public Criteria andProjectpeopleidIn(List<Integer> values) {
            addCriterion("projectpeopleid in", values, "projectpeopleid");
            return (Criteria) this;
        }

        public Criteria andProjectpeopleidNotIn(List<Integer> values) {
            addCriterion("projectpeopleid not in", values, "projectpeopleid");
            return (Criteria) this;
        }

        public Criteria andProjectpeopleidBetween(Integer value1, Integer value2) {
            addCriterion("projectpeopleid between", value1, value2, "projectpeopleid");
            return (Criteria) this;
        }

        public Criteria andProjectpeopleidNotBetween(Integer value1, Integer value2) {
            addCriterion("projectpeopleid not between", value1, value2, "projectpeopleid");
            return (Criteria) this;
        }

        public Criteria andProjectpeoplenameIsNull() {
            addCriterion("projectpeoplename is null");
            return (Criteria) this;
        }

        public Criteria andProjectpeoplenameIsNotNull() {
            addCriterion("projectpeoplename is not null");
            return (Criteria) this;
        }

        public Criteria andProjectpeoplenameEqualTo(String value) {
            addCriterion("projectpeoplename =", value, "projectpeoplename");
            return (Criteria) this;
        }

        public Criteria andProjectpeoplenameNotEqualTo(String value) {
            addCriterion("projectpeoplename <>", value, "projectpeoplename");
            return (Criteria) this;
        }

        public Criteria andProjectpeoplenameGreaterThan(String value) {
            addCriterion("projectpeoplename >", value, "projectpeoplename");
            return (Criteria) this;
        }

        public Criteria andProjectpeoplenameGreaterThanOrEqualTo(String value) {
            addCriterion("projectpeoplename >=", value, "projectpeoplename");
            return (Criteria) this;
        }

        public Criteria andProjectpeoplenameLessThan(String value) {
            addCriterion("projectpeoplename <", value, "projectpeoplename");
            return (Criteria) this;
        }

        public Criteria andProjectpeoplenameLessThanOrEqualTo(String value) {
            addCriterion("projectpeoplename <=", value, "projectpeoplename");
            return (Criteria) this;
        }

        public Criteria andProjectpeoplenameLike(String value) {
            addCriterion("projectpeoplename like", value, "projectpeoplename");
            return (Criteria) this;
        }

        public Criteria andProjectpeoplenameNotLike(String value) {
            addCriterion("projectpeoplename not like", value, "projectpeoplename");
            return (Criteria) this;
        }

        public Criteria andProjectpeoplenameIn(List<String> values) {
            addCriterion("projectpeoplename in", values, "projectpeoplename");
            return (Criteria) this;
        }

        public Criteria andProjectpeoplenameNotIn(List<String> values) {
            addCriterion("projectpeoplename not in", values, "projectpeoplename");
            return (Criteria) this;
        }

        public Criteria andProjectpeoplenameBetween(String value1, String value2) {
            addCriterion("projectpeoplename between", value1, value2, "projectpeoplename");
            return (Criteria) this;
        }

        public Criteria andProjectpeoplenameNotBetween(String value1, String value2) {
            addCriterion("projectpeoplename not between", value1, value2, "projectpeoplename");
            return (Criteria) this;
        }

        public Criteria andProjectidIsNull() {
            addCriterion("projectid is null");
            return (Criteria) this;
        }

        public Criteria andProjectidIsNotNull() {
            addCriterion("projectid is not null");
            return (Criteria) this;
        }

        public Criteria andProjectidEqualTo(Integer value) {
            addCriterion("projectid =", value, "projectid");
            return (Criteria) this;
        }

        public Criteria andProjectidNotEqualTo(Integer value) {
            addCriterion("projectid <>", value, "projectid");
            return (Criteria) this;
        }

        public Criteria andProjectidGreaterThan(Integer value) {
            addCriterion("projectid >", value, "projectid");
            return (Criteria) this;
        }

        public Criteria andProjectidGreaterThanOrEqualTo(Integer value) {
            addCriterion("projectid >=", value, "projectid");
            return (Criteria) this;
        }

        public Criteria andProjectidLessThan(Integer value) {
            addCriterion("projectid <", value, "projectid");
            return (Criteria) this;
        }

        public Criteria andProjectidLessThanOrEqualTo(Integer value) {
            addCriterion("projectid <=", value, "projectid");
            return (Criteria) this;
        }

        public Criteria andProjectidIn(List<Integer> values) {
            addCriterion("projectid in", values, "projectid");
            return (Criteria) this;
        }

        public Criteria andProjectidNotIn(List<Integer> values) {
            addCriterion("projectid not in", values, "projectid");
            return (Criteria) this;
        }

        public Criteria andProjectidBetween(Integer value1, Integer value2) {
            addCriterion("projectid between", value1, value2, "projectid");
            return (Criteria) this;
        }

        public Criteria andProjectidNotBetween(Integer value1, Integer value2) {
            addCriterion("projectid not between", value1, value2, "projectid");
            return (Criteria) this;
        }

        public Criteria andProjecttitleIsNull() {
            addCriterion("projecttitle is null");
            return (Criteria) this;
        }

        public Criteria andProjecttitleIsNotNull() {
            addCriterion("projecttitle is not null");
            return (Criteria) this;
        }

        public Criteria andProjecttitleEqualTo(String value) {
            addCriterion("projecttitle =", value, "projecttitle");
            return (Criteria) this;
        }

        public Criteria andProjecttitleNotEqualTo(String value) {
            addCriterion("projecttitle <>", value, "projecttitle");
            return (Criteria) this;
        }

        public Criteria andProjecttitleGreaterThan(String value) {
            addCriterion("projecttitle >", value, "projecttitle");
            return (Criteria) this;
        }

        public Criteria andProjecttitleGreaterThanOrEqualTo(String value) {
            addCriterion("projecttitle >=", value, "projecttitle");
            return (Criteria) this;
        }

        public Criteria andProjecttitleLessThan(String value) {
            addCriterion("projecttitle <", value, "projecttitle");
            return (Criteria) this;
        }

        public Criteria andProjecttitleLessThanOrEqualTo(String value) {
            addCriterion("projecttitle <=", value, "projecttitle");
            return (Criteria) this;
        }

        public Criteria andProjecttitleLike(String value) {
            addCriterion("projecttitle like", value, "projecttitle");
            return (Criteria) this;
        }

        public Criteria andProjecttitleNotLike(String value) {
            addCriterion("projecttitle not like", value, "projecttitle");
            return (Criteria) this;
        }

        public Criteria andProjecttitleIn(List<String> values) {
            addCriterion("projecttitle in", values, "projecttitle");
            return (Criteria) this;
        }

        public Criteria andProjecttitleNotIn(List<String> values) {
            addCriterion("projecttitle not in", values, "projecttitle");
            return (Criteria) this;
        }

        public Criteria andProjecttitleBetween(String value1, String value2) {
            addCriterion("projecttitle between", value1, value2, "projecttitle");
            return (Criteria) this;
        }

        public Criteria andProjecttitleNotBetween(String value1, String value2) {
            addCriterion("projecttitle not between", value1, value2, "projecttitle");
            return (Criteria) this;
        }

        public Criteria andDetailidIsNull() {
            addCriterion("detailid is null");
            return (Criteria) this;
        }

        public Criteria andDetailidIsNotNull() {
            addCriterion("detailid is not null");
            return (Criteria) this;
        }

        public Criteria andDetailidEqualTo(Integer value) {
            addCriterion("detailid =", value, "detailid");
            return (Criteria) this;
        }

        public Criteria andDetailidNotEqualTo(Integer value) {
            addCriterion("detailid <>", value, "detailid");
            return (Criteria) this;
        }

        public Criteria andDetailidGreaterThan(Integer value) {
            addCriterion("detailid >", value, "detailid");
            return (Criteria) this;
        }

        public Criteria andDetailidGreaterThanOrEqualTo(Integer value) {
            addCriterion("detailid >=", value, "detailid");
            return (Criteria) this;
        }

        public Criteria andDetailidLessThan(Integer value) {
            addCriterion("detailid <", value, "detailid");
            return (Criteria) this;
        }

        public Criteria andDetailidLessThanOrEqualTo(Integer value) {
            addCriterion("detailid <=", value, "detailid");
            return (Criteria) this;
        }

        public Criteria andDetailidIn(List<Integer> values) {
            addCriterion("detailid in", values, "detailid");
            return (Criteria) this;
        }

        public Criteria andDetailidNotIn(List<Integer> values) {
            addCriterion("detailid not in", values, "detailid");
            return (Criteria) this;
        }

        public Criteria andDetailidBetween(Integer value1, Integer value2) {
            addCriterion("detailid between", value1, value2, "detailid");
            return (Criteria) this;
        }

        public Criteria andDetailidNotBetween(Integer value1, Integer value2) {
            addCriterion("detailid not between", value1, value2, "detailid");
            return (Criteria) this;
        }

        public Criteria andDetailtitleIsNull() {
            addCriterion("detailtitle is null");
            return (Criteria) this;
        }

        public Criteria andDetailtitleIsNotNull() {
            addCriterion("detailtitle is not null");
            return (Criteria) this;
        }

        public Criteria andDetailtitleEqualTo(String value) {
            addCriterion("detailtitle =", value, "detailtitle");
            return (Criteria) this;
        }

        public Criteria andDetailtitleNotEqualTo(String value) {
            addCriterion("detailtitle <>", value, "detailtitle");
            return (Criteria) this;
        }

        public Criteria andDetailtitleGreaterThan(String value) {
            addCriterion("detailtitle >", value, "detailtitle");
            return (Criteria) this;
        }

        public Criteria andDetailtitleGreaterThanOrEqualTo(String value) {
            addCriterion("detailtitle >=", value, "detailtitle");
            return (Criteria) this;
        }

        public Criteria andDetailtitleLessThan(String value) {
            addCriterion("detailtitle <", value, "detailtitle");
            return (Criteria) this;
        }

        public Criteria andDetailtitleLessThanOrEqualTo(String value) {
            addCriterion("detailtitle <=", value, "detailtitle");
            return (Criteria) this;
        }

        public Criteria andDetailtitleLike(String value) {
            addCriterion("detailtitle like", value, "detailtitle");
            return (Criteria) this;
        }

        public Criteria andDetailtitleNotLike(String value) {
            addCriterion("detailtitle not like", value, "detailtitle");
            return (Criteria) this;
        }

        public Criteria andDetailtitleIn(List<String> values) {
            addCriterion("detailtitle in", values, "detailtitle");
            return (Criteria) this;
        }

        public Criteria andDetailtitleNotIn(List<String> values) {
            addCriterion("detailtitle not in", values, "detailtitle");
            return (Criteria) this;
        }

        public Criteria andDetailtitleBetween(String value1, String value2) {
            addCriterion("detailtitle between", value1, value2, "detailtitle");
            return (Criteria) this;
        }

        public Criteria andDetailtitleNotBetween(String value1, String value2) {
            addCriterion("detailtitle not between", value1, value2, "detailtitle");
            return (Criteria) this;
        }

        public Criteria andDetailtypeIsNull() {
            addCriterion("detailtype is null");
            return (Criteria) this;
        }

        public Criteria andDetailtypeIsNotNull() {
            addCriterion("detailtype is not null");
            return (Criteria) this;
        }

        public Criteria andDetailtypeEqualTo(Byte value) {
            addCriterion("detailtype =", value, "detailtype");
            return (Criteria) this;
        }

        public Criteria andDetailtypeNotEqualTo(Byte value) {
            addCriterion("detailtype <>", value, "detailtype");
            return (Criteria) this;
        }

        public Criteria andDetailtypeGreaterThan(Byte value) {
            addCriterion("detailtype >", value, "detailtype");
            return (Criteria) this;
        }

        public Criteria andDetailtypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("detailtype >=", value, "detailtype");
            return (Criteria) this;
        }

        public Criteria andDetailtypeLessThan(Byte value) {
            addCriterion("detailtype <", value, "detailtype");
            return (Criteria) this;
        }

        public Criteria andDetailtypeLessThanOrEqualTo(Byte value) {
            addCriterion("detailtype <=", value, "detailtype");
            return (Criteria) this;
        }

        public Criteria andDetailtypeIn(List<Byte> values) {
            addCriterion("detailtype in", values, "detailtype");
            return (Criteria) this;
        }

        public Criteria andDetailtypeNotIn(List<Byte> values) {
            addCriterion("detailtype not in", values, "detailtype");
            return (Criteria) this;
        }

        public Criteria andDetailtypeBetween(Byte value1, Byte value2) {
            addCriterion("detailtype between", value1, value2, "detailtype");
            return (Criteria) this;
        }

        public Criteria andDetailtypeNotBetween(Byte value1, Byte value2) {
            addCriterion("detailtype not between", value1, value2, "detailtype");
            return (Criteria) this;
        }

        public Criteria andRequesttimeIsNull() {
            addCriterion("requesttime is null");
            return (Criteria) this;
        }

        public Criteria andRequesttimeIsNotNull() {
            addCriterion("requesttime is not null");
            return (Criteria) this;
        }

        public Criteria andRequesttimeEqualTo(Date value) {
            addCriterion("requesttime =", value, "requesttime");
            return (Criteria) this;
        }

        public Criteria andRequesttimeNotEqualTo(Date value) {
            addCriterion("requesttime <>", value, "requesttime");
            return (Criteria) this;
        }

        public Criteria andRequesttimeGreaterThan(Date value) {
            addCriterion("requesttime >", value, "requesttime");
            return (Criteria) this;
        }

        public Criteria andRequesttimeGreaterThanOrEqualTo(Date value) {
            addCriterion("requesttime >=", value, "requesttime");
            return (Criteria) this;
        }

        public Criteria andRequesttimeLessThan(Date value) {
            addCriterion("requesttime <", value, "requesttime");
            return (Criteria) this;
        }

        public Criteria andRequesttimeLessThanOrEqualTo(Date value) {
            addCriterion("requesttime <=", value, "requesttime");
            return (Criteria) this;
        }

        public Criteria andRequesttimeIn(List<Date> values) {
            addCriterion("requesttime in", values, "requesttime");
            return (Criteria) this;
        }

        public Criteria andRequesttimeNotIn(List<Date> values) {
            addCriterion("requesttime not in", values, "requesttime");
            return (Criteria) this;
        }

        public Criteria andRequesttimeBetween(Date value1, Date value2) {
            addCriterion("requesttime between", value1, value2, "requesttime");
            return (Criteria) this;
        }

        public Criteria andRequesttimeNotBetween(Date value1, Date value2) {
            addCriterion("requesttime not between", value1, value2, "requesttime");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(Byte value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(Byte value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(Byte value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(Byte value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(Byte value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(Byte value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<Byte> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<Byte> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(Byte value1, Byte value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(Byte value1, Byte value2) {
            addCriterion("state not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andAudittimeIsNull() {
            addCriterion("audittime is null");
            return (Criteria) this;
        }

        public Criteria andAudittimeIsNotNull() {
            addCriterion("audittime is not null");
            return (Criteria) this;
        }

        public Criteria andAudittimeEqualTo(Date value) {
            addCriterion("audittime =", value, "audittime");
            return (Criteria) this;
        }

        public Criteria andAudittimeNotEqualTo(Date value) {
            addCriterion("audittime <>", value, "audittime");
            return (Criteria) this;
        }

        public Criteria andAudittimeGreaterThan(Date value) {
            addCriterion("audittime >", value, "audittime");
            return (Criteria) this;
        }

        public Criteria andAudittimeGreaterThanOrEqualTo(Date value) {
            addCriterion("audittime >=", value, "audittime");
            return (Criteria) this;
        }

        public Criteria andAudittimeLessThan(Date value) {
            addCriterion("audittime <", value, "audittime");
            return (Criteria) this;
        }

        public Criteria andAudittimeLessThanOrEqualTo(Date value) {
            addCriterion("audittime <=", value, "audittime");
            return (Criteria) this;
        }

        public Criteria andAudittimeIn(List<Date> values) {
            addCriterion("audittime in", values, "audittime");
            return (Criteria) this;
        }

        public Criteria andAudittimeNotIn(List<Date> values) {
            addCriterion("audittime not in", values, "audittime");
            return (Criteria) this;
        }

        public Criteria andAudittimeBetween(Date value1, Date value2) {
            addCriterion("audittime between", value1, value2, "audittime");
            return (Criteria) this;
        }

        public Criteria andAudittimeNotBetween(Date value1, Date value2) {
            addCriterion("audittime not between", value1, value2, "audittime");
            return (Criteria) this;
        }

        public Criteria andRevieweridIsNull() {
            addCriterion("reviewerid is null");
            return (Criteria) this;
        }

        public Criteria andRevieweridIsNotNull() {
            addCriterion("reviewerid is not null");
            return (Criteria) this;
        }

        public Criteria andRevieweridEqualTo(Integer value) {
            addCriterion("reviewerid =", value, "reviewerid");
            return (Criteria) this;
        }

        public Criteria andRevieweridNotEqualTo(Integer value) {
            addCriterion("reviewerid <>", value, "reviewerid");
            return (Criteria) this;
        }

        public Criteria andRevieweridGreaterThan(Integer value) {
            addCriterion("reviewerid >", value, "reviewerid");
            return (Criteria) this;
        }

        public Criteria andRevieweridGreaterThanOrEqualTo(Integer value) {
            addCriterion("reviewerid >=", value, "reviewerid");
            return (Criteria) this;
        }

        public Criteria andRevieweridLessThan(Integer value) {
            addCriterion("reviewerid <", value, "reviewerid");
            return (Criteria) this;
        }

        public Criteria andRevieweridLessThanOrEqualTo(Integer value) {
            addCriterion("reviewerid <=", value, "reviewerid");
            return (Criteria) this;
        }

        public Criteria andRevieweridIn(List<Integer> values) {
            addCriterion("reviewerid in", values, "reviewerid");
            return (Criteria) this;
        }

        public Criteria andRevieweridNotIn(List<Integer> values) {
            addCriterion("reviewerid not in", values, "reviewerid");
            return (Criteria) this;
        }

        public Criteria andRevieweridBetween(Integer value1, Integer value2) {
            addCriterion("reviewerid between", value1, value2, "reviewerid");
            return (Criteria) this;
        }

        public Criteria andRevieweridNotBetween(Integer value1, Integer value2) {
            addCriterion("reviewerid not between", value1, value2, "reviewerid");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {

        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if(value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}