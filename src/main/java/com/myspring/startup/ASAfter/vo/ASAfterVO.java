package com.myspring.startup.ASAfter.vo;

import java.sql.Date;

public class ASAfterVO {
	private int asNo;
	private Date meetDate;
	private String pname;
	private String prodGroup;
	private String addr;
	private String uname;
	private int sta;
	
	public int getAsNo() {
		return asNo;
	}
	public void setAsNo(int asNo) {
		this.asNo = asNo;
	}
	public Date getMeetDate() {
		return meetDate;
	}
	public void setMeetDate(Date meetDate) {
		this.meetDate = meetDate;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getProdGroup() {
		return prodGroup;
	}
	public void setProdGroup(String prodGroup) {
		this.prodGroup = prodGroup;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public int getSta() {
		return sta;
	}
	public void setSta(int sta) {
		this.sta = sta;
	}
}