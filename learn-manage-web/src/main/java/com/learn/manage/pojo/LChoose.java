package com.learn.manage.pojo;

import java.io.Serializable;

public class LChoose implements Serializable{
    private Integer xzId;

    private String xzTitle;

    private String xzA;

    private String xzB;

    private String xzC;

    private String xzD;

    private String xzCurrent;

    private Integer qId;

    public Integer getXzId() {
        return xzId;
    }

    public void setXzId(Integer xzId) {
        this.xzId = xzId;
    }

    public String getXzTitle() {
        return xzTitle;
    }

    public void setXzTitle(String xzTitle) {
        this.xzTitle = xzTitle == null ? null : xzTitle.trim();
    }

    public String getXzA() {
        return xzA;
    }

    public void setXzA(String xzA) {
        this.xzA = xzA == null ? null : xzA.trim();
    }

    public String getXzB() {
        return xzB;
    }

    public void setXzB(String xzB) {
        this.xzB = xzB == null ? null : xzB.trim();
    }

    public String getXzC() {
        return xzC;
    }

    public void setXzC(String xzC) {
        this.xzC = xzC == null ? null : xzC.trim();
    }

    public String getXzD() {
        return xzD;
    }

    public void setXzD(String xzD) {
        this.xzD = xzD == null ? null : xzD.trim();
    }

    public String getXzCurrent() {
        return xzCurrent;
    }

    public void setXzCurrent(String xzCurrent) {
        this.xzCurrent = xzCurrent == null ? null : xzCurrent.trim();
    }

    public Integer getqId() {
        return qId;
    }

    public void setqId(Integer qId) {
        this.qId = qId;
    }
}