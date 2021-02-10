package com.myspring.startup.member.vo;

import org.springframework.stereotype.Component;

@Component("memberVO")
public class MemberVO {
	private String cuId;
	private String pw;
	private int uNo;
	
	public String getCuId() {
		return cuId;
	}
	public void setCuId(String cuId) {
		this.cuId = cuId;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public int getuNo() {
		return uNo;
	}
	public void setuNo(int uNo) {
		this.uNo = uNo;
	}
}
