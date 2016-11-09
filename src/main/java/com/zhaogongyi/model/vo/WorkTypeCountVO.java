package com.zhaogongyi.model.vo;
/**
 * 这个类是除了WorkType表字段外,可能还会根据功能拓展,增加计数的字段
 * @author Administrator
 *
 */
public class WorkTypeCountVO {
	private String workTypeName;
	private String workTypeId;
	private String orderId;// 排序
	private Integer count;//
	private String isChild;
	private String pid;// 父id
	private Short hierarchy;
	
	public String getWorkTypeName() {
		return workTypeName;
	}
	public void setWorkTypeName(String workTypeName) {
		this.workTypeName = workTypeName;
	}
	public String getWorkTypeId() {
		return workTypeId;
	}
	public void setWorkTypeId(String workTypeId) {
		this.workTypeId = workTypeId;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public String getIsChild() {
		return isChild;
	}
	public void setIsChild(String isChild) {
		this.isChild = isChild;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public Short getHierarchy() {
		return hierarchy;
	}
	public void setHierarchy(Short hierarchy) {
		this.hierarchy = hierarchy;
	}
}
