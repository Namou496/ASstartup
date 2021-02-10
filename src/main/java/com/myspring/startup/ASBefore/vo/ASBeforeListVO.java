package com.myspring.startup.ASBefore.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component("ASbeforeListVO")
public class ASBeforeListVO {
	private int asno;
	private String name;
	private String prodgroup;
	private String addr;
	private int meeting;
	private Date respDate;
	private int sta;
	
	
	public int getAsno() {
		return asno;
	}
	public void setAsno(int asno) {
		this.asno = asno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProdgroup() {
		return prodgroup;
	}
	public void setProdgroup(String prodgroup) {
		this.prodgroup = prodgroup;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public int getMeeting() {
		return meeting;
	}
	public void setMeeting(int meeting) {
		this.meeting = meeting;
	}
	public Date getRespDate() {
		return respDate;
	}
	public void setRespDate(Date respDate) {
		this.respDate = respDate;
	}
	public int getSta() {
		return sta;
	}
	public void setSta(int sta) {
		this.sta = sta;
	}
}
