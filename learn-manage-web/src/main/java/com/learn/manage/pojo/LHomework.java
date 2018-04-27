package com.learn.manage.pojo;

public class LHomework {
    private Integer hId;

    private Integer qId;

    private String qTitle;

    private String type;

    private String sId;

    private String sScope;
    
    public Integer gethId() {
        return hId;
    }

    public void sethId(Integer hId) {
        this.hId = hId;
    }

    public Integer getqId() {
        return qId;
    }

    public void setqId(Integer qId) {
        this.qId = qId;
    }

    public String getqTitle() {
        return qTitle;
    }

    public void setqTitle(String qTitle) {
        this.qTitle = qTitle == null ? null : qTitle.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId == null ? null : sId.trim();
    }

	public String getsScope() {
		return sScope;
	}

	public void setsScope(String sScope) {
		this.sScope = sScope ==null ? null : sScope.trim();
	}
    
    
    
}