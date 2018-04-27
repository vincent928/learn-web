package com.learn.manage.pojo;

import java.util.ArrayList;
import java.util.List;

public class StuChooseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StuChooseExample() {
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

        public Criteria andXzIdIsNull() {
            addCriterion("xz_id is null");
            return (Criteria) this;
        }

        public Criteria andXzIdIsNotNull() {
            addCriterion("xz_id is not null");
            return (Criteria) this;
        }

        public Criteria andXzIdEqualTo(Integer value) {
            addCriterion("xz_id =", value, "xzId");
            return (Criteria) this;
        }

        public Criteria andXzIdNotEqualTo(Integer value) {
            addCriterion("xz_id <>", value, "xzId");
            return (Criteria) this;
        }

        public Criteria andXzIdGreaterThan(Integer value) {
            addCriterion("xz_id >", value, "xzId");
            return (Criteria) this;
        }

        public Criteria andXzIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("xz_id >=", value, "xzId");
            return (Criteria) this;
        }

        public Criteria andXzIdLessThan(Integer value) {
            addCriterion("xz_id <", value, "xzId");
            return (Criteria) this;
        }

        public Criteria andXzIdLessThanOrEqualTo(Integer value) {
            addCriterion("xz_id <=", value, "xzId");
            return (Criteria) this;
        }

        public Criteria andXzIdIn(List<Integer> values) {
            addCriterion("xz_id in", values, "xzId");
            return (Criteria) this;
        }

        public Criteria andXzIdNotIn(List<Integer> values) {
            addCriterion("xz_id not in", values, "xzId");
            return (Criteria) this;
        }

        public Criteria andXzIdBetween(Integer value1, Integer value2) {
            addCriterion("xz_id between", value1, value2, "xzId");
            return (Criteria) this;
        }

        public Criteria andXzIdNotBetween(Integer value1, Integer value2) {
            addCriterion("xz_id not between", value1, value2, "xzId");
            return (Criteria) this;
        }

        public Criteria andSAnswerIsNull() {
            addCriterion("s_answer is null");
            return (Criteria) this;
        }

        public Criteria andSAnswerIsNotNull() {
            addCriterion("s_answer is not null");
            return (Criteria) this;
        }

        public Criteria andSAnswerEqualTo(String value) {
            addCriterion("s_answer =", value, "sAnswer");
            return (Criteria) this;
        }

        public Criteria andSAnswerNotEqualTo(String value) {
            addCriterion("s_answer <>", value, "sAnswer");
            return (Criteria) this;
        }

        public Criteria andSAnswerGreaterThan(String value) {
            addCriterion("s_answer >", value, "sAnswer");
            return (Criteria) this;
        }

        public Criteria andSAnswerGreaterThanOrEqualTo(String value) {
            addCriterion("s_answer >=", value, "sAnswer");
            return (Criteria) this;
        }

        public Criteria andSAnswerLessThan(String value) {
            addCriterion("s_answer <", value, "sAnswer");
            return (Criteria) this;
        }

        public Criteria andSAnswerLessThanOrEqualTo(String value) {
            addCriterion("s_answer <=", value, "sAnswer");
            return (Criteria) this;
        }

        public Criteria andSAnswerLike(String value) {
            addCriterion("s_answer like", value, "sAnswer");
            return (Criteria) this;
        }

        public Criteria andSAnswerNotLike(String value) {
            addCriterion("s_answer not like", value, "sAnswer");
            return (Criteria) this;
        }

        public Criteria andSAnswerIn(List<String> values) {
            addCriterion("s_answer in", values, "sAnswer");
            return (Criteria) this;
        }

        public Criteria andSAnswerNotIn(List<String> values) {
            addCriterion("s_answer not in", values, "sAnswer");
            return (Criteria) this;
        }

        public Criteria andSAnswerBetween(String value1, String value2) {
            addCriterion("s_answer between", value1, value2, "sAnswer");
            return (Criteria) this;
        }

        public Criteria andSAnswerNotBetween(String value1, String value2) {
            addCriterion("s_answer not between", value1, value2, "sAnswer");
            return (Criteria) this;
        }

        public Criteria andHIdIsNull() {
            addCriterion("h_id is null");
            return (Criteria) this;
        }

        public Criteria andHIdIsNotNull() {
            addCriterion("h_id is not null");
            return (Criteria) this;
        }

        public Criteria andHIdEqualTo(Integer value) {
            addCriterion("h_id =", value, "hId");
            return (Criteria) this;
        }

        public Criteria andHIdNotEqualTo(Integer value) {
            addCriterion("h_id <>", value, "hId");
            return (Criteria) this;
        }

        public Criteria andHIdGreaterThan(Integer value) {
            addCriterion("h_id >", value, "hId");
            return (Criteria) this;
        }

        public Criteria andHIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("h_id >=", value, "hId");
            return (Criteria) this;
        }

        public Criteria andHIdLessThan(Integer value) {
            addCriterion("h_id <", value, "hId");
            return (Criteria) this;
        }

        public Criteria andHIdLessThanOrEqualTo(Integer value) {
            addCriterion("h_id <=", value, "hId");
            return (Criteria) this;
        }

        public Criteria andHIdIn(List<Integer> values) {
            addCriterion("h_id in", values, "hId");
            return (Criteria) this;
        }

        public Criteria andHIdNotIn(List<Integer> values) {
            addCriterion("h_id not in", values, "hId");
            return (Criteria) this;
        }

        public Criteria andHIdBetween(Integer value1, Integer value2) {
            addCriterion("h_id between", value1, value2, "hId");
            return (Criteria) this;
        }

        public Criteria andHIdNotBetween(Integer value1, Integer value2) {
            addCriterion("h_id not between", value1, value2, "hId");
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