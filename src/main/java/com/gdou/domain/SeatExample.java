package com.gdou.domain;

import java.util.ArrayList;
import java.util.List;

public class SeatExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SeatExample() {
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

        public Criteria andSeatidIsNull() {
            addCriterion("seatid is null");
            return (Criteria) this;
        }

        public Criteria andSeatidIsNotNull() {
            addCriterion("seatid is not null");
            return (Criteria) this;
        }

        public Criteria andSeatidEqualTo(Integer value) {
            addCriterion("seatid =", value, "seatid");
            return (Criteria) this;
        }

        public Criteria andSeatidNotEqualTo(Integer value) {
            addCriterion("seatid <>", value, "seatid");
            return (Criteria) this;
        }

        public Criteria andSeatidGreaterThan(Integer value) {
            addCriterion("seatid >", value, "seatid");
            return (Criteria) this;
        }

        public Criteria andSeatidGreaterThanOrEqualTo(Integer value) {
            addCriterion("seatid >=", value, "seatid");
            return (Criteria) this;
        }

        public Criteria andSeatidLessThan(Integer value) {
            addCriterion("seatid <", value, "seatid");
            return (Criteria) this;
        }

        public Criteria andSeatidLessThanOrEqualTo(Integer value) {
            addCriterion("seatid <=", value, "seatid");
            return (Criteria) this;
        }

        public Criteria andSeatidIn(List<Integer> values) {
            addCriterion("seatid in", values, "seatid");
            return (Criteria) this;
        }

        public Criteria andSeatidNotIn(List<Integer> values) {
            addCriterion("seatid not in", values, "seatid");
            return (Criteria) this;
        }

        public Criteria andSeatidBetween(Integer value1, Integer value2) {
            addCriterion("seatid between", value1, value2, "seatid");
            return (Criteria) this;
        }

        public Criteria andSeatidNotBetween(Integer value1, Integer value2) {
            addCriterion("seatid not between", value1, value2, "seatid");
            return (Criteria) this;
        }

        public Criteria andTrainidIsNull() {
            addCriterion("trainid is null");
            return (Criteria) this;
        }

        public Criteria andTrainidIsNotNull() {
            addCriterion("trainid is not null");
            return (Criteria) this;
        }

        public Criteria andTrainidEqualTo(Integer value) {
            addCriterion("trainid =", value, "trainid");
            return (Criteria) this;
        }

        public Criteria andTrainidNotEqualTo(Integer value) {
            addCriterion("trainid <>", value, "trainid");
            return (Criteria) this;
        }

        public Criteria andTrainidGreaterThan(Integer value) {
            addCriterion("trainid >", value, "trainid");
            return (Criteria) this;
        }

        public Criteria andTrainidGreaterThanOrEqualTo(Integer value) {
            addCriterion("trainid >=", value, "trainid");
            return (Criteria) this;
        }

        public Criteria andTrainidLessThan(Integer value) {
            addCriterion("trainid <", value, "trainid");
            return (Criteria) this;
        }

        public Criteria andTrainidLessThanOrEqualTo(Integer value) {
            addCriterion("trainid <=", value, "trainid");
            return (Criteria) this;
        }

        public Criteria andTrainidIn(List<Integer> values) {
            addCriterion("trainid in", values, "trainid");
            return (Criteria) this;
        }

        public Criteria andTrainidNotIn(List<Integer> values) {
            addCriterion("trainid not in", values, "trainid");
            return (Criteria) this;
        }

        public Criteria andTrainidBetween(Integer value1, Integer value2) {
            addCriterion("trainid between", value1, value2, "trainid");
            return (Criteria) this;
        }

        public Criteria andTrainidNotBetween(Integer value1, Integer value2) {
            addCriterion("trainid not between", value1, value2, "trainid");
            return (Criteria) this;
        }

        public Criteria andSeattypeIsNull() {
            addCriterion("seattype is null");
            return (Criteria) this;
        }

        public Criteria andSeattypeIsNotNull() {
            addCriterion("seattype is not null");
            return (Criteria) this;
        }

        public Criteria andSeattypeEqualTo(String value) {
            addCriterion("seattype =", value, "seattype");
            return (Criteria) this;
        }

        public Criteria andSeattypeNotEqualTo(String value) {
            addCriterion("seattype <>", value, "seattype");
            return (Criteria) this;
        }

        public Criteria andSeattypeGreaterThan(String value) {
            addCriterion("seattype >", value, "seattype");
            return (Criteria) this;
        }

        public Criteria andSeattypeGreaterThanOrEqualTo(String value) {
            addCriterion("seattype >=", value, "seattype");
            return (Criteria) this;
        }

        public Criteria andSeattypeLessThan(String value) {
            addCriterion("seattype <", value, "seattype");
            return (Criteria) this;
        }

        public Criteria andSeattypeLessThanOrEqualTo(String value) {
            addCriterion("seattype <=", value, "seattype");
            return (Criteria) this;
        }

        public Criteria andSeattypeLike(String value) {
            addCriterion("seattype like", value, "seattype");
            return (Criteria) this;
        }

        public Criteria andSeattypeNotLike(String value) {
            addCriterion("seattype not like", value, "seattype");
            return (Criteria) this;
        }

        public Criteria andSeattypeIn(List<String> values) {
            addCriterion("seattype in", values, "seattype");
            return (Criteria) this;
        }

        public Criteria andSeattypeNotIn(List<String> values) {
            addCriterion("seattype not in", values, "seattype");
            return (Criteria) this;
        }

        public Criteria andSeattypeBetween(String value1, String value2) {
            addCriterion("seattype between", value1, value2, "seattype");
            return (Criteria) this;
        }

        public Criteria andSeattypeNotBetween(String value1, String value2) {
            addCriterion("seattype not between", value1, value2, "seattype");
            return (Criteria) this;
        }

        public Criteria andCarriageIsNull() {
            addCriterion("carriage is null");
            return (Criteria) this;
        }

        public Criteria andCarriageIsNotNull() {
            addCriterion("carriage is not null");
            return (Criteria) this;
        }

        public Criteria andCarriageEqualTo(Integer value) {
            addCriterion("carriage =", value, "carriage");
            return (Criteria) this;
        }

        public Criteria andCarriageNotEqualTo(Integer value) {
            addCriterion("carriage <>", value, "carriage");
            return (Criteria) this;
        }

        public Criteria andCarriageGreaterThan(Integer value) {
            addCriterion("carriage >", value, "carriage");
            return (Criteria) this;
        }

        public Criteria andCarriageGreaterThanOrEqualTo(Integer value) {
            addCriterion("carriage >=", value, "carriage");
            return (Criteria) this;
        }

        public Criteria andCarriageLessThan(Integer value) {
            addCriterion("carriage <", value, "carriage");
            return (Criteria) this;
        }

        public Criteria andCarriageLessThanOrEqualTo(Integer value) {
            addCriterion("carriage <=", value, "carriage");
            return (Criteria) this;
        }

        public Criteria andCarriageIn(List<Integer> values) {
            addCriterion("carriage in", values, "carriage");
            return (Criteria) this;
        }

        public Criteria andCarriageNotIn(List<Integer> values) {
            addCriterion("carriage not in", values, "carriage");
            return (Criteria) this;
        }

        public Criteria andCarriageBetween(Integer value1, Integer value2) {
            addCriterion("carriage between", value1, value2, "carriage");
            return (Criteria) this;
        }

        public Criteria andCarriageNotBetween(Integer value1, Integer value2) {
            addCriterion("carriage not between", value1, value2, "carriage");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andSeatlocationIsNull() {
            addCriterion("seatlocation is null");
            return (Criteria) this;
        }

        public Criteria andSeatlocationIsNotNull() {
            addCriterion("seatlocation is not null");
            return (Criteria) this;
        }

        public Criteria andSeatlocationEqualTo(String value) {
            addCriterion("seatlocation =", value, "seatlocation");
            return (Criteria) this;
        }

        public Criteria andSeatlocationNotEqualTo(String value) {
            addCriterion("seatlocation <>", value, "seatlocation");
            return (Criteria) this;
        }

        public Criteria andSeatlocationGreaterThan(String value) {
            addCriterion("seatlocation >", value, "seatlocation");
            return (Criteria) this;
        }

        public Criteria andSeatlocationGreaterThanOrEqualTo(String value) {
            addCriterion("seatlocation >=", value, "seatlocation");
            return (Criteria) this;
        }

        public Criteria andSeatlocationLessThan(String value) {
            addCriterion("seatlocation <", value, "seatlocation");
            return (Criteria) this;
        }

        public Criteria andSeatlocationLessThanOrEqualTo(String value) {
            addCriterion("seatlocation <=", value, "seatlocation");
            return (Criteria) this;
        }

        public Criteria andSeatlocationLike(String value) {
            addCriterion("seatlocation like", value, "seatlocation");
            return (Criteria) this;
        }

        public Criteria andSeatlocationNotLike(String value) {
            addCriterion("seatlocation not like", value, "seatlocation");
            return (Criteria) this;
        }

        public Criteria andSeatlocationIn(List<String> values) {
            addCriterion("seatlocation in", values, "seatlocation");
            return (Criteria) this;
        }

        public Criteria andSeatlocationNotIn(List<String> values) {
            addCriterion("seatlocation not in", values, "seatlocation");
            return (Criteria) this;
        }

        public Criteria andSeatlocationBetween(String value1, String value2) {
            addCriterion("seatlocation between", value1, value2, "seatlocation");
            return (Criteria) this;
        }

        public Criteria andSeatlocationNotBetween(String value1, String value2) {
            addCriterion("seatlocation not between", value1, value2, "seatlocation");
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