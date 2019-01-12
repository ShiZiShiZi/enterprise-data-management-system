package org.hfut.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SelectAllFinancialInformationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SelectAllFinancialInformationExample() {
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
        if (oredCriteria.size() == 0) {
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
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andLogIdIsNull() {
            addCriterion("log_id is null");
            return (Criteria) this;
        }

        public Criteria andLogIdIsNotNull() {
            addCriterion("log_id is not null");
            return (Criteria) this;
        }

        public Criteria andLogIdEqualTo(Integer value) {
            addCriterion("log_id =", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdNotEqualTo(Integer value) {
            addCriterion("log_id <>", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdGreaterThan(Integer value) {
            addCriterion("log_id >", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("log_id >=", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdLessThan(Integer value) {
            addCriterion("log_id <", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdLessThanOrEqualTo(Integer value) {
            addCriterion("log_id <=", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdIn(List<Integer> values) {
            addCriterion("log_id in", values, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdNotIn(List<Integer> values) {
            addCriterion("log_id not in", values, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdBetween(Integer value1, Integer value2) {
            addCriterion("log_id between", value1, value2, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdNotBetween(Integer value1, Integer value2) {
            addCriterion("log_id not between", value1, value2, "logId");
            return (Criteria) this;
        }

        public Criteria andLogNumIsNull() {
            addCriterion("log_num is null");
            return (Criteria) this;
        }

        public Criteria andLogNumIsNotNull() {
            addCriterion("log_num is not null");
            return (Criteria) this;
        }

        public Criteria andLogNumEqualTo(Double value) {
            addCriterion("log_num =", value, "logNum");
            return (Criteria) this;
        }

        public Criteria andLogNumNotEqualTo(Double value) {
            addCriterion("log_num <>", value, "logNum");
            return (Criteria) this;
        }

        public Criteria andLogNumGreaterThan(Double value) {
            addCriterion("log_num >", value, "logNum");
            return (Criteria) this;
        }

        public Criteria andLogNumGreaterThanOrEqualTo(Double value) {
            addCriterion("log_num >=", value, "logNum");
            return (Criteria) this;
        }

        public Criteria andLogNumLessThan(Double value) {
            addCriterion("log_num <", value, "logNum");
            return (Criteria) this;
        }

        public Criteria andLogNumLessThanOrEqualTo(Double value) {
            addCriterion("log_num <=", value, "logNum");
            return (Criteria) this;
        }

        public Criteria andLogNumIn(List<Double> values) {
            addCriterion("log_num in", values, "logNum");
            return (Criteria) this;
        }

        public Criteria andLogNumNotIn(List<Double> values) {
            addCriterion("log_num not in", values, "logNum");
            return (Criteria) this;
        }

        public Criteria andLogNumBetween(Double value1, Double value2) {
            addCriterion("log_num between", value1, value2, "logNum");
            return (Criteria) this;
        }

        public Criteria andLogNumNotBetween(Double value1, Double value2) {
            addCriterion("log_num not between", value1, value2, "logNum");
            return (Criteria) this;
        }

        public Criteria andTaxRateIsNull() {
            addCriterion("tax_rate is null");
            return (Criteria) this;
        }

        public Criteria andTaxRateIsNotNull() {
            addCriterion("tax_rate is not null");
            return (Criteria) this;
        }

        public Criteria andTaxRateEqualTo(Float value) {
            addCriterion("tax_rate =", value, "taxRate");
            return (Criteria) this;
        }

        public Criteria andTaxRateNotEqualTo(Float value) {
            addCriterion("tax_rate <>", value, "taxRate");
            return (Criteria) this;
        }

        public Criteria andTaxRateGreaterThan(Float value) {
            addCriterion("tax_rate >", value, "taxRate");
            return (Criteria) this;
        }

        public Criteria andTaxRateGreaterThanOrEqualTo(Float value) {
            addCriterion("tax_rate >=", value, "taxRate");
            return (Criteria) this;
        }

        public Criteria andTaxRateLessThan(Float value) {
            addCriterion("tax_rate <", value, "taxRate");
            return (Criteria) this;
        }

        public Criteria andTaxRateLessThanOrEqualTo(Float value) {
            addCriterion("tax_rate <=", value, "taxRate");
            return (Criteria) this;
        }

        public Criteria andTaxRateIn(List<Float> values) {
            addCriterion("tax_rate in", values, "taxRate");
            return (Criteria) this;
        }

        public Criteria andTaxRateNotIn(List<Float> values) {
            addCriterion("tax_rate not in", values, "taxRate");
            return (Criteria) this;
        }

        public Criteria andTaxRateBetween(Float value1, Float value2) {
            addCriterion("tax_rate between", value1, value2, "taxRate");
            return (Criteria) this;
        }

        public Criteria andTaxRateNotBetween(Float value1, Float value2) {
            addCriterion("tax_rate not between", value1, value2, "taxRate");
            return (Criteria) this;
        }

        public Criteria andLogTypeIsNull() {
            addCriterion("log_type is null");
            return (Criteria) this;
        }

        public Criteria andLogTypeIsNotNull() {
            addCriterion("log_type is not null");
            return (Criteria) this;
        }

        public Criteria andLogTypeEqualTo(Byte value) {
            addCriterion("log_type =", value, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeNotEqualTo(Byte value) {
            addCriterion("log_type <>", value, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeGreaterThan(Byte value) {
            addCriterion("log_type >", value, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("log_type >=", value, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeLessThan(Byte value) {
            addCriterion("log_type <", value, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeLessThanOrEqualTo(Byte value) {
            addCriterion("log_type <=", value, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeIn(List<Byte> values) {
            addCriterion("log_type in", values, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeNotIn(List<Byte> values) {
            addCriterion("log_type not in", values, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeBetween(Byte value1, Byte value2) {
            addCriterion("log_type between", value1, value2, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("log_type not between", value1, value2, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTimeIsNull() {
            addCriterion("log_time is null");
            return (Criteria) this;
        }

        public Criteria andLogTimeIsNotNull() {
            addCriterion("log_time is not null");
            return (Criteria) this;
        }

        public Criteria andLogTimeEqualTo(Date value) {
            addCriterion("log_time =", value, "logTime");
            return (Criteria) this;
        }

        public Criteria andLogTimeNotEqualTo(Date value) {
            addCriterion("log_time <>", value, "logTime");
            return (Criteria) this;
        }

        public Criteria andLogTimeGreaterThan(Date value) {
            addCriterion("log_time >", value, "logTime");
            return (Criteria) this;
        }

        public Criteria andLogTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("log_time >=", value, "logTime");
            return (Criteria) this;
        }

        public Criteria andLogTimeLessThan(Date value) {
            addCriterion("log_time <", value, "logTime");
            return (Criteria) this;
        }

        public Criteria andLogTimeLessThanOrEqualTo(Date value) {
            addCriterion("log_time <=", value, "logTime");
            return (Criteria) this;
        }

        public Criteria andLogTimeIn(List<Date> values) {
            addCriterion("log_time in", values, "logTime");
            return (Criteria) this;
        }

        public Criteria andLogTimeNotIn(List<Date> values) {
            addCriterion("log_time not in", values, "logTime");
            return (Criteria) this;
        }

        public Criteria andLogTimeBetween(Date value1, Date value2) {
            addCriterion("log_time between", value1, value2, "logTime");
            return (Criteria) this;
        }

        public Criteria andLogTimeNotBetween(Date value1, Date value2) {
            addCriterion("log_time not between", value1, value2, "logTime");
            return (Criteria) this;
        }

        public Criteria andFinancialPeopleIdIsNull() {
            addCriterion("financial_people_id is null");
            return (Criteria) this;
        }

        public Criteria andFinancialPeopleIdIsNotNull() {
            addCriterion("financial_people_id is not null");
            return (Criteria) this;
        }

        public Criteria andFinancialPeopleIdEqualTo(Integer value) {
            addCriterion("financial_people_id =", value, "financialPeopleId");
            return (Criteria) this;
        }

        public Criteria andFinancialPeopleIdNotEqualTo(Integer value) {
            addCriterion("financial_people_id <>", value, "financialPeopleId");
            return (Criteria) this;
        }

        public Criteria andFinancialPeopleIdGreaterThan(Integer value) {
            addCriterion("financial_people_id >", value, "financialPeopleId");
            return (Criteria) this;
        }

        public Criteria andFinancialPeopleIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("financial_people_id >=", value, "financialPeopleId");
            return (Criteria) this;
        }

        public Criteria andFinancialPeopleIdLessThan(Integer value) {
            addCriterion("financial_people_id <", value, "financialPeopleId");
            return (Criteria) this;
        }

        public Criteria andFinancialPeopleIdLessThanOrEqualTo(Integer value) {
            addCriterion("financial_people_id <=", value, "financialPeopleId");
            return (Criteria) this;
        }

        public Criteria andFinancialPeopleIdIn(List<Integer> values) {
            addCriterion("financial_people_id in", values, "financialPeopleId");
            return (Criteria) this;
        }

        public Criteria andFinancialPeopleIdNotIn(List<Integer> values) {
            addCriterion("financial_people_id not in", values, "financialPeopleId");
            return (Criteria) this;
        }

        public Criteria andFinancialPeopleIdBetween(Integer value1, Integer value2) {
            addCriterion("financial_people_id between", value1, value2, "financialPeopleId");
            return (Criteria) this;
        }

        public Criteria andFinancialPeopleIdNotBetween(Integer value1, Integer value2) {
            addCriterion("financial_people_id not between", value1, value2, "financialPeopleId");
            return (Criteria) this;
        }

        public Criteria andDetailIdIsNull() {
            addCriterion("detail_id is null");
            return (Criteria) this;
        }

        public Criteria andDetailIdIsNotNull() {
            addCriterion("detail_id is not null");
            return (Criteria) this;
        }

        public Criteria andDetailIdEqualTo(Integer value) {
            addCriterion("detail_id =", value, "detailId");
            return (Criteria) this;
        }

        public Criteria andDetailIdNotEqualTo(Integer value) {
            addCriterion("detail_id <>", value, "detailId");
            return (Criteria) this;
        }

        public Criteria andDetailIdGreaterThan(Integer value) {
            addCriterion("detail_id >", value, "detailId");
            return (Criteria) this;
        }

        public Criteria andDetailIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("detail_id >=", value, "detailId");
            return (Criteria) this;
        }

        public Criteria andDetailIdLessThan(Integer value) {
            addCriterion("detail_id <", value, "detailId");
            return (Criteria) this;
        }

        public Criteria andDetailIdLessThanOrEqualTo(Integer value) {
            addCriterion("detail_id <=", value, "detailId");
            return (Criteria) this;
        }

        public Criteria andDetailIdIn(List<Integer> values) {
            addCriterion("detail_id in", values, "detailId");
            return (Criteria) this;
        }

        public Criteria andDetailIdNotIn(List<Integer> values) {
            addCriterion("detail_id not in", values, "detailId");
            return (Criteria) this;
        }

        public Criteria andDetailIdBetween(Integer value1, Integer value2) {
            addCriterion("detail_id between", value1, value2, "detailId");
            return (Criteria) this;
        }

        public Criteria andDetailIdNotBetween(Integer value1, Integer value2) {
            addCriterion("detail_id not between", value1, value2, "detailId");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andDetailNumIsNull() {
            addCriterion("detail_num is null");
            return (Criteria) this;
        }

        public Criteria andDetailNumIsNotNull() {
            addCriterion("detail_num is not null");
            return (Criteria) this;
        }

        public Criteria andDetailNumEqualTo(Double value) {
            addCriterion("detail_num =", value, "detailNum");
            return (Criteria) this;
        }

        public Criteria andDetailNumNotEqualTo(Double value) {
            addCriterion("detail_num <>", value, "detailNum");
            return (Criteria) this;
        }

        public Criteria andDetailNumGreaterThan(Double value) {
            addCriterion("detail_num >", value, "detailNum");
            return (Criteria) this;
        }

        public Criteria andDetailNumGreaterThanOrEqualTo(Double value) {
            addCriterion("detail_num >=", value, "detailNum");
            return (Criteria) this;
        }

        public Criteria andDetailNumLessThan(Double value) {
            addCriterion("detail_num <", value, "detailNum");
            return (Criteria) this;
        }

        public Criteria andDetailNumLessThanOrEqualTo(Double value) {
            addCriterion("detail_num <=", value, "detailNum");
            return (Criteria) this;
        }

        public Criteria andDetailNumIn(List<Double> values) {
            addCriterion("detail_num in", values, "detailNum");
            return (Criteria) this;
        }

        public Criteria andDetailNumNotIn(List<Double> values) {
            addCriterion("detail_num not in", values, "detailNum");
            return (Criteria) this;
        }

        public Criteria andDetailNumBetween(Double value1, Double value2) {
            addCriterion("detail_num between", value1, value2, "detailNum");
            return (Criteria) this;
        }

        public Criteria andDetailNumNotBetween(Double value1, Double value2) {
            addCriterion("detail_num not between", value1, value2, "detailNum");
            return (Criteria) this;
        }

        public Criteria andDetailTimeIsNull() {
            addCriterion("detail_time is null");
            return (Criteria) this;
        }

        public Criteria andDetailTimeIsNotNull() {
            addCriterion("detail_time is not null");
            return (Criteria) this;
        }

        public Criteria andDetailTimeEqualTo(Date value) {
            addCriterion("detail_time =", value, "detailTime");
            return (Criteria) this;
        }

        public Criteria andDetailTimeNotEqualTo(Date value) {
            addCriterion("detail_time <>", value, "detailTime");
            return (Criteria) this;
        }

        public Criteria andDetailTimeGreaterThan(Date value) {
            addCriterion("detail_time >", value, "detailTime");
            return (Criteria) this;
        }

        public Criteria andDetailTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("detail_time >=", value, "detailTime");
            return (Criteria) this;
        }

        public Criteria andDetailTimeLessThan(Date value) {
            addCriterion("detail_time <", value, "detailTime");
            return (Criteria) this;
        }

        public Criteria andDetailTimeLessThanOrEqualTo(Date value) {
            addCriterion("detail_time <=", value, "detailTime");
            return (Criteria) this;
        }

        public Criteria andDetailTimeIn(List<Date> values) {
            addCriterion("detail_time in", values, "detailTime");
            return (Criteria) this;
        }

        public Criteria andDetailTimeNotIn(List<Date> values) {
            addCriterion("detail_time not in", values, "detailTime");
            return (Criteria) this;
        }

        public Criteria andDetailTimeBetween(Date value1, Date value2) {
            addCriterion("detail_time between", value1, value2, "detailTime");
            return (Criteria) this;
        }

        public Criteria andDetailTimeNotBetween(Date value1, Date value2) {
            addCriterion("detail_time not between", value1, value2, "detailTime");
            return (Criteria) this;
        }

        public Criteria andDetailTypeIsNull() {
            addCriterion("detail_type is null");
            return (Criteria) this;
        }

        public Criteria andDetailTypeIsNotNull() {
            addCriterion("detail_type is not null");
            return (Criteria) this;
        }

        public Criteria andDetailTypeEqualTo(Byte value) {
            addCriterion("detail_type =", value, "detailType");
            return (Criteria) this;
        }

        public Criteria andDetailTypeNotEqualTo(Byte value) {
            addCriterion("detail_type <>", value, "detailType");
            return (Criteria) this;
        }

        public Criteria andDetailTypeGreaterThan(Byte value) {
            addCriterion("detail_type >", value, "detailType");
            return (Criteria) this;
        }

        public Criteria andDetailTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("detail_type >=", value, "detailType");
            return (Criteria) this;
        }

        public Criteria andDetailTypeLessThan(Byte value) {
            addCriterion("detail_type <", value, "detailType");
            return (Criteria) this;
        }

        public Criteria andDetailTypeLessThanOrEqualTo(Byte value) {
            addCriterion("detail_type <=", value, "detailType");
            return (Criteria) this;
        }

        public Criteria andDetailTypeIn(List<Byte> values) {
            addCriterion("detail_type in", values, "detailType");
            return (Criteria) this;
        }

        public Criteria andDetailTypeNotIn(List<Byte> values) {
            addCriterion("detail_type not in", values, "detailType");
            return (Criteria) this;
        }

        public Criteria andDetailTypeBetween(Byte value1, Byte value2) {
            addCriterion("detail_type between", value1, value2, "detailType");
            return (Criteria) this;
        }

        public Criteria andDetailTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("detail_type not between", value1, value2, "detailType");
            return (Criteria) this;
        }

        public Criteria andProjectPeopleIdIsNull() {
            addCriterion("project_people_id is null");
            return (Criteria) this;
        }

        public Criteria andProjectPeopleIdIsNotNull() {
            addCriterion("project_people_id is not null");
            return (Criteria) this;
        }

        public Criteria andProjectPeopleIdEqualTo(Integer value) {
            addCriterion("project_people_id =", value, "projectPeopleId");
            return (Criteria) this;
        }

        public Criteria andProjectPeopleIdNotEqualTo(Integer value) {
            addCriterion("project_people_id <>", value, "projectPeopleId");
            return (Criteria) this;
        }

        public Criteria andProjectPeopleIdGreaterThan(Integer value) {
            addCriterion("project_people_id >", value, "projectPeopleId");
            return (Criteria) this;
        }

        public Criteria andProjectPeopleIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("project_people_id >=", value, "projectPeopleId");
            return (Criteria) this;
        }

        public Criteria andProjectPeopleIdLessThan(Integer value) {
            addCriterion("project_people_id <", value, "projectPeopleId");
            return (Criteria) this;
        }

        public Criteria andProjectPeopleIdLessThanOrEqualTo(Integer value) {
            addCriterion("project_people_id <=", value, "projectPeopleId");
            return (Criteria) this;
        }

        public Criteria andProjectPeopleIdIn(List<Integer> values) {
            addCriterion("project_people_id in", values, "projectPeopleId");
            return (Criteria) this;
        }

        public Criteria andProjectPeopleIdNotIn(List<Integer> values) {
            addCriterion("project_people_id not in", values, "projectPeopleId");
            return (Criteria) this;
        }

        public Criteria andProjectPeopleIdBetween(Integer value1, Integer value2) {
            addCriterion("project_people_id between", value1, value2, "projectPeopleId");
            return (Criteria) this;
        }

        public Criteria andProjectPeopleIdNotBetween(Integer value1, Integer value2) {
            addCriterion("project_people_id not between", value1, value2, "projectPeopleId");
            return (Criteria) this;
        }

        public Criteria andModelIdIsNull() {
            addCriterion("model_id is null");
            return (Criteria) this;
        }

        public Criteria andModelIdIsNotNull() {
            addCriterion("model_id is not null");
            return (Criteria) this;
        }

        public Criteria andModelIdEqualTo(Integer value) {
            addCriterion("model_id =", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdNotEqualTo(Integer value) {
            addCriterion("model_id <>", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdGreaterThan(Integer value) {
            addCriterion("model_id >", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("model_id >=", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdLessThan(Integer value) {
            addCriterion("model_id <", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdLessThanOrEqualTo(Integer value) {
            addCriterion("model_id <=", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdIn(List<Integer> values) {
            addCriterion("model_id in", values, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdNotIn(List<Integer> values) {
            addCriterion("model_id not in", values, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdBetween(Integer value1, Integer value2) {
            addCriterion("model_id between", value1, value2, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdNotBetween(Integer value1, Integer value2) {
            addCriterion("model_id not between", value1, value2, "modelId");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andModelNumIsNull() {
            addCriterion("model_num is null");
            return (Criteria) this;
        }

        public Criteria andModelNumIsNotNull() {
            addCriterion("model_num is not null");
            return (Criteria) this;
        }

        public Criteria andModelNumEqualTo(Double value) {
            addCriterion("model_num =", value, "modelNum");
            return (Criteria) this;
        }

        public Criteria andModelNumNotEqualTo(Double value) {
            addCriterion("model_num <>", value, "modelNum");
            return (Criteria) this;
        }

        public Criteria andModelNumGreaterThan(Double value) {
            addCriterion("model_num >", value, "modelNum");
            return (Criteria) this;
        }

        public Criteria andModelNumGreaterThanOrEqualTo(Double value) {
            addCriterion("model_num >=", value, "modelNum");
            return (Criteria) this;
        }

        public Criteria andModelNumLessThan(Double value) {
            addCriterion("model_num <", value, "modelNum");
            return (Criteria) this;
        }

        public Criteria andModelNumLessThanOrEqualTo(Double value) {
            addCriterion("model_num <=", value, "modelNum");
            return (Criteria) this;
        }

        public Criteria andModelNumIn(List<Double> values) {
            addCriterion("model_num in", values, "modelNum");
            return (Criteria) this;
        }

        public Criteria andModelNumNotIn(List<Double> values) {
            addCriterion("model_num not in", values, "modelNum");
            return (Criteria) this;
        }

        public Criteria andModelNumBetween(Double value1, Double value2) {
            addCriterion("model_num between", value1, value2, "modelNum");
            return (Criteria) this;
        }

        public Criteria andModelNumNotBetween(Double value1, Double value2) {
            addCriterion("model_num not between", value1, value2, "modelNum");
            return (Criteria) this;
        }

        public Criteria andModelTypeIsNull() {
            addCriterion("model_type is null");
            return (Criteria) this;
        }

        public Criteria andModelTypeIsNotNull() {
            addCriterion("model_type is not null");
            return (Criteria) this;
        }

        public Criteria andModelTypeEqualTo(Byte value) {
            addCriterion("model_type =", value, "modelType");
            return (Criteria) this;
        }

        public Criteria andModelTypeNotEqualTo(Byte value) {
            addCriterion("model_type <>", value, "modelType");
            return (Criteria) this;
        }

        public Criteria andModelTypeGreaterThan(Byte value) {
            addCriterion("model_type >", value, "modelType");
            return (Criteria) this;
        }

        public Criteria andModelTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("model_type >=", value, "modelType");
            return (Criteria) this;
        }

        public Criteria andModelTypeLessThan(Byte value) {
            addCriterion("model_type <", value, "modelType");
            return (Criteria) this;
        }

        public Criteria andModelTypeLessThanOrEqualTo(Byte value) {
            addCriterion("model_type <=", value, "modelType");
            return (Criteria) this;
        }

        public Criteria andModelTypeIn(List<Byte> values) {
            addCriterion("model_type in", values, "modelType");
            return (Criteria) this;
        }

        public Criteria andModelTypeNotIn(List<Byte> values) {
            addCriterion("model_type not in", values, "modelType");
            return (Criteria) this;
        }

        public Criteria andModelTypeBetween(Byte value1, Byte value2) {
            addCriterion("model_type between", value1, value2, "modelType");
            return (Criteria) this;
        }

        public Criteria andModelTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("model_type not between", value1, value2, "modelType");
            return (Criteria) this;
        }

        public Criteria andProjectIdIsNull() {
            addCriterion("project_Id is null");
            return (Criteria) this;
        }

        public Criteria andProjectIdIsNotNull() {
            addCriterion("project_Id is not null");
            return (Criteria) this;
        }

        public Criteria andProjectIdEqualTo(Integer value) {
            addCriterion("project_Id =", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotEqualTo(Integer value) {
            addCriterion("project_Id <>", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdGreaterThan(Integer value) {
            addCriterion("project_Id >", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("project_Id >=", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLessThan(Integer value) {
            addCriterion("project_Id <", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLessThanOrEqualTo(Integer value) {
            addCriterion("project_Id <=", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdIn(List<Integer> values) {
            addCriterion("project_Id in", values, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotIn(List<Integer> values) {
            addCriterion("project_Id not in", values, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdBetween(Integer value1, Integer value2) {
            addCriterion("project_Id between", value1, value2, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotBetween(Integer value1, Integer value2) {
            addCriterion("project_Id not between", value1, value2, "projectId");
            return (Criteria) this;
        }

        public Criteria andActiveIsNull() {
            addCriterion("active is null");
            return (Criteria) this;
        }

        public Criteria andActiveIsNotNull() {
            addCriterion("active is not null");
            return (Criteria) this;
        }

        public Criteria andActiveEqualTo(Boolean value) {
            addCriterion("active =", value, "active");
            return (Criteria) this;
        }

        public Criteria andActiveNotEqualTo(Boolean value) {
            addCriterion("active <>", value, "active");
            return (Criteria) this;
        }

        public Criteria andActiveGreaterThan(Boolean value) {
            addCriterion("active >", value, "active");
            return (Criteria) this;
        }

        public Criteria andActiveGreaterThanOrEqualTo(Boolean value) {
            addCriterion("active >=", value, "active");
            return (Criteria) this;
        }

        public Criteria andActiveLessThan(Boolean value) {
            addCriterion("active <", value, "active");
            return (Criteria) this;
        }

        public Criteria andActiveLessThanOrEqualTo(Boolean value) {
            addCriterion("active <=", value, "active");
            return (Criteria) this;
        }

        public Criteria andActiveIn(List<Boolean> values) {
            addCriterion("active in", values, "active");
            return (Criteria) this;
        }

        public Criteria andActiveNotIn(List<Boolean> values) {
            addCriterion("active not in", values, "active");
            return (Criteria) this;
        }

        public Criteria andActiveBetween(Boolean value1, Boolean value2) {
            addCriterion("active between", value1, value2, "active");
            return (Criteria) this;
        }

        public Criteria andActiveNotBetween(Boolean value1, Boolean value2) {
            addCriterion("active not between", value1, value2, "active");
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
            if (value instanceof List<?>) {
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