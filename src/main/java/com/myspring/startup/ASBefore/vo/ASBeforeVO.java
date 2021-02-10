package com.myspring.startup.ASBefore.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component("ASbeforeVO")
public class ASBeforeVO {
	private int asno;
	private String custoname;
	private String addr;
	private String prodgroup;
	private String mcrname;
	private int productNo;
	private String proname;
	private String meeting;
	private String symptoms;
	private Date meetDate;
	private Date respDate;
	private String cuid; /*공급자 아이디*/
	private String asComment;/*ASrespond update*/
	private int manCost;/*ASrespond update*/
	private int serviceCost;/*ASrespon update*/
	private int sta;/*ASForm update*/
	
	
	public String getCustoname() {
		return custoname;
	}
	public void setCustoname(String custoname) {
		this.custoname = custoname;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getProdgroup() {
		return prodgroup;
	}
	public void setProdgroup(String prodgroup) {
		this.prodgroup = prodgroup;
	}
	public String getMcrname() {
		return mcrname;
	}
	public void setMcrname(String mcrname) {
		this.mcrname = mcrname;
	}
	public int getProductNo() {
		return productNo;
	}
	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}
	public String getProname() {
		return proname;
	}
	public void setProname(String proname) {
		this.proname = proname;
	}
	public String getMeeting() {
		return meeting;
	}
	public void setMeeting(String meeting) {
		this.meeting = meeting;
	}
	public String getSymptoms() {
		return symptoms;
	}
	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}
	public Date getMeetDate() {
		return meetDate;
	}
	public void setMeetDate(Date meetDate) {
		this.meetDate = meetDate;
	}
	public Date getRespDate() {
		return respDate;
	}
	public void setRespDate(Date respDate) {
		this.respDate = respDate;
	}
	public String getCuid() {
		return cuid;
	}
	public void setCuid(String cuid) {
		this.cuid = cuid;
	}
	
	public int getManCost() {
		return manCost;
	}
	public void setManCost(int manCost) {
		this.manCost = manCost;
	}
	public int getServiceCost() {
		return serviceCost;
	}
	public void setServiceCost(int serviceCost) {
		this.serviceCost = serviceCost;
	}
	public int getSta() {
		return sta;
	}
	public void setSta(int sta) {
		this.sta = sta;
	}
	public int getAsno() {
		return asno;
	}
	public void setAsno(int asno) {
		this.asno = asno;
	}
	public String getAsComment() {
		return asComment;
	}
	public void setAsComment(String asComment) {
		this.asComment = asComment;
	}
	
	
	
}
