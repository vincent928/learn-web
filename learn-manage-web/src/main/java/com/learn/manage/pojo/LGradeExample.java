package com.learn.manage.pojo;

import java.util.ArrayList;
import java.util.List;

public class LGradeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LGradeExample() {
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

        public Criteria andTIdIsNull() {
            addCriterion("t_id is null");
            return (Criteria) this;
        }

        public Criteria andTIdIsNotNull() {
            addCriterion("t_id is not null");
            return (Criteria) this;
        }

        public Criteria andTIdEqualTo(String value) {
            addCriterion("t_id =", value, "tId");
            return (Criteria) this;
        }

        public Criteria andTIdNotEqualTo(String value) {
            addCriterion("t_id <>", value, "tId");
            return (Criteria) this;
        }

        public Criteria andTIdGreaterThan(String value) {
            addCriterion("t_id >", value, "tId");
            return (Criteria) this;
        }

        public Criteria andTIdGreaterThanOrEqualTo(String value) {
            addCriterion("t_id >=", value, "tId");
            return (Criteria) this;
        }

        public Criteria andTIdLessThan(String value) {
            addCriterion("t_id <", value, "tId");
            return (Criteria) this;
        }

        public Criteria andTIdLessThanOrEqualTo(String value) {
            addCriterion("t_id <=", value, "tId");
            return (Criteria) this;
        }

        public Criteria andTIdLike(String value) {
            addCriterion("t_id like", value, "tId");
            return (Criteria) this;
        }

        public Criteria andTIdNotLike(String value) {
            addCriterion("t_id not like", value, "tId");
            return (Criteria) this;
        }

        public Criteria andTIdIn(List<String> values) {
            addCriterion("t_id in", values, "tId");
            return (Criteria) this;
        }

        public Criteria andTIdNotIn(List<String> values) {
            addCriterion("t_id not in", values, "tId");
            return (Criteria) this;
        }

        public Criteria andTIdBetween(String value1, String value2) {
            addCriterion("t_id between", value1, value2, "tId");
            return (Criteria) this;
        }

        public Criteria andTIdNotBetween(String value1, String value2) {
            addCriterion("t_id not between", value1, value2, "tId");
            return (Criteria) this;
        }

        public Criteria andLGradeIsNull() {
            addCriterion("l_grade is null");
            return (Criteria) this;
        }

        public Criteria andLGradeIsNotNull() {
            addCriterion("l_grade is not null");
            return (Criteria) this;
        }

        public Criteria andLGradeEqualTo(String value) {
            addCriterion("l_grade =", value, "lGrade");
            return (Criteria) this;
        }

        public Criteria andLGradeNotEqualTo(String value) {
            addCriterion("l_grade <>", value, "lGrade");
            return (Criteria) this;
        }

        public Criteria andLGradeGreaterThan(String value) {
            addCriterion("l_grade >", value, "lGrade");
            return (Criteria) this;
        }

        public Criteria andLGradeGreaterThanOrEqualTo(String value) {
            addCriterion("l_grade >=", value, "lGrade");
            return (Criteria) this;
        }

        public Criteria andLGradeLessThan(String value) {
            addCriterion("l_grade <", value, "lGrade");
            return (Criteria) this;
        }

        public Criteria andLGradeLessThanOrEqualTo(String value) {
            addCriterion("l_grade <=", value, "lGrade");
            return (Criteria) this;
        }

        public Criteria andLGradeLike(String value) {
            addCriterion("l_grade like", value, "lGrade");
            return (Criteria) this;
        }

        public Criteria andLGradeNotLike(String value) {
            addCriterion("l_grade not like", value, "lGrade");
            return (Criteria) this;
        }

        public Criteria andLGradeIn(List<String> values) {
            addCriterion("l_grade in", values, "lGrade");
            return (Criteria) this;
        }

        public Criteria andLGradeNotIn(List<String> values) {
            addCriterion("l_grade not in", values, "lGrade");
            return (Criteria) this;
        }

        public Criteria andLGradeBetween(String value1, String value2) {
            addCriterion("l_grade between", value1, value2, "lGrade");
            return (Criteria) this;
        }

        public Criteria andLGradeNotBetween(String value1, String value2) {
            addCriterion("l_grade not between", value1, value2, "lGrade");
            return (Criteria) this;
        }

        public Criteria andLClassIsNull() {
            addCriterion("l_class is null");
            return (Criteria) this;
        }

        public Criteria andLClassIsNotNull() {
            addCriterion("l_class is not null");
            return (Criteria) this;
        }

        public Criteria andLClassEqualTo(String value) {
            addCriterion("l_class =", value, "lClass");
            return (Criteria) this;
        }

        public Criteria andLClassNotEqualTo(String value) {
            addCriterion("l_class <>", value, "lClass");
            return (Criteria) this;
        }

        public Criteria andLClassGreaterThan(String value) {
            addCriterion("l_class >", value, "lClass");
            return (Criteria) this;
        }

        public Criteria andLClassGreaterThanOrEqualTo(String value) {
            addCriterion("l_class >=", value, "lClass");
            return (Criteria) this;
        }

        public Criteria andLClassLessThan(String value) {
            addCriterion("l_class <", value, "lClass");
            return (Criteria) this;
        }

        public Criteria andLClassLessThanOrEqualTo(String value) {
            addCriterion("l_class <=", value, "lClass");
            return (Criteria) this;
        }

        public Criteria andLClassLike(String value) {
            addCriterion("l_class like", value, "lClass");
            return (Criteria) this;
        }

        public Criteria andLClassNotLike(String value) {
            addCriterion("l_class not like", value, "lClass");
            return (Criteria) this;
        }

        public Criteria andLClassIn(List<String> values) {
            addCriterion("l_class in", values, "lClass");
            return (Criteria) this;
        }

        public Criteria andLClassNotIn(List<String> values) {
            addCriterion("l_class not in", values, "lClass");
            return (Criteria) this;
        }

        public Criteria andLClassBetween(String value1, String value2) {
            addCriterion("l_class between", value1, value2, "lClass");
            return (Criteria) this;
        }

        public Criteria andLClassNotBetween(String value1, String value2) {
            addCriterion("l_class not between", value1, value2, "lClass");
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