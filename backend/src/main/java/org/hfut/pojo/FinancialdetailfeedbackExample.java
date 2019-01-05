package org.hfut.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FinancialdetailfeedbackExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FinancialdetailfeedbackExample() {
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

        public Criteria andFinancialdetailidIsNull() {
            addCriterion("financialdetailid is null");
            return (Criteria) this;
        }

        public Criteria andFinancialdetailidIsNotNull() {
            addCriterion("financialdetailid is not null");
            return (Criteria) this;
        }

        public Criteria andFinancialdetailidEqualTo(Integer value) {
            addCriterion("financialdetailid =", value, "financialdetailid");
            return (Criteria) this;
        }

        public Criteria andFinancialdetailidNotEqualTo(Integer value) {
            addCriterion("financialdetailid <>", value, "financialdetailid");
            return (Criteria) this;
        }

        public Criteria andFinancialdetailidGreaterThan(Integer value) {
            addCriterion("financialdetailid >", value, "financialdetailid");
            return (Criteria) this;
        }

        public Criteria andFinancialdetailidGreaterThanOrEqualTo(Integer value) {
            addCriterion("financialdetailid >=", value, "financialdetailid");
            return (Criteria) this;
        }

        public Criteria andFinancialdetailidLessThan(Integer value) {
            addCriterion("financialdetailid <", value, "financialdetailid");
            return (Criteria) this;
        }

        public Criteria andFinancialdetailidLessThanOrEqualTo(Integer value) {
            addCriterion("financialdetailid <=", value, "financialdetailid");
            return (Criteria) this;
        }

        public Criteria andFinancialdetailidIn(List<Integer> values) {
            addCriterion("financialdetailid in", values, "financialdetailid");
            return (Criteria) this;
        }

        public Criteria andFinancialdetailidNotIn(List<Integer> values) {
            addCriterion("financialdetailid not in", values, "financialdetailid");
            return (Criteria) this;
        }

        public Criteria andFinancialdetailidBetween(Integer value1, Integer value2) {
            addCriterion("financialdetailid between", value1, value2, "financialdetailid");
            return (Criteria) this;
        }

        public Criteria andFinancialdetailidNotBetween(Integer value1, Integer value2) {
            addCriterion("financialdetailid not between", value1, value2, "financialdetailid");
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