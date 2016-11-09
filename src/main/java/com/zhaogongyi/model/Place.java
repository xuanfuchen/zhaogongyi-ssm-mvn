package com.zhaogongyi.model;

import java.io.Serializable;

public class Place implements Serializable {
    private String placeId;

    private String placeName;

    private String placeType;

    private String pid;

    private Byte isChild;

    private String pinyin;

    private static final long serialVersionUID = 1L;

    public String getPlaceId() {
        return placeId;
    }

    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getPlaceType() {
        return placeType;
    }

    public void setPlaceType(String placeType) {
        this.placeType = placeType;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public Byte getIsChild() {
        return isChild;
    }

    public void setIsChild(Byte isChild) {
        this.isChild = isChild;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }
}