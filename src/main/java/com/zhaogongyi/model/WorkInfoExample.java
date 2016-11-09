package com.zhaogongyi.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WorkInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WorkInfoExample() {
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

        public Criteria andWorkIdIsNull() {
            addCriterion("WORK_ID is null");
            return (Criteria) this;
        }

        public Criteria andWorkIdIsNotNull() {
            addCriterion("WORK_ID is not null");
            return (Criteria) this;
        }

        public Criteria andWorkIdEqualTo(Integer value) {
            addCriterion("WORK_ID =", value, "workId");
            return (Criteria) this;
        }

        public Criteria andWorkIdNotEqualTo(Integer value) {
            addCriterion("WORK_ID <>", value, "workId");
            return (Criteria) this;
        }

        public Criteria andWorkIdGreaterThan(Integer value) {
            addCriterion("WORK_ID >", value, "workId");
            return (Criteria) this;
        }

        public Criteria andWorkIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("WORK_ID >=", value, "workId");
            return (Criteria) this;
        }

        public Criteria andWorkIdLessThan(Integer value) {
            addCriterion("WORK_ID <", value, "workId");
            return (Criteria) this;
        }

        public Criteria andWorkIdLessThanOrEqualTo(Integer value) {
            addCriterion("WORK_ID <=", value, "workId");
            return (Criteria) this;
        }

        public Criteria andWorkIdIn(List<Integer> values) {
            addCriterion("WORK_ID in", values, "workId");
            return (Criteria) this;
        }

        public Criteria andWorkIdNotIn(List<Integer> values) {
            addCriterion("WORK_ID not in", values, "workId");
            return (Criteria) this;
        }

        public Criteria andWorkIdBetween(Integer value1, Integer value2) {
            addCriterion("WORK_ID between", value1, value2, "workId");
            return (Criteria) this;
        }

        public Criteria andWorkIdNotBetween(Integer value1, Integer value2) {
            addCriterion("WORK_ID not between", value1, value2, "workId");
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

        public Criteria andNumIsNull() {
            addCriterion("NUM is null");
            return (Criteria) this;
        }

        public Criteria andNumIsNotNull() {
            addCriterion("NUM is not null");
            return (Criteria) this;
        }

        public Criteria andNumEqualTo(Integer value) {
            addCriterion("NUM =", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotEqualTo(Integer value) {
            addCriterion("NUM <>", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumGreaterThan(Integer value) {
            addCriterion("NUM >", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("NUM >=", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumLessThan(Integer value) {
            addCriterion("NUM <", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumLessThanOrEqualTo(Integer value) {
            addCriterion("NUM <=", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumIn(List<Integer> values) {
            addCriterion("NUM in", values, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotIn(List<Integer> values) {
            addCriterion("NUM not in", values, "num");
            return (Criteria) this;
        }

        public Criteria andNumBetween(Integer value1, Integer value2) {
            addCriterion("NUM between", value1, value2, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotBetween(Integer value1, Integer value2) {
            addCriterion("NUM not between", value1, value2, "num");
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

        public Criteria andSlyBeginIsNull() {
            addCriterion("SLY_BEGIN is null");
            return (Criteria) this;
        }

        public Criteria andSlyBeginIsNotNull() {
            addCriterion("SLY_BEGIN is not null");
            return (Criteria) this;
        }

        public Criteria andSlyBeginEqualTo(String value) {
            addCriterion("SLY_BEGIN =", value, "slyBegin");
            return (Criteria) this;
        }

        public Criteria andSlyBeginNotEqualTo(String value) {
            addCriterion("SLY_BEGIN <>", value, "slyBegin");
            return (Criteria) this;
        }

        public Criteria andSlyBeginGreaterThan(String value) {
            addCriterion("SLY_BEGIN >", value, "slyBegin");
            return (Criteria) this;
        }

        public Criteria andSlyBeginGreaterThanOrEqualTo(String value) {
            addCriterion("SLY_BEGIN >=", value, "slyBegin");
            return (Criteria) this;
        }

        public Criteria andSlyBeginLessThan(String value) {
            addCriterion("SLY_BEGIN <", value, "slyBegin");
            return (Criteria) this;
        }

        public Criteria andSlyBeginLessThanOrEqualTo(String value) {
            addCriterion("SLY_BEGIN <=", value, "slyBegin");
            return (Criteria) this;
        }

        public Criteria andSlyBeginLike(String value) {
            addCriterion("SLY_BEGIN like", value, "slyBegin");
            return (Criteria) this;
        }

        public Criteria andSlyBeginNotLike(String value) {
            addCriterion("SLY_BEGIN not like", value, "slyBegin");
            return (Criteria) this;
        }

        public Criteria andSlyBeginIn(List<String> values) {
            addCriterion("SLY_BEGIN in", values, "slyBegin");
            return (Criteria) this;
        }

        public Criteria andSlyBeginNotIn(List<String> values) {
            addCriterion("SLY_BEGIN not in", values, "slyBegin");
            return (Criteria) this;
        }

        public Criteria andSlyBeginBetween(String value1, String value2) {
            addCriterion("SLY_BEGIN between", value1, value2, "slyBegin");
            return (Criteria) this;
        }

        public Criteria andSlyBeginNotBetween(String value1, String value2) {
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

        public Criteria andSlyEndEqualTo(String value) {
            addCriterion("SLY_END =", value, "slyEnd");
            return (Criteria) this;
        }

        public Criteria andSlyEndNotEqualTo(String value) {
            addCriterion("SLY_END <>", value, "slyEnd");
            return (Criteria) this;
        }

        public Criteria andSlyEndGreaterThan(String value) {
            addCriterion("SLY_END >", value, "slyEnd");
            return (Criteria) this;
        }

        public Criteria andSlyEndGreaterThanOrEqualTo(String value) {
            addCriterion("SLY_END >=", value, "slyEnd");
            return (Criteria) this;
        }

        public Criteria andSlyEndLessThan(String value) {
            addCriterion("SLY_END <", value, "slyEnd");
            return (Criteria) this;
        }

        public Criteria andSlyEndLessThanOrEqualTo(String value) {
            addCriterion("SLY_END <=", value, "slyEnd");
            return (Criteria) this;
        }

        public Criteria andSlyEndLike(String value) {
            addCriterion("SLY_END like", value, "slyEnd");
            return (Criteria) this;
        }

        public Criteria andSlyEndNotLike(String value) {
            addCriterion("SLY_END not like", value, "slyEnd");
            return (Criteria) this;
        }

        public Criteria andSlyEndIn(List<String> values) {
            addCriterion("SLY_END in", values, "slyEnd");
            return (Criteria) this;
        }

        public Criteria andSlyEndNotIn(List<String> values) {
            addCriterion("SLY_END not in", values, "slyEnd");
            return (Criteria) this;
        }

        public Criteria andSlyEndBetween(String value1, String value2) {
            addCriterion("SLY_END between", value1, value2, "slyEnd");
            return (Criteria) this;
        }

        public Criteria andSlyEndNotBetween(String value1, String value2) {
            addCriterion("SLY_END not between", value1, value2, "slyEnd");
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

        public Criteria andContactPersonIsNull() {
            addCriterion("CONTACT_PERSON is null");
            return (Criteria) this;
        }

        public Criteria andContactPersonIsNotNull() {
            addCriterion("CONTACT_PERSON is not null");
            return (Criteria) this;
        }

        public Criteria andContactPersonEqualTo(String value) {
            addCriterion("CONTACT_PERSON =", value, "contactPerson");
            return (Criteria) this;
        }

        public Criteria andContactPersonNotEqualTo(String value) {
            addCriterion("CONTACT_PERSON <>", value, "contactPerson");
            return (Criteria) this;
        }

        public Criteria andContactPersonGreaterThan(String value) {
            addCriterion("CONTACT_PERSON >", value, "contactPerson");
            return (Criteria) this;
        }

        public Criteria andContactPersonGreaterThanOrEqualTo(String value) {
            addCriterion("CONTACT_PERSON >=", value, "contactPerson");
            return (Criteria) this;
        }

        public Criteria andContactPersonLessThan(String value) {
            addCriterion("CONTACT_PERSON <", value, "contactPerson");
            return (Criteria) this;
        }

        public Criteria andContactPersonLessThanOrEqualTo(String value) {
            addCriterion("CONTACT_PERSON <=", value, "contactPerson");
            return (Criteria) this;
        }

        public Criteria andContactPersonLike(String value) {
            addCriterion("CONTACT_PERSON like", value, "contactPerson");
            return (Criteria) this;
        }

        public Criteria andContactPersonNotLike(String value) {
            addCriterion("CONTACT_PERSON not like", value, "contactPerson");
            return (Criteria) this;
        }

        public Criteria andContactPersonIn(List<String> values) {
            addCriterion("CONTACT_PERSON in", values, "contactPerson");
            return (Criteria) this;
        }

        public Criteria andContactPersonNotIn(List<String> values) {
            addCriterion("CONTACT_PERSON not in", values, "contactPerson");
            return (Criteria) this;
        }

        public Criteria andContactPersonBetween(String value1, String value2) {
            addCriterion("CONTACT_PERSON between", value1, value2, "contactPerson");
            return (Criteria) this;
        }

        public Criteria andContactPersonNotBetween(String value1, String value2) {
            addCriterion("CONTACT_PERSON not between", value1, value2, "contactPerson");
            return (Criteria) this;
        }

        public Criteria andContactPhoneIsNull() {
            addCriterion("CONTACT_PHONE is null");
            return (Criteria) this;
        }

        public Criteria andContactPhoneIsNotNull() {
            addCriterion("CONTACT_PHONE is not null");
            return (Criteria) this;
        }

        public Criteria andContactPhoneEqualTo(String value) {
            addCriterion("CONTACT_PHONE =", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneNotEqualTo(String value) {
            addCriterion("CONTACT_PHONE <>", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneGreaterThan(String value) {
            addCriterion("CONTACT_PHONE >", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("CONTACT_PHONE >=", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneLessThan(String value) {
            addCriterion("CONTACT_PHONE <", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneLessThanOrEqualTo(String value) {
            addCriterion("CONTACT_PHONE <=", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneLike(String value) {
            addCriterion("CONTACT_PHONE like", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneNotLike(String value) {
            addCriterion("CONTACT_PHONE not like", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneIn(List<String> values) {
            addCriterion("CONTACT_PHONE in", values, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneNotIn(List<String> values) {
            addCriterion("CONTACT_PHONE not in", values, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneBetween(String value1, String value2) {
            addCriterion("CONTACT_PHONE between", value1, value2, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneNotBetween(String value1, String value2) {
            addCriterion("CONTACT_PHONE not between", value1, value2, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andWorkEmailIsNull() {
            addCriterion("WORK_EMAIL is null");
            return (Criteria) this;
        }

        public Criteria andWorkEmailIsNotNull() {
            addCriterion("WORK_EMAIL is not null");
            return (Criteria) this;
        }

        public Criteria andWorkEmailEqualTo(String value) {
            addCriterion("WORK_EMAIL =", value, "workEmail");
            return (Criteria) this;
        }

        public Criteria andWorkEmailNotEqualTo(String value) {
            addCriterion("WORK_EMAIL <>", value, "workEmail");
            return (Criteria) this;
        }

        public Criteria andWorkEmailGreaterThan(String value) {
            addCriterion("WORK_EMAIL >", value, "workEmail");
            return (Criteria) this;
        }

        public Criteria andWorkEmailGreaterThanOrEqualTo(String value) {
            addCriterion("WORK_EMAIL >=", value, "workEmail");
            return (Criteria) this;
        }

        public Criteria andWorkEmailLessThan(String value) {
            addCriterion("WORK_EMAIL <", value, "workEmail");
            return (Criteria) this;
        }

        public Criteria andWorkEmailLessThanOrEqualTo(String value) {
            addCriterion("WORK_EMAIL <=", value, "workEmail");
            return (Criteria) this;
        }

        public Criteria andWorkEmailLike(String value) {
            addCriterion("WORK_EMAIL like", value, "workEmail");
            return (Criteria) this;
        }

        public Criteria andWorkEmailNotLike(String value) {
            addCriterion("WORK_EMAIL not like", value, "workEmail");
            return (Criteria) this;
        }

        public Criteria andWorkEmailIn(List<String> values) {
            addCriterion("WORK_EMAIL in", values, "workEmail");
            return (Criteria) this;
        }

        public Criteria andWorkEmailNotIn(List<String> values) {
            addCriterion("WORK_EMAIL not in", values, "workEmail");
            return (Criteria) this;
        }

        public Criteria andWorkEmailBetween(String value1, String value2) {
            addCriterion("WORK_EMAIL between", value1, value2, "workEmail");
            return (Criteria) this;
        }

        public Criteria andWorkEmailNotBetween(String value1, String value2) {
            addCriterion("WORK_EMAIL not between", value1, value2, "workEmail");
            return (Criteria) this;
        }

        public Criteria andCompanyIdFkIsNull() {
            addCriterion("COMPANY_ID_FK is null");
            return (Criteria) this;
        }

        public Criteria andCompanyIdFkIsNotNull() {
            addCriterion("COMPANY_ID_FK is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyIdFkEqualTo(Integer value) {
            addCriterion("COMPANY_ID_FK =", value, "companyIdFk");
            return (Criteria) this;
        }

        public Criteria andCompanyIdFkNotEqualTo(Integer value) {
            addCriterion("COMPANY_ID_FK <>", value, "companyIdFk");
            return (Criteria) this;
        }

        public Criteria andCompanyIdFkGreaterThan(Integer value) {
            addCriterion("COMPANY_ID_FK >", value, "companyIdFk");
            return (Criteria) this;
        }

        public Criteria andCompanyIdFkGreaterThanOrEqualTo(Integer value) {
            addCriterion("COMPANY_ID_FK >=", value, "companyIdFk");
            return (Criteria) this;
        }

        public Criteria andCompanyIdFkLessThan(Integer value) {
            addCriterion("COMPANY_ID_FK <", value, "companyIdFk");
            return (Criteria) this;
        }

        public Criteria andCompanyIdFkLessThanOrEqualTo(Integer value) {
            addCriterion("COMPANY_ID_FK <=", value, "companyIdFk");
            return (Criteria) this;
        }

        public Criteria andCompanyIdFkIn(List<Integer> values) {
            addCriterion("COMPANY_ID_FK in", values, "companyIdFk");
            return (Criteria) this;
        }

        public Criteria andCompanyIdFkNotIn(List<Integer> values) {
            addCriterion("COMPANY_ID_FK not in", values, "companyIdFk");
            return (Criteria) this;
        }

        public Criteria andCompanyIdFkBetween(Integer value1, Integer value2) {
            addCriterion("COMPANY_ID_FK between", value1, value2, "companyIdFk");
            return (Criteria) this;
        }

        public Criteria andCompanyIdFkNotBetween(Integer value1, Integer value2) {
            addCriterion("COMPANY_ID_FK not between", value1, value2, "companyIdFk");
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

        public Criteria andCompanyNameIsNull() {
            addCriterion("COMPANY_NAME is null");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIsNotNull() {
            addCriterion("COMPANY_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyNameEqualTo(String value) {
            addCriterion("COMPANY_NAME =", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotEqualTo(String value) {
            addCriterion("COMPANY_NAME <>", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameGreaterThan(String value) {
            addCriterion("COMPANY_NAME >", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameGreaterThanOrEqualTo(String value) {
            addCriterion("COMPANY_NAME >=", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLessThan(String value) {
            addCriterion("COMPANY_NAME <", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLessThanOrEqualTo(String value) {
            addCriterion("COMPANY_NAME <=", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLike(String value) {
            addCriterion("COMPANY_NAME like", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotLike(String value) {
            addCriterion("COMPANY_NAME not like", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIn(List<String> values) {
            addCriterion("COMPANY_NAME in", values, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotIn(List<String> values) {
            addCriterion("COMPANY_NAME not in", values, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameBetween(String value1, String value2) {
            addCriterion("COMPANY_NAME between", value1, value2, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotBetween(String value1, String value2) {
            addCriterion("COMPANY_NAME not between", value1, value2, "companyName");
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