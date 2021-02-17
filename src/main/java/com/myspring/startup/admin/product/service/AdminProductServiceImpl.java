package com.myspring.startup.admin.product.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.myspring.startup.admin.product.dao.AdminProductDAO;
import com.myspring.startup.admin.product.vo.AdminProductVO;
import com.myspring.startup.product.vo.ProductVO;

@Service("AdminProductService")
public class AdminProductServiceImpl implements AdminProductService{
	@Autowired
	private AdminProductDAO adminProductDAO;

//	제품승인요청리스트
	@Override
	public List<AdminProductVO> AdminProductList() throws Exception {
		return  adminProductDAO.selectProductApprovalList();
	}
	
//	제품상세
	@Override
	public AdminProductVO AdminProductDetail(int productNO) {
		AdminProductVO adminProductVO = adminProductDAO.selectProductApprovalDetail(productNO);
		return adminProductVO;
	}
	
//	제품검색
	@Override
	public List<AdminProductVO> AdminProductSearch(String name)  {
		List searchList = adminProductDAO.selectByProduct(name);
		return searchList;
	}
	
//	제품승인거절
	@Override
	public void AdminProductApproval(AdminProductVO adminProductVO) {
		adminProductDAO.updateProductApprovalStatus(adminProductVO);
		
	}
	
}
