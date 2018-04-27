package com.learn.manage.pojo;

public class LJudgment {
    private Integer pdId;

    private String pdTitle;

    private String pdA;

    private String pdB;

    private String pdCurrent;

    private Integer qId;

    public Integer getPdId() {
        return pdId;
    }

    public void setPdId(Integer pdId) {
        this.pdId = pdId;
    }

    public String getPdTitle() {
        return pdTitle;
    }

    public void setPdTitle(String pdTitle) {
        this.pdTitle = pdTitle == null ? null : pdTitle.trim();
    }

    public String getPdA() {
        return pdA;
    }

    public void setPdA(String pdA) {
        this.pdA = pdA == null ? null : pdA.trim();
    }

    public String getPdB() {
        return pdB;
    }

    public void setPdB(String pdB) {
        this.pdB = pdB == null ? null : pdB.trim();
    }

    public String getPdCurrent() {
        return pdCurrent;
    }

    public void setPdCurrent(String pdCurrent) {
        this.pdCurrent = pdCurrent == null ? null : pdCurrent.trim();
    }

    public Integer getqId() {
        return qId;
    }

    public void setqId(Integer qId) {
        this.qId = qId;
    }
}