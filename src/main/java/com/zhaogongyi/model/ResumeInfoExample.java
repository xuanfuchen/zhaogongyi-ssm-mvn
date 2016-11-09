package com.zhaogongyi.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ResumeInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ResumeInfoExample() {
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

        public Criteria andResumeIdIsNull() {
            addCriterion("RESUME_ID is null");
            return (Criteria) this;
        }

        public Criteria andResumeIdIsNotNull() {
            addCriterion("RESUME_ID is not null");
            return (Criteria) this;
        }

        public Criteria andResumeIdEqualTo(Integer value) {
            addCriterion("RESUME_ID =", value, "resumeId");
            return (Criteria) this;
        }

        public Criteria andResumeIdNotEqualTo(Integer value) {
            addCriterion("RESUME_ID <>", value, "resumeId");
            return (Criteria) this;
        }

        public Criteria andResumeIdGreaterThan(Integer value) {
            addCriterion("RESUME_ID >", value, "resumeId");
            return (Criteria) this;
        }

        public Criteria andResumeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("RESUME_ID >=", value, "resumeId");
            return (Criteria) this;
        }

        public Criteria andResumeIdLessThan(Integer value) {
            addCriterion("RESUME_ID <", value, "resumeId");
            return (Criteria) this;
        }

        public Criteria andResumeIdLessThanOrEqualTo(Integer value) {
            addCriterion("RESUME_ID <=", value, "resumeId");
            return (Criteria) this;
        }

        public Criteria andResumeIdIn(List<Integer> values) {
            addCriterion("RESUME_ID in", values, "resumeId");
            return (Criteria) this;
        }

        public Criteria andResumeIdNotIn(List<Integer> values) {
            addCriterion("RESUME_ID not in", values, "resumeId");
            return (Criteria) this;
        }

        public Criteria andResumeIdBetween(Integer value1, Integer value2) {
            addCriterion("RESUME_ID between", value1, value2, "resumeId");
            return (Criteria) this;
        }

        public Criteria andResumeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("RESUME_ID not between", value1, value2, "resumeId");
            return (Criteria) this;
        }

        public Criteria andFullNameIsNull() {
            addCriterion("FULL_NAME is null");
            return (Criteria) this;
        }

        public Criteria andFullNameIsNotNull() {
            addCriterion("FULL_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andFullNameEqualTo(String value) {
            addCriterion("FULL_NAME =", value, "fullName");
            return (Criteria) this;
        }

        public Criteria andFullNameNotEqualTo(String value) {
            addCriterion("FULL_NAME <>", value, "fullName");
            return (Criteria) this;
        }

        public Criteria andFullNameGreaterThan(String value) {
            addCriterion("FULL_NAME >", value, "fullName");
            return (Criteria) this;
        }

        public Criteria andFullNameGreaterThanOrEqualTo(String value) {
            addCriterion("FULL_NAME >=", value, "fullName");
            return (Criteria) this;
        }

        public Criteria andFullNameLessThan(String value) {
            addCriterion("FULL_NAME <", value, "fullName");
            return (Criteria) this;
        }

        public Criteria andFullNameLessThanOrEqualTo(String value) {
            addCriterion("FULL_NAME <=", value, "fullName");
            return (Criteria) this;
        }

        public Criteria andFullNameLike(String value) {
            addCriterion("FULL_NAME like", value, "fullName");
            return (Criteria) this;
        }

        public Criteria andFullNameNotLike(String value) {
            addCriterion("FULL_NAME not like", value, "fullName");
            return (Criteria) this;
        }

        public Criteria andFullNameIn(List<String> values) {
            addCriterion("FULL_NAME in", values, "fullName");
            return (Criteria) this;
        }

        public Criteria andFullNameNotIn(List<String> values) {
            addCriterion("FULL_NAME not in", values, "fullName");
            return (Criteria) this;
        }

        public Criteria andFullNameBetween(String value1, String value2) {
            addCriterion("FULL_NAME between", value1, value2, "fullName");
            return (Criteria) this;
        }

        public Criteria andFullNameNotBetween(String value1, String value2) {
            addCriterion("FULL_NAME not between", value1, value2, "fullName");
            return (Criteria) this;
        }

        public Criteria andGenderIsNull() {
            addCriterion("GENDER is null");
            return (Criteria) this;
        }

        public Criteria andGenderIsNotNull() {
            addCriterion("GENDER is not null");
            return (Criteria) this;
        }

        public Criteria andGenderEqualTo(Byte value) {
            addCriterion("GENDER =", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotEqualTo(Byte value) {
            addCriterion("GENDER <>", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThan(Byte value) {
            addCriterion("GENDER >", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThanOrEqualTo(Byte value) {
            addCriterion("GENDER >=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThan(Byte value) {
            addCriterion("GENDER <", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThanOrEqualTo(Byte value) {
            addCriterion("GENDER <=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderIn(List<Byte> values) {
            addCriterion("GENDER in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotIn(List<Byte> values) {
            addCriterion("GENDER not in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderBetween(Byte value1, Byte value2) {
            addCriterion("GENDER between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotBetween(Byte value1, Byte value2) {
            addCriterion("GENDER not between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andCellPhoneIsNull() {
            addCriterion("CELL_PHONE is null");
            return (Criteria) this;
        }

        public Criteria andCellPhoneIsNotNull() {
            addCriterion("CELL_PHONE is not null");
            return (Criteria) this;
        }

        public Criteria andCellPhoneEqualTo(String value) {
            addCriterion("CELL_PHONE =", value, "cellPhone");
            return (Criteria) this;
        }

        public Criteria andCellPhoneNotEqualTo(String value) {
            addCriterion("CELL_PHONE <>", value, "cellPhone");
            return (Criteria) this;
        }

        public Criteria andCellPhoneGreaterThan(String value) {
            addCriterion("CELL_PHONE >", value, "cellPhone");
            return (Criteria) this;
        }

        public Criteria andCellPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("CELL_PHONE >=", value, "cellPhone");
            return (Criteria) this;
        }

        public Criteria andCellPhoneLessThan(String value) {
            addCriterion("CELL_PHONE <", value, "cellPhone");
            return (Criteria) this;
        }

        public Criteria andCellPhoneLessThanOrEqualTo(String value) {
            addCriterion("CELL_PHONE <=", value, "cellPhone");
            return (Criteria) this;
        }

        public Criteria andCellPhoneLike(String value) {
            addCriterion("CELL_PHONE like", value, "cellPhone");
            return (Criteria) this;
        }

        public Criteria andCellPhoneNotLike(String value) {
            addCriterion("CELL_PHONE not like", value, "cellPhone");
            return (Criteria) this;
        }

        public Criteria andCellPhoneIn(List<String> values) {
            addCriterion("CELL_PHONE in", values, "cellPhone");
            return (Criteria) this;
        }

        public Criteria andCellPhoneNotIn(List<String> values) {
            addCriterion("CELL_PHONE not in", values, "cellPhone");
            return (Criteria) this;
        }

        public Criteria andCellPhoneBetween(String value1, String value2) {
            addCriterion("CELL_PHONE between", value1, value2, "cellPhone");
            return (Criteria) this;
        }

        public Criteria andCellPhoneNotBetween(String value1, String value2) {
            addCriterion("CELL_PHONE not between", value1, value2, "cellPhone");
            return (Criteria) this;
        }

        public Criteria andPlaceIdFkIsNull() {
            addCriterion("PLACE_ID_FK is null");
            return (Criteria) this;
        }

        public Criteria andPlaceIdFkIsNotNull() {
            addCriterion("PLACE_ID_FK is not null");
            return (Criteria) this;
        }

        public Criteria andPlaceIdFkEqualTo(String value) {
            addCriterion("PLACE_ID_FK =", value, "placeIdFk");
            return (Criteria) this;
        }

        public Criteria andPlaceIdFkNotEqualTo(String value) {
            addCriterion("PLACE_ID_FK <>", value, "placeIdFk");
            return (Criteria) this;
        }

        public Criteria andPlaceIdFkGreaterThan(String value) {
            addCriterion("PLACE_ID_FK >", value, "placeIdFk");
            return (Criteria) this;
        }

        public Criteria andPlaceIdFkGreaterThanOrEqualTo(String value) {
            addCriterion("PLACE_ID_FK >=", value, "placeIdFk");
            return (Criteria) this;
        }

        public Criteria andPlaceIdFkLessThan(String value) {
            addCriterion("PLACE_ID_FK <", value, "placeIdFk");
            return (Criteria) this;
        }

        public Criteria andPlaceIdFkLessThanOrEqualTo(String value) {
            addCriterion("PLACE_ID_FK <=", value, "placeIdFk");
            return (Criteria) this;
        }

        public Criteria andPlaceIdFkLike(String value) {
            addCriterion("PLACE_ID_FK like", value, "placeIdFk");
            return (Criteria) this;
        }

        public Criteria andPlaceIdFkNotLike(String value) {
            addCriterion("PLACE_ID_FK not like", value, "placeIdFk");
            return (Criteria) this;
        }

        public Criteria andPlaceIdFkIn(List<String> values) {
            addCriterion("PLACE_ID_FK in", values, "placeIdFk");
            return (Criteria) this;
        }

        public Criteria andPlaceIdFkNotIn(List<String> values) {
            addCriterion("PLACE_ID_FK not in", values, "placeIdFk");
            return (Criteria) this;
        }

        public Criteria andPlaceIdFkBetween(String value1, String value2) {
            addCriterion("PLACE_ID_FK between", value1, value2, "placeIdFk");
            return (Criteria) this;
        }

        public Criteria andPlaceIdFkNotBetween(String value1, String value2) {
            addCriterion("PLACE_ID_FK not between", value1, value2, "placeIdFk");
            return (Criteria) this;
        }

        public Criteria andPlaceNameIsNull() {
            addCriterion("PLACE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andPlaceNameIsNotNull() {
            addCriterion("PLACE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andPlaceNameEqualTo(String value) {
            addCriterion("PLACE_NAME =", value, "placeName");
            return (Criteria) this;
        }

        public Criteria andPlaceNameNotEqualTo(String value) {
            addCriterion("PLACE_NAME <>", value, "placeName");
            return (Criteria) this;
        }

        public Criteria andPlaceNameGreaterThan(String value) {
            addCriterion("PLACE_NAME >", value, "placeName");
            return (Criteria) this;
        }

        public Criteria andPlaceNameGreaterThanOrEqualTo(String value) {
            addCriterion("PLACE_NAME >=", value, "placeName");
            return (Criteria) this;
        }

        public Criteria andPlaceNameLessThan(String value) {
            addCriterion("PLACE_NAME <", value, "placeName");
            return (Criteria) this;
        }

        public Criteria andPlaceNameLessThanOrEqualTo(String value) {
            addCriterion("PLACE_NAME <=", value, "placeName");
            return (Criteria) this;
        }

        public Criteria andPlaceNameLike(String value) {
            addCriterion("PLACE_NAME like", value, "placeName");
            return (Criteria) this;
        }

        public Criteria andPlaceNameNotLike(String value) {
            addCriterion("PLACE_NAME not like", value, "placeName");
            return (Criteria) this;
        }

        public Criteria andPlaceNameIn(List<String> values) {
            addCriterion("PLACE_NAME in", values, "placeName");
            return (Criteria) this;
        }

        public Criteria andPlaceNameNotIn(List<String> values) {
            addCriterion("PLACE_NAME not in", values, "placeName");
            return (Criteria) this;
        }

        public Criteria andPlaceNameBetween(String value1, String value2) {
            addCriterion("PLACE_NAME between", value1, value2, "placeName");
            return (Criteria) this;
        }

        public Criteria andPlaceNameNotBetween(String value1, String value2) {
            addCriterion("PLACE_NAME not between", value1, value2, "placeName");
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

        public Criteria andJiguanIsNull() {
            addCriterion("JIGUAN is null");
            return (Criteria) this;
        }

        public Criteria andJiguanIsNotNull() {
            addCriterion("JIGUAN is not null");
            return (Criteria) this;
        }

        public Criteria andJiguanEqualTo(String value) {
            addCriterion("JIGUAN =", value, "jiguan");
            return (Criteria) this;
        }

        public Criteria andJiguanNotEqualTo(String value) {
            addCriterion("JIGUAN <>", value, "jiguan");
            return (Criteria) this;
        }

        public Criteria andJiguanGreaterThan(String value) {
            addCriterion("JIGUAN >", value, "jiguan");
            return (Criteria) this;
        }

        public Criteria andJiguanGreaterThanOrEqualTo(String value) {
            addCriterion("JIGUAN >=", value, "jiguan");
            return (Criteria) this;
        }

        public Criteria andJiguanLessThan(String value) {
            addCriterion("JIGUAN <", value, "jiguan");
            return (Criteria) this;
        }

        public Criteria andJiguanLessThanOrEqualTo(String value) {
            addCriterion("JIGUAN <=", value, "jiguan");
            return (Criteria) this;
        }

        public Criteria andJiguanLike(String value) {
            addCriterion("JIGUAN like", value, "jiguan");
            return (Criteria) this;
        }

        public Criteria andJiguanNotLike(String value) {
            addCriterion("JIGUAN not like", value, "jiguan");
            return (Criteria) this;
        }

        public Criteria andJiguanIn(List<String> values) {
            addCriterion("JIGUAN in", values, "jiguan");
            return (Criteria) this;
        }

        public Criteria andJiguanNotIn(List<String> values) {
            addCriterion("JIGUAN not in", values, "jiguan");
            return (Criteria) this;
        }

        public Criteria andJiguanBetween(String value1, String value2) {
            addCriterion("JIGUAN between", value1, value2, "jiguan");
            return (Criteria) this;
        }

        public Criteria andJiguanNotBetween(String value1, String value2) {
            addCriterion("JIGUAN not between", value1, value2, "jiguan");
            return (Criteria) this;
        }

        public Criteria andEducationIsNull() {
            addCriterion("EDUCATION is null");
            return (Criteria) this;
        }

        public Criteria andEducationIsNotNull() {
            addCriterion("EDUCATION is not null");
            return (Criteria) this;
        }

        public Criteria andEducationEqualTo(String value) {
            addCriterion("EDUCATION =", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationNotEqualTo(String value) {
            addCriterion("EDUCATION <>", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationGreaterThan(String value) {
            addCriterion("EDUCATION >", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationGreaterThanOrEqualTo(String value) {
            addCriterion("EDUCATION >=", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationLessThan(String value) {
            addCriterion("EDUCATION <", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationLessThanOrEqualTo(String value) {
            addCriterion("EDUCATION <=", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationLike(String value) {
            addCriterion("EDUCATION like", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationNotLike(String value) {
            addCriterion("EDUCATION not like", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationIn(List<String> values) {
            addCriterion("EDUCATION in", values, "education");
            return (Criteria) this;
        }

        public Criteria andEducationNotIn(List<String> values) {
            addCriterion("EDUCATION not in", values, "education");
            return (Criteria) this;
        }

        public Criteria andEducationBetween(String value1, String value2) {
            addCriterion("EDUCATION between", value1, value2, "education");
            return (Criteria) this;
        }

        public Criteria andEducationNotBetween(String value1, String value2) {
            addCriterion("EDUCATION not between", value1, value2, "education");
            return (Criteria) this;
        }

        public Criteria andAgeIsNull() {
            addCriterion("AGE is null");
            return (Criteria) this;
        }

        public Criteria andAgeIsNotNull() {
            addCriterion("AGE is not null");
            return (Criteria) this;
        }

        public Criteria andAgeEqualTo(Integer value) {
            addCriterion("AGE =", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotEqualTo(Integer value) {
            addCriterion("AGE <>", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeGreaterThan(Integer value) {
            addCriterion("AGE >", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeGreaterThanOrEqualTo(Integer value) {
            addCriterion("AGE >=", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeLessThan(Integer value) {
            addCriterion("AGE <", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeLessThanOrEqualTo(Integer value) {
            addCriterion("AGE <=", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeIn(List<Integer> values) {
            addCriterion("AGE in", values, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotIn(List<Integer> values) {
            addCriterion("AGE not in", values, "age");
            return (Criteria) this;
        }

        public Criteria andAgeBetween(Integer value1, Integer value2) {
            addCriterion("AGE between", value1, value2, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotBetween(Integer value1, Integer value2) {
            addCriterion("AGE not between", value1, value2, "age");
            return (Criteria) this;
        }

        public Criteria andDisFlagIsNull() {
            addCriterion("DIS_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andDisFlagIsNotNull() {
            addCriterion("DIS_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andDisFlagEqualTo(Byte value) {
            addCriterion("DIS_FLAG =", value, "disFlag");
            return (Criteria) this;
        }

        public Criteria andDisFlagNotEqualTo(Byte value) {
            addCriterion("DIS_FLAG <>", value, "disFlag");
            return (Criteria) this;
        }

        public Criteria andDisFlagGreaterThan(Byte value) {
            addCriterion("DIS_FLAG >", value, "disFlag");
            return (Criteria) this;
        }

        public Criteria andDisFlagGreaterThanOrEqualTo(Byte value) {
            addCriterion("DIS_FLAG >=", value, "disFlag");
            return (Criteria) this;
        }

        public Criteria andDisFlagLessThan(Byte value) {
            addCriterion("DIS_FLAG <", value, "disFlag");
            return (Criteria) this;
        }

        public Criteria andDisFlagLessThanOrEqualTo(Byte value) {
            addCriterion("DIS_FLAG <=", value, "disFlag");
            return (Criteria) this;
        }

        public Criteria andDisFlagIn(List<Byte> values) {
            addCriterion("DIS_FLAG in", values, "disFlag");
            return (Criteria) this;
        }

        public Criteria andDisFlagNotIn(List<Byte> values) {
            addCriterion("DIS_FLAG not in", values, "disFlag");
            return (Criteria) this;
        }

        public Criteria andDisFlagBetween(Byte value1, Byte value2) {
            addCriterion("DIS_FLAG between", value1, value2, "disFlag");
            return (Criteria) this;
        }

        public Criteria andDisFlagNotBetween(Byte value1, Byte value2) {
            addCriterion("DIS_FLAG not between", value1, value2, "disFlag");
            return (Criteria) this;
        }

        public Criteria andPublishDateIsNull() {
            addCriterion("PUBLISH_DATE is null");
            return (Criteria) this;
        }

        public Criteria andPublishDateIsNotNull() {
            addCriterion("PUBLISH_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andPublishDateEqualTo(Date value) {
            addCriterion("PUBLISH_DATE =", value, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateNotEqualTo(Date value) {
            addCriterion("PUBLISH_DATE <>", value, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateGreaterThan(Date value) {
            addCriterion("PUBLISH_DATE >", value, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateGreaterThanOrEqualTo(Date value) {
            addCriterion("PUBLISH_DATE >=", value, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateLessThan(Date value) {
            addCriterion("PUBLISH_DATE <", value, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateLessThanOrEqualTo(Date value) {
            addCriterion("PUBLISH_DATE <=", value, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateIn(List<Date> values) {
            addCriterion("PUBLISH_DATE in", values, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateNotIn(List<Date> values) {
            addCriterion("PUBLISH_DATE not in", values, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateBetween(Date value1, Date value2) {
            addCriterion("PUBLISH_DATE between", value1, value2, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateNotBetween(Date value1, Date value2) {
            addCriterion("PUBLISH_DATE not between", value1, value2, "publishDate");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("EMAIL is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("EMAIL is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("EMAIL =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("EMAIL <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("EMAIL >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("EMAIL >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("EMAIL <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("EMAIL <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("EMAIL like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("EMAIL not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("EMAIL in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("EMAIL not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("EMAIL between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("EMAIL not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("TITLE is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("TITLE is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("TITLE =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("TITLE <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("TITLE >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("TITLE >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("TITLE <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("TITLE <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("TITLE like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("TITLE not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("TITLE in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("TITLE not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("TITLE between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("TITLE not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andExprTimeIsNull() {
            addCriterion("EXPR_TIME is null");
            return (Criteria) this;
        }

        public Criteria andExprTimeIsNotNull() {
            addCriterion("EXPR_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andExprTimeEqualTo(String value) {
            addCriterion("EXPR_TIME =", value, "exprTime");
            return (Criteria) this;
        }

        public Criteria andExprTimeNotEqualTo(String value) {
            addCriterion("EXPR_TIME <>", value, "exprTime");
            return (Criteria) this;
        }

        public Criteria andExprTimeGreaterThan(String value) {
            addCriterion("EXPR_TIME >", value, "exprTime");
            return (Criteria) this;
        }

        public Criteria andExprTimeGreaterThanOrEqualTo(String value) {
            addCriterion("EXPR_TIME >=", value, "exprTime");
            return (Criteria) this;
        }

        public Criteria andExprTimeLessThan(String value) {
            addCriterion("EXPR_TIME <", value, "exprTime");
            return (Criteria) this;
        }

        public Criteria andExprTimeLessThanOrEqualTo(String value) {
            addCriterion("EXPR_TIME <=", value, "exprTime");
            return (Criteria) this;
        }

        public Criteria andExprTimeLike(String value) {
            addCriterion("EXPR_TIME like", value, "exprTime");
            return (Criteria) this;
        }

        public Criteria andExprTimeNotLike(String value) {
            addCriterion("EXPR_TIME not like", value, "exprTime");
            return (Criteria) this;
        }

        public Criteria andExprTimeIn(List<String> values) {
            addCriterion("EXPR_TIME in", values, "exprTime");
            return (Criteria) this;
        }

        public Criteria andExprTimeNotIn(List<String> values) {
            addCriterion("EXPR_TIME not in", values, "exprTime");
            return (Criteria) this;
        }

        public Criteria andExprTimeBetween(String value1, String value2) {
            addCriterion("EXPR_TIME between", value1, value2, "exprTime");
            return (Criteria) this;
        }

        public Criteria andExprTimeNotBetween(String value1, String value2) {
            addCriterion("EXPR_TIME not between", value1, value2, "exprTime");
            return (Criteria) this;
        }

        public Criteria andIntroduceIsNull() {
            addCriterion("INTRODUCE is null");
            return (Criteria) this;
        }

        public Criteria andIntroduceIsNotNull() {
            addCriterion("INTRODUCE is not null");
            return (Criteria) this;
        }

        public Criteria andIntroduceEqualTo(String value) {
            addCriterion("INTRODUCE =", value, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceNotEqualTo(String value) {
            addCriterion("INTRODUCE <>", value, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceGreaterThan(String value) {
            addCriterion("INTRODUCE >", value, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceGreaterThanOrEqualTo(String value) {
            addCriterion("INTRODUCE >=", value, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceLessThan(String value) {
            addCriterion("INTRODUCE <", value, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceLessThanOrEqualTo(String value) {
            addCriterion("INTRODUCE <=", value, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceLike(String value) {
            addCriterion("INTRODUCE like", value, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceNotLike(String value) {
            addCriterion("INTRODUCE not like", value, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceIn(List<String> values) {
            addCriterion("INTRODUCE in", values, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceNotIn(List<String> values) {
            addCriterion("INTRODUCE not in", values, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceBetween(String value1, String value2) {
            addCriterion("INTRODUCE between", value1, value2, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceNotBetween(String value1, String value2) {
            addCriterion("INTRODUCE not between", value1, value2, "introduce");
            return (Criteria) this;
        }

        public Criteria andSlyBeginIsNull() {
            addCriterion("SLY_BEGIN is null");
            return (Criteria) this;
        }

        public Criteria andSlyBeginIsNotNull() {
            addCriterion("SLY_BEGIN is not null");
            return (Criteria) this;
        }

        public Criteria andSlyBeginEqualTo(Integer value) {
            addCriterion("SLY_BEGIN =", value, "slyBegin");
            return (Criteria) this;
        }

        public Criteria andSlyBeginNotEqualTo(Integer value) {
            addCriterion("SLY_BEGIN <>", value, "slyBegin");
            return (Criteria) this;
        }

        public Criteria andSlyBeginGreaterThan(Integer value) {
            addCriterion("SLY_BEGIN >", value, "slyBegin");
            return (Criteria) this;
        }

        public Criteria andSlyBeginGreaterThanOrEqualTo(Integer value) {
            addCriterion("SLY_BEGIN >=", value, "slyBegin");
            return (Criteria) this;
        }

        public Criteria andSlyBeginLessThan(Integer value) {
            addCriterion("SLY_BEGIN <", value, "slyBegin");
            return (Criteria) this;
        }

        public Criteria andSlyBeginLessThanOrEqualTo(Integer value) {
            addCriterion("SLY_BEGIN <=", value, "slyBegin");
            return (Criteria) this;
        }

        public Criteria andSlyBeginIn(List<Integer> values) {
            addCriterion("SLY_BEGIN in", values, "slyBegin");
            return (Criteria) this;
        }

        public Criteria andSlyBeginNotIn(List<Integer> values) {
            addCriterion("SLY_BEGIN not in", values, "slyBegin");
            return (Criteria) this;
        }

        public Criteria andSlyBeginBetween(Integer value1, Integer value2) {
            addCriterion("SLY_BEGIN between", value1, value2, "slyBegin");
            return (Criteria) this;
        }

        public Criteria andSlyBeginNotBetween(Integer value1, Integer value2) {
            addCriterion("SLY_BEGIN not between", value1, value2, "slyBegin");
            return (Criteria) this;
        }

        public Criteria andSlyEndIsNull() {
            addCriterion("SLY_END is null");
            return (Criteria) this;
        }

        public Criteria andSlyEndIsNotNull() {
            addCriterion("SLY_END is not null");
            return (Criteria) this;
        }

        public Criteria andSlyEndEqualTo(Integer value) {
            addCriterion("SLY_END =", value, "slyEnd");
            return (Criteria) this;
        }

        public Criteria andSlyEndNotEqualTo(Integer value) {
            addCriterion("SLY_END <>", value, "slyEnd");
            return (Criteria) this;
        }

        public Criteria andSlyEndGreaterThan(Integer value) {
            addCriterion("SLY_END >", value, "slyEnd");
            return (Criteria) this;
        }

        public Criteria andSlyEndGreaterThanOrEqualTo(Integer value) {
            addCriterion("SLY_END >=", value, "slyEnd");
            return (Criteria) this;
        }

        public Criteria andSlyEndLessThan(Integer value) {
            addCriterion("SLY_END <", value, "slyEnd");
            return (Criteria) this;
        }

        public Criteria andSlyEndLessThanOrEqualTo(Integer value) {
            addCriterion("SLY_END <=", value, "slyEnd");
            return (Criteria) this;
        }

        public Criteria andSlyEndIn(List<Integer> values) {
            addCriterion("SLY_END in", values, "slyEnd");
            return (Criteria) this;
        }

        public Criteria andSlyEndNotIn(List<Integer> values) {
            addCriterion("SLY_END not in", values, "slyEnd");
            return (Criteria) this;
        }

        public Criteria andSlyEndBetween(Integer value1, Integer value2) {
            addCriterion("SLY_END between", value1, value2, "slyEnd");
            return (Criteria) this;
        }

        public Criteria andSlyEndNotBetween(Integer value1, Integer value2) {
            addCriterion("SLY_END not between", value1, value2, "slyEnd");
            return (Criteria) this;
        }

        public Criteria andWorkTypeNameIsNull() {
            addCriterion("WORK_TYPE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andWorkTypeNameIsNotNull() {
            addCriterion("WORK_TYPE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andWorkTypeNameEqualTo(String value) {
            addCriterion("WORK_TYPE_NAME =", value, "workTypeName");
            return (Criteria) this;
        }

        public Criteria andWorkTypeNameNotEqualTo(String value) {
            addCriterion("WORK_TYPE_NAME <>", value, "workTypeName");
            return (Criteria) this;
        }

        public Criteria andWorkTypeNameGreaterThan(String value) {
            addCriterion("WORK_TYPE_NAME >", value, "workTypeName");
            return (Criteria) this;
        }

        public Criteria andWorkTypeNameGreaterThanOrEqualTo(String value) {
            addCriterion("WORK_TYPE_NAME >=", value, "workTypeName");
            return (Criteria) this;
        }

        public Criteria andWorkTypeNameLessThan(String value) {
            addCriterion("WORK_TYPE_NAME <", value, "workTypeName");
            return (Criteria) this;
        }

        public Criteria andWorkTypeNameLessThanOrEqualTo(String value) {
            addCriterion("WORK_TYPE_NAME <=", value, "workTypeName");
            return (Criteria) this;
        }

        public Criteria andWorkTypeNameLike(String value) {
            addCriterion("WORK_TYPE_NAME like", value, "workTypeName");
            return (Criteria) this;
        }

        public Criteria andWorkTypeNameNotLike(String value) {
            addCriterion("WORK_TYPE_NAME not like", value, "workTypeName");
            return (Criteria) this;
        }

        public Criteria andWorkTypeNameIn(List<String> values) {
            addCriterion("WORK_TYPE_NAME in", values, "workTypeName");
            return (Criteria) this;
        }

        public Criteria andWorkTypeNameNotIn(List<String> values) {
            addCriterion("WORK_TYPE_NAME not in", values, "workTypeName");
            return (Criteria) this;
        }

        public Criteria andWorkTypeNameBetween(String value1, String value2) {
            addCriterion("WORK_TYPE_NAME between", value1, value2, "workTypeName");
            return (Criteria) this;
        }

        public Criteria andWorkTypeNameNotBetween(String value1, String value2) {
            addCriterion("WORK_TYPE_NAME not between", value1, value2, "workTypeName");
            return (Criteria) this;
        }

        public Criteria andWorkTypeIdFkIsNull() {
            addCriterion("WORK_TYPE_ID_FK is null");
            return (Criteria) this;
        }

        public Criteria andWorkTypeIdFkIsNotNull() {
            addCriterion("WORK_TYPE_ID_FK is not null");
            return (Criteria) this;
        }

        public Criteria andWorkTypeIdFkEqualTo(String value) {
            addCriterion("WORK_TYPE_ID_FK =", value, "workTypeIdFk");
            return (Criteria) this;
        }

        public Criteria andWorkTypeIdFkNotEqualTo(String value) {
            addCriterion("WORK_TYPE_ID_FK <>", value, "workTypeIdFk");
            return (Criteria) this;
        }

        public Criteria andWorkTypeIdFkGreaterThan(String value) {
            addCriterion("WORK_TYPE_ID_FK >", value, "workTypeIdFk");
            return (Criteria) this;
        }

        public Criteria andWorkTypeIdFkGreaterThanOrEqualTo(String value) {
            addCriterion("WORK_TYPE_ID_FK >=", value, "workTypeIdFk");
            return (Criteria) this;
        }

        public Criteria andWorkTypeIdFkLessThan(String value) {
            addCriterion("WORK_TYPE_ID_FK <", value, "workTypeIdFk");
            return (Criteria) this;
        }

        public Criteria andWorkTypeIdFkLessThanOrEqualTo(String value) {
            addCriterion("WORK_TYPE_ID_FK <=", value, "workTypeIdFk");
            return (Criteria) this;
        }

        public Criteria andWorkTypeIdFkLike(String value) {
            addCriterion("WORK_TYPE_ID_FK like", value, "workTypeIdFk");
            return (Criteria) this;
        }

        public Criteria andWorkTypeIdFkNotLike(String value) {
            addCriterion("WORK_TYPE_ID_FK not like", value, "workTypeIdFk");
            return (Criteria) this;
        }

        public Criteria andWorkTypeIdFkIn(List<String> values) {
            addCriterion("WORK_TYPE_ID_FK in", values, "workTypeIdFk");
            return (Criteria) this;
        }

        public Criteria andWorkTypeIdFkNotIn(List<String> values) {
            addCriterion("WORK_TYPE_ID_FK not in", values, "workTypeIdFk");
            return (Criteria) this;
        }

        public Criteria andWorkTypeIdFkBetween(String value1, String value2) {
            addCriterion("WORK_TYPE_ID_FK between", value1, value2, "workTypeIdFk");
            return (Criteria) this;
        }

        public Criteria andWorkTypeIdFkNotBetween(String value1, String value2) {
            addCriterion("WORK_TYPE_ID_FK not between", value1, value2, "workTypeIdFk");
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

        public Criteria andResumeTitleIsNull() {
            addCriterion("RESUME_TITLE is null");
            return (Criteria) this;
        }

        public Criteria andResumeTitleIsNotNull() {
            addCriterion("RESUME_TITLE is not null");
            return (Criteria) this;
        }

        public Criteria andResumeTitleEqualTo(String value) {
            addCriterion("RESUME_TITLE =", value, "resumeTitle");
            return (Criteria) this;
        }

        public Criteria andResumeTitleNotEqualTo(String value) {
            addCriterion("RESUME_TITLE <>", value, "resumeTitle");
            return (Criteria) this;
        }

        public Criteria andResumeTitleGreaterThan(String value) {
            addCriterion("RESUME_TITLE >", value, "resumeTitle");
            return (Criteria) this;
        }

        public Criteria andResumeTitleGreaterThanOrEqualTo(String value) {
            addCriterion("RESUME_TITLE >=", value, "resumeTitle");
            return (Criteria) this;
        }

        public Criteria andResumeTitleLessThan(String value) {
            addCriterion("RESUME_TITLE <", value, "resumeTitle");
            return (Criteria) this;
        }

        public Criteria andResumeTitleLessThanOrEqualTo(String value) {
            addCriterion("RESUME_TITLE <=", value, "resumeTitle");
            return (Criteria) this;
        }

        public Criteria andResumeTitleLike(String value) {
            addCriterion("RESUME_TITLE like", value, "resumeTitle");
            return (Criteria) this;
        }

        public Criteria andResumeTitleNotLike(String value) {
            addCriterion("RESUME_TITLE not like", value, "resumeTitle");
            return (Criteria) this;
        }

        public Criteria andResumeTitleIn(List<String> values) {
            addCriterion("RESUME_TITLE in", values, "resumeTitle");
            return (Criteria) this;
        }

        public Criteria andResumeTitleNotIn(List<String> values) {
            addCriterion("RESUME_TITLE not in", values, "resumeTitle");
            return (Criteria) this;
        }

        public Criteria andResumeTitleBetween(String value1, String value2) {
            addCriterion("RESUME_TITLE between", value1, value2, "resumeTitle");
            return (Criteria) this;
        }

        public Criteria andResumeTitleNotBetween(String value1, String value2) {
            addCriterion("RESUME_TITLE not between", value1, value2, "resumeTitle");
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