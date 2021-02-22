package com.myspring.startup.Asstarrate.vo;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component("AsstarrateVO")
public class AsstarrateVO {
	private int asNo;
	private Date respDate;
	private String ascomment;
	private int manCost;
	private int serviceCost;
	private int star;
	private String textBox;
	private String cuid;

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

	public String getAscomment() {
		return ascomment;
	}

	public void setAscomment(String ascomment) {
		this.ascomment = ascomment;
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

	public int getStar() {
		return star;
	}

	public void setStar(int star) {
		this.star = star;
	}

	public String getTextBox() {
		return textBox;
	}

	public void setTextBox(String textBox) {
		this.textBox = textBox;
	}

	public String getCuid() {
		return cuid;
	}

	public void setCuid(String cuid) {
		this.cuid = cuid;
	}
}

