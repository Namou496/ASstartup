package com.myspring.startup.admin.product.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.myspring.startup.admin.product.vo.AdminProductVO;

public interface AdminProductService {
	public Map<String,Object>AdminProductList(int secNum, int pageNum) throws Exception;

	public AdminProductVO AdminProductDetail(int productNO);

	public List<AdminProductVO> AdminProductSearch(String name);

	public void AdminProductApproval(AdminProductVO adminProductVO);

}
