package com.myspring.startup.ASAfter.vo;

import java.sql.Date;

public class ASAfterDetailVO {
	private String uname;
	private String tel;
	private String addr;
	private String prodGroup;
	private String mname;
	private String pname;
	private Date meetDate;
	private String symptoms;
	
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getProdGroup() {
		return prodGroup;
	}
	public void setProdGroup(String prodGroup) {
		this.prodGroup = prodGroup;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public Date getMeetDate() {
		return meetDate;
	}
	public void setMeetDate(Date meetDate) {
		this.meetDate = meetDate;
	}
	public String getSymptoms() {
		return symptoms;
	}
	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}
}