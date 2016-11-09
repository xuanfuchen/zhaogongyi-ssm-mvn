package com.zhaogongyi.model;

import java.io.Serializable;
import java.util.Date;

public class WorkInfo implements Serializable {
    private Integer workId;

    private String workTypeIdFk;

    private String title;

    private Integer num;

    private String exprTime;

    private String education;

    private String slyBegin;

    private String slyEnd;

    private String placeIdFk;

    private String placeName;

    private String contactPerson;

    private String contactPhone;

    private String workEmail;

    private Integer companyIdFk;

    private Date publishDate;

    private String workTypeName;

    private Byte disFlag;

    private String companyName;

    private String dutyReq;

    private static final long serialVersionUID = 1L;

    public Integer getWorkId() {
        return workId;
    }

    public void setWorkId(Integer workId) {
        this.workId = workId;
    }

    public String getWorkTypeIdFk() {
        return workTypeIdFk;
    }

    public void setWorkTypeIdFk(String workTypeIdFk) {
        this.workTypeIdFk = workTypeIdFk;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getExprTime() {
        return exprTime;
    }

    public void setExprTime(String exprTime) {
        this.exprTime = exprTime;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getSlyBegin() {
        return slyBegin;
    }

    public void setSlyBegin(String slyBegin) {
        this.slyBegin = slyBegin;
    }

    public String getSlyEnd() {
        return slyEnd;
    }

    public void setSlyEnd(String slyEnd) {
        this.slyEnd = slyEnd;
    }

    public String getPlaceIdFk() {
        return placeIdFk;
    }

    public void setPlaceIdFk(String placeIdFk) {
        this.placeIdFk = placeIdFk;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getWorkEmail() {
        return workEmail;
    }

    public void setWorkEmail(String workEmail) {
        this.workEmail = workEmail;
    }

    public Integer getCompanyIdFk() {
        return companyIdFk;
    }

    public void setCompanyIdFk(Integer companyIdFk) {
        this.companyIdFk = companyIdFk;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public String getWorkTypeName() {
        return workTypeName;
    }

    public void setWorkTypeName(String workTypeName) {
        this.workTypeName = workTypeName;
    }

    public Byte getDisFlag() {
        return disFlag;
    }

    public void setDisFlag(Byte disFlag) {
        this.disFlag = disFlag;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getDutyReq() {
        return dutyReq;
    }

    public void setDutyReq(String dutyReq) {
        this.dutyReq = dutyReq;
    }
}