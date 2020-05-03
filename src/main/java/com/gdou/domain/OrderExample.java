package com.gdou.domain;

import java.util.ArrayList;
import java.util.List;

public class OrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderExample() {
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

        public Criteria andOrderidIsNull() {
            addCriterion("orderid is null");
            return (Criteria) this;
        }

        public Criteria andOrderidIsNotNull() {
            addCriterion("orderid is not null");
            return (Criteria) this;
        }

        public Criteria andOrderidEqualTo(String value) {
            addCriterion("orderid =", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidNotEqualTo(String value) {
            addCriterion("orderid <>", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidGreaterThan(String value) {
            addCriterion("orderid >", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidGreaterThanOrEqualTo(String value) {
            addCriterion("orderid >=", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidLessThan(String value) {
            addCriterion("orderid <", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidLessThanOrEqualTo(String value) {
            addCriterion("orderid <=", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidIn(List<String> values) {
            addCriterion("orderid in", values, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidNotIn(List<String> values) {
            addCriterion("orderid not in", values, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidBetween(String value1, String value2) {
            addCriterion("orderid between", value1, value2, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidNotBetween(String value1, String value2) {
            addCriterion("orderid not between", value1, value2, "orderid");
            return (Criteria) this;
        }

        public Criteria andUseridIsNull() {
            addCriterion("userid is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userid is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(Integer value) {
            addCriterion("userid =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(Integer value) {
            addCriterion("userid <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(Integer value) {
            addCriterion("userid >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("userid >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(Integer value) {
            addCriterion("userid <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(Integer value) {
            addCriterion("userid <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<Integer> values) {
            addCriterion("userid in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<Integer> values) {
            addCriterion("userid not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(Integer value1, Integer value2) {
            addCriterion("userid between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(Integer value1, Integer value2) {
            addCriterion("userid not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andOrderUsernameIsNull() {
            addCriterion("order_username is null");
            return (Criteria) this;
        }

        public Criteria andOrderUsernameIsNotNull() {
            addCriterion("order_username is not null");
            return (Criteria) this;
        }

        public Criteria andOrderUsernameEqualTo(String value) {
            addCriterion("order_username =", value, "orderUsername");
            return (Criteria) this;
        }

        public Criteria andOrderUsernameNotEqualTo(String value) {
            addCriterion("order_username <>", value, "orderUsername");
            return (Criteria) this;
        }

        public Criteria andOrderUsernameGreaterThan(String value) {
            addCriterion("order_username >", value, "orderUsername");
            return (Criteria) this;
        }

        public Criteria andOrderUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("order_username >=", value, "orderUsername");
            return (Criteria) this;
        }

        public Criteria andOrderUsernameLessThan(String value) {
            addCriterion("order_username <", value, "orderUsername");
            return (Criteria) this;
        }

        public Criteria andOrderUsernameLessThanOrEqualTo(String value) {
            addCriterion("order_username <=", value, "orderUsername");
            return (Criteria) this;
        }

        public Criteria andOrderUsernameLike(String value) {
            addCriterion("order_username like", value, "orderUsername");
            return (Criteria) this;
        }

        public Criteria andOrderUsernameNotLike(String value) {
            addCriterion("order_username not like", value, "orderUsername");
            return (Criteria) this;
        }

        public Criteria andOrderUsernameIn(List<String> values) {
            addCriterion("order_username in", values, "orderUsername");
            return (Criteria) this;
        }

        public Criteria andOrderUsernameNotIn(List<String> values) {
            addCriterion("order_username not in", values, "orderUsername");
            return (Criteria) this;
        }

        public Criteria andOrderUsernameBetween(String value1, String value2) {
            addCriterion("order_username between", value1, value2, "orderUsername");
            return (Criteria) this;
        }

        public Criteria andOrderUsernameNotBetween(String value1, String value2) {
            addCriterion("order_username not between", value1, value2, "orderUsername");
            return (Criteria) this;
        }

        public Criteria andOrderIdcardnameIsNull() {
            addCriterion("order_idcardname is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdcardnameIsNotNull() {
            addCriterion("order_idcardname is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdcardnameEqualTo(String value) {
            addCriterion("order_idcardname =", value, "orderIdcardname");
            return (Criteria) this;
        }

        public Criteria andOrderIdcardnameNotEqualTo(String value) {
            addCriterion("order_idcardname <>", value, "orderIdcardname");
            return (Criteria) this;
        }

        public Criteria andOrderIdcardnameGreaterThan(String value) {
            addCriterion("order_idcardname >", value, "orderIdcardname");
            return (Criteria) this;
        }

        public Criteria andOrderIdcardnameGreaterThanOrEqualTo(String value) {
            addCriterion("order_idcardname >=", value, "orderIdcardname");
            return (Criteria) this;
        }

        public Criteria andOrderIdcardnameLessThan(String value) {
            addCriterion("order_idcardname <", value, "orderIdcardname");
            return (Criteria) this;
        }

        public Criteria andOrderIdcardnameLessThanOrEqualTo(String value) {
            addCriterion("order_idcardname <=", value, "orderIdcardname");
            return (Criteria) this;
        }

        public Criteria andOrderIdcardnameLike(String value) {
            addCriterion("order_idcardname like", value, "orderIdcardname");
            return (Criteria) this;
        }

        public Criteria andOrderIdcardnameNotLike(String value) {
            addCriterion("order_idcardname not like", value, "orderIdcardname");
            return (Criteria) this;
        }

        public Criteria andOrderIdcardnameIn(List<String> values) {
            addCriterion("order_idcardname in", values, "orderIdcardname");
            return (Criteria) this;
        }

        public Criteria andOrderIdcardnameNotIn(List<String> values) {
            addCriterion("order_idcardname not in", values, "orderIdcardname");
            return (Criteria) this;
        }

        public Criteria andOrderIdcardnameBetween(String value1, String value2) {
            addCriterion("order_idcardname between", value1, value2, "orderIdcardname");
            return (Criteria) this;
        }

        public Criteria andOrderIdcardnameNotBetween(String value1, String value2) {
            addCriterion("order_idcardname not between", value1, value2, "orderIdcardname");
            return (Criteria) this;
        }

        public Criteria andOrderIdcardnumberIsNull() {
            addCriterion("order_idcardnumber is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdcardnumberIsNotNull() {
            addCriterion("order_idcardnumber is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdcardnumberEqualTo(String value) {
            addCriterion("order_idcardnumber =", value, "orderIdcardnumber");
            return (Criteria) this;
        }

        public Criteria andOrderIdcardnumberNotEqualTo(String value) {
            addCriterion("order_idcardnumber <>", value, "orderIdcardnumber");
            return (Criteria) this;
        }

        public Criteria andOrderIdcardnumberGreaterThan(String value) {
            addCriterion("order_idcardnumber >", value, "orderIdcardnumber");
            return (Criteria) this;
        }

        public Criteria andOrderIdcardnumberGreaterThanOrEqualTo(String value) {
            addCriterion("order_idcardnumber >=", value, "orderIdcardnumber");
            return (Criteria) this;
        }

        public Criteria andOrderIdcardnumberLessThan(String value) {
            addCriterion("order_idcardnumber <", value, "orderIdcardnumber");
            return (Criteria) this;
        }

        public Criteria andOrderIdcardnumberLessThanOrEqualTo(String value) {
            addCriterion("order_idcardnumber <=", value, "orderIdcardnumber");
            return (Criteria) this;
        }

        public Criteria andOrderIdcardnumberLike(String value) {
            addCriterion("order_idcardnumber like", value, "orderIdcardnumber");
            return (Criteria) this;
        }

        public Criteria andOrderIdcardnumberNotLike(String value) {
            addCriterion("order_idcardnumber not like", value, "orderIdcardnumber");
            return (Criteria) this;
        }

        public Criteria andOrderIdcardnumberIn(List<String> values) {
            addCriterion("order_idcardnumber in", values, "orderIdcardnumber");
            return (Criteria) this;
        }

        public Criteria andOrderIdcardnumberNotIn(List<String> values) {
            addCriterion("order_idcardnumber not in", values, "orderIdcardnumber");
            return (Criteria) this;
        }

        public Criteria andOrderIdcardnumberBetween(String value1, String value2) {
            addCriterion("order_idcardnumber between", value1, value2, "orderIdcardnumber");
            return (Criteria) this;
        }

        public Criteria andOrderIdcardnumberNotBetween(String value1, String value2) {
            addCriterion("order_idcardnumber not between", value1, value2, "orderIdcardnumber");
            return (Criteria) this;
        }

        public Criteria andTicketidIsNull() {
            addCriterion("ticketid is null");
            return (Criteria) this;
        }

        public Criteria andTicketidIsNotNull() {
            addCriterion("ticketid is not null");
            return (Criteria) this;
        }

        public Criteria andTicketidEqualTo(Integer value) {
            addCriterion("ticketid =", value, "ticketid");
            return (Criteria) this;
        }

        public Criteria andTicketidNotEqualTo(Integer value) {
            addCriterion("ticketid <>", value, "ticketid");
            return (Criteria) this;
        }

        public Criteria andTicketidGreaterThan(Integer value) {
            addCriterion("ticketid >", value, "ticketid");
            return (Criteria) this;
        }

        public Criteria andTicketidGreaterThanOrEqualTo(Integer value) {
            addCriterion("ticketid >=", value, "ticketid");
            return (Criteria) this;
        }

        public Criteria andTicketidLessThan(Integer value) {
            addCriterion("ticketid <", value, "ticketid");
            return (Criteria) this;
        }

        public Criteria andTicketidLessThanOrEqualTo(Integer value) {
            addCriterion("ticketid <=", value, "ticketid");
            return (Criteria) this;
        }

        public Criteria andTicketidIn(List<Integer> values) {
            addCriterion("ticketid in", values, "ticketid");
            return (Criteria) this;
        }

        public Criteria andTicketidNotIn(List<Integer> values) {
            addCriterion("ticketid not in", values, "ticketid");
            return (Criteria) this;
        }

        public Criteria andTicketidBetween(Integer value1, Integer value2) {
            addCriterion("ticketid between", value1, value2, "ticketid");
            return (Criteria) this;
        }

        public Criteria andTicketidNotBetween(Integer value1, Integer value2) {
            addCriterion("ticketid not between", value1, value2, "ticketid");
            return (Criteria) this;
        }

        public Criteria andOrderTrainnameIsNull() {
            addCriterion("order_trainname is null");
            return (Criteria) this;
        }

        public Criteria andOrderTrainnameIsNotNull() {
            addCriterion("order_trainname is not null");
            return (Criteria) this;
        }

        public Criteria andOrderTrainnameEqualTo(String value) {
            addCriterion("order_trainname =", value, "orderTrainname");
            return (Criteria) this;
        }

        public Criteria andOrderTrainnameNotEqualTo(String value) {
            addCriterion("order_trainname <>", value, "orderTrainname");
            return (Criteria) this;
        }

        public Criteria andOrderTrainnameGreaterThan(String value) {
            addCriterion("order_trainname >", value, "orderTrainname");
            return (Criteria) this;
        }

        public Criteria andOrderTrainnameGreaterThanOrEqualTo(String value) {
            addCriterion("order_trainname >=", value, "orderTrainname");
            return (Criteria) this;
        }

        public Criteria andOrderTrainnameLessThan(String value) {
            addCriterion("order_trainname <", value, "orderTrainname");
            return (Criteria) this;
        }

        public Criteria andOrderTrainnameLessThanOrEqualTo(String value) {
            addCriterion("order_trainname <=", value, "orderTrainname");
            return (Criteria) this;
        }

        public Criteria andOrderTrainnameLike(String value) {
            addCriterion("order_trainname like", value, "orderTrainname");
            return (Criteria) this;
        }

        public Criteria andOrderTrainnameNotLike(String value) {
            addCriterion("order_trainname not like", value, "orderTrainname");
            return (Criteria) this;
        }

        public Criteria andOrderTrainnameIn(List<String> values) {
            addCriterion("order_trainname in", values, "orderTrainname");
            return (Criteria) this;
        }

        public Criteria andOrderTrainnameNotIn(List<String> values) {
            addCriterion("order_trainname not in", values, "orderTrainname");
            return (Criteria) this;
        }

        public Criteria andOrderTrainnameBetween(String value1, String value2) {
            addCriterion("order_trainname between", value1, value2, "orderTrainname");
            return (Criteria) this;
        }

        public Criteria andOrderTrainnameNotBetween(String value1, String value2) {
            addCriterion("order_trainname not between", value1, value2, "orderTrainname");
            return (Criteria) this;
        }

        public Criteria andOrderStartstationIsNull() {
            addCriterion("order_startstation is null");
            return (Criteria) this;
        }

        public Criteria andOrderStartstationIsNotNull() {
            addCriterion("order_startstation is not null");
            return (Criteria) this;
        }

        public Criteria andOrderStartstationEqualTo(String value) {
            addCriterion("order_startstation =", value, "orderStartstation");
            return (Criteria) this;
        }

        public Criteria andOrderStartstationNotEqualTo(String value) {
            addCriterion("order_startstation <>", value, "orderStartstation");
            return (Criteria) this;
        }

        public Criteria andOrderStartstationGreaterThan(String value) {
            addCriterion("order_startstation >", value, "orderStartstation");
            return (Criteria) this;
        }

        public Criteria andOrderStartstationGreaterThanOrEqualTo(String value) {
            addCriterion("order_startstation >=", value, "orderStartstation");
            return (Criteria) this;
        }

        public Criteria andOrderStartstationLessThan(String value) {
            addCriterion("order_startstation <", value, "orderStartstation");
            return (Criteria) this;
        }

        public Criteria andOrderStartstationLessThanOrEqualTo(String value) {
            addCriterion("order_startstation <=", value, "orderStartstation");
            return (Criteria) this;
        }

        public Criteria andOrderStartstationLike(String value) {
            addCriterion("order_startstation like", value, "orderStartstation");
            return (Criteria) this;
        }

        public Criteria andOrderStartstationNotLike(String value) {
            addCriterion("order_startstation not like", value, "orderStartstation");
            return (Criteria) this;
        }

        public Criteria andOrderStartstationIn(List<String> values) {
            addCriterion("order_startstation in", values, "orderStartstation");
            return (Criteria) this;
        }

        public Criteria andOrderStartstationNotIn(List<String> values) {
            addCriterion("order_startstation not in", values, "orderStartstation");
            return (Criteria) this;
        }

        public Criteria andOrderStartstationBetween(String value1, String value2) {
            addCriterion("order_startstation between", value1, value2, "orderStartstation");
            return (Criteria) this;
        }

        public Criteria andOrderStartstationNotBetween(String value1, String value2) {
            addCriterion("order_startstation not between", value1, value2, "orderStartstation");
            return (Criteria) this;
        }

        public Criteria andOrderEndstationIsNull() {
            addCriterion("order_endstation is null");
            return (Criteria) this;
        }

        public Criteria andOrderEndstationIsNotNull() {
            addCriterion("order_endstation is not null");
            return (Criteria) this;
        }

        public Criteria andOrderEndstationEqualTo(String value) {
            addCriterion("order_endstation =", value, "orderEndstation");
            return (Criteria) this;
        }

        public Criteria andOrderEndstationNotEqualTo(String value) {
            addCriterion("order_endstation <>", value, "orderEndstation");
            return (Criteria) this;
        }

        public Criteria andOrderEndstationGreaterThan(String value) {
            addCriterion("order_endstation >", value, "orderEndstation");
            return (Criteria) this;
        }

        public Criteria andOrderEndstationGreaterThanOrEqualTo(String value) {
            addCriterion("order_endstation >=", value, "orderEndstation");
            return (Criteria) this;
        }

        public Criteria andOrderEndstationLessThan(String value) {
            addCriterion("order_endstation <", value, "orderEndstation");
            return (Criteria) this;
        }

        public Criteria andOrderEndstationLessThanOrEqualTo(String value) {
            addCriterion("order_endstation <=", value, "orderEndstation");
            return (Criteria) this;
        }

        public Criteria andOrderEndstationLike(String value) {
            addCriterion("order_endstation like", value, "orderEndstation");
            return (Criteria) this;
        }

        public Criteria andOrderEndstationNotLike(String value) {
            addCriterion("order_endstation not like", value, "orderEndstation");
            return (Criteria) this;
        }

        public Criteria andOrderEndstationIn(List<String> values) {
            addCriterion("order_endstation in", values, "orderEndstation");
            return (Criteria) this;
        }

        public Criteria andOrderEndstationNotIn(List<String> values) {
            addCriterion("order_endstation not in", values, "orderEndstation");
            return (Criteria) this;
        }

        public Criteria andOrderEndstationBetween(String value1, String value2) {
            addCriterion("order_endstation between", value1, value2, "orderEndstation");
            return (Criteria) this;
        }

        public Criteria andOrderEndstationNotBetween(String value1, String value2) {
            addCriterion("order_endstation not between", value1, value2, "orderEndstation");
            return (Criteria) this;
        }

        public Criteria andOrderStarttimeIsNull() {
            addCriterion("order_starttime is null");
            return (Criteria) this;
        }

        public Criteria andOrderStarttimeIsNotNull() {
            addCriterion("order_starttime is not null");
            return (Criteria) this;
        }

        public Criteria andOrderStarttimeEqualTo(String value) {
            addCriterion("order_starttime =", value, "orderStarttime");
            return (Criteria) this;
        }

        public Criteria andOrderStarttimeNotEqualTo(String value) {
            addCriterion("order_starttime <>", value, "orderStarttime");
            return (Criteria) this;
        }

        public Criteria andOrderStarttimeGreaterThan(String value) {
            addCriterion("order_starttime >", value, "orderStarttime");
            return (Criteria) this;
        }

        public Criteria andOrderStarttimeGreaterThanOrEqualTo(String value) {
            addCriterion("order_starttime >=", value, "orderStarttime");
            return (Criteria) this;
        }

        public Criteria andOrderStarttimeLessThan(String value) {
            addCriterion("order_starttime <", value, "orderStarttime");
            return (Criteria) this;
        }

        public Criteria andOrderStarttimeLessThanOrEqualTo(String value) {
            addCriterion("order_starttime <=", value, "orderStarttime");
            return (Criteria) this;
        }

        public Criteria andOrderStarttimeIn(List<String> values) {
            addCriterion("order_starttime in", values, "orderStarttime");
            return (Criteria) this;
        }

        public Criteria andOrderStarttimeNotIn(List<String> values) {
            addCriterion("order_starttime not in", values, "orderStarttime");
            return (Criteria) this;
        }

        public Criteria andOrderStarttimeBetween(String value1, String value2) {
            addCriterion("order_starttime between", value1, value2, "orderStarttime");
            return (Criteria) this;
        }

        public Criteria andOrderStarttimeNotBetween(String value1, String value2) {
            addCriterion("order_starttime not between", value1, value2, "orderStarttime");
            return (Criteria) this;
        }

        public Criteria andOrderArrivetimeIsNull() {
            addCriterion("order_arrivetime is null");
            return (Criteria) this;
        }

        public Criteria andOrderArrivetimeIsNotNull() {
            addCriterion("order_arrivetime is not null");
            return (Criteria) this;
        }

        public Criteria andOrderArrivetimeEqualTo(String value) {
            addCriterion("order_arrivetime =", value, "orderArrivetime");
            return (Criteria) this;
        }

        public Criteria andOrderArrivetimeNotEqualTo(String value) {
            addCriterion("order_arrivetime <>", value, "orderArrivetime");
            return (Criteria) this;
        }

        public Criteria andOrderArrivetimeGreaterThan(String value) {
            addCriterion("order_arrivetime >", value, "orderArrivetime");
            return (Criteria) this;
        }

        public Criteria andOrderArrivetimeGreaterThanOrEqualTo(String value) {
            addCriterion("order_arrivetime >=", value, "orderArrivetime");
            return (Criteria) this;
        }

        public Criteria andOrderArrivetimeLessThan(String value) {
            addCriterion("order_arrivetime <", value, "orderArrivetime");
            return (Criteria) this;
        }

        public Criteria andOrderArrivetimeLessThanOrEqualTo(String value) {
            addCriterion("order_arrivetime <=", value, "orderArrivetime");
            return (Criteria) this;
        }

        public Criteria andOrderArrivetimeIn(List<String> values) {
            addCriterion("order_arrivetime in", values, "orderArrivetime");
            return (Criteria) this;
        }

        public Criteria andOrderArrivetimeNotIn(List<String> values) {
            addCriterion("order_arrivetime not in", values, "orderArrivetime");
            return (Criteria) this;
        }

        public Criteria andOrderArrivetimeBetween(String value1, String value2) {
            addCriterion("order_arrivetime between", value1, value2, "orderArrivetime");
            return (Criteria) this;
        }

        public Criteria andOrderArrivetimeNotBetween(String value1, String value2) {
            addCriterion("order_arrivetime not between", value1, value2, "orderArrivetime");
            return (Criteria) this;
        }

        public Criteria andOrderPriceIsNull() {
            addCriterion("order_price is null");
            return (Criteria) this;
        }

        public Criteria andOrderPriceIsNotNull() {
            addCriterion("order_price is not null");
            return (Criteria) this;
        }

        public Criteria andOrderPriceEqualTo(Double value) {
            addCriterion("order_price =", value, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPriceNotEqualTo(Double value) {
            addCriterion("order_price <>", value, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPriceGreaterThan(Double value) {
            addCriterion("order_price >", value, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("order_price >=", value, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPriceLessThan(Double value) {
            addCriterion("order_price <", value, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPriceLessThanOrEqualTo(Double value) {
            addCriterion("order_price <=", value, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPriceIn(List<Double> values) {
            addCriterion("order_price in", values, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPriceNotIn(List<Double> values) {
            addCriterion("order_price not in", values, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPriceBetween(Double value1, Double value2) {
            addCriterion("order_price between", value1, value2, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPriceNotBetween(Double value1, Double value2) {
            addCriterion("order_price not between", value1, value2, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrdertimeIsNull() {
            addCriterion("ordertime is null");
            return (Criteria) this;
        }

        public Criteria andOrdertimeIsNotNull() {
            addCriterion("ordertime is not null");
            return (Criteria) this;
        }

        public Criteria andOrdertimeEqualTo(String value) {
            addCriterion("ordertime =", value, "ordertime");
            return (Criteria) this;
        }

        public Criteria andOrdertimeNotEqualTo(String value) {
            addCriterion("ordertime <>", value, "ordertime");
            return (Criteria) this;
        }

        public Criteria andOrdertimeGreaterThan(String value) {
            addCriterion("ordertime >", value, "ordertime");
            return (Criteria) this;
        }

        public Criteria andOrdertimeGreaterThanOrEqualTo(String value) {
            addCriterion("ordertime >=", value, "ordertime");
            return (Criteria) this;
        }

        public Criteria andOrdertimeLessThan(String value) {
            addCriterion("ordertime <", value, "ordertime");
            return (Criteria) this;
        }

        public Criteria andOrdertimeLessThanOrEqualTo(String value) {
            addCriterion("ordertime <=", value, "ordertime");
            return (Criteria) this;
        }

        public Criteria andOrdertimeIn(List<String> values) {
            addCriterion("ordertime in", values, "ordertime");
            return (Criteria) this;
        }

        public Criteria andOrdertimeNotIn(List<String> values) {
            addCriterion("ordertime not in", values, "ordertime");
            return (Criteria) this;
        }

        public Criteria andOrdertimeBetween(String value1, String value2) {
            addCriterion("ordertime between", value1, value2, "ordertime");
            return (Criteria) this;
        }

        public Criteria andOrdertimeNotBetween(String value1, String value2) {
            addCriterion("ordertime not between", value1, value2, "ordertime");
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

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
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

        public Criteria andOrderCarriageIsNull() {
            addCriterion("order_carriage is null");
            return (Criteria) this;
        }

        public Criteria andOrderCarriageIsNotNull() {
            addCriterion("order_carriage is not null");
            return (Criteria) this;
        }

        public Criteria andOrderCarriageEqualTo(Integer value) {
            addCriterion("order_carriage =", value, "orderCarriage");
            return (Criteria) this;
        }

        public Criteria andOrderCarriageNotEqualTo(Integer value) {
            addCriterion("order_carriage <>", value, "orderCarriage");
            return (Criteria) this;
        }

        public Criteria andOrderCarriageGreaterThan(Integer value) {
            addCriterion("order_carriage >", value, "orderCarriage");
            return (Criteria) this;
        }

        public Criteria andOrderCarriageGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_carriage >=", value, "orderCarriage");
            return (Criteria) this;
        }

        public Criteria andOrderCarriageLessThan(Integer value) {
            addCriterion("order_carriage <", value, "orderCarriage");
            return (Criteria) this;
        }

        public Criteria andOrderCarriageLessThanOrEqualTo(Integer value) {
            addCriterion("order_carriage <=", value, "orderCarriage");
            return (Criteria) this;
        }

        public Criteria andOrderCarriageIn(List<Integer> values) {
            addCriterion("order_carriage in", values, "orderCarriage");
            return (Criteria) this;
        }

        public Criteria andOrderCarriageNotIn(List<Integer> values) {
            addCriterion("order_carriage not in", values, "orderCarriage");
            return (Criteria) this;
        }

        public Criteria andOrderCarriageBetween(Integer value1, Integer value2) {
            addCriterion("order_carriage between", value1, value2, "orderCarriage");
            return (Criteria) this;
        }

        public Criteria andOrderCarriageNotBetween(Integer value1, Integer value2) {
            addCriterion("order_carriage not between", value1, value2, "orderCarriage");
            return (Criteria) this;
        }

        public Criteria andOrderSeattypeIsNull() {
            addCriterion("order_seattype is null");
            return (Criteria) this;
        }

        public Criteria andOrderSeattypeIsNotNull() {
            addCriterion("order_seattype is not null");
            return (Criteria) this;
        }

        public Criteria andOrderSeattypeEqualTo(String value) {
            addCriterion("order_seattype =", value, "orderSeattype");
            return (Criteria) this;
        }

        public Criteria andOrderSeattypeNotEqualTo(String value) {
            addCriterion("order_seattype <>", value, "orderSeattype");
            return (Criteria) this;
        }

        public Criteria andOrderSeattypeGreaterThan(String value) {
            addCriterion("order_seattype >", value, "orderSeattype");
            return (Criteria) this;
        }

        public Criteria andOrderSeattypeGreaterThanOrEqualTo(String value) {
            addCriterion("order_seattype >=", value, "orderSeattype");
            return (Criteria) this;
        }

        public Criteria andOrderSeattypeLessThan(String value) {
            addCriterion("order_seattype <", value, "orderSeattype");
            return (Criteria) this;
        }

        public Criteria andOrderSeattypeLessThanOrEqualTo(String value) {
            addCriterion("order_seattype <=", value, "orderSeattype");
            return (Criteria) this;
        }

        public Criteria andOrderSeattypeLike(String value) {
            addCriterion("order_seattype like", value, "orderSeattype");
            return (Criteria) this;
        }

        public Criteria andOrderSeattypeNotLike(String value) {
            addCriterion("order_seattype not like", value, "orderSeattype");
            return (Criteria) this;
        }

        public Criteria andOrderSeattypeIn(List<String> values) {
            addCriterion("order_seattype in", values, "orderSeattype");
            return (Criteria) this;
        }

        public Criteria andOrderSeattypeNotIn(List<String> values) {
            addCriterion("order_seattype not in", values, "orderSeattype");
            return (Criteria) this;
        }

        public Criteria andOrderSeattypeBetween(String value1, String value2) {
            addCriterion("order_seattype between", value1, value2, "orderSeattype");
            return (Criteria) this;
        }

        public Criteria andOrderSeattypeNotBetween(String value1, String value2) {
            addCriterion("order_seattype not between", value1, value2, "orderSeattype");
            return (Criteria) this;
        }

        public Criteria andOrderSeatlocationIsNull() {
            addCriterion("order_seatlocation is null");
            return (Criteria) this;
        }

        public Criteria andOrderSeatlocationIsNotNull() {
            addCriterion("order_seatlocation is not null");
            return (Criteria) this;
        }

        public Criteria andOrderSeatlocationEqualTo(String value) {
            addCriterion("order_seatlocation =", value, "orderSeatlocation");
            return (Criteria) this;
        }

        public Criteria andOrderSeatlocationNotEqualTo(String value) {
            addCriterion("order_seatlocation <>", value, "orderSeatlocation");
            return (Criteria) this;
        }

        public Criteria andOrderSeatlocationGreaterThan(String value) {
            addCriterion("order_seatlocation >", value, "orderSeatlocation");
            return (Criteria) this;
        }

        public Criteria andOrderSeatlocationGreaterThanOrEqualTo(String value) {
            addCriterion("order_seatlocation >=", value, "orderSeatlocation");
            return (Criteria) this;
        }

        public Criteria andOrderSeatlocationLessThan(String value) {
            addCriterion("order_seatlocation <", value, "orderSeatlocation");
            return (Criteria) this;
        }

        public Criteria andOrderSeatlocationLessThanOrEqualTo(String value) {
            addCriterion("order_seatlocation <=", value, "orderSeatlocation");
            return (Criteria) this;
        }

        public Criteria andOrderSeatlocationLike(String value) {
            addCriterion("order_seatlocation like", value, "orderSeatlocation");
            return (Criteria) this;
        }

        public Criteria andOrderSeatlocationNotLike(String value) {
            addCriterion("order_seatlocation not like", value, "orderSeatlocation");
            return (Criteria) this;
        }

        public Criteria andOrderSeatlocationIn(List<String> values) {
            addCriterion("order_seatlocation in", values, "orderSeatlocation");
            return (Criteria) this;
        }

        public Criteria andOrderSeatlocationNotIn(List<String> values) {
            addCriterion("order_seatlocation not in", values, "orderSeatlocation");
            return (Criteria) this;
        }

        public Criteria andOrderSeatlocationBetween(String value1, String value2) {
            addCriterion("order_seatlocation between", value1, value2, "orderSeatlocation");
            return (Criteria) this;
        }

        public Criteria andOrderSeatlocationNotBetween(String value1, String value2) {
            addCriterion("order_seatlocation not between", value1, value2, "orderSeatlocation");
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