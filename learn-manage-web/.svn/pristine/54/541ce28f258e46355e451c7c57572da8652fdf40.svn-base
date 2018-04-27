package com.learn.manage.pojo;

import java.util.ArrayList;
import java.util.List;

public class LJudgmentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LJudgmentExample() {
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

        public Criteria andPdIdIsNull() {
            addCriterion("pd_id is null");
            return (Criteria) this;
        }

        public Criteria andPdIdIsNotNull() {
            addCriterion("pd_id is not null");
            return (Criteria) this;
        }

        public Criteria andPdIdEqualTo(Integer value) {
            addCriterion("pd_id =", value, "pdId");
            return (Criteria) this;
        }

        public Criteria andPdIdNotEqualTo(Integer value) {
            addCriterion("pd_id <>", value, "pdId");
            return (Criteria) this;
        }

        public Criteria andPdIdGreaterThan(Integer value) {
            addCriterion("pd_id >", value, "pdId");
            return (Criteria) this;
        }

        public Criteria andPdIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("pd_id >=", value, "pdId");
            return (Criteria) this;
        }

        public Criteria andPdIdLessThan(Integer value) {
            addCriterion("pd_id <", value, "pdId");
            return (Criteria) this;
        }

        public Criteria andPdIdLessThanOrEqualTo(Integer value) {
            addCriterion("pd_id <=", value, "pdId");
            return (Criteria) this;
        }

        public Criteria andPdIdIn(List<Integer> values) {
            addCriterion("pd_id in", values, "pdId");
            return (Criteria) this;
        }

        public Criteria andPdIdNotIn(List<Integer> values) {
            addCriterion("pd_id not in", values, "pdId");
            return (Criteria) this;
        }

        public Criteria andPdIdBetween(Integer value1, Integer value2) {
            addCriterion("pd_id between", value1, value2, "pdId");
            return (Criteria) this;
        }

        public Criteria andPdIdNotBetween(Integer value1, Integer value2) {
            addCriterion("pd_id not between", value1, value2, "pdId");
            return (Criteria) this;
        }

        public Criteria andPdTitleIsNull() {
            addCriterion("pd_title is null");
            return (Criteria) this;
        }

        public Criteria andPdTitleIsNotNull() {
            addCriterion("pd_title is not null");
            return (Criteria) this;
        }

        public Criteria andPdTitleEqualTo(String value) {
            addCriterion("pd_title =", value, "pdTitle");
            return (Criteria) this;
        }

        public Criteria andPdTitleNotEqualTo(String value) {
            addCriterion("pd_title <>", value, "pdTitle");
            return (Criteria) this;
        }

        public Criteria andPdTitleGreaterThan(String value) {
            addCriterion("pd_title >", value, "pdTitle");
            return (Criteria) this;
        }

        public Criteria andPdTitleGreaterThanOrEqualTo(String value) {
            addCriterion("pd_title >=", value, "pdTitle");
            return (Criteria) this;
        }

        public Criteria andPdTitleLessThan(String value) {
            addCriterion("pd_title <", value, "pdTitle");
            return (Criteria) this;
        }

        public Criteria andPdTitleLessThanOrEqualTo(String value) {
            addCriterion("pd_title <=", value, "pdTitle");
            return (Criteria) this;
        }

        public Criteria andPdTitleLike(String value) {
            addCriterion("pd_title like", value, "pdTitle");
            return (Criteria) this;
        }

        public Criteria andPdTitleNotLike(String value) {
            addCriterion("pd_title not like", value, "pdTitle");
            return (Criteria) this;
        }

        public Criteria andPdTitleIn(List<String> values) {
            addCriterion("pd_title in", values, "pdTitle");
            return (Criteria) this;
        }

        public Criteria andPdTitleNotIn(List<String> values) {
            addCriterion("pd_title not in", values, "pdTitle");
            return (Criteria) this;
        }

        public Criteria andPdTitleBetween(String value1, String value2) {
            addCriterion("pd_title between", value1, value2, "pdTitle");
            return (Criteria) this;
        }

        public Criteria andPdTitleNotBetween(String value1, String value2) {
            addCriterion("pd_title not between", value1, value2, "pdTitle");
            return (Criteria) this;
        }

        public Criteria andPdAIsNull() {
            addCriterion("pd_a is null");
            return (Criteria) this;
        }

        public Criteria andPdAIsNotNull() {
            addCriterion("pd_a is not null");
            return (Criteria) this;
        }

        public Criteria andPdAEqualTo(String value) {
            addCriterion("pd_a =", value, "pdA");
            return (Criteria) this;
        }

        public Criteria andPdANotEqualTo(String value) {
            addCriterion("pd_a <>", value, "pdA");
            return (Criteria) this;
        }

        public Criteria andPdAGreaterThan(String value) {
            addCriterion("pd_a >", value, "pdA");
            return (Criteria) this;
        }

        public Criteria andPdAGreaterThanOrEqualTo(String value) {
            addCriterion("pd_a >=", value, "pdA");
            return (Criteria) this;
        }

        public Criteria andPdALessThan(String value) {
            addCriterion("pd_a <", value, "pdA");
            return (Criteria) this;
        }

        public Criteria andPdALessThanOrEqualTo(String value) {
            addCriterion("pd_a <=", value, "pdA");
            return (Criteria) this;
        }

        public Criteria andPdALike(String value) {
            addCriterion("pd_a like", value, "pdA");
            return (Criteria) this;
        }

        public Criteria andPdANotLike(String value) {
            addCriterion("pd_a not like", value, "pdA");
            return (Criteria) this;
        }

        public Criteria andPdAIn(List<String> values) {
            addCriterion("pd_a in", values, "pdA");
            return (Criteria) this;
        }

        public Criteria andPdANotIn(List<String> values) {
            addCriterion("pd_a not in", values, "pdA");
            return (Criteria) this;
        }

        public Criteria andPdABetween(String value1, String value2) {
            addCriterion("pd_a between", value1, value2, "pdA");
            return (Criteria) this;
        }

        public Criteria andPdANotBetween(String value1, String value2) {
            addCriterion("pd_a not between", value1, value2, "pdA");
            return (Criteria) this;
        }

        public Criteria andPdBIsNull() {
            addCriterion("pd_b is null");
            return (Criteria) this;
        }

        public Criteria andPdBIsNotNull() {
            addCriterion("pd_b is not null");
            return (Criteria) this;
        }

        public Criteria andPdBEqualTo(String value) {
            addCriterion("pd_b =", value, "pdB");
            return (Criteria) this;
        }

        public Criteria andPdBNotEqualTo(String value) {
            addCriterion("pd_b <>", value, "pdB");
            return (Criteria) this;
        }

        public Criteria andPdBGreaterThan(String value) {
            addCriterion("pd_b >", value, "pdB");
            return (Criteria) this;
        }

        public Criteria andPdBGreaterThanOrEqualTo(String value) {
            addCriterion("pd_b >=", value, "pdB");
            return (Criteria) this;
        }

        public Criteria andPdBLessThan(String value) {
            addCriterion("pd_b <", value, "pdB");
            return (Criteria) this;
        }

        public Criteria andPdBLessThanOrEqualTo(String value) {
            addCriterion("pd_b <=", value, "pdB");
            return (Criteria) this;
        }

        public Criteria andPdBLike(String value) {
            addCriterion("pd_b like", value, "pdB");
            return (Criteria) this;
        }

        public Criteria andPdBNotLike(String value) {
            addCriterion("pd_b not like", value, "pdB");
            return (Criteria) this;
        }

        public Criteria andPdBIn(List<String> values) {
            addCriterion("pd_b in", values, "pdB");
            return (Criteria) this;
        }

        public Criteria andPdBNotIn(List<String> values) {
            addCriterion("pd_b not in", values, "pdB");
            return (Criteria) this;
        }

        public Criteria andPdBBetween(String value1, String value2) {
            addCriterion("pd_b between", value1, value2, "pdB");
            return (Criteria) this;
        }

        public Criteria andPdBNotBetween(String value1, String value2) {
            addCriterion("pd_b not between", value1, value2, "pdB");
            return (Criteria) this;
        }

        public Criteria andPdCurrentIsNull() {
            addCriterion("pd_current is null");
            return (Criteria) this;
        }

        public Criteria andPdCurrentIsNotNull() {
            addCriterion("pd_current is not null");
            return (Criteria) this;
        }

        public Criteria andPdCurrentEqualTo(String value) {
            addCriterion("pd_current =", value, "pdCurrent");
            return (Criteria) this;
        }

        public Criteria andPdCurrentNotEqualTo(String value) {
            addCriterion("pd_current <>", value, "pdCurrent");
            return (Criteria) this;
        }

        public Criteria andPdCurrentGreaterThan(String value) {
            addCriterion("pd_current >", value, "pdCurrent");
            return (Criteria) this;
        }

        public Criteria andPdCurrentGreaterThanOrEqualTo(String value) {
            addCriterion("pd_current >=", value, "pdCurrent");
            return (Criteria) this;
        }

        public Criteria andPdCurrentLessThan(String value) {
            addCriterion("pd_current <", value, "pdCurrent");
            return (Criteria) this;
        }

        public Criteria andPdCurrentLessThanOrEqualTo(String value) {
            addCriterion("pd_current <=", value, "pdCurrent");
            return (Criteria) this;
        }

        public Criteria andPdCurrentLike(String value) {
            addCriterion("pd_current like", value, "pdCurrent");
            return (Criteria) this;
        }

        public Criteria andPdCurrentNotLike(String value) {
            addCriterion("pd_current not like", value, "pdCurrent");
            return (Criteria) this;
        }

        public Criteria andPdCurrentIn(List<String> values) {
            addCriterion("pd_current in", values, "pdCurrent");
            return (Criteria) this;
        }

        public Criteria andPdCurrentNotIn(List<String> values) {
            addCriterion("pd_current not in", values, "pdCurrent");
            return (Criteria) this;
        }

        public Criteria andPdCurrentBetween(String value1, String value2) {
            addCriterion("pd_current between", value1, value2, "pdCurrent");
            return (Criteria) this;
        }

        public Criteria andPdCurrentNotBetween(String value1, String value2) {
            addCriterion("pd_current not between", value1, value2, "pdCurrent");
            return (Criteria) this;
        }

        public Criteria andQIdIsNull() {
            addCriterion("q_id is null");
            return (Criteria) this;
        }

        public Criteria andQIdIsNotNull() {
            addCriterion("q_id is not null");
            return (Criteria) this;
        }

        public Criteria andQIdEqualTo(Integer value) {
            addCriterion("q_id =", value, "qId");
            return (Criteria) this;
        }

        public Criteria andQIdNotEqualTo(Integer value) {
            addCriterion("q_id <>", value, "qId");
            return (Criteria) this;
        }

        public Criteria andQIdGreaterThan(Integer value) {
            addCriterion("q_id >", value, "qId");
            return (Criteria) this;
        }

        public Criteria andQIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("q_id >=", value, "qId");
            return (Criteria) this;
        }

        public Criteria andQIdLessThan(Integer value) {
            addCriterion("q_id <", value, "qId");
            return (Criteria) this;
        }

        public Criteria andQIdLessThanOrEqualTo(Integer value) {
            addCriterion("q_id <=", value, "qId");
            return (Criteria) this;
        }

        public Criteria andQIdIn(List<Integer> values) {
            addCriterion("q_id in", values, "qId");
            return (Criteria) this;
        }

        public Criteria andQIdNotIn(List<Integer> values) {
            addCriterion("q_id not in", values, "qId");
            return (Criteria) this;
        }

        public Criteria andQIdBetween(Integer value1, Integer value2) {
            addCriterion("q_id between", value1, value2, "qId");
            return (Criteria) this;
        }

        public Criteria andQIdNotBetween(Integer value1, Integer value2) {
            addCriterion("q_id not between", value1, value2, "qId");
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