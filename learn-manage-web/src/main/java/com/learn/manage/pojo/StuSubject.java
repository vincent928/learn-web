package com.learn.manage.pojo;

import java.io.Serializable;

public class StuSubject implements Serializable{
    private Integer zgId;

    private Integer hId;

    private String sAnswer;

    public Integer getZgId() {
        return zgId;
    }

    public void setZgId(Integer zgId) {
        this.zgId = zgId;
    }

    public Integer gethId() {
        return hId;
    }

    public void sethId(Integer hId) {
        this.hId = hId;
    }

    public String getsAnswer() {
        return sAnswer;
    }

    public void setsAnswer(String sAnswer) {
        this.sAnswer = sAnswer == null ? null : sAnswer.trim();
    }
}