package com.zhaogongyi.model.vo;

public class AdminQueryCond {
	// 简历
	private Integer resumeId;
	private String fullName;
	private String introduce;
	private String title;// 简历 工作 共用
	private String placeId;// 简历 工作 共用
	private String publishDateBegin;// 简历 工作 共用
	private String publishDateEnd;// 简历 工作 共用
	
	
	
	// 工作
	private Integer workId;
	// title
	// placeId
	private String companyName;// 工作 公司 共用
	
	
	
	// 公司
	private Integer companyId;
	// companyName
	private String remark;
	
	
	
	
	
	
	
	
	
	
	
	
	
	public Integer getResumeId() {
		return resumeId;
	}
	public void setResumeId(Integer resumeId) {
		this.resumeId = resumeId;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPlaceId() {
		return placeId;
	}
	public void setPlaceId(String placeId) {
		this.placeId = placeId;
	}
	public String getPublishDateBegin() {
		return publishDateBegin;
	}
	public void setPublishDateBegin(String publishDateBegin) {
		this.publishDateBegin = publishDateBegin;
	}
	public String getPublishDateEnd() {
		return publishDateEnd;
	}
	public void setPublishDateEnd(String publishDateEnd) {
		this.publishDateEnd = publishDateEnd;
	}
	public Integer getWorkId() {
		return workId;
	}
	public void setWorkId(Integer workId) {
		this.workId = workId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public Integer getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
}
