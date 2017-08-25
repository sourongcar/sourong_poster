package com.sourongindex.serviceidea.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ServiceideaVOExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public ServiceideaVOExample() {
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

        public Criteria andServiceideaidIsNull() {
            addCriterion("serviceideaId is null");
            return (Criteria) this;
        }

        public Criteria andServiceideaidIsNotNull() {
            addCriterion("serviceideaId is not null");
            return (Criteria) this;
        }

        public Criteria andServiceideaidEqualTo(Integer value) {
            addCriterion("serviceideaId =", value, "serviceideaid");
            return (Criteria) this;
        }

        public Criteria andServiceideaidNotEqualTo(Integer value) {
            addCriterion("serviceideaId <>", value, "serviceideaid");
            return (Criteria) this;
        }

        public Criteria andServiceideaidGreaterThan(Integer value) {
            addCriterion("serviceideaId >", value, "serviceideaid");
            return (Criteria) this;
        }

        public Criteria andServiceideaidGreaterThanOrEqualTo(Integer value) {
            addCriterion("serviceideaId >=", value, "serviceideaid");
            return (Criteria) this;
        }

        public Criteria andServiceideaidLessThan(Integer value) {
            addCriterion("serviceideaId <", value, "serviceideaid");
            return (Criteria) this;
        }

        public Criteria andServiceideaidLessThanOrEqualTo(Integer value) {
            addCriterion("serviceideaId <=", value, "serviceideaid");
            return (Criteria) this;
        }

        public Criteria andServiceideaidIn(List<Integer> values) {
            addCriterion("serviceideaId in", values, "serviceideaid");
            return (Criteria) this;
        }

        public Criteria andServiceideaidNotIn(List<Integer> values) {
            addCriterion("serviceideaId not in", values, "serviceideaid");
            return (Criteria) this;
        }

        public Criteria andServiceideaidBetween(Integer value1, Integer value2) {
            addCriterion("serviceideaId between", value1, value2, "serviceideaid");
            return (Criteria) this;
        }

        public Criteria andServiceideaidNotBetween(Integer value1, Integer value2) {
            addCriterion("serviceideaId not between", value1, value2, "serviceideaid");
            return (Criteria) this;
        }

        public Criteria andPicnameIsNull() {
            addCriterion("picName is null");
            return (Criteria) this;
        }

        public Criteria andPicnameIsNotNull() {
            addCriterion("picName is not null");
            return (Criteria) this;
        }

        public Criteria andPicnameEqualTo(String value) {
            addCriterion("picName =", value, "picname");
            return (Criteria) this;
        }

        public Criteria andPicnameNotEqualTo(String value) {
            addCriterion("picName <>", value, "picname");
            return (Criteria) this;
        }

        public Criteria andPicnameGreaterThan(String value) {
            addCriterion("picName >", value, "picname");
            return (Criteria) this;
        }

        public Criteria andPicnameGreaterThanOrEqualTo(String value) {
            addCriterion("picName >=", value, "picname");
            return (Criteria) this;
        }

        public Criteria andPicnameLessThan(String value) {
            addCriterion("picName <", value, "picname");
            return (Criteria) this;
        }

        public Criteria andPicnameLessThanOrEqualTo(String value) {
            addCriterion("picName <=", value, "picname");
            return (Criteria) this;
        }

        public Criteria andPicnameLike(String value) {
            addCriterion("picName like", value, "picname");
            return (Criteria) this;
        }

        public Criteria andPicnameNotLike(String value) {
            addCriterion("picName not like", value, "picname");
            return (Criteria) this;
        }

        public Criteria andPicnameIn(List<String> values) {
            addCriterion("picName in", values, "picname");
            return (Criteria) this;
        }

        public Criteria andPicnameNotIn(List<String> values) {
            addCriterion("picName not in", values, "picname");
            return (Criteria) this;
        }

        public Criteria andPicnameBetween(String value1, String value2) {
            addCriterion("picName between", value1, value2, "picname");
            return (Criteria) this;
        }

        public Criteria andPicnameNotBetween(String value1, String value2) {
            addCriterion("picName not between", value1, value2, "picname");
            return (Criteria) this;
        }

        public Criteria andIdeadescribeIsNull() {
            addCriterion("Ideadescribe is null");
            return (Criteria) this;
        }

        public Criteria andIdeadescribeIsNotNull() {
            addCriterion("Ideadescribe is not null");
            return (Criteria) this;
        }

        public Criteria andIdeadescribeEqualTo(String value) {
            addCriterion("Ideadescribe =", value, "ideadescribe");
            return (Criteria) this;
        }

        public Criteria andIdeadescribeNotEqualTo(String value) {
            addCriterion("Ideadescribe <>", value, "ideadescribe");
            return (Criteria) this;
        }

        public Criteria andIdeadescribeGreaterThan(String value) {
            addCriterion("Ideadescribe >", value, "ideadescribe");
            return (Criteria) this;
        }

        public Criteria andIdeadescribeGreaterThanOrEqualTo(String value) {
            addCriterion("Ideadescribe >=", value, "ideadescribe");
            return (Criteria) this;
        }

        public Criteria andIdeadescribeLessThan(String value) {
            addCriterion("Ideadescribe <", value, "ideadescribe");
            return (Criteria) this;
        }

        public Criteria andIdeadescribeLessThanOrEqualTo(String value) {
            addCriterion("Ideadescribe <=", value, "ideadescribe");
            return (Criteria) this;
        }

        public Criteria andIdeadescribeLike(String value) {
            addCriterion("Ideadescribe like", value, "ideadescribe");
            return (Criteria) this;
        }

        public Criteria andIdeadescribeNotLike(String value) {
            addCriterion("Ideadescribe not like", value, "ideadescribe");
            return (Criteria) this;
        }

        public Criteria andIdeadescribeIn(List<String> values) {
            addCriterion("Ideadescribe in", values, "ideadescribe");
            return (Criteria) this;
        }

        public Criteria andIdeadescribeNotIn(List<String> values) {
            addCriterion("Ideadescribe not in", values, "ideadescribe");
            return (Criteria) this;
        }

        public Criteria andIdeadescribeBetween(String value1, String value2) {
            addCriterion("Ideadescribe between", value1, value2, "ideadescribe");
            return (Criteria) this;
        }

        public Criteria andIdeadescribeNotBetween(String value1, String value2) {
            addCriterion("Ideadescribe not between", value1, value2, "ideadescribe");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("createTime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("createTime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterion("createTime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterion("createTime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterion("createTime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("createTime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterion("createTime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("createTime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterion("createTime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterion("createTime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterion("createTime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("createTime not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andLasttimeIsNull() {
            addCriterion("lastTime is null");
            return (Criteria) this;
        }

        public Criteria andLasttimeIsNotNull() {
            addCriterion("lastTime is not null");
            return (Criteria) this;
        }

        public Criteria andLasttimeEqualTo(Date value) {
            addCriterion("lastTime =", value, "lasttime");
            return (Criteria) this;
        }

        public Criteria andLasttimeNotEqualTo(Date value) {
            addCriterion("lastTime <>", value, "lasttime");
            return (Criteria) this;
        }

        public Criteria andLasttimeGreaterThan(Date value) {
            addCriterion("lastTime >", value, "lasttime");
            return (Criteria) this;
        }

        public Criteria andLasttimeGreaterThanOrEqualTo(Date value) {
            addCriterion("lastTime >=", value, "lasttime");
            return (Criteria) this;
        }

        public Criteria andLasttimeLessThan(Date value) {
            addCriterion("lastTime <", value, "lasttime");
            return (Criteria) this;
        }

        public Criteria andLasttimeLessThanOrEqualTo(Date value) {
            addCriterion("lastTime <=", value, "lasttime");
            return (Criteria) this;
        }

        public Criteria andLasttimeIn(List<Date> values) {
            addCriterion("lastTime in", values, "lasttime");
            return (Criteria) this;
        }

        public Criteria andLasttimeNotIn(List<Date> values) {
            addCriterion("lastTime not in", values, "lasttime");
            return (Criteria) this;
        }

        public Criteria andLasttimeBetween(Date value1, Date value2) {
            addCriterion("lastTime between", value1, value2, "lasttime");
            return (Criteria) this;
        }

        public Criteria andLasttimeNotBetween(Date value1, Date value2) {
            addCriterion("lastTime not between", value1, value2, "lasttime");
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