package com.myspring.startup.product.vo;

import org.springframework.stereotype.Component;

@Component("ProductVO")
public class ProductVO {
	// 제품VO
		private int 		productNo;
		private String	 	productName;
		private String 		productGroup;
		private String 		useManual;
		private String 		asManual;
		private String 		productImage;
		
	//	승인VO
		private int 		approvalStatus;
		private int 		approvalNum;
		
	//	memberVO
		private String 		manufacName;
		private String 		cuId;
		private int uno;
	//	component(부품)
		private String 		componentName;
		private int 		componentNo;
		private int 		componentPrice;
		private int			componentPart;
		
		private int			totProduct;

		public int getProductNo() {
			return productNo;
		}

		public void setProductNo(int productNo) {
			this.productNo = productNo;
		}

		public String getProductName() {
			return productName;
		}

		public void setProductName(String productName) {
			this.productName = productName;
		}

		public String getProductGroup() {
			return productGroup;
		}

		public void setProductGroup(String productGroup) {
			this.productGroup = productGroup;
		}

		public String getUseManual() {
			return useManual;
		}

		public void setUseManual(String useManual) {
			this.useManual = useManual;
		}

		public String getAsManual() {
			return asManual;
		}

		public void setAsManual(String asManual) {
			this.asManual = asManual;
		}

		public String getProductImage() {
			return productImage;
		}

		public void setProductImage(String productImage) {
			this.productImage = productImage;
		}

		public int getApprovalStatus() {
			return approvalStatus;
		}

		public void setApprovalStatus(int approvalStatus) {
			this.approvalStatus = approvalStatus;
		}

		public int getApprovalNum() {
			return approvalNum;
		}

		public void setApprovalNum(int approvalNum) {
			this.approvalNum = approvalNum;
		}

		public String getManufacName() {
			return manufacName;
		}

		public void setManufacName(String manufacName) {
			this.manufacName = manufacName;
		}

		public String getCuId() {
			return cuId;
		}

		public void setCuId(String cuId) {
			this.cuId = cuId;
		}

		public int getUno() {
			return uno;
		}

		public void setUno(int uno) {
			this.uno = uno;
		}

		public String getComponentName() {
			return componentName;
		}

		public void setComponentName(String componentName) {
			this.componentName = componentName;
		}

		public int getComponentNo() {
			return componentNo;
		}

		public void setComponentNo(int componentNo) {
			this.componentNo = componentNo;
		}

		public int getComponentPrice() {
			return componentPrice;
		}

		public void setComponentPrice(int componentPrice) {
			this.componentPrice = componentPrice;
		}

		public int getComponentPart() {
			return componentPart;
		}

		public void setComponentPart(int componentPart) {
			this.componentPart = componentPart;
		}

		public int getTotProduct() {
			return totProduct;
		}

		public void setTotProduct(int totProduct) {
			this.totProduct = totProduct;
		}
		
		
	
		
		
}
