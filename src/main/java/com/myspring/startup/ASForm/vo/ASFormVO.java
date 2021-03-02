package com.myspring.startup.ASForm.vo;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component("ASFormVO")
public class ASFormVO {
	private int asNo;			//A/S번호
	private String phone;		//전화번호
	private String addr;		//주소
	private String symptoms;	//증상
	private int meeting;		//만남종류
	private String fileImg; //첨부파일 이름
	private int sta;			//처리현황(단계)
	private String cuId;		//사용자 아이디
	private int productNo;		//제품번호
	private Date meetDate;		//방문 희망 일자
	private String productGroup;
	private String manufacName;
	
	
	public String getProductGroup() {
		return productGroup;
	}
	public void setProductGroup(String productGroup) {
		this.productGroup = productGroup;
	}
	public String getManufacName() {
		return manufacName;
	}
	public void setManufacName(String manufacName) {
		this.manufacName = manufacName;
	}
	public int getAsNo() {
		return asNo;
	}
	public void setAsNo(int asNo) {
		this.asNo = asNo;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getSymptoms() {
		return symptoms;
	}
	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}
	public int getMeeting() {
		return meeting;
	}
	public void setMeeting(int meeting) {
		this.meeting = meeting;
	}
	public String getFileImg() {
		return fileImg;
	}
	public void setFileImg(String fileImg) {
		this.fileImg = fileImg;
	}
	public int getSta() {
		return sta;
	}
	public void setSta(int sta) {
		this.sta = sta;
	}
	public String getCuId() {
		return cuId;
	}
	public void setCuId(String cuId) {
		this.cuId = cuId;
	}
	public int getProductNo() {
		return productNo;
	}
	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}
	public Date getMeetDate() {
		return meetDate;
	}
	public void setMeetDate(Date meetDate) {
		this.meetDate = meetDate;
	}
	
}
