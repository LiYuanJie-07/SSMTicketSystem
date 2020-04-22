package com.gdou.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StationExample() {
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

        public Criteria andStationidIsNull() {
            addCriterion("stationid is null");
            return (Criteria) this;
        }

        public Criteria andStationidIsNotNull() {
            addCriterion("stationid is not null");
            return (Criteria) this;
        }

        public Criteria andStationidEqualTo(Integer value) {
            addCriterion("stationid =", value, "stationid");
            return (Criteria) this;
        }

        public Criteria andStationidNotEqualTo(Integer value) {
            addCriterion("stationid <>", value, "stationid");
            return (Criteria) this;
        }

        public Criteria andStationidGreaterThan(Integer value) {
            addCriterion("stationid >", value, "stationid");
            return (Criteria) this;
        }

        public Criteria andStationidGreaterThanOrEqualTo(Integer value) {
            addCriterion("stationid >=", value, "stationid");
            return (Criteria) this;
        }

        public Criteria andStationidLessThan(Integer value) {
            addCriterion("stationid <", value, "stationid");
            return (Criteria) this;
        }

        public Criteria andStationidLessThanOrEqualTo(Integer value) {
            addCriterion("stationid <=", value, "stationid");
            return (Criteria) this;
        }

        public Criteria andStationidIn(List<Integer> values) {
            addCriterion("stationid in", values, "stationid");
            return (Criteria) this;
        }

        public Criteria andStationidNotIn(List<Integer> values) {
            addCriterion("stationid not in", values, "stationid");
            return (Criteria) this;
        }

        public Criteria andStationidBetween(Integer value1, Integer value2) {
            addCriterion("stationid between", value1, value2, "stationid");
            return (Criteria) this;
        }

        public Criteria andStationidNotBetween(Integer value1, Integer value2) {
            addCriterion("stationid not between", value1, value2, "stationid");
            return (Criteria) this;
        }

        public Criteria andStartstationIsNull() {
            addCriterion("startstation is null");
            return (Criteria) this;
        }

        public Criteria andStartstationIsNotNull() {
            addCriterion("startstation is not null");
            return (Criteria) this;
        }

        public Criteria andStartstationEqualTo(String value) {
            addCriterion("startstation =", value, "startstation");
            return (Criteria) this;
        }

        public Criteria andStartstationNotEqualTo(String value) {
            addCriterion("startstation <>", value, "startstation");
            return (Criteria) this;
        }

        public Criteria andStartstationGreaterThan(String value) {
            addCriterion("startstation >", value, "startstation");
            return (Criteria) this;
        }

        public Criteria andStartstationGreaterThanOrEqualTo(String value) {
            addCriterion("startstation >=", value, "startstation");
            return (Criteria) this;
        }

        public Criteria andStartstationLessThan(String value) {
            addCriterion("startstation <", value, "startstation");
            return (Criteria) this;
        }

        public Criteria andStartstationLessThanOrEqualTo(String value) {
            addCriterion("startstation <=", value, "startstation");
            return (Criteria) this;
        }

        public Criteria andStartstationLike(String value) {
            addCriterion("startstation like", value, "startstation");
            return (Criteria) this;
        }

        public Criteria andStartstationNotLike(String value) {
            addCriterion("startstation not like", value, "startstation");
            return (Criteria) this;
        }

        public Criteria andStartstationIn(List<String> values) {
            addCriterion("startstation in", values, "startstation");
            return (Criteria) this;
        }

        public Criteria andStartstationNotIn(List<String> values) {
            addCriterion("startstation not in", values, "startstation");
            return (Criteria) this;
        }

        public Criteria andStartstationBetween(String value1, String value2) {
            addCriterion("startstation between", value1, value2, "startstation");
            return (Criteria) this;
        }

        public Criteria andStartstationNotBetween(String value1, String value2) {
            addCriterion("startstation not between", value1, value2, "startstation");
            return (Criteria) this;
        }

        public Criteria andEndstationIsNull() {
            addCriterion("endstation is null");
            return (Criteria) this;
        }

        public Criteria andEndstationIsNotNull() {
            addCriterion("endstation is not null");
            return (Criteria) this;
        }

        public Criteria andEndstationEqualTo(String value) {
            addCriterion("endstation =", value, "endstation");
            return (Criteria) this;
        }

        public Criteria andEndstationNotEqualTo(String value) {
            addCriterion("endstation <>", value, "endstation");
            return (Criteria) this;
        }

        public Criteria andEndstationGreaterThan(String value) {
            addCriterion("endstation >", value, "endstation");
            return (Criteria) this;
        }

        public Criteria andEndstationGreaterThanOrEqualTo(String value) {
            addCriterion("endstation >=", value, "endstation");
            return (Criteria) this;
        }

        public Criteria andEndstationLessThan(String value) {
            addCriterion("endstation <", value, "endstation");
            return (Criteria) this;
        }

        public Criteria andEndstationLessThanOrEqualTo(String value) {
            addCriterion("endstation <=", value, "endstation");
            return (Criteria) this;
        }

        public Criteria andEndstationLike(String value) {
            addCriterion("endstation like", value, "endstation");
            return (Criteria) this;
        }

        public Criteria andEndstationNotLike(String value) {
            addCriterion("endstation not like", value, "endstation");
            return (Criteria) this;
        }

        public Criteria andEndstationIn(List<String> values) {
            addCriterion("endstation in", values, "endstation");
            return (Criteria) this;
        }

        public Criteria andEndstationNotIn(List<String> values) {
            addCriterion("endstation not in", values, "endstation");
            return (Criteria) this;
        }

        public Criteria andEndstationBetween(String value1, String value2) {
            addCriterion("endstation between", value1, value2, "endstation");
            return (Criteria) this;
        }

        public Criteria andEndstationNotBetween(String value1, String value2) {
            addCriterion("endstation not between", value1, value2, "endstation");
            return (Criteria) this;
        }

        public Criteria andStarttimeIsNull() {
            addCriterion("starttime is null");
            return (Criteria) this;
        }

        public Criteria andStarttimeIsNotNull() {
            addCriterion("starttime is not null");
            return (Criteria) this;
        }

        public Criteria andStarttimeEqualTo(String value) {
            addCriterion("starttime =", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotEqualTo(String value) {
            addCriterion("starttime <>", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeGreaterThan(String value) {
            addCriterion("starttime >", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeGreaterThanOrEqualTo(String value) {
            addCriterion("starttime >=", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeLessThan(String value) {
            addCriterion("starttime <", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeLessThanOrEqualTo(String value) {
            addCriterion("starttime <=", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeIn(List<String> values) {
            addCriterion("starttime in", values, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotIn(List<String> values) {
            addCriterion("starttime not in", values, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeBetween(String value1, String value2) {
            addCriterion("starttime between", value1, value2, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotBetween(String value1, String value2) {
            addCriterion("starttime not between", value1, value2, "starttime");
            return (Criteria) this;
        }

        public Criteria andArrivetimeIsNull() {
            addCriterion("arrivetime is null");
            return (Criteria) this;
        }

        public Criteria andArrivetimeIsNotNull() {
            addCriterion("arrivetime is not null");
            return (Criteria) this;
        }

        public Criteria andArrivetimeEqualTo(String value) {
            addCriterion("arrivetime =", value, "arrivetime");
            return (Criteria) this;
        }

        public Criteria andArrivetimeNotEqualTo(String value) {
            addCriterion("arrivetime <>", value, "arrivetime");
            return (Criteria) this;
        }

        public Criteria andArrivetimeGreaterThan(String value) {
            addCriterion("arrivetime >", value, "arrivetime");
            return (Criteria) this;
        }

        public Criteria andArrivetimeGreaterThanOrEqualTo(String value) {
            addCriterion("arrivetime >=", value, "arrivetime");
            return (Criteria) this;
        }

        public Criteria andArrivetimeLessThan(String value) {
            addCriterion("arrivetime <", value, "arrivetime");
            return (Criteria) this;
        }

        public Criteria andArrivetimeLessThanOrEqualTo(String value) {
            addCriterion("arrivetime <=", value, "arrivetime");
            return (Criteria) this;
        }

        public Criteria andArrivetimeIn(List<String> values) {
            addCriterion("arrivetime in", values, "arrivetime");
            return (Criteria) this;
        }

        public Criteria andArrivetimeNotIn(List<String> values) {
            addCriterion("arrivetime not in", values, "arrivetime");
            return (Criteria) this;
        }

        public Criteria andArrivetimeBetween(String value1, String value2) {
            addCriterion("arrivetime between", value1, value2, "arrivetime");
            return (Criteria) this;
        }

        public Criteria andArrivetimeNotBetween(String value1, String value2) {
            addCriterion("arrivetime not between", value1, value2, "arrivetime");
            return (Criteria) this;
        }

        public Criteria andUsetimeIsNull() {
            addCriterion("usetime is null");
            return (Criteria) this;
        }

        public Criteria andUsetimeIsNotNull() {
            addCriterion("usetime is not null");
            return (Criteria) this;
        }

        public Criteria andUsetimeEqualTo(String value) {
            addCriterion("usetime =", value, "usetime");
            return (Criteria) this;
        }

        public Criteria andUsetimeNotEqualTo(String value) {
            addCriterion("usetime <>", value, "usetime");
            return (Criteria) this;
        }

        public Criteria andUsetimeGreaterThan(String value) {
            addCriterion("usetime >", value, "usetime");
            return (Criteria) this;
        }

        public Criteria andUsetimeGreaterThanOrEqualTo(String value) {
            addCriterion("usetime >=", value, "usetime");
            return (Criteria) this;
        }

        public Criteria andUsetimeLessThan(String value) {
            addCriterion("usetime <", value, "usetime");
            return (Criteria) this;
        }

        public Criteria andUsetimeLessThanOrEqualTo(String value) {
            addCriterion("usetime <=", value, "usetime");
            return (Criteria) this;
        }

        public Criteria andUsetimeIn(List<String> values) {
            addCriterion("usetime in", values, "usetime");
            return (Criteria) this;
        }

        public Criteria andUsetimeNotIn(List<String> values) {
            addCriterion("usetime not in", values, "usetime");
            return (Criteria) this;
        }

        public Criteria andUsetimeBetween(String value1, String value2) {
            addCriterion("usetime between", value1, value2, "usetime");
            return (Criteria) this;
        }

        public Criteria andUsetimeNotBetween(String value1, String value2) {
            addCriterion("usetime not between", value1, value2, "usetime");
            return (Criteria) this;
        }

        public Criteria andDistanceIsNull() {
            addCriterion("distance is null");
            return (Criteria) this;
        }

        public Criteria andDistanceIsNotNull() {
            addCriterion("distance is not null");
            return (Criteria) this;
        }

        public Criteria andDistanceEqualTo(Integer value) {
            addCriterion("distance =", value, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceNotEqualTo(Integer value) {
            addCriterion("distance <>", value, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceGreaterThan(Integer value) {
            addCriterion("distance >", value, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceGreaterThanOrEqualTo(Integer value) {
            addCriterion("distance >=", value, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceLessThan(Integer value) {
            addCriterion("distance <", value, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceLessThanOrEqualTo(Integer value) {
            addCriterion("distance <=", value, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceIn(List<Integer> values) {
            addCriterion("distance in", values, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceNotIn(List<Integer> values) {
            addCriterion("distance not in", values, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceBetween(Integer value1, Integer value2) {
            addCriterion("distance between", value1, value2, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceNotBetween(Integer value1, Integer value2) {
            addCriterion("distance not between", value1, value2, "distance");
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