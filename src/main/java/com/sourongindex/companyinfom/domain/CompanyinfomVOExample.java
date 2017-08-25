package com.sourongindex.companyinfom.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CompanyinfomVOExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public CompanyinfomVOExample() {
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

        public Criteria andCompanyidIsNull() {
            addCriterion("companyid is null");
            return (Criteria) this;
        }

        public Criteria andCompanyidIsNotNull() {
            addCriterion("companyid is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyidEqualTo(Integer value) {
            addCriterion("companyid =", value, "companyid");
            return (Criteria) this;
        }

        public Criteria andCompanyidNotEqualTo(Integer value) {
            addCriterion("companyid <>", value, "companyid");
            return (Criteria) this;
        }

        public Criteria andCompanyidGreaterThan(Integer value) {
            addCriterion("companyid >", value, "companyid");
            return (Criteria) this;
        }

        public Criteria andCompanyidGreaterThanOrEqualTo(Integer value) {
            addCriterion("companyid >=", value, "companyid");
            return (Criteria) this;
        }

        public Criteria andCompanyidLessThan(Integer value) {
            addCriterion("companyid <", value, "companyid");
            return (Criteria) this;
        }

        public Criteria andCompanyidLessThanOrEqualTo(Integer value) {
            addCriterion("companyid <=", value, "companyid");
            return (Criteria) this;
        }

        public Criteria andCompanyidIn(List<Integer> values) {
            addCriterion("companyid in", values, "companyid");
            return (Criteria) this;
        }

        public Criteria andCompanyidNotIn(List<Integer> values) {
            addCriterion("companyid not in", values, "companyid");
            return (Criteria) this;
        }

        public Criteria andCompanyidBetween(Integer value1, Integer value2) {
            addCriterion("companyid between", value1, value2, "companyid");
            return (Criteria) this;
        }

        public Criteria andCompanyidNotBetween(Integer value1, Integer value2) {
            addCriterion("companyid not between", value1, value2, "companyid");
            return (Criteria) this;
        }

        public Criteria andCompanynameIsNull() {
            addCriterion("companyName is null");
            return (Criteria) this;
        }

        public Criteria andCompanynameIsNotNull() {
            addCriterion("companyName is not null");
            return (Criteria) this;
        }

        public Criteria andCompanynameEqualTo(String value) {
            addCriterion("companyName =", value, "companyname");
            return (Criteria) this;
        }

        public Criteria andCompanynameNotEqualTo(String value) {
            addCriterion("companyName <>", value, "companyname");
            return (Criteria) this;
        }

        public Criteria andCompanynameGreaterThan(String value) {
            addCriterion("companyName >", value, "companyname");
            return (Criteria) this;
        }

        public Criteria andCompanynameGreaterThanOrEqualTo(String value) {
            addCriterion("companyName >=", value, "companyname");
            return (Criteria) this;
        }

        public Criteria andCompanynameLessThan(String value) {
            addCriterion("companyName <", value, "companyname");
            return (Criteria) this;
        }

        public Criteria andCompanynameLessThanOrEqualTo(String value) {
            addCriterion("companyName <=", value, "companyname");
            return (Criteria) this;
        }

        public Criteria andCompanynameLike(String value) {
            addCriterion("companyName like", value, "companyname");
            return (Criteria) this;
        }

        public Criteria andCompanynameNotLike(String value) {
            addCriterion("companyName not like", value, "companyname");
            return (Criteria) this;
        }

        public Criteria andCompanynameIn(List<String> values) {
            addCriterion("companyName in", values, "companyname");
            return (Criteria) this;
        }

        public Criteria andCompanynameNotIn(List<String> values) {
            addCriterion("companyName not in", values, "companyname");
            return (Criteria) this;
        }

        public Criteria andCompanynameBetween(String value1, String value2) {
            addCriterion("companyName between", value1, value2, "companyname");
            return (Criteria) this;
        }

        public Criteria andCompanynameNotBetween(String value1, String value2) {
            addCriterion("companyName not between", value1, value2, "companyname");
            return (Criteria) this;
        }

        public Criteria andServicephoneIsNull() {
            addCriterion("servicePhone is null");
            return (Criteria) this;
        }

        public Criteria andServicephoneIsNotNull() {
            addCriterion("servicePhone is not null");
            return (Criteria) this;
        }

        public Criteria andServicephoneEqualTo(String value) {
            addCriterion("servicePhone =", value, "servicephone");
            return (Criteria) this;
        }

        public Criteria andServicephoneNotEqualTo(String value) {
            addCriterion("servicePhone <>", value, "servicephone");
            return (Criteria) this;
        }

        public Criteria andServicephoneGreaterThan(String value) {
            addCriterion("servicePhone >", value, "servicephone");
            return (Criteria) this;
        }

        public Criteria andServicephoneGreaterThanOrEqualTo(String value) {
            addCriterion("servicePhone >=", value, "servicephone");
            return (Criteria) this;
        }

        public Criteria andServicephoneLessThan(String value) {
            addCriterion("servicePhone <", value, "servicephone");
            return (Criteria) this;
        }

        public Criteria andServicephoneLessThanOrEqualTo(String value) {
            addCriterion("servicePhone <=", value, "servicephone");
            return (Criteria) this;
        }

        public Criteria andServicephoneLike(String value) {
            addCriterion("servicePhone like", value, "servicephone");
            return (Criteria) this;
        }

        public Criteria andServicephoneNotLike(String value) {
            addCriterion("servicePhone not like", value, "servicephone");
            return (Criteria) this;
        }

        public Criteria andServicephoneIn(List<String> values) {
            addCriterion("servicePhone in", values, "servicephone");
            return (Criteria) this;
        }

        public Criteria andServicephoneNotIn(List<String> values) {
            addCriterion("servicePhone not in", values, "servicephone");
            return (Criteria) this;
        }

        public Criteria andServicephoneBetween(String value1, String value2) {
            addCriterion("servicePhone between", value1, value2, "servicephone");
            return (Criteria) this;
        }

        public Criteria andServicephoneNotBetween(String value1, String value2) {
            addCriterion("servicePhone not between", value1, value2, "servicephone");
            return (Criteria) this;
        }

        public Criteria andServicetimeIsNull() {
            addCriterion("serviceTime is null");
            return (Criteria) this;
        }

        public Criteria andServicetimeIsNotNull() {
            addCriterion("serviceTime is not null");
            return (Criteria) this;
        }

        public Criteria andServicetimeEqualTo(String value) {
            addCriterion("serviceTime =", value, "servicetime");
            return (Criteria) this;
        }

        public Criteria andServicetimeNotEqualTo(String value) {
            addCriterion("serviceTime <>", value, "servicetime");
            return (Criteria) this;
        }

        public Criteria andServicetimeGreaterThan(String value) {
            addCriterion("serviceTime >", value, "servicetime");
            return (Criteria) this;
        }

        public Criteria andServicetimeGreaterThanOrEqualTo(String value) {
            addCriterion("serviceTime >=", value, "servicetime");
            return (Criteria) this;
        }

        public Criteria andServicetimeLessThan(String value) {
            addCriterion("serviceTime <", value, "servicetime");
            return (Criteria) this;
        }

        public Criteria andServicetimeLessThanOrEqualTo(String value) {
            addCriterion("serviceTime <=", value, "servicetime");
            return (Criteria) this;
        }

        public Criteria andServicetimeLike(String value) {
            addCriterion("serviceTime like", value, "servicetime");
            return (Criteria) this;
        }

        public Criteria andServicetimeNotLike(String value) {
            addCriterion("serviceTime not like", value, "servicetime");
            return (Criteria) this;
        }

        public Criteria andServicetimeIn(List<String> values) {
            addCriterion("serviceTime in", values, "servicetime");
            return (Criteria) this;
        }

        public Criteria andServicetimeNotIn(List<String> values) {
            addCriterion("serviceTime not in", values, "servicetime");
            return (Criteria) this;
        }

        public Criteria andServicetimeBetween(String value1, String value2) {
            addCriterion("serviceTime between", value1, value2, "servicetime");
            return (Criteria) this;
        }

        public Criteria andServicetimeNotBetween(String value1, String value2) {
            addCriterion("serviceTime not between", value1, value2, "servicetime");
            return (Criteria) this;
        }

        public Criteria andCompanyaddressIsNull() {
            addCriterion("companyaddress is null");
            return (Criteria) this;
        }

        public Criteria andCompanyaddressIsNotNull() {
            addCriterion("companyaddress is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyaddressEqualTo(String value) {
            addCriterion("companyaddress =", value, "companyaddress");
            return (Criteria) this;
        }

        public Criteria andCompanyaddressNotEqualTo(String value) {
            addCriterion("companyaddress <>", value, "companyaddress");
            return (Criteria) this;
        }

        public Criteria andCompanyaddressGreaterThan(String value) {
            addCriterion("companyaddress >", value, "companyaddress");
            return (Criteria) this;
        }

        public Criteria andCompanyaddressGreaterThanOrEqualTo(String value) {
            addCriterion("companyaddress >=", value, "companyaddress");
            return (Criteria) this;
        }

        public Criteria andCompanyaddressLessThan(String value) {
            addCriterion("companyaddress <", value, "companyaddress");
            return (Criteria) this;
        }

        public Criteria andCompanyaddressLessThanOrEqualTo(String value) {
            addCriterion("companyaddress <=", value, "companyaddress");
            return (Criteria) this;
        }

        public Criteria andCompanyaddressLike(String value) {
            addCriterion("companyaddress like", value, "companyaddress");
            return (Criteria) this;
        }

        public Criteria andCompanyaddressNotLike(String value) {
            addCriterion("companyaddress not like", value, "companyaddress");
            return (Criteria) this;
        }

        public Criteria andCompanyaddressIn(List<String> values) {
            addCriterion("companyaddress in", values, "companyaddress");
            return (Criteria) this;
        }

        public Criteria andCompanyaddressNotIn(List<String> values) {
            addCriterion("companyaddress not in", values, "companyaddress");
            return (Criteria) this;
        }

        public Criteria andCompanyaddressBetween(String value1, String value2) {
            addCriterion("companyaddress between", value1, value2, "companyaddress");
            return (Criteria) this;
        }

        public Criteria andCompanyaddressNotBetween(String value1, String value2) {
            addCriterion("companyaddress not between", value1, value2, "companyaddress");
            return (Criteria) this;
        }

        public Criteria andCompanylogoIsNull() {
            addCriterion("companylogo is null");
            return (Criteria) this;
        }

        public Criteria andCompanylogoIsNotNull() {
            addCriterion("companylogo is not null");
            return (Criteria) this;
        }

        public Criteria andCompanylogoEqualTo(String value) {
            addCriterion("companylogo =", value, "companylogo");
            return (Criteria) this;
        }

        public Criteria andCompanylogoNotEqualTo(String value) {
            addCriterion("companylogo <>", value, "companylogo");
            return (Criteria) this;
        }

        public Criteria andCompanylogoGreaterThan(String value) {
            addCriterion("companylogo >", value, "companylogo");
            return (Criteria) this;
        }

        public Criteria andCompanylogoGreaterThanOrEqualTo(String value) {
            addCriterion("companylogo >=", value, "companylogo");
            return (Criteria) this;
        }

        public Criteria andCompanylogoLessThan(String value) {
            addCriterion("companylogo <", value, "companylogo");
            return (Criteria) this;
        }

        public Criteria andCompanylogoLessThanOrEqualTo(String value) {
            addCriterion("companylogo <=", value, "companylogo");
            return (Criteria) this;
        }

        public Criteria andCompanylogoLike(String value) {
            addCriterion("companylogo like", value, "companylogo");
            return (Criteria) this;
        }

        public Criteria andCompanylogoNotLike(String value) {
            addCriterion("companylogo not like", value, "companylogo");
            return (Criteria) this;
        }

        public Criteria andCompanylogoIn(List<String> values) {
            addCriterion("companylogo in", values, "companylogo");
            return (Criteria) this;
        }

        public Criteria andCompanylogoNotIn(List<String> values) {
            addCriterion("companylogo not in", values, "companylogo");
            return (Criteria) this;
        }

        public Criteria andCompanylogoBetween(String value1, String value2) {
            addCriterion("companylogo between", value1, value2, "companylogo");
            return (Criteria) this;
        }

        public Criteria andCompanylogoNotBetween(String value1, String value2) {
            addCriterion("companylogo not between", value1, value2, "companylogo");
            return (Criteria) this;
        }

        public Criteria andCompanyqrIsNull() {
            addCriterion("companyQR is null");
            return (Criteria) this;
        }

        public Criteria andCompanyqrIsNotNull() {
            addCriterion("companyQR is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyqrEqualTo(String value) {
            addCriterion("companyQR =", value, "companyqr");
            return (Criteria) this;
        }

        public Criteria andCompanyqrNotEqualTo(String value) {
            addCriterion("companyQR <>", value, "companyqr");
            return (Criteria) this;
        }

        public Criteria andCompanyqrGreaterThan(String value) {
            addCriterion("companyQR >", value, "companyqr");
            return (Criteria) this;
        }

        public Criteria andCompanyqrGreaterThanOrEqualTo(String value) {
            addCriterion("companyQR >=", value, "companyqr");
            return (Criteria) this;
        }

        public Criteria andCompanyqrLessThan(String value) {
            addCriterion("companyQR <", value, "companyqr");
            return (Criteria) this;
        }

        public Criteria andCompanyqrLessThanOrEqualTo(String value) {
            addCriterion("companyQR <=", value, "companyqr");
            return (Criteria) this;
        }

        public Criteria andCompanyqrLike(String value) {
            addCriterion("companyQR like", value, "companyqr");
            return (Criteria) this;
        }

        public Criteria andCompanyqrNotLike(String value) {
            addCriterion("companyQR not like", value, "companyqr");
            return (Criteria) this;
        }

        public Criteria andCompanyqrIn(List<String> values) {
            addCriterion("companyQR in", values, "companyqr");
            return (Criteria) this;
        }

        public Criteria andCompanyqrNotIn(List<String> values) {
            addCriterion("companyQR not in", values, "companyqr");
            return (Criteria) this;
        }

        public Criteria andCompanyqrBetween(String value1, String value2) {
            addCriterion("companyQR between", value1, value2, "companyqr");
            return (Criteria) this;
        }

        public Criteria andCompanyqrNotBetween(String value1, String value2) {
            addCriterion("companyQR not between", value1, value2, "companyqr");
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

        public Criteria andDetailaddressIsNull() {
            addCriterion("detailaddress is null");
            return (Criteria) this;
        }

        public Criteria andDetailaddressIsNotNull() {
            addCriterion("detailaddress is not null");
            return (Criteria) this;
        }

        public Criteria andDetailaddressEqualTo(String value) {
            addCriterion("detailaddress =", value, "detailaddress");
            return (Criteria) this;
        }

        public Criteria andDetailaddressNotEqualTo(String value) {
            addCriterion("detailaddress <>", value, "detailaddress");
            return (Criteria) this;
        }

        public Criteria andDetailaddressGreaterThan(String value) {
            addCriterion("detailaddress >", value, "detailaddress");
            return (Criteria) this;
        }

        public Criteria andDetailaddressGreaterThanOrEqualTo(String value) {
            addCriterion("detailaddress >=", value, "detailaddress");
            return (Criteria) this;
        }

        public Criteria andDetailaddressLessThan(String value) {
            addCriterion("detailaddress <", value, "detailaddress");
            return (Criteria) this;
        }

        public Criteria andDetailaddressLessThanOrEqualTo(String value) {
            addCriterion("detailaddress <=", value, "detailaddress");
            return (Criteria) this;
        }

        public Criteria andDetailaddressLike(String value) {
            addCriterion("detailaddress like", value, "detailaddress");
            return (Criteria) this;
        }

        public Criteria andDetailaddressNotLike(String value) {
            addCriterion("detailaddress not like", value, "detailaddress");
            return (Criteria) this;
        }

        public Criteria andDetailaddressIn(List<String> values) {
            addCriterion("detailaddress in", values, "detailaddress");
            return (Criteria) this;
        }

        public Criteria andDetailaddressNotIn(List<String> values) {
            addCriterion("detailaddress not in", values, "detailaddress");
            return (Criteria) this;
        }

        public Criteria andDetailaddressBetween(String value1, String value2) {
            addCriterion("detailaddress between", value1, value2, "detailaddress");
            return (Criteria) this;
        }

        public Criteria andDetailaddressNotBetween(String value1, String value2) {
            addCriterion("detailaddress not between", value1, value2, "detailaddress");
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