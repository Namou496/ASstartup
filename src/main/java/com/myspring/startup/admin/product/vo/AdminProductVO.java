package com.myspring.startup.admin.product.vo;

import org.springframework.stereotype.Component;

@Component("adminProductVO")
public class AdminProductVO {
	
	private int productNO;
	private String manufacturerName;
	private String name;
	private int approvalNum;
	private int approvalStatus;
	private String prodGroup;
	private String useManual;
	private String ASManual;
	private String productImage;

//	부품
	private int componentNO;
	private String componentName;
	private int price;
	private int part;
	
	public String getComponentName() {
		return componentName;
	}
	public void setComponentName(String componentName) {
		this.componentName = componentName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getPart() {
		return part;
	}
	public void setPart(int part) {
		this.part = part;
	}

	
	
	

	public String getManufacturerName() {
		return manufacturerName;
	}
	public void setManufacturerName(String manufacturerName) {
		this.manufacturerName = manufacturerName;
	}
	public String getUseManual() {
		return useManual;
	}
	public void setUseManual(String useManual) {
		this.useManual = useManual;
	}
	public String getASManual() {
		return ASManual;
	}
	public void setASManual(String aSManual) {
		ASManual = aSManual;
	}
	public String getProductImage() {
		return productImage;
	}
	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}
	public String getProdGroup() {
		return prodGroup;
	}
	public void setProdGroup(String prodGroup) {
		this.prodGroup = prodGroup;
	}
	private String rejectionReason;
	
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
	public int getProductNO() {
		return productNO;
	}
	public void setProductNO(int productNO) {
		this.productNO = productNO;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getComponentNO() {
		return componentNO;
	}
	public void setComponentNO(int componentNO) {
		this.componentNO = componentNO;
	}

}
