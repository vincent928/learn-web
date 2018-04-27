package com.learn.manage.pojo;

import java.io.Serializable;

public class StuJudgment implements Serializable{
    private Integer pdId;

    private String sAnswer;

    private Integer hId;

    public Integer getPdId() {
        return pdId;
    }

    public void setPdId(Integer pdId) {
        this.pdId = pdId;
    }

    public String getsAnswer() {
        return sAnswer;
    }

    public void setsAnswer(String sAnswer) {
        this.sAnswer = sAnswer == null ? null : sAnswer.trim();
    }

    public Integer gethId() {
        return hId;
    }

    public void sethId(Integer hId) {
        this.hId = hId;
    }
}