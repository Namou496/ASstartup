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
	public Map<String,Object> AdminProductList(int secNum,int pageNum) throws Exception {
		Map<String,Object> pageMap=new HashMap<String,Object>();
		pageMap.put("secNum", secNum);
		pageMap.put("pageNum", pageNum);
		
		List<AdminProductVO> productList=adminProductDAO.selectProductApprovalList(pageMap);
		
		double lastPageNum=adminProductDAO.selectProductApprovalListCount(secNum);
		lastPageNum=lastPageNum/10;
		Map<String,Object> productMap=new HashMap<String,Object>();
		productMap.put("secNum",secNum);
		productMap.put("lastPageNum",(int)Math.ceil(lastPageNum));
		productMap.put("pageNum",pageNum);
		productMap.put("productList", productList);
		
		return productMap;
	}
	
//	제품상세
	@Override
	public AdminProductVO AdminProductDetail(int productNO) {
		AdminProductVO adminProductVO = adminProductDAO.selectProductApprovalDetail(productNO);
		return adminProductVO;
	}
	
//	부품목록
	@Override
	public List<AdminProductVO> AdminProductComponent(int productNO) {
		List componentList = adminProductDAO.selectProductComponent(productNO);
		return componentList;
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
