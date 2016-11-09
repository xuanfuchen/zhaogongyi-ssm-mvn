package com.zhaogongyi.model;

import java.util.ArrayList;
import java.util.List;

public class WorkTypeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WorkTypeExample() {
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

        public Criteria andWorkTypeIdIsNull() {
            addCriterion("WORK_TYPE_ID is null");
            return (Criteria) this;
        }

        public Criteria andWorkTypeIdIsNotNull() {
            addCriterion("WORK_TYPE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andWorkTypeIdEqualTo(String value) {
            addCriterion("WORK_TYPE_ID =", value, "workTypeId");
            return (Criteria) this;
        }

        public Criteria andWorkTypeIdNotEqualTo(String value) {
            addCriterion("WORK_TYPE_ID <>", value, "workTypeId");
            return (Criteria) this;
        }

        public Criteria andWorkTypeIdGreaterThan(String value) {
            addCriterion("WORK_TYPE_ID >", value, "workTypeId");
            return (Criteria) this;
        }

        public Criteria andWorkTypeIdGreaterThanOrEqualTo(String value) {
            addCriterion("WORK_TYPE_ID >=", value, "workTypeId");
            return (Criteria) this;
        }

        public Criteria andWorkTypeIdLessThan(String value) {
            addCriterion("WORK_TYPE_ID <", value, "workTypeId");
            return (Criteria) this;
        }

        public Criteria andWorkTypeIdLessThanOrEqualTo(String value) {
            addCriterion("WORK_TYPE_ID <=", value, "workTypeId");
            return (Criteria) this;
        }

        public Criteria andWorkTypeIdLike(String value) {
            addCriterion("WORK_TYPE_ID like", value, "workTypeId");
            return (Criteria) this;
        }

        public Criteria andWorkTypeIdNotLike(String value) {
            addCriterion("WORK_TYPE_ID not like", value, "workTypeId");
            return (Criteria) this;
        }

        public Criteria andWorkTypeIdIn(List<String> values) {
            addCriterion("WORK_TYPE_ID in", values, "workTypeId");
            return (Criteria) this;
        }

        public Criteria andWorkTypeIdNotIn(List<String> values) {
            addCriterion("WORK_TYPE_ID not in", values, "workTypeId");
            return (Criteria) this;
        }

        public Criteria andWorkTypeIdBetween(String value1, String value2) {
            addCriterion("WORK_TYPE_ID between", value1, value2, "workTypeId");
            return (Criteria) this;
        }

        public Criteria andWorkTypeIdNotBetween(String value1, String value2) {
            addCriterion("WORK_TYPE_ID not between", value1, value2, "workTypeId");
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

        public Criteria andParentIdIsNull() {
            addCriterion("PARENT_ID is null");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNotNull() {
            addCriterion("PARENT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andParentIdEqualTo(String value) {
            addCriterion("PARENT_ID =", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotEqualTo(String value) {
            addCriterion("PARENT_ID <>", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThan(String value) {
            addCriterion("PARENT_ID >", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThanOrEqualTo(String value) {
            addCriterion("PARENT_ID >=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThan(String value) {
            addCriterion("PARENT_ID <", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThanOrEqualTo(String value) {
            addCriterion("PARENT_ID <=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLike(String value) {
            addCriterion("PARENT_ID like", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotLike(String value) {
            addCriterion("PARENT_ID not like", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdIn(List<String> values) {
            addCriterion("PARENT_ID in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotIn(List<String> values) {
            addCriterion("PARENT_ID not in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdBetween(String value1, String value2) {
            addCriterion("PARENT_ID between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotBetween(String value1, String value2) {
            addCriterion("PARENT_ID not between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andHierarchyIsNull() {
            addCriterion("HIERARCHY is null");
            return (Criteria) this;
        }

        public Criteria andHierarchyIsNotNull() {
            addCriterion("HIERARCHY is not null");
            return (Criteria) this;
        }

        public Criteria andHierarchyEqualTo(Short value) {
            addCriterion("HIERARCHY =", value, "hierarchy");
            return (Criteria) this;
        }

        public Criteria andHierarchyNotEqualTo(Short value) {
            addCriterion("HIERARCHY <>", value, "hierarchy");
            return (Criteria) this;
        }

        public Criteria andHierarchyGreaterThan(Short value) {
            addCriterion("HIERARCHY >", value, "hierarchy");
            return (Criteria) this;
        }

        public Criteria andHierarchyGreaterThanOrEqualTo(Short value) {
            addCriterion("HIERARCHY >=", value, "hierarchy");
            return (Criteria) this;
        }

        public Criteria andHierarchyLessThan(Short value) {
            addCriterion("HIERARCHY <", value, "hierarchy");
            return (Criteria) this;
        }

        public Criteria andHierarchyLessThanOrEqualTo(Short value) {
            addCriterion("HIERARCHY <=", value, "hierarchy");
            return (Criteria) this;
        }

        public Criteria andHierarchyIn(List<Short> values) {
            addCriterion("HIERARCHY in", values, "hierarchy");
            return (Criteria) this;
        }

        public Criteria andHierarchyNotIn(List<Short> values) {
            addCriterion("HIERARCHY not in", values, "hierarchy");
            return (Criteria) this;
        }

        public Criteria andHierarchyBetween(Short value1, Short value2) {
            addCriterion("HIERARCHY between", value1, value2, "hierarchy");
            return (Criteria) this;
        }

        public Criteria andHierarchyNotBetween(Short value1, Short value2) {
            addCriterion("HIERARCHY not between", value1, value2, "hierarchy");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNull() {
            addCriterion("ORDER_ID is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("ORDER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(String value) {
            addCriterion("ORDER_ID =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(String value) {
            addCriterion("ORDER_ID <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(String value) {
            addCriterion("ORDER_ID >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(String value) {
            addCriterion("ORDER_ID >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(String value) {
            addCriterion("ORDER_ID <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(String value) {
            addCriterion("ORDER_ID <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLike(String value) {
            addCriterion("ORDER_ID like", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotLike(String value) {
            addCriterion("ORDER_ID not like", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<String> values) {
            addCriterion("ORDER_ID in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<String> values) {
            addCriterion("ORDER_ID not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(String value1, String value2) {
            addCriterion("ORDER_ID between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(String value1, String value2) {
            addCriterion("ORDER_ID not between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andIsChildIsNull() {
            addCriterion("IS_CHILD is null");
            return (Criteria) this;
        }

        public Criteria andIsChildIsNotNull() {
            addCriterion("IS_CHILD is not null");
            return (Criteria) this;
        }

        public Criteria andIsChildEqualTo(String value) {
            addCriterion("IS_CHILD =", value, "isChild");
            return (Criteria) this;
        }

        public Criteria andIsChildNotEqualTo(String value) {
            addCriterion("IS_CHILD <>", value, "isChild");
            return (Criteria) this;
        }

        public Criteria andIsChildGreaterThan(String value) {
            addCriterion("IS_CHILD >", value, "isChild");
            return (Criteria) this;
        }

        public Criteria andIsChildGreaterThanOrEqualTo(String value) {
            addCriterion("IS_CHILD >=", value, "isChild");
            return (Criteria) this;
        }

        public Criteria andIsChildLessThan(String value) {
            addCriterion("IS_CHILD <", value, "isChild");
            return (Criteria) this;
        }

        public Criteria andIsChildLessThanOrEqualTo(String value) {
            addCriterion("IS_CHILD <=", value, "isChild");
            return (Criteria) this;
        }

        public Criteria andIsChildLike(String value) {
            addCriterion("IS_CHILD like", value, "isChild");
            return (Criteria) this;
        }

        public Criteria andIsChildNotLike(String value) {
            addCriterion("IS_CHILD not like", value, "isChild");
            return (Criteria) this;
        }

        public Criteria andIsChildIn(List<String> values) {
            addCriterion("IS_CHILD in", values, "isChild");
            return (Criteria) this;
        }

        public Criteria andIsChildNotIn(List<String> values) {
            addCriterion("IS_CHILD not in", values, "isChild");
            return (Criteria) this;
        }

        public Criteria andIsChildBetween(String value1, String value2) {
            addCriterion("IS_CHILD between", value1, value2, "isChild");
            return (Criteria) this;
        }

        public Criteria andIsChildNotBetween(String value1, String value2) {
            addCriterion("IS_CHILD not between", value1, value2, "isChild");
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