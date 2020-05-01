package com.gdou.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TicketExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TicketExample() {
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

        public Criteria andTicketStartstationIsNull() {
            addCriterion("ticket_startstation is null");
            return (Criteria) this;
        }

        public Criteria andTicketStartstationIsNotNull() {
            addCriterion("ticket_startstation is not null");
            return (Criteria) this;
        }

        public Criteria andTicketStartstationEqualTo(String value) {
            addCriterion("ticket_startstation =", value, "ticketStartstation");
            return (Criteria) this;
        }

        public Criteria andTicketStartstationNotEqualTo(String value) {
            addCriterion("ticket_startstation <>", value, "ticketStartstation");
            return (Criteria) this;
        }

        public Criteria andTicketStartstationGreaterThan(String value) {
            addCriterion("ticket_startstation >", value, "ticketStartstation");
            return (Criteria) this;
        }

        public Criteria andTicketStartstationGreaterThanOrEqualTo(String value) {
            addCriterion("ticket_startstation >=", value, "ticketStartstation");
            return (Criteria) this;
        }

        public Criteria andTicketStartstationLessThan(String value) {
            addCriterion("ticket_startstation <", value, "ticketStartstation");
            return (Criteria) this;
        }

        public Criteria andTicketStartstationLessThanOrEqualTo(String value) {
            addCriterion("ticket_startstation <=", value, "ticketStartstation");
            return (Criteria) this;
        }

        public Criteria andTicketStartstationLike(String value) {
            addCriterion("ticket_startstation like", value, "ticketStartstation");
            return (Criteria) this;
        }

        public Criteria andTicketStartstationNotLike(String value) {
            addCriterion("ticket_startstation not like", value, "ticketStartstation");
            return (Criteria) this;
        }

        public Criteria andTicketStartstationIn(List<String> values) {
            addCriterion("ticket_startstation in", values, "ticketStartstation");
            return (Criteria) this;
        }

        public Criteria andTicketStartstationNotIn(List<String> values) {
            addCriterion("ticket_startstation not in", values, "ticketStartstation");
            return (Criteria) this;
        }

        public Criteria andTicketStartstationBetween(String value1, String value2) {
            addCriterion("ticket_startstation between", value1, value2, "ticketStartstation");
            return (Criteria) this;
        }

        public Criteria andTicketStartstationNotBetween(String value1, String value2) {
            addCriterion("ticket_startstation not between", value1, value2, "ticketStartstation");
            return (Criteria) this;
        }

        public Criteria andTicketEndstationIsNull() {
            addCriterion("ticket_endstation is null");
            return (Criteria) this;
        }

        public Criteria andTicketEndstationIsNotNull() {
            addCriterion("ticket_endstation is not null");
            return (Criteria) this;
        }

        public Criteria andTicketEndstationEqualTo(String value) {
            addCriterion("ticket_endstation =", value, "ticketEndstation");
            return (Criteria) this;
        }

        public Criteria andTicketEndstationNotEqualTo(String value) {
            addCriterion("ticket_endstation <>", value, "ticketEndstation");
            return (Criteria) this;
        }

        public Criteria andTicketEndstationGreaterThan(String value) {
            addCriterion("ticket_endstation >", value, "ticketEndstation");
            return (Criteria) this;
        }

        public Criteria andTicketEndstationGreaterThanOrEqualTo(String value) {
            addCriterion("ticket_endstation >=", value, "ticketEndstation");
            return (Criteria) this;
        }

        public Criteria andTicketEndstationLessThan(String value) {
            addCriterion("ticket_endstation <", value, "ticketEndstation");
            return (Criteria) this;
        }

        public Criteria andTicketEndstationLessThanOrEqualTo(String value) {
            addCriterion("ticket_endstation <=", value, "ticketEndstation");
            return (Criteria) this;
        }

        public Criteria andTicketEndstationLike(String value) {
            addCriterion("ticket_endstation like", value, "ticketEndstation");
            return (Criteria) this;
        }

        public Criteria andTicketEndstationNotLike(String value) {
            addCriterion("ticket_endstation not like", value, "ticketEndstation");
            return (Criteria) this;
        }

        public Criteria andTicketEndstationIn(List<String> values) {
            addCriterion("ticket_endstation in", values, "ticketEndstation");
            return (Criteria) this;
        }

        public Criteria andTicketEndstationNotIn(List<String> values) {
            addCriterion("ticket_endstation not in", values, "ticketEndstation");
            return (Criteria) this;
        }

        public Criteria andTicketEndstationBetween(String value1, String value2) {
            addCriterion("ticket_endstation between", value1, value2, "ticketEndstation");
            return (Criteria) this;
        }

        public Criteria andTicketEndstationNotBetween(String value1, String value2) {
            addCriterion("ticket_endstation not between", value1, value2, "ticketEndstation");
            return (Criteria) this;
        }

        public Criteria andTicketStarttimeIsNull() {
            addCriterion("ticket_starttime is null");
            return (Criteria) this;
        }

        public Criteria andTicketStarttimeIsNotNull() {
            addCriterion("ticket_starttime is not null");
            return (Criteria) this;
        }

        public Criteria andTicketStarttimeEqualTo(String value) {
            addCriterion("ticket_starttime =", value, "ticketStarttime");
            return (Criteria) this;
        }

        public Criteria andTicketStarttimeNotEqualTo(String value) {
            addCriterion("ticket_starttime <>", value, "ticketStarttime");
            return (Criteria) this;
        }

        public Criteria andTicketStarttimeGreaterThan(String value) {
            addCriterion("ticket_starttime >", value, "ticketStarttime");
            return (Criteria) this;
        }

        public Criteria andTicketStarttimeGreaterThanOrEqualTo(String value) {
            addCriterion("ticket_starttime >=", value, "ticketStarttime");
            return (Criteria) this;
        }

        public Criteria andTicketStarttimeLessThan(String value) {
            addCriterion("ticket_starttime <", value, "ticketStarttime");
            return (Criteria) this;
        }

        public Criteria andTicketStarttimeLessThanOrEqualTo(String value) {
            addCriterion("ticket_starttime <=", value, "ticketStarttime");
            return (Criteria) this;
        }

        public Criteria andTicketStarttimeIn(List<String> values) {
            addCriterion("ticket_starttime in", values, "ticketStarttime");
            return (Criteria) this;
        }

        public Criteria andTicketStarttimeNotIn(List<String> values) {
            addCriterion("ticket_starttime not in", values, "ticketStarttime");
            return (Criteria) this;
        }

        public Criteria andTicketStarttimeBetween(String value1, String value2) {
            addCriterion("ticket_starttime between", value1, value2, "ticketStarttime");
            return (Criteria) this;
        }

        public Criteria andTicketStarttimeNotBetween(String value1, String value2) {
            addCriterion("ticket_starttime not between", value1, value2, "ticketStarttime");
            return (Criteria) this;
        }

        public Criteria andTicketArrivetimeIsNull() {
            addCriterion("ticket_arrivetime is null");
            return (Criteria) this;
        }

        public Criteria andTicketArrivetimeIsNotNull() {
            addCriterion("ticket_arrivetime is not null");
            return (Criteria) this;
        }

        public Criteria andTicketArrivetimeEqualTo(String value) {
            addCriterion("ticket_arrivetime =", value, "ticketArrivetime");
            return (Criteria) this;
        }

        public Criteria andTicketArrivetimeNotEqualTo(String value) {
            addCriterion("ticket_arrivetime <>", value, "ticketArrivetime");
            return (Criteria) this;
        }

        public Criteria andTicketArrivetimeGreaterThan(String value) {
            addCriterion("ticket_arrivetime >", value, "ticketArrivetime");
            return (Criteria) this;
        }

        public Criteria andTicketArrivetimeGreaterThanOrEqualTo(String value) {
            addCriterion("ticket_arrivetime >=", value, "ticketArrivetime");
            return (Criteria) this;
        }

        public Criteria andTicketArrivetimeLessThan(String value) {
            addCriterion("ticket_arrivetime <", value, "ticketArrivetime");
            return (Criteria) this;
        }

        public Criteria andTicketArrivetimeLessThanOrEqualTo(String value) {
            addCriterion("ticket_arrivetime <=", value, "ticketArrivetime");
            return (Criteria) this;
        }

        public Criteria andTicketArrivetimeIn(List<String> values) {
            addCriterion("ticket_arrivetime in", values, "ticketArrivetime");
            return (Criteria) this;
        }

        public Criteria andTicketArrivetimeNotIn(List<String> values) {
            addCriterion("ticket_arrivetime not in", values, "ticketArrivetime");
            return (Criteria) this;
        }

        public Criteria andTicketArrivetimeBetween(String value1, String value2) {
            addCriterion("ticket_arrivetime between", value1, value2, "ticketArrivetime");
            return (Criteria) this;
        }

        public Criteria andTicketArrivetimeNotBetween(String value1, String value2) {
            addCriterion("ticket_arrivetime not between", value1, value2, "ticketArrivetime");
            return (Criteria) this;
        }

        public Criteria andTicketUsetimeIsNull() {
            addCriterion("ticket_usetime is null");
            return (Criteria) this;
        }

        public Criteria andTicketUsetimeIsNotNull() {
            addCriterion("ticket_usetime is not null");
            return (Criteria) this;
        }

        public Criteria andTicketUsetimeEqualTo(String value) {
            addCriterion("ticket_usetime =", value, "ticketUsetime");
            return (Criteria) this;
        }

        public Criteria andTicketUsetimeNotEqualTo(String value) {
            addCriterion("ticket_usetime <>", value, "ticketUsetime");
            return (Criteria) this;
        }

        public Criteria andTicketUsetimeGreaterThan(String value) {
            addCriterion("ticket_usetime >", value, "ticketUsetime");
            return (Criteria) this;
        }

        public Criteria andTicketUsetimeGreaterThanOrEqualTo(String value) {
            addCriterion("ticket_usetime >=", value, "ticketUsetime");
            return (Criteria) this;
        }

        public Criteria andTicketUsetimeLessThan(String value) {
            addCriterion("ticket_usetime <", value, "ticketUsetime");
            return (Criteria) this;
        }

        public Criteria andTicketUsetimeLessThanOrEqualTo(String value) {
            addCriterion("ticket_usetime <=", value, "ticketUsetime");
            return (Criteria) this;
        }

        public Criteria andTicketUsetimeIn(List<String> values) {
            addCriterion("ticket_usetime in", values, "ticketUsetime");
            return (Criteria) this;
        }

        public Criteria andTicketUsetimeNotIn(List<String> values) {
            addCriterion("ticket_usetime not in", values, "ticketUsetime");
            return (Criteria) this;
        }

        public Criteria andTicketUsetimeBetween(String value1, String value2) {
            addCriterion("ticket_usetime between", value1, value2, "ticketUsetime");
            return (Criteria) this;
        }

        public Criteria andTicketUsetimeNotBetween(String value1, String value2) {
            addCriterion("ticket_usetime not between", value1, value2, "ticketUsetime");
            return (Criteria) this;
        }

        public Criteria andTicketpriceIsNull() {
            addCriterion("ticketprice is null");
            return (Criteria) this;
        }

        public Criteria andTicketpriceIsNotNull() {
            addCriterion("ticketprice is not null");
            return (Criteria) this;
        }

        public Criteria andTicketpriceEqualTo(Double value) {
            addCriterion("ticketprice =", value, "ticketprice");
            return (Criteria) this;
        }

        public Criteria andTicketpriceNotEqualTo(Double value) {
            addCriterion("ticketprice <>", value, "ticketprice");
            return (Criteria) this;
        }

        public Criteria andTicketpriceGreaterThan(Double value) {
            addCriterion("ticketprice >", value, "ticketprice");
            return (Criteria) this;
        }

        public Criteria andTicketpriceGreaterThanOrEqualTo(Double value) {
            addCriterion("ticketprice >=", value, "ticketprice");
            return (Criteria) this;
        }

        public Criteria andTicketpriceLessThan(Double value) {
            addCriterion("ticketprice <", value, "ticketprice");
            return (Criteria) this;
        }

        public Criteria andTicketpriceLessThanOrEqualTo(Double value) {
            addCriterion("ticketprice <=", value, "ticketprice");
            return (Criteria) this;
        }

        public Criteria andTicketpriceIn(List<Double> values) {
            addCriterion("ticketprice in", values, "ticketprice");
            return (Criteria) this;
        }

        public Criteria andTicketpriceNotIn(List<Double> values) {
            addCriterion("ticketprice not in", values, "ticketprice");
            return (Criteria) this;
        }

        public Criteria andTicketpriceBetween(Double value1, Double value2) {
            addCriterion("ticketprice between", value1, value2, "ticketprice");
            return (Criteria) this;
        }

        public Criteria andTicketpriceNotBetween(Double value1, Double value2) {
            addCriterion("ticketprice not between", value1, value2, "ticketprice");
            return (Criteria) this;
        }

        public Criteria andTicketTrainnameIsNull() {
            addCriterion("ticket_trainname is null");
            return (Criteria) this;
        }

        public Criteria andTicketTrainnameIsNotNull() {
            addCriterion("ticket_trainname is not null");
            return (Criteria) this;
        }

        public Criteria andTicketTrainnameEqualTo(String value) {
            addCriterion("ticket_trainname =", value, "ticketTrainname");
            return (Criteria) this;
        }

        public Criteria andTicketTrainnameNotEqualTo(String value) {
            addCriterion("ticket_trainname <>", value, "ticketTrainname");
            return (Criteria) this;
        }

        public Criteria andTicketTrainnameGreaterThan(String value) {
            addCriterion("ticket_trainname >", value, "ticketTrainname");
            return (Criteria) this;
        }

        public Criteria andTicketTrainnameGreaterThanOrEqualTo(String value) {
            addCriterion("ticket_trainname >=", value, "ticketTrainname");
            return (Criteria) this;
        }

        public Criteria andTicketTrainnameLessThan(String value) {
            addCriterion("ticket_trainname <", value, "ticketTrainname");
            return (Criteria) this;
        }

        public Criteria andTicketTrainnameLessThanOrEqualTo(String value) {
            addCriterion("ticket_trainname <=", value, "ticketTrainname");
            return (Criteria) this;
        }

        public Criteria andTicketTrainnameLike(String value) {
            addCriterion("ticket_trainname like", value, "ticketTrainname");
            return (Criteria) this;
        }

        public Criteria andTicketTrainnameNotLike(String value) {
            addCriterion("ticket_trainname not like", value, "ticketTrainname");
            return (Criteria) this;
        }

        public Criteria andTicketTrainnameIn(List<String> values) {
            addCriterion("ticket_trainname in", values, "ticketTrainname");
            return (Criteria) this;
        }

        public Criteria andTicketTrainnameNotIn(List<String> values) {
            addCriterion("ticket_trainname not in", values, "ticketTrainname");
            return (Criteria) this;
        }

        public Criteria andTicketTrainnameBetween(String value1, String value2) {
            addCriterion("ticket_trainname between", value1, value2, "ticketTrainname");
            return (Criteria) this;
        }

        public Criteria andTicketTrainnameNotBetween(String value1, String value2) {
            addCriterion("ticket_trainname not between", value1, value2, "ticketTrainname");
            return (Criteria) this;
        }

        public Criteria andTicketTraintypeIsNull() {
            addCriterion("ticket_traintype is null");
            return (Criteria) this;
        }

        public Criteria andTicketTraintypeIsNotNull() {
            addCriterion("ticket_traintype is not null");
            return (Criteria) this;
        }

        public Criteria andTicketTraintypeEqualTo(String value) {
            addCriterion("ticket_traintype =", value, "ticketTraintype");
            return (Criteria) this;
        }

        public Criteria andTicketTraintypeNotEqualTo(String value) {
            addCriterion("ticket_traintype <>", value, "ticketTraintype");
            return (Criteria) this;
        }

        public Criteria andTicketTraintypeGreaterThan(String value) {
            addCriterion("ticket_traintype >", value, "ticketTraintype");
            return (Criteria) this;
        }

        public Criteria andTicketTraintypeGreaterThanOrEqualTo(String value) {
            addCriterion("ticket_traintype >=", value, "ticketTraintype");
            return (Criteria) this;
        }

        public Criteria andTicketTraintypeLessThan(String value) {
            addCriterion("ticket_traintype <", value, "ticketTraintype");
            return (Criteria) this;
        }

        public Criteria andTicketTraintypeLessThanOrEqualTo(String value) {
            addCriterion("ticket_traintype <=", value, "ticketTraintype");
            return (Criteria) this;
        }

        public Criteria andTicketTraintypeLike(String value) {
            addCriterion("ticket_traintype like", value, "ticketTraintype");
            return (Criteria) this;
        }

        public Criteria andTicketTraintypeNotLike(String value) {
            addCriterion("ticket_traintype not like", value, "ticketTraintype");
            return (Criteria) this;
        }

        public Criteria andTicketTraintypeIn(List<String> values) {
            addCriterion("ticket_traintype in", values, "ticketTraintype");
            return (Criteria) this;
        }

        public Criteria andTicketTraintypeNotIn(List<String> values) {
            addCriterion("ticket_traintype not in", values, "ticketTraintype");
            return (Criteria) this;
        }

        public Criteria andTicketTraintypeBetween(String value1, String value2) {
            addCriterion("ticket_traintype between", value1, value2, "ticketTraintype");
            return (Criteria) this;
        }

        public Criteria andTicketTraintypeNotBetween(String value1, String value2) {
            addCriterion("ticket_traintype not between", value1, value2, "ticketTraintype");
            return (Criteria) this;
        }

        public Criteria andSpecialSeatNumberIsNull() {
            addCriterion("special_seat_number is null");
            return (Criteria) this;
        }

        public Criteria andSpecialSeatNumberIsNotNull() {
            addCriterion("special_seat_number is not null");
            return (Criteria) this;
        }

        public Criteria andSpecialSeatNumberEqualTo(Integer value) {
            addCriterion("special_seat_number =", value, "specialSeatNumber");
            return (Criteria) this;
        }

        public Criteria andSpecialSeatNumberNotEqualTo(Integer value) {
            addCriterion("special_seat_number <>", value, "specialSeatNumber");
            return (Criteria) this;
        }

        public Criteria andSpecialSeatNumberGreaterThan(Integer value) {
            addCriterion("special_seat_number >", value, "specialSeatNumber");
            return (Criteria) this;
        }

        public Criteria andSpecialSeatNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("special_seat_number >=", value, "specialSeatNumber");
            return (Criteria) this;
        }

        public Criteria andSpecialSeatNumberLessThan(Integer value) {
            addCriterion("special_seat_number <", value, "specialSeatNumber");
            return (Criteria) this;
        }

        public Criteria andSpecialSeatNumberLessThanOrEqualTo(Integer value) {
            addCriterion("special_seat_number <=", value, "specialSeatNumber");
            return (Criteria) this;
        }

        public Criteria andSpecialSeatNumberIn(List<Integer> values) {
            addCriterion("special_seat_number in", values, "specialSeatNumber");
            return (Criteria) this;
        }

        public Criteria andSpecialSeatNumberNotIn(List<Integer> values) {
            addCriterion("special_seat_number not in", values, "specialSeatNumber");
            return (Criteria) this;
        }

        public Criteria andSpecialSeatNumberBetween(Integer value1, Integer value2) {
            addCriterion("special_seat_number between", value1, value2, "specialSeatNumber");
            return (Criteria) this;
        }

        public Criteria andSpecialSeatNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("special_seat_number not between", value1, value2, "specialSeatNumber");
            return (Criteria) this;
        }

        public Criteria andFirstSeatNumberIsNull() {
            addCriterion("first_seat_number is null");
            return (Criteria) this;
        }

        public Criteria andFirstSeatNumberIsNotNull() {
            addCriterion("first_seat_number is not null");
            return (Criteria) this;
        }

        public Criteria andFirstSeatNumberEqualTo(Integer value) {
            addCriterion("first_seat_number =", value, "firstSeatNumber");
            return (Criteria) this;
        }

        public Criteria andFirstSeatNumberNotEqualTo(Integer value) {
            addCriterion("first_seat_number <>", value, "firstSeatNumber");
            return (Criteria) this;
        }

        public Criteria andFirstSeatNumberGreaterThan(Integer value) {
            addCriterion("first_seat_number >", value, "firstSeatNumber");
            return (Criteria) this;
        }

        public Criteria andFirstSeatNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("first_seat_number >=", value, "firstSeatNumber");
            return (Criteria) this;
        }

        public Criteria andFirstSeatNumberLessThan(Integer value) {
            addCriterion("first_seat_number <", value, "firstSeatNumber");
            return (Criteria) this;
        }

        public Criteria andFirstSeatNumberLessThanOrEqualTo(Integer value) {
            addCriterion("first_seat_number <=", value, "firstSeatNumber");
            return (Criteria) this;
        }

        public Criteria andFirstSeatNumberIn(List<Integer> values) {
            addCriterion("first_seat_number in", values, "firstSeatNumber");
            return (Criteria) this;
        }

        public Criteria andFirstSeatNumberNotIn(List<Integer> values) {
            addCriterion("first_seat_number not in", values, "firstSeatNumber");
            return (Criteria) this;
        }

        public Criteria andFirstSeatNumberBetween(Integer value1, Integer value2) {
            addCriterion("first_seat_number between", value1, value2, "firstSeatNumber");
            return (Criteria) this;
        }

        public Criteria andFirstSeatNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("first_seat_number not between", value1, value2, "firstSeatNumber");
            return (Criteria) this;
        }

        public Criteria andSecondSeatNumberIsNull() {
            addCriterion("second_seat_number is null");
            return (Criteria) this;
        }

        public Criteria andSecondSeatNumberIsNotNull() {
            addCriterion("second_seat_number is not null");
            return (Criteria) this;
        }

        public Criteria andSecondSeatNumberEqualTo(Integer value) {
            addCriterion("second_seat_number =", value, "secondSeatNumber");
            return (Criteria) this;
        }

        public Criteria andSecondSeatNumberNotEqualTo(Integer value) {
            addCriterion("second_seat_number <>", value, "secondSeatNumber");
            return (Criteria) this;
        }

        public Criteria andSecondSeatNumberGreaterThan(Integer value) {
            addCriterion("second_seat_number >", value, "secondSeatNumber");
            return (Criteria) this;
        }

        public Criteria andSecondSeatNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("second_seat_number >=", value, "secondSeatNumber");
            return (Criteria) this;
        }

        public Criteria andSecondSeatNumberLessThan(Integer value) {
            addCriterion("second_seat_number <", value, "secondSeatNumber");
            return (Criteria) this;
        }

        public Criteria andSecondSeatNumberLessThanOrEqualTo(Integer value) {
            addCriterion("second_seat_number <=", value, "secondSeatNumber");
            return (Criteria) this;
        }

        public Criteria andSecondSeatNumberIn(List<Integer> values) {
            addCriterion("second_seat_number in", values, "secondSeatNumber");
            return (Criteria) this;
        }

        public Criteria andSecondSeatNumberNotIn(List<Integer> values) {
            addCriterion("second_seat_number not in", values, "secondSeatNumber");
            return (Criteria) this;
        }

        public Criteria andSecondSeatNumberBetween(Integer value1, Integer value2) {
            addCriterion("second_seat_number between", value1, value2, "secondSeatNumber");
            return (Criteria) this;
        }

        public Criteria andSecondSeatNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("second_seat_number not between", value1, value2, "secondSeatNumber");
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