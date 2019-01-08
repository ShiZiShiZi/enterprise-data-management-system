package org.hfut.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProjectPeopleFeedbackExample {

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProjectPeopleFeedbackExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andRequestPeopleIdIsNull() {
            addCriterion("request_people_id is null");
            return (Criteria) this;
        }

        public Criteria andRequestPeopleIdIsNotNull() {
            addCriterion("request_people_id is not null");
            return (Criteria) this;
        }

        public Criteria andRequestPeopleIdEqualTo(Integer value) {
            addCriterion("request_people_id =", value, "requestPeopleId");
            return (Criteria) this;
        }

        public Criteria andRequestPeopleIdNotEqualTo(Integer value) {
            addCriterion("request_people_id <>", value, "requestPeopleId");
            return (Criteria) this;
        }

        public Criteria andRequestPeopleIdGreaterThan(Integer value) {
            addCriterion("request_people_id >", value, "requestPeopleId");
            return (Criteria) this;
        }

        public Criteria andRequestPeopleIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("request_people_id >=", value, "requestPeopleId");
            return (Criteria) this;
        }

        public Criteria andRequestPeopleIdLessThan(Integer value) {
            addCriterion("request_people_id <", value, "requestPeopleId");
            return (Criteria) this;
        }

        public Criteria andRequestPeopleIdLessThanOrEqualTo(Integer value) {
            addCriterion("request_people_id <=", value, "requestPeopleId");
            return (Criteria) this;
        }

        public Criteria andRequestPeopleIdIn(List<Integer> values) {
            addCriterion("request_people_id in", values, "requestPeopleId");
            return (Criteria) this;
        }

        public Criteria andRequestPeopleIdNotIn(List<Integer> values) {
            addCriterion("request_people_id not in", values, "requestPeopleId");
            return (Criteria) this;
        }

        public Criteria andRequestPeopleIdBetween(Integer value1, Integer value2) {
            addCriterion("request_people_id between", value1, value2, "requestPeopleId");
            return (Criteria) this;
        }

        public Criteria andRequestPeopleIdNotBetween(Integer value1, Integer value2) {
            addCriterion("request_people_id not between", value1, value2, "requestPeopleId");
            return (Criteria) this;
        }

        public Criteria andRequestTimeIsNull() {
            addCriterion("request_time is null");
            return (Criteria) this;
        }

        public Criteria andRequestTimeIsNotNull() {
            addCriterion("request_time is not null");
            return (Criteria) this;
        }

        public Criteria andRequestTimeEqualTo(Date value) {
            addCriterion("request_time =", value, "requestTime");
            return (Criteria) this;
        }

        public Criteria andRequestTimeNotEqualTo(Date value) {
            addCriterion("request_time <>", value, "requestTime");
            return (Criteria) this;
        }

        public Criteria andRequestTimeGreaterThan(Date value) {
            addCriterion("request_time >", value, "requestTime");
            return (Criteria) this;
        }

        public Criteria andRequestTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("request_time >=", value, "requestTime");
            return (Criteria) this;
        }

        public Criteria andRequestTimeLessThan(Date value) {
            addCriterion("request_time <", value, "requestTime");
            return (Criteria) this;
        }

        public Criteria andRequestTimeLessThanOrEqualTo(Date value) {
            addCriterion("request_time <=", value, "requestTime");
            return (Criteria) this;
        }

        public Criteria andRequestTimeIn(List<Date> values) {
            addCriterion("request_time in", values, "requestTime");
            return (Criteria) this;
        }

        public Criteria andRequestTimeNotIn(List<Date> values) {
            addCriterion("request_time not in", values, "requestTime");
            return (Criteria) this;
        }

        public Criteria andRequestTimeBetween(Date value1, Date value2) {
            addCriterion("request_time between", value1, value2, "requestTime");
            return (Criteria) this;
        }

        public Criteria andRequestTimeNotBetween(Date value1, Date value2) {
            addCriterion("request_time not between", value1, value2, "requestTime");
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

        public Criteria andResponsePeopeleIdIsNull() {
            addCriterion("response_peopele_id is null");
            return (Criteria) this;
        }

        public Criteria andResponsePeopeleIdIsNotNull() {
            addCriterion("response_peopele_id is not null");
            return (Criteria) this;
        }

        public Criteria andResponsePeopeleIdEqualTo(Integer value) {
            addCriterion("response_peopele_id =", value, "responsePeopeleId");
            return (Criteria) this;
        }

        public Criteria andResponsePeopeleIdNotEqualTo(Integer value) {
            addCriterion("response_peopele_id <>", value, "responsePeopeleId");
            return (Criteria) this;
        }

        public Criteria andResponsePeopeleIdGreaterThan(Integer value) {
            addCriterion("response_peopele_id >", value, "responsePeopeleId");
            return (Criteria) this;
        }

        public Criteria andResponsePeopeleIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("response_peopele_id >=", value, "responsePeopeleId");
            return (Criteria) this;
        }

        public Criteria andResponsePeopeleIdLessThan(Integer value) {
            addCriterion("response_peopele_id <", value, "responsePeopeleId");
            return (Criteria) this;
        }

        public Criteria andResponsePeopeleIdLessThanOrEqualTo(Integer value) {
            addCriterion("response_peopele_id <=", value, "responsePeopeleId");
            return (Criteria) this;
        }

        public Criteria andResponsePeopeleIdIn(List<Integer> values) {
            addCriterion("response_peopele_id in", values, "responsePeopeleId");
            return (Criteria) this;
        }

        public Criteria andResponsePeopeleIdNotIn(List<Integer> values) {
            addCriterion("response_peopele_id not in", values, "responsePeopeleId");
            return (Criteria) this;
        }

        public Criteria andResponsePeopeleIdBetween(Integer value1, Integer value2) {
            addCriterion("response_peopele_id between", value1, value2, "responsePeopeleId");
            return (Criteria) this;
        }

        public Criteria andResponsePeopeleIdNotBetween(Integer value1, Integer value2) {
            addCriterion("response_peopele_id not between", value1, value2, "responsePeopeleId");
            return (Criteria) this;
        }

        public Criteria andReesponseTimeIsNull() {
            addCriterion("reesponse_time is null");
            return (Criteria) this;
        }

        public Criteria andReesponseTimeIsNotNull() {
            addCriterion("reesponse_time is not null");
            return (Criteria) this;
        }

        public Criteria andReesponseTimeEqualTo(Date value) {
            addCriterion("reesponse_time =", value, "reesponseTime");
            return (Criteria) this;
        }

        public Criteria andReesponseTimeNotEqualTo(Date value) {
            addCriterion("reesponse_time <>", value, "reesponseTime");
            return (Criteria) this;
        }

        public Criteria andReesponseTimeGreaterThan(Date value) {
            addCriterion("reesponse_time >", value, "reesponseTime");
            return (Criteria) this;
        }

        public Criteria andReesponseTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("reesponse_time >=", value, "reesponseTime");
            return (Criteria) this;
        }

        public Criteria andReesponseTimeLessThan(Date value) {
            addCriterion("reesponse_time <", value, "reesponseTime");
            return (Criteria) this;
        }

        public Criteria andReesponseTimeLessThanOrEqualTo(Date value) {
            addCriterion("reesponse_time <=", value, "reesponseTime");
            return (Criteria) this;
        }

        public Criteria andReesponseTimeIn(List<Date> values) {
            addCriterion("reesponse_time in", values, "reesponseTime");
            return (Criteria) this;
        }

        public Criteria andReesponseTimeNotIn(List<Date> values) {
            addCriterion("reesponse_time not in", values, "reesponseTime");
            return (Criteria) this;
        }

        public Criteria andReesponseTimeBetween(Date value1, Date value2) {
            addCriterion("reesponse_time between", value1, value2, "reesponseTime");
            return (Criteria) this;
        }

        public Criteria andReesponseTimeNotBetween(Date value1, Date value2) {
            addCriterion("reesponse_time not between", value1, value2, "reesponseTime");
            return (Criteria) this;
        }

        public Criteria andTargetPeopleIdIsNull() {
            addCriterion("target_people_id is null");
            return (Criteria) this;
        }

        public Criteria andTargetPeopleIdIsNotNull() {
            addCriterion("target_people_id is not null");
            return (Criteria) this;
        }

        public Criteria andTargetPeopleIdEqualTo(Integer value) {
            addCriterion("target_people_id =", value, "targetPeopleId");
            return (Criteria) this;
        }

        public Criteria andTargetPeopleIdNotEqualTo(Integer value) {
            addCriterion("target_people_id <>", value, "targetPeopleId");
            return (Criteria) this;
        }

        public Criteria andTargetPeopleIdGreaterThan(Integer value) {
            addCriterion("target_people_id >", value, "targetPeopleId");
            return (Criteria) this;
        }

        public Criteria andTargetPeopleIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("target_people_id >=", value, "targetPeopleId");
            return (Criteria) this;
        }

        public Criteria andTargetPeopleIdLessThan(Integer value) {
            addCriterion("target_people_id <", value, "targetPeopleId");
            return (Criteria) this;
        }

        public Criteria andTargetPeopleIdLessThanOrEqualTo(Integer value) {
            addCriterion("target_people_id <=", value, "targetPeopleId");
            return (Criteria) this;
        }

        public Criteria andTargetPeopleIdIn(List<Integer> values) {
            addCriterion("target_people_id in", values, "targetPeopleId");
            return (Criteria) this;
        }

        public Criteria andTargetPeopleIdNotIn(List<Integer> values) {
            addCriterion("target_people_id not in", values, "targetPeopleId");
            return (Criteria) this;
        }

        public Criteria andTargetPeopleIdBetween(Integer value1, Integer value2) {
            addCriterion("target_people_id between", value1, value2, "targetPeopleId");
            return (Criteria) this;
        }

        public Criteria andTargetPeopleIdNotBetween(Integer value1, Integer value2) {
            addCriterion("target_people_id not between", value1, value2, "targetPeopleId");
            return (Criteria) this;
        }

        public Criteria andTargetDepartmentIdIsNull() {
            addCriterion("target_department_id is null");
            return (Criteria) this;
        }

        public Criteria andTargetDepartmentIdIsNotNull() {
            addCriterion("target_department_id is not null");
            return (Criteria) this;
        }

        public Criteria andTargetDepartmentIdEqualTo(Integer value) {
            addCriterion("target_department_id =", value, "targetDepartmentId");
            return (Criteria) this;
        }

        public Criteria andTargetDepartmentIdNotEqualTo(Integer value) {
            addCriterion("target_department_id <>", value, "targetDepartmentId");
            return (Criteria) this;
        }

        public Criteria andTargetDepartmentIdGreaterThan(Integer value) {
            addCriterion("target_department_id >", value, "targetDepartmentId");
            return (Criteria) this;
        }

        public Criteria andTargetDepartmentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("target_department_id >=", value, "targetDepartmentId");
            return (Criteria) this;
        }

        public Criteria andTargetDepartmentIdLessThan(Integer value) {
            addCriterion("target_department_id <", value, "targetDepartmentId");
            return (Criteria) this;
        }

        public Criteria andTargetDepartmentIdLessThanOrEqualTo(Integer value) {
            addCriterion("target_department_id <=", value, "targetDepartmentId");
            return (Criteria) this;
        }

        public Criteria andTargetDepartmentIdIn(List<Integer> values) {
            addCriterion("target_department_id in", values, "targetDepartmentId");
            return (Criteria) this;
        }

        public Criteria andTargetDepartmentIdNotIn(List<Integer> values) {
            addCriterion("target_department_id not in", values, "targetDepartmentId");
            return (Criteria) this;
        }

        public Criteria andTargetDepartmentIdBetween(Integer value1, Integer value2) {
            addCriterion("target_department_id between", value1, value2, "targetDepartmentId");
            return (Criteria) this;
        }

        public Criteria andTargetDepartmentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("target_department_id not between", value1, value2, "targetDepartmentId");
            return (Criteria) this;
        }

        public Criteria andTargetProjectIdIsNull() {
            addCriterion("target_project_id is null");
            return (Criteria) this;
        }

        public Criteria andTargetProjectIdIsNotNull() {
            addCriterion("target_project_id is not null");
            return (Criteria) this;
        }

        public Criteria andTargetProjectIdEqualTo(Integer value) {
            addCriterion("target_project_id =", value, "targetProjectId");
            return (Criteria) this;
        }

        public Criteria andTargetProjectIdNotEqualTo(Integer value) {
            addCriterion("target_project_id <>", value, "targetProjectId");
            return (Criteria) this;
        }

        public Criteria andTargetProjectIdGreaterThan(Integer value) {
            addCriterion("target_project_id >", value, "targetProjectId");
            return (Criteria) this;
        }

        public Criteria andTargetProjectIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("target_project_id >=", value, "targetProjectId");
            return (Criteria) this;
        }

        public Criteria andTargetProjectIdLessThan(Integer value) {
            addCriterion("target_project_id <", value, "targetProjectId");
            return (Criteria) this;
        }

        public Criteria andTargetProjectIdLessThanOrEqualTo(Integer value) {
            addCriterion("target_project_id <=", value, "targetProjectId");
            return (Criteria) this;
        }

        public Criteria andTargetProjectIdIn(List<Integer> values) {
            addCriterion("target_project_id in", values, "targetProjectId");
            return (Criteria) this;
        }

        public Criteria andTargetProjectIdNotIn(List<Integer> values) {
            addCriterion("target_project_id not in", values, "targetProjectId");
            return (Criteria) this;
        }

        public Criteria andTargetProjectIdBetween(Integer value1, Integer value2) {
            addCriterion("target_project_id between", value1, value2, "targetProjectId");
            return (Criteria) this;
        }

        public Criteria andTargetProjectIdNotBetween(Integer value1, Integer value2) {
            addCriterion("target_project_id not between", value1, value2, "targetProjectId");
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