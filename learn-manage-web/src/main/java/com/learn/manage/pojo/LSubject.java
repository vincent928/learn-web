package com.learn.manage.pojo;

import java.io.Serializable;

public class LSubject implements Serializable{
    private Integer zgId;

    private String zgTitle;

    private Integer qId;

    public Integer getZgId() {
        return zgId;
    }

    public void setZgId(Integer zgId) {
        this.zgId = zgId;
    }

    public String getZgTitle() {
        return zgTitle;
    }

    public void setZgTitle(String zgTitle) {
        this.zgTitle = zgTitle == null ? null : zgTitle.trim();
    }

    public Integer getqId() {
        return qId;
    }

    public void setqId(Integer qId) {
        this.qId = qId;
    }
}