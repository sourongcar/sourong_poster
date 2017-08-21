package com.sourong.reservation.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReservationVOExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public ReservationVOExample() {
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

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getOffset() {
        return offset;
    }

    protected abstract static class GeneratedCriteria implements Serializable {
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

        public Criteria andReservationidIsNull() {
            addCriterion("reservationID is null");
            return (Criteria) this;
        }

        public Criteria andReservationidIsNotNull() {
            addCriterion("reservationID is not null");
            return (Criteria) this;
        }

        public Criteria andReservationidEqualTo(Integer value) {
            addCriterion("reservationID =", value, "reservationid");
            return (Criteria) this;
        }

        public Criteria andReservationidNotEqualTo(Integer value) {
            addCriterion("reservationID <>", value, "reservationid");
            return (Criteria) this;
        }

        public Criteria andReservationidGreaterThan(Integer value) {
            addCriterion("reservationID >", value, "reservationid");
            return (Criteria) this;
        }

        public Criteria andReservationidGreaterThanOrEqualTo(Integer value) {
            addCriterion("reservationID >=", value, "reservationid");
            return (Criteria) this;
        }

        public Criteria andReservationidLessThan(Integer value) {
            addCriterion("reservationID <", value, "reservationid");
            return (Criteria) this;
        }

        public Criteria andReservationidLessThanOrEqualTo(Integer value) {
            addCriterion("reservationID <=", value, "reservationid");
            return (Criteria) this;
        }

        public Criteria andReservationidIn(List<Integer> values) {
            addCriterion("reservationID in", values, "reservationid");
            return (Criteria) this;
        }

        public Criteria andReservationidNotIn(List<Integer> values) {
            addCriterion("reservationID not in", values, "reservationid");
            return (Criteria) this;
        }

        public Criteria andReservationidBetween(Integer value1, Integer value2) {
            addCriterion("reservationID between", value1, value2, "reservationid");
            return (Criteria) this;
        }

        public Criteria andReservationidNotBetween(Integer value1, Integer value2) {
            addCriterion("reservationID not between", value1, value2, "reservationid");
            return (Criteria) this;
        }

        public Criteria andUseridIsNull() {
            addCriterion("userID is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userID is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(String value) {
            addCriterion("userID =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(String value) {
            addCriterion("userID <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(String value) {
            addCriterion("userID >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(String value) {
            addCriterion("userID >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(String value) {
            addCriterion("userID <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(String value) {
            addCriterion("userID <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLike(String value) {
            addCriterion("userID like", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotLike(String value) {
            addCriterion("userID not like", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<String> values) {
            addCriterion("userID in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<String> values) {
            addCriterion("userID not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(String value1, String value2) {
            addCriterion("userID between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(String value1, String value2) {
            addCriterion("userID not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNull() {
            addCriterion("userName is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("userName is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("userName =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("userName <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("userName >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("userName >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("userName <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("userName <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("userName like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("userName not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("userName in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("userName not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("userName between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("userName not between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUserphoneIsNull() {
            addCriterion("userPhone is null");
            return (Criteria) this;
        }

        public Criteria andUserphoneIsNotNull() {
            addCriterion("userPhone is not null");
            return (Criteria) this;
        }

        public Criteria andUserphoneEqualTo(String value) {
            addCriterion("userPhone =", value, "userphone");
            return (Criteria) this;
        }

        public Criteria andUserphoneNotEqualTo(String value) {
            addCriterion("userPhone <>", value, "userphone");
            return (Criteria) this;
        }

        public Criteria andUserphoneGreaterThan(String value) {
            addCriterion("userPhone >", value, "userphone");
            return (Criteria) this;
        }

        public Criteria andUserphoneGreaterThanOrEqualTo(String value) {
            addCriterion("userPhone >=", value, "userphone");
            return (Criteria) this;
        }

        public Criteria andUserphoneLessThan(String value) {
            addCriterion("userPhone <", value, "userphone");
            return (Criteria) this;
        }

        public Criteria andUserphoneLessThanOrEqualTo(String value) {
            addCriterion("userPhone <=", value, "userphone");
            return (Criteria) this;
        }

        public Criteria andUserphoneLike(String value) {
            addCriterion("userPhone like", value, "userphone");
            return (Criteria) this;
        }

        public Criteria andUserphoneNotLike(String value) {
            addCriterion("userPhone not like", value, "userphone");
            return (Criteria) this;
        }

        public Criteria andUserphoneIn(List<String> values) {
            addCriterion("userPhone in", values, "userphone");
            return (Criteria) this;
        }

        public Criteria andUserphoneNotIn(List<String> values) {
            addCriterion("userPhone not in", values, "userphone");
            return (Criteria) this;
        }

        public Criteria andUserphoneBetween(String value1, String value2) {
            addCriterion("userPhone between", value1, value2, "userphone");
            return (Criteria) this;
        }

        public Criteria andUserphoneNotBetween(String value1, String value2) {
            addCriterion("userPhone not between", value1, value2, "userphone");
            return (Criteria) this;
        }

        public Criteria andReservationresultIsNull() {
            addCriterion("reservationResult is null");
            return (Criteria) this;
        }

        public Criteria andReservationresultIsNotNull() {
            addCriterion("reservationResult is not null");
            return (Criteria) this;
        }

        public Criteria andReservationresultEqualTo(String value) {
            addCriterion("reservationResult =", value, "reservationresult");
            return (Criteria) this;
        }

        public Criteria andReservationresultNotEqualTo(String value) {
            addCriterion("reservationResult <>", value, "reservationresult");
            return (Criteria) this;
        }

        public Criteria andReservationresultGreaterThan(String value) {
            addCriterion("reservationResult >", value, "reservationresult");
            return (Criteria) this;
        }

        public Criteria andReservationresultGreaterThanOrEqualTo(String value) {
            addCriterion("reservationResult >=", value, "reservationresult");
            return (Criteria) this;
        }

        public Criteria andReservationresultLessThan(String value) {
            addCriterion("reservationResult <", value, "reservationresult");
            return (Criteria) this;
        }

        public Criteria andReservationresultLessThanOrEqualTo(String value) {
            addCriterion("reservationResult <=", value, "reservationresult");
            return (Criteria) this;
        }

        public Criteria andReservationresultLike(String value) {
            addCriterion("reservationResult like", value, "reservationresult");
            return (Criteria) this;
        }

        public Criteria andReservationresultNotLike(String value) {
            addCriterion("reservationResult not like", value, "reservationresult");
            return (Criteria) this;
        }

        public Criteria andReservationresultIn(List<String> values) {
            addCriterion("reservationResult in", values, "reservationresult");
            return (Criteria) this;
        }

        public Criteria andReservationresultNotIn(List<String> values) {
            addCriterion("reservationResult not in", values, "reservationresult");
            return (Criteria) this;
        }

        public Criteria andReservationresultBetween(String value1, String value2) {
            addCriterion("reservationResult between", value1, value2, "reservationresult");
            return (Criteria) this;
        }

        public Criteria andReservationresultNotBetween(String value1, String value2) {
            addCriterion("reservationResult not between", value1, value2, "reservationresult");
            return (Criteria) this;
        }

        public Criteria andDisposalIsNull() {
            addCriterion("disposal is null");
            return (Criteria) this;
        }

        public Criteria andDisposalIsNotNull() {
            addCriterion("disposal is not null");
            return (Criteria) this;
        }

        public Criteria andDisposalEqualTo(Integer value) {
            addCriterion("disposal =", value, "disposal");
            return (Criteria) this;
        }

        public Criteria andDisposalNotEqualTo(Integer value) {
            addCriterion("disposal <>", value, "disposal");
            return (Criteria) this;
        }

        public Criteria andDisposalGreaterThan(Integer value) {
            addCriterion("disposal >", value, "disposal");
            return (Criteria) this;
        }

        public Criteria andDisposalGreaterThanOrEqualTo(Integer value) {
            addCriterion("disposal >=", value, "disposal");
            return (Criteria) this;
        }

        public Criteria andDisposalLessThan(Integer value) {
            addCriterion("disposal <", value, "disposal");
            return (Criteria) this;
        }

        public Criteria andDisposalLessThanOrEqualTo(Integer value) {
            addCriterion("disposal <=", value, "disposal");
            return (Criteria) this;
        }

        public Criteria andDisposalIn(List<Integer> values) {
            addCriterion("disposal in", values, "disposal");
            return (Criteria) this;
        }

        public Criteria andDisposalNotIn(List<Integer> values) {
            addCriterion("disposal not in", values, "disposal");
            return (Criteria) this;
        }

        public Criteria andDisposalBetween(Integer value1, Integer value2) {
            addCriterion("disposal between", value1, value2, "disposal");
            return (Criteria) this;
        }

        public Criteria andDisposalNotBetween(Integer value1, Integer value2) {
            addCriterion("disposal not between", value1, value2, "disposal");
            return (Criteria) this;
        }

        public Criteria andRegistertimeIsNull() {
            addCriterion("registerTime is null");
            return (Criteria) this;
        }

        public Criteria andRegistertimeIsNotNull() {
            addCriterion("registerTime is not null");
            return (Criteria) this;
        }

        public Criteria andRegistertimeEqualTo(Date value) {
            addCriterion("registerTime =", value, "registertime");
            return (Criteria) this;
        }

        public Criteria andRegistertimeNotEqualTo(Date value) {
            addCriterion("registerTime <>", value, "registertime");
            return (Criteria) this;
        }

        public Criteria andRegistertimeGreaterThan(Date value) {
            addCriterion("registerTime >", value, "registertime");
            return (Criteria) this;
        }

        public Criteria andRegistertimeGreaterThanOrEqualTo(Date value) {
            addCriterion("registerTime >=", value, "registertime");
            return (Criteria) this;
        }

        public Criteria andRegistertimeLessThan(Date value) {
            addCriterion("registerTime <", value, "registertime");
            return (Criteria) this;
        }

        public Criteria andRegistertimeLessThanOrEqualTo(Date value) {
            addCriterion("registerTime <=", value, "registertime");
            return (Criteria) this;
        }

        public Criteria andRegistertimeIn(List<Date> values) {
            addCriterion("registerTime in", values, "registertime");
            return (Criteria) this;
        }

        public Criteria andRegistertimeNotIn(List<Date> values) {
            addCriterion("registerTime not in", values, "registertime");
            return (Criteria) this;
        }

        public Criteria andRegistertimeBetween(Date value1, Date value2) {
            addCriterion("registerTime between", value1, value2, "registertime");
            return (Criteria) this;
        }

        public Criteria andRegistertimeNotBetween(Date value1, Date value2) {
            addCriterion("registerTime not between", value1, value2, "registertime");
            return (Criteria) this;
        }

        public Criteria andChangetimeIsNull() {
            addCriterion("changeTime is null");
            return (Criteria) this;
        }

        public Criteria andChangetimeIsNotNull() {
            addCriterion("changeTime is not null");
            return (Criteria) this;
        }

        public Criteria andChangetimeEqualTo(Date value) {
            addCriterion("changeTime =", value, "changetime");
            return (Criteria) this;
        }

        public Criteria andChangetimeNotEqualTo(Date value) {
            addCriterion("changeTime <>", value, "changetime");
            return (Criteria) this;
        }

        public Criteria andChangetimeGreaterThan(Date value) {
            addCriterion("changeTime >", value, "changetime");
            return (Criteria) this;
        }

        public Criteria andChangetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("changeTime >=", value, "changetime");
            return (Criteria) this;
        }

        public Criteria andChangetimeLessThan(Date value) {
            addCriterion("changeTime <", value, "changetime");
            return (Criteria) this;
        }

        public Criteria andChangetimeLessThanOrEqualTo(Date value) {
            addCriterion("changeTime <=", value, "changetime");
            return (Criteria) this;
        }

        public Criteria andChangetimeIn(List<Date> values) {
            addCriterion("changeTime in", values, "changetime");
            return (Criteria) this;
        }

        public Criteria andChangetimeNotIn(List<Date> values) {
            addCriterion("changeTime not in", values, "changetime");
            return (Criteria) this;
        }

        public Criteria andChangetimeBetween(Date value1, Date value2) {
            addCriterion("changeTime between", value1, value2, "changetime");
            return (Criteria) this;
        }

        public Criteria andChangetimeNotBetween(Date value1, Date value2) {
            addCriterion("changeTime not between", value1, value2, "changetime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria implements Serializable {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion implements Serializable {
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