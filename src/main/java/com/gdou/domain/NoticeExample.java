package com.gdou.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 * 公告数据库实体类，用于查询数据库
 */
public class NoticeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public NoticeExample() {
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

        public Criteria andNoticeidIsNull() {
            addCriterion("noticeid is null");
            return (Criteria) this;
        }

        public Criteria andNoticeidIsNotNull() {
            addCriterion("noticeid is not null");
            return (Criteria) this;
        }

        public Criteria andNoticeidEqualTo(Integer value) {
            addCriterion("noticeid =", value, "noticeid");
            return (Criteria) this;
        }

        public Criteria andNoticeidNotEqualTo(Integer value) {
            addCriterion("noticeid <>", value, "noticeid");
            return (Criteria) this;
        }

        public Criteria andNoticeidGreaterThan(Integer value) {
            addCriterion("noticeid >", value, "noticeid");
            return (Criteria) this;
        }

        public Criteria andNoticeidGreaterThanOrEqualTo(Integer value) {
            addCriterion("noticeid >=", value, "noticeid");
            return (Criteria) this;
        }

        public Criteria andNoticeidLessThan(Integer value) {
            addCriterion("noticeid <", value, "noticeid");
            return (Criteria) this;
        }

        public Criteria andNoticeidLessThanOrEqualTo(Integer value) {
            addCriterion("noticeid <=", value, "noticeid");
            return (Criteria) this;
        }

        public Criteria andNoticeidIn(List<Integer> values) {
            addCriterion("noticeid in", values, "noticeid");
            return (Criteria) this;
        }

        public Criteria andNoticeidNotIn(List<Integer> values) {
            addCriterion("noticeid not in", values, "noticeid");
            return (Criteria) this;
        }

        public Criteria andNoticeidBetween(Integer value1, Integer value2) {
            addCriterion("noticeid between", value1, value2, "noticeid");
            return (Criteria) this;
        }

        public Criteria andNoticeidNotBetween(Integer value1, Integer value2) {
            addCriterion("noticeid not between", value1, value2, "noticeid");
            return (Criteria) this;
        }

        public Criteria andNoticetitleIsNull() {
            addCriterion("noticetitle is null");
            return (Criteria) this;
        }

        public Criteria andNoticetitleIsNotNull() {
            addCriterion("noticetitle is not null");
            return (Criteria) this;
        }

        public Criteria andNoticetitleEqualTo(String value) {
            addCriterion("noticetitle =", value, "noticetitle");
            return (Criteria) this;
        }

        public Criteria andNoticetitleNotEqualTo(String value) {
            addCriterion("noticetitle <>", value, "noticetitle");
            return (Criteria) this;
        }

        public Criteria andNoticetitleGreaterThan(String value) {
            addCriterion("noticetitle >", value, "noticetitle");
            return (Criteria) this;
        }

        public Criteria andNoticetitleGreaterThanOrEqualTo(String value) {
            addCriterion("noticetitle >=", value, "noticetitle");
            return (Criteria) this;
        }

        public Criteria andNoticetitleLessThan(String value) {
            addCriterion("noticetitle <", value, "noticetitle");
            return (Criteria) this;
        }

        public Criteria andNoticetitleLessThanOrEqualTo(String value) {
            addCriterion("noticetitle <=", value, "noticetitle");
            return (Criteria) this;
        }

        public Criteria andNoticetitleLike(String value) {
            addCriterion("noticetitle like", value, "noticetitle");
            return (Criteria) this;
        }

        public Criteria andNoticetitleNotLike(String value) {
            addCriterion("noticetitle not like", value, "noticetitle");
            return (Criteria) this;
        }

        public Criteria andNoticetitleIn(List<String> values) {
            addCriterion("noticetitle in", values, "noticetitle");
            return (Criteria) this;
        }

        public Criteria andNoticetitleNotIn(List<String> values) {
            addCriterion("noticetitle not in", values, "noticetitle");
            return (Criteria) this;
        }

        public Criteria andNoticetitleBetween(String value1, String value2) {
            addCriterion("noticetitle between", value1, value2, "noticetitle");
            return (Criteria) this;
        }

        public Criteria andNoticetitleNotBetween(String value1, String value2) {
            addCriterion("noticetitle not between", value1, value2, "noticetitle");
            return (Criteria) this;
        }

        public Criteria andNoticetimeIsNull() {
            addCriterion("noticetime is null");
            return (Criteria) this;
        }

        public Criteria andNoticetimeIsNotNull() {
            addCriterion("noticetime is not null");
            return (Criteria) this;
        }

        public Criteria andNoticetimeEqualTo(Date value) {
            addCriterion("noticetime =", value, "noticetime");
            return (Criteria) this;
        }

        public Criteria andNoticetimeNotEqualTo(Date value) {
            addCriterion("noticetime <>", value, "noticetime");
            return (Criteria) this;
        }

        public Criteria andNoticetimeGreaterThan(Date value) {
            addCriterion("noticetime >", value, "noticetime");
            return (Criteria) this;
        }

        public Criteria andNoticetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("noticetime >=", value, "noticetime");
            return (Criteria) this;
        }

        public Criteria andNoticetimeLessThan(Date value) {
            addCriterion("noticetime <", value, "noticetime");
            return (Criteria) this;
        }

        public Criteria andNoticetimeLessThanOrEqualTo(Date value) {
            addCriterion("noticetime <=", value, "noticetime");
            return (Criteria) this;
        }

        public Criteria andNoticetimeIn(List<Date> values) {
            addCriterion("noticetime in", values, "noticetime");
            return (Criteria) this;
        }

        public Criteria andNoticetimeNotIn(List<Date> values) {
            addCriterion("noticetime not in", values, "noticetime");
            return (Criteria) this;
        }

        public Criteria andNoticetimeBetween(Date value1, Date value2) {
            addCriterion("noticetime between", value1, value2, "noticetime");
            return (Criteria) this;
        }

        public Criteria andNoticetimeNotBetween(Date value1, Date value2) {
            addCriterion("noticetime not between", value1, value2, "noticetime");
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