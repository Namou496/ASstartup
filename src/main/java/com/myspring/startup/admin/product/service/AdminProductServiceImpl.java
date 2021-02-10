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

	@Override
	public List<AdminProductVO> AdminProductList() throws Exception {
		return  adminProductDAO.selectProductApprovalList();
	}
	
}
