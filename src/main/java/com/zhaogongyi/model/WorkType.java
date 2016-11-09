package com.zhaogongyi.model;

import java.io.Serializable;

public class WorkType implements Serializable {
    private String workTypeId;

    private String name;

    private String parentId;

    private Short hierarchy;

    private String orderId;

    private String isChild;

    private static final long serialVersionUID = 1L;

    public String getWorkTypeId() {
        return workTypeId;
    }

    public void setWorkTypeId(String workTypeId) {
        this.workTypeId = workTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public Short getHierarchy() {
        return hierarchy;
    }

    public void setHierarchy(Short hierarchy) {
        this.hierarchy = hierarchy;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getIsChild() {
        return isChild;
    }

    public void setIsChild(String isChild) {
        this.isChild = isChild;
    }
}