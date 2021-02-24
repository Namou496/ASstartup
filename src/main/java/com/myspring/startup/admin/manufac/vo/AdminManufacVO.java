package com.myspring.startup.admin.manufac.vo;

import org.springframework.stereotype.Component;

@Component("adminManufacVO")
public class AdminManufacVO {
	
//	제조사테이블
	private String cuId;
	private int manufacturerNO;
	private String name;
	private String addr;
	private String officer;
	private String tel;
	
//	승인테이블
	private int approvalNum;
	private int approvalStatus;
	private String rejectionReason;
	
	
	public String getCuId() {
		return cuId;
	}
	public void setCuId(String cuId) {
		this.cuId = cuId;
	}
	public int getApprovalNum() {
		return approvalNum;
	}
	public void setApprovalNum(int approvalNum) {
		this.approvalNum = approvalNum;
	}
	public int getApprovalStatus() {
		return approvalStatus;
	}
	public void setApprovalStatus(int approvalStatus) {
		this.approvalStatus = approvalStatus;
	}
	public String getRejectionReason() {
		return rejectionReason;
	}
	public void setRejectionReason(String rejectionReason) {
		this.rejectionReason = rejectionReason;
	}

	public int getManufacturerNO() {
		return manufacturerNO;
	}
	public void setManufacturerNO(int manufacturerNO) {
		this.manufacturerNO = manufacturerNO;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getOfficer() {
		return officer;
	}
	public void setOfficer(String officer) {
		this.officer = officer;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	
	
}
