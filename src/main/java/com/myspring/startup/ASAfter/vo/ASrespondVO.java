package com.myspring.startup.ASAfter.vo;

import java.sql.Date;

public class ASrespondVO {
	private int asNo;
	private Date respDate;
	private String cuId;
	
	public int getAsNo() {
		return asNo;
	}
	public void setAsNo(int asNo) {
		this.asNo = asNo;
	}
	public Date getRespDate() {
		return respDate;
	}
	public void setRespDate(Date respDate) {
		this.respDate = respDate;
	}
	public String getCuId() {
		return cuId;
	}
	public void setCuId(String cuId) {
		this.cuId = cuId;
	}
}