package com.gdou.domain;

import java.util.ArrayList;
import java.util.List;

public class TrainExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TrainExample() {
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

        public Criteria andTrainnameIsNull() {
            addCriterion("trainname is null");
            return (Criteria) this;
        }

        public Criteria andTrainnameIsNotNull() {
            addCriterion("trainname is not null");
            return (Criteria) this;
        }

        public Criteria andTrainnameEqualTo(String value) {
            addCriterion("trainname =", value, "trainname");
            return (Criteria) this;
        }

        public Criteria andTrainnameNotEqualTo(String value) {
            addCriterion("trainname <>", value, "trainname");
            return (Criteria) this;
        }

        public Criteria andTrainnameGreaterThan(String value) {
            addCriterion("trainname >", value, "trainname");
            return (Criteria) this;
        }

        public Criteria andTrainnameGreaterThanOrEqualTo(String value) {
            addCriterion("trainname >=", value, "trainname");
            return (Criteria) this;
        }

        public Criteria andTrainnameLessThan(String value) {
            addCriterion("trainname <", value, "trainname");
            return (Criteria) this;
        }

        public Criteria andTrainnameLessThanOrEqualTo(String value) {
            addCriterion("trainname <=", value, "trainname");
            return (Criteria) this;
        }

        public Criteria andTrainnameLike(String value) {
            addCriterion("trainname like", value, "trainname");
            return (Criteria) this;
        }

        public Criteria andTrainnameNotLike(String value) {
            addCriterion("trainname not like", value, "trainname");
            return (Criteria) this;
        }

        public Criteria andTrainnameIn(List<String> values) {
            addCriterion("trainname in", values, "trainname");
            return (Criteria) this;
        }

        public Criteria andTrainnameNotIn(List<String> values) {
            addCriterion("trainname not in", values, "trainname");
            return (Criteria) this;
        }

        public Criteria andTrainnameBetween(String value1, String value2) {
            addCriterion("trainname between", value1, value2, "trainname");
            return (Criteria) this;
        }

        public Criteria andTrainnameNotBetween(String value1, String value2) {
            addCriterion("trainname not between", value1, value2, "trainname");
            return (Criteria) this;
        }

        public Criteria andTraintypeIsNull() {
            addCriterion("traintype is null");
            return (Criteria) this;
        }

        public Criteria andTraintypeIsNotNull() {
            addCriterion("traintype is not null");
            return (Criteria) this;
        }

        public Criteria andTraintypeEqualTo(String value) {
            addCriterion("traintype =", value, "traintype");
            return (Criteria) this;
        }

        public Criteria andTraintypeNotEqualTo(String value) {
            addCriterion("traintype <>", value, "traintype");
            return (Criteria) this;
        }

        public Criteria andTraintypeGreaterThan(String value) {
            addCriterion("traintype >", value, "traintype");
            return (Criteria) this;
        }

        public Criteria andTraintypeGreaterThanOrEqualTo(String value) {
            addCriterion("traintype >=", value, "traintype");
            return (Criteria) this;
        }

        public Criteria andTraintypeLessThan(String value) {
            addCriterion("traintype <", value, "traintype");
            return (Criteria) this;
        }

        public Criteria andTraintypeLessThanOrEqualTo(String value) {
            addCriterion("traintype <=", value, "traintype");
            return (Criteria) this;
        }

        public Criteria andTraintypeLike(String value) {
            addCriterion("traintype like", value, "traintype");
            return (Criteria) this;
        }

        public Criteria andTraintypeNotLike(String value) {
            addCriterion("traintype not like", value, "traintype");
            return (Criteria) this;
        }

        public Criteria andTraintypeIn(List<String> values) {
            addCriterion("traintype in", values, "traintype");
            return (Criteria) this;
        }

        public Criteria andTraintypeNotIn(List<String> values) {
            addCriterion("traintype not in", values, "traintype");
            return (Criteria) this;
        }

        public Criteria andTraintypeBetween(String value1, String value2) {
            addCriterion("traintype between", value1, value2, "traintype");
            return (Criteria) this;
        }

        public Criteria andTraintypeNotBetween(String value1, String value2) {
            addCriterion("traintype not between", value1, value2, "traintype");
            return (Criteria) this;
        }

        public Criteria andTrainlocationIsNull() {
            addCriterion("trainlocation is null");
            return (Criteria) this;
        }

        public Criteria andTrainlocationIsNotNull() {
            addCriterion("trainlocation is not null");
            return (Criteria) this;
        }

        public Criteria andTrainlocationEqualTo(String value) {
            addCriterion("trainlocation =", value, "trainlocation");
            return (Criteria) this;
        }

        public Criteria andTrainlocationNotEqualTo(String value) {
            addCriterion("trainlocation <>", value, "trainlocation");
            return (Criteria) this;
        }

        public Criteria andTrainlocationGreaterThan(String value) {
            addCriterion("trainlocation >", value, "trainlocation");
            return (Criteria) this;
        }

        public Criteria andTrainlocationGreaterThanOrEqualTo(String value) {
            addCriterion("trainlocation >=", value, "trainlocation");
            return (Criteria) this;
        }

        public Criteria andTrainlocationLessThan(String value) {
            addCriterion("trainlocation <", value, "trainlocation");
            return (Criteria) this;
        }

        public Criteria andTrainlocationLessThanOrEqualTo(String value) {
            addCriterion("trainlocation <=", value, "trainlocation");
            return (Criteria) this;
        }

        public Criteria andTrainlocationLike(String value) {
            addCriterion("trainlocation like", value, "trainlocation");
            return (Criteria) this;
        }

        public Criteria andTrainlocationNotLike(String value) {
            addCriterion("trainlocation not like", value, "trainlocation");
            return (Criteria) this;
        }

        public Criteria andTrainlocationIn(List<String> values) {
            addCriterion("trainlocation in", values, "trainlocation");
            return (Criteria) this;
        }

        public Criteria andTrainlocationNotIn(List<String> values) {
            addCriterion("trainlocation not in", values, "trainlocation");
            return (Criteria) this;
        }

        public Criteria andTrainlocationBetween(String value1, String value2) {
            addCriterion("trainlocation between", value1, value2, "trainlocation");
            return (Criteria) this;
        }

        public Criteria andTrainlocationNotBetween(String value1, String value2) {
            addCriterion("trainlocation not between", value1, value2, "trainlocation");
            return (Criteria) this;
        }

        public Criteria andSpecialClassSeatIsNull() {
            addCriterion("special_class_seat is null");
            return (Criteria) this;
        }

        public Criteria andSpecialClassSeatIsNotNull() {
            addCriterion("special_class_seat is not null");
            return (Criteria) this;
        }

        public Criteria andSpecialClassSeatEqualTo(Integer value) {
            addCriterion("special_class_seat =", value, "specialClassSeat");
            return (Criteria) this;
        }

        public Criteria andSpecialClassSeatNotEqualTo(Integer value) {
            addCriterion("special_class_seat <>", value, "specialClassSeat");
            return (Criteria) this;
        }

        public Criteria andSpecialClassSeatGreaterThan(Integer value) {
            addCriterion("special_class_seat >", value, "specialClassSeat");
            return (Criteria) this;
        }

        public Criteria andSpecialClassSeatGreaterThanOrEqualTo(Integer value) {
            addCriterion("special_class_seat >=", value, "specialClassSeat");
            return (Criteria) this;
        }

        public Criteria andSpecialClassSeatLessThan(Integer value) {
            addCriterion("special_class_seat <", value, "specialClassSeat");
            return (Criteria) this;
        }

        public Criteria andSpecialClassSeatLessThanOrEqualTo(Integer value) {
            addCriterion("special_class_seat <=", value, "specialClassSeat");
            return (Criteria) this;
        }

        public Criteria andSpecialClassSeatIn(List<Integer> values) {
            addCriterion("special_class_seat in", values, "specialClassSeat");
            return (Criteria) this;
        }

        public Criteria andSpecialClassSeatNotIn(List<Integer> values) {
            addCriterion("special_class_seat not in", values, "specialClassSeat");
            return (Criteria) this;
        }

        public Criteria andSpecialClassSeatBetween(Integer value1, Integer value2) {
            addCriterion("special_class_seat between", value1, value2, "specialClassSeat");
            return (Criteria) this;
        }

        public Criteria andSpecialClassSeatNotBetween(Integer value1, Integer value2) {
            addCriterion("special_class_seat not between", value1, value2, "specialClassSeat");
            return (Criteria) this;
        }

        public Criteria andFirstClassSeatIsNull() {
            addCriterion("first_class_seat is null");
            return (Criteria) this;
        }

        public Criteria andFirstClassSeatIsNotNull() {
            addCriterion("first_class_seat is not null");
            return (Criteria) this;
        }

        public Criteria andFirstClassSeatEqualTo(Integer value) {
            addCriterion("first_class_seat =", value, "firstClassSeat");
            return (Criteria) this;
        }

        public Criteria andFirstClassSeatNotEqualTo(Integer value) {
            addCriterion("first_class_seat <>", value, "firstClassSeat");
            return (Criteria) this;
        }

        public Criteria andFirstClassSeatGreaterThan(Integer value) {
            addCriterion("first_class_seat >", value, "firstClassSeat");
            return (Criteria) this;
        }

        public Criteria andFirstClassSeatGreaterThanOrEqualTo(Integer value) {
            addCriterion("first_class_seat >=", value, "firstClassSeat");
            return (Criteria) this;
        }

        public Criteria andFirstClassSeatLessThan(Integer value) {
            addCriterion("first_class_seat <", value, "firstClassSeat");
            return (Criteria) this;
        }

        public Criteria andFirstClassSeatLessThanOrEqualTo(Integer value) {
            addCriterion("first_class_seat <=", value, "firstClassSeat");
            return (Criteria) this;
        }

        public Criteria andFirstClassSeatIn(List<Integer> values) {
            addCriterion("first_class_seat in", values, "firstClassSeat");
            return (Criteria) this;
        }

        public Criteria andFirstClassSeatNotIn(List<Integer> values) {
            addCriterion("first_class_seat not in", values, "firstClassSeat");
            return (Criteria) this;
        }

        public Criteria andFirstClassSeatBetween(Integer value1, Integer value2) {
            addCriterion("first_class_seat between", value1, value2, "firstClassSeat");
            return (Criteria) this;
        }

        public Criteria andFirstClassSeatNotBetween(Integer value1, Integer value2) {
            addCriterion("first_class_seat not between", value1, value2, "firstClassSeat");
            return (Criteria) this;
        }

        public Criteria andSecondClassSeatIsNull() {
            addCriterion("second_class_seat is null");
            return (Criteria) this;
        }

        public Criteria andSecondClassSeatIsNotNull() {
            addCriterion("second_class_seat is not null");
            return (Criteria) this;
        }

        public Criteria andSecondClassSeatEqualTo(Integer value) {
            addCriterion("second_class_seat =", value, "secondClassSeat");
            return (Criteria) this;
        }

        public Criteria andSecondClassSeatNotEqualTo(Integer value) {
            addCriterion("second_class_seat <>", value, "secondClassSeat");
            return (Criteria) this;
        }

        public Criteria andSecondClassSeatGreaterThan(Integer value) {
            addCriterion("second_class_seat >", value, "secondClassSeat");
            return (Criteria) this;
        }

        public Criteria andSecondClassSeatGreaterThanOrEqualTo(Integer value) {
            addCriterion("second_class_seat >=", value, "secondClassSeat");
            return (Criteria) this;
        }

        public Criteria andSecondClassSeatLessThan(Integer value) {
            addCriterion("second_class_seat <", value, "secondClassSeat");
            return (Criteria) this;
        }

        public Criteria andSecondClassSeatLessThanOrEqualTo(Integer value) {
            addCriterion("second_class_seat <=", value, "secondClassSeat");
            return (Criteria) this;
        }

        public Criteria andSecondClassSeatIn(List<Integer> values) {
            addCriterion("second_class_seat in", values, "secondClassSeat");
            return (Criteria) this;
        }

        public Criteria andSecondClassSeatNotIn(List<Integer> values) {
            addCriterion("second_class_seat not in", values, "secondClassSeat");
            return (Criteria) this;
        }

        public Criteria andSecondClassSeatBetween(Integer value1, Integer value2) {
            addCriterion("second_class_seat between", value1, value2, "secondClassSeat");
            return (Criteria) this;
        }

        public Criteria andSecondClassSeatNotBetween(Integer value1, Integer value2) {
            addCriterion("second_class_seat not between", value1, value2, "secondClassSeat");
            return (Criteria) this;
        }

        public Criteria andTrainpriceIsNull() {
            addCriterion("trainprice is null");
            return (Criteria) this;
        }

        public Criteria andTrainpriceIsNotNull() {
            addCriterion("trainprice is not null");
            return (Criteria) this;
        }

        public Criteria andTrainpriceEqualTo(Double value) {
            addCriterion("trainprice =", value, "trainprice");
            return (Criteria) this;
        }

        public Criteria andTrainpriceNotEqualTo(Double value) {
            addCriterion("trainprice <>", value, "trainprice");
            return (Criteria) this;
        }

        public Criteria andTrainpriceGreaterThan(Double value) {
            addCriterion("trainprice >", value, "trainprice");
            return (Criteria) this;
        }

        public Criteria andTrainpriceGreaterThanOrEqualTo(Double value) {
            addCriterion("trainprice >=", value, "trainprice");
            return (Criteria) this;
        }

        public Criteria andTrainpriceLessThan(Double value) {
            addCriterion("trainprice <", value, "trainprice");
            return (Criteria) this;
        }

        public Criteria andTrainpriceLessThanOrEqualTo(Double value) {
            addCriterion("trainprice <=", value, "trainprice");
            return (Criteria) this;
        }

        public Criteria andTrainpriceIn(List<Double> values) {
            addCriterion("trainprice in", values, "trainprice");
            return (Criteria) this;
        }

        public Criteria andTrainpriceNotIn(List<Double> values) {
            addCriterion("trainprice not in", values, "trainprice");
            return (Criteria) this;
        }

        public Criteria andTrainpriceBetween(Double value1, Double value2) {
            addCriterion("trainprice between", value1, value2, "trainprice");
            return (Criteria) this;
        }

        public Criteria andTrainpriceNotBetween(Double value1, Double value2) {
            addCriterion("trainprice not between", value1, value2, "trainprice");
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