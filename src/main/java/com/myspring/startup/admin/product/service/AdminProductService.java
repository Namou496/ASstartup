package com.myspring.startup.admin.product.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.myspring.startup.admin.product.vo.AdminProductVO;

public interface AdminProductService {
	
//	제품리스트
	public Map<String,Object>AdminProductList(int secNum, int pageNum) throws Exception;
//	제품상세
	public AdminProductVO AdminProductDetail(int productNO);
//	제품검색
	public List<AdminProductVO> AdminProductSearch(String name);
//	제품승인
	public void AdminProductApproval(AdminProductVO adminProductVO);
//	부품목록
	public List<AdminProductVO> AdminProductComponent(int productNO);



}
