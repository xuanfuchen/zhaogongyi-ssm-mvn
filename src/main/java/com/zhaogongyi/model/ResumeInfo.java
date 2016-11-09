package com.zhaogongyi.model;

import java.io.Serializable;
import java.util.Date;

public class ResumeInfo implements Serializable {
    private Integer resumeId;

    private String fullName;

    private Byte gender;

    private String cellPhone;

    private String placeIdFk;

    private String placeName;

    private String trade;

    private String jiguan;

    private String education;

    private Integer age;

    private Byte disFlag;

    private Date publishDate;

    private String email;

    private String title;

    private String exprTime;

    private String introduce;

    private Integer slyBegin;

    private Integer slyEnd;

    private String workTypeName;

    private String workTypeIdFk;

    private Integer acctIdFk;

    private String resumeTitle;

    private static final long serialVersionUID = 1L;

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

    public Byte getGender() {
        return gender;
    }

    public void setGender(Byte gender) {
        this.gender = gender;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
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

    public String getTrade() {
        return trade;
    }

    public void setTrade(String trade) {
        this.trade = trade;
    }

    public String getJiguan() {
        return jiguan;
    }

    public void setJiguan(String jiguan) {
        this.jiguan = jiguan;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Byte getDisFlag() {
        return disFlag;
    }

    public void setDisFlag(Byte disFlag) {
        this.disFlag = disFlag;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getExprTime() {
        return exprTime;
    }

    public void setExprTime(String exprTime) {
        this.exprTime = exprTime;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public Integer getSlyBegin() {
        return slyBegin;
    }

    public void setSlyBegin(Integer slyBegin) {
        this.slyBegin = slyBegin;
    }

    public Integer getSlyEnd() {
        return slyEnd;
    }

    public void setSlyEnd(Integer slyEnd) {
        this.slyEnd = slyEnd;
    }

    public String getWorkTypeName() {
        return workTypeName;
    }

    public void setWorkTypeName(String workTypeName) {
        this.workTypeName = workTypeName;
    }

    public String getWorkTypeIdFk() {
        return workTypeIdFk;
    }

    public void setWorkTypeIdFk(String workTypeIdFk) {
        this.workTypeIdFk = workTypeIdFk;
    }

    public Integer getAcctIdFk() {
        return acctIdFk;
    }

    public void setAcctIdFk(Integer acctIdFk) {
        this.acctIdFk = acctIdFk;
    }

    public String getResumeTitle() {
        return resumeTitle;
    }

    public void setResumeTitle(String resumeTitle) {
        this.resumeTitle = resumeTitle;
    }
}