package com.zhaogongyi.model;

import java.util.ArrayList;
import java.util.List;

public class CompanyInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CompanyInfoExample() {
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

        public Criteria andCompanyIdIsNull() {
            addCriterion("COMPANY_ID is null");
            return (Criteria) this;
        }

        public Criteria andCompanyIdIsNotNull() {
            addCriterion("COMPANY_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyIdEqualTo(Integer value) {
            addCriterion("COMPANY_ID =", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotEqualTo(Integer value) {
            addCriterion("COMPANY_ID <>", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdGreaterThan(Integer value) {
            addCriterion("COMPANY_ID >", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("COMPANY_ID >=", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdLessThan(Integer value) {
            addCriterion("COMPANY_ID <", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdLessThanOrEqualTo(Integer value) {
            addCriterion("COMPANY_ID <=", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdIn(List<Integer> values) {
            addCriterion("COMPANY_ID in", values, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotIn(List<Integer> values) {
            addCriterion("COMPANY_ID not in", values, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdBetween(Integer value1, Integer value2) {
            addCriterion("COMPANY_ID between", value1, value2, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotBetween(Integer value1, Integer value2) {
            addCriterion("COMPANY_ID not between", value1, value2, "companyId");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("NAME is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("NAME is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("NAME =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("NAME <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("NAME >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("NAME >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("NAME <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("NAME <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("NAME like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("NAME not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("NAME in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("NAME not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("NAME between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("NAME not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andTradeIsNull() {
            addCriterion("TRADE is null");
            return (Criteria) this;
        }

        public Criteria andTradeIsNotNull() {
            addCriterion("TRADE is not null");
            return (Criteria) this;
        }

        public Criteria andTradeEqualTo(String value) {
            addCriterion("TRADE =", value, "trade");
            return (Criteria) this;
        }

        public Criteria andTradeNotEqualTo(String value) {
            addCriterion("TRADE <>", value, "trade");
            return (Criteria) this;
        }

        public Criteria andTradeGreaterThan(String value) {
            addCriterion("TRADE >", value, "trade");
            return (Criteria) this;
        }

        public Criteria andTradeGreaterThanOrEqualTo(String value) {
            addCriterion("TRADE >=", value, "trade");
            return (Criteria) this;
        }

        public Criteria andTradeLessThan(String value) {
            addCriterion("TRADE <", value, "trade");
            return (Criteria) this;
        }

        public Criteria andTradeLessThanOrEqualTo(String value) {
            addCriterion("TRADE <=", value, "trade");
            return (Criteria) this;
        }

        public Criteria andTradeLike(String value) {
            addCriterion("TRADE like", value, "trade");
            return (Criteria) this;
        }

        public Criteria andTradeNotLike(String value) {
            addCriterion("TRADE not like", value, "trade");
            return (Criteria) this;
        }

        public Criteria andTradeIn(List<String> values) {
            addCriterion("TRADE in", values, "trade");
            return (Criteria) this;
        }

        public Criteria andTradeNotIn(List<String> values) {
            addCriterion("TRADE not in", values, "trade");
            return (Criteria) this;
        }

        public Criteria andTradeBetween(String value1, String value2) {
            addCriterion("TRADE between", value1, value2, "trade");
            return (Criteria) this;
        }

        public Criteria andTradeNotBetween(String value1, String value2) {
            addCriterion("TRADE not between", value1, value2, "trade");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("TYPE is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("TYPE =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("TYPE <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("TYPE >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("TYPE >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("TYPE <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("TYPE <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("TYPE like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("TYPE not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("TYPE in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("TYPE not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("TYPE between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("TYPE not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andGrandIsNull() {
            addCriterion("GRAND is null");
            return (Criteria) this;
        }

        public Criteria andGrandIsNotNull() {
            addCriterion("GRAND is not null");
            return (Criteria) this;
        }

        public Criteria andGrandEqualTo(String value) {
            addCriterion("GRAND =", value, "grand");
            return (Criteria) this;
        }

        public Criteria andGrandNotEqualTo(String value) {
            addCriterion("GRAND <>", value, "grand");
            return (Criteria) this;
        }

        public Criteria andGrandGreaterThan(String value) {
            addCriterion("GRAND >", value, "grand");
            return (Criteria) this;
        }

        public Criteria andGrandGreaterThanOrEqualTo(String value) {
            addCriterion("GRAND >=", value, "grand");
            return (Criteria) this;
        }

        public Criteria andGrandLessThan(String value) {
            addCriterion("GRAND <", value, "grand");
            return (Criteria) this;
        }

        public Criteria andGrandLessThanOrEqualTo(String value) {
            addCriterion("GRAND <=", value, "grand");
            return (Criteria) this;
        }

        public Criteria andGrandLike(String value) {
            addCriterion("GRAND like", value, "grand");
            return (Criteria) this;
        }

        public Criteria andGrandNotLike(String value) {
            addCriterion("GRAND not like", value, "grand");
            return (Criteria) this;
        }

        public Criteria andGrandIn(List<String> values) {
            addCriterion("GRAND in", values, "grand");
            return (Criteria) this;
        }

        public Criteria andGrandNotIn(List<String> values) {
            addCriterion("GRAND not in", values, "grand");
            return (Criteria) this;
        }

        public Criteria andGrandBetween(String value1, String value2) {
            addCriterion("GRAND between", value1, value2, "grand");
            return (Criteria) this;
        }

        public Criteria andGrandNotBetween(String value1, String value2) {
            addCriterion("GRAND not between", value1, value2, "grand");
            return (Criteria) this;
        }

        public Criteria andComPhoneIsNull() {
            addCriterion("COM_PHONE is null");
            return (Criteria) this;
        }

        public Criteria andComPhoneIsNotNull() {
            addCriterion("COM_PHONE is not null");
            return (Criteria) this;
        }

        public Criteria andComPhoneEqualTo(String value) {
            addCriterion("COM_PHONE =", value, "comPhone");
            return (Criteria) this;
        }

        public Criteria andComPhoneNotEqualTo(String value) {
            addCriterion("COM_PHONE <>", value, "comPhone");
            return (Criteria) this;
        }

        public Criteria andComPhoneGreaterThan(String value) {
            addCriterion("COM_PHONE >", value, "comPhone");
            return (Criteria) this;
        }

        public Criteria andComPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("COM_PHONE >=", value, "comPhone");
            return (Criteria) this;
        }

        public Criteria andComPhoneLessThan(String value) {
            addCriterion("COM_PHONE <", value, "comPhone");
            return (Criteria) this;
        }

        public Criteria andComPhoneLessThanOrEqualTo(String value) {
            addCriterion("COM_PHONE <=", value, "comPhone");
            return (Criteria) this;
        }

        public Criteria andComPhoneLike(String value) {
            addCriterion("COM_PHONE like", value, "comPhone");
            return (Criteria) this;
        }

        public Criteria andComPhoneNotLike(String value) {
            addCriterion("COM_PHONE not like", value, "comPhone");
            return (Criteria) this;
        }

        public Criteria andComPhoneIn(List<String> values) {
            addCriterion("COM_PHONE in", values, "comPhone");
            return (Criteria) this;
        }

        public Criteria andComPhoneNotIn(List<String> values) {
            addCriterion("COM_PHONE not in", values, "comPhone");
            return (Criteria) this;
        }

        public Criteria andComPhoneBetween(String value1, String value2) {
            addCriterion("COM_PHONE between", value1, value2, "comPhone");
            return (Criteria) this;
        }

        public Criteria andComPhoneNotBetween(String value1, String value2) {
            addCriterion("COM_PHONE not between", value1, value2, "comPhone");
            return (Criteria) this;
        }

        public Criteria andComEmailIsNull() {
            addCriterion("COM_EMAIL is null");
            return (Criteria) this;
        }

        public Criteria andComEmailIsNotNull() {
            addCriterion("COM_EMAIL is not null");
            return (Criteria) this;
        }

        public Criteria andComEmailEqualTo(String value) {
            addCriterion("COM_EMAIL =", value, "comEmail");
            return (Criteria) this;
        }

        public Criteria andComEmailNotEqualTo(String value) {
            addCriterion("COM_EMAIL <>", value, "comEmail");
            return (Criteria) this;
        }

        public Criteria andComEmailGreaterThan(String value) {
            addCriterion("COM_EMAIL >", value, "comEmail");
            return (Criteria) this;
        }

        public Criteria andComEmailGreaterThanOrEqualTo(String value) {
            addCriterion("COM_EMAIL >=", value, "comEmail");
            return (Criteria) this;
        }

        public Criteria andComEmailLessThan(String value) {
            addCriterion("COM_EMAIL <", value, "comEmail");
            return (Criteria) this;
        }

        public Criteria andComEmailLessThanOrEqualTo(String value) {
            addCriterion("COM_EMAIL <=", value, "comEmail");
            return (Criteria) this;
        }

        public Criteria andComEmailLike(String value) {
            addCriterion("COM_EMAIL like", value, "comEmail");
            return (Criteria) this;
        }

        public Criteria andComEmailNotLike(String value) {
            addCriterion("COM_EMAIL not like", value, "comEmail");
            return (Criteria) this;
        }

        public Criteria andComEmailIn(List<String> values) {
            addCriterion("COM_EMAIL in", values, "comEmail");
            return (Criteria) this;
        }

        public Criteria andComEmailNotIn(List<String> values) {
            addCriterion("COM_EMAIL not in", values, "comEmail");
            return (Criteria) this;
        }

        public Criteria andComEmailBetween(String value1, String value2) {
            addCriterion("COM_EMAIL between", value1, value2, "comEmail");
            return (Criteria) this;
        }

        public Criteria andComEmailNotBetween(String value1, String value2) {
            addCriterion("COM_EMAIL not between", value1, value2, "comEmail");
            return (Criteria) this;
        }

        public Criteria andAddrIsNull() {
            addCriterion("ADDR is null");
            return (Criteria) this;
        }

        public Criteria andAddrIsNotNull() {
            addCriterion("ADDR is not null");
            return (Criteria) this;
        }

        public Criteria andAddrEqualTo(String value) {
            addCriterion("ADDR =", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrNotEqualTo(String value) {
            addCriterion("ADDR <>", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrGreaterThan(String value) {
            addCriterion("ADDR >", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrGreaterThanOrEqualTo(String value) {
            addCriterion("ADDR >=", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrLessThan(String value) {
            addCriterion("ADDR <", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrLessThanOrEqualTo(String value) {
            addCriterion("ADDR <=", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrLike(String value) {
            addCriterion("ADDR like", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrNotLike(String value) {
            addCriterion("ADDR not like", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrIn(List<String> values) {
            addCriterion("ADDR in", values, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrNotIn(List<String> values) {
            addCriterion("ADDR not in", values, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrBetween(String value1, String value2) {
            addCriterion("ADDR between", value1, value2, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrNotBetween(String value1, String value2) {
            addCriterion("ADDR not between", value1, value2, "addr");
            return (Criteria) this;
        }

        public Criteria andAcctIdFkIsNull() {
            addCriterion("ACCT_ID_FK is null");
            return (Criteria) this;
        }

        public Criteria andAcctIdFkIsNotNull() {
            addCriterion("ACCT_ID_FK is not null");
            return (Criteria) this;
        }

        public Criteria andAcctIdFkEqualTo(Integer value) {
            addCriterion("ACCT_ID_FK =", value, "acctIdFk");
            return (Criteria) this;
        }

        public Criteria andAcctIdFkNotEqualTo(Integer value) {
            addCriterion("ACCT_ID_FK <>", value, "acctIdFk");
            return (Criteria) this;
        }

        public Criteria andAcctIdFkGreaterThan(Integer value) {
            addCriterion("ACCT_ID_FK >", value, "acctIdFk");
            return (Criteria) this;
        }

        public Criteria andAcctIdFkGreaterThanOrEqualTo(Integer value) {
            addCriterion("ACCT_ID_FK >=", value, "acctIdFk");
            return (Criteria) this;
        }

        public Criteria andAcctIdFkLessThan(Integer value) {
            addCriterion("ACCT_ID_FK <", value, "acctIdFk");
            return (Criteria) this;
        }

        public Criteria andAcctIdFkLessThanOrEqualTo(Integer value) {
            addCriterion("ACCT_ID_FK <=", value, "acctIdFk");
            return (Criteria) this;
        }

        public Criteria andAcctIdFkIn(List<Integer> values) {
            addCriterion("ACCT_ID_FK in", values, "acctIdFk");
            return (Criteria) this;
        }

        public Criteria andAcctIdFkNotIn(List<Integer> values) {
            addCriterion("ACCT_ID_FK not in", values, "acctIdFk");
            return (Criteria) this;
        }

        public Criteria andAcctIdFkBetween(Integer value1, Integer value2) {
            addCriterion("ACCT_ID_FK between", value1, value2, "acctIdFk");
            return (Criteria) this;
        }

        public Criteria andAcctIdFkNotBetween(Integer value1, Integer value2) {
            addCriterion("ACCT_ID_FK not between", value1, value2, "acctIdFk");
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