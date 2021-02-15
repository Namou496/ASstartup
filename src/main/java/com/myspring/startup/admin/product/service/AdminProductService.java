package com.myspring.startup.admin.product.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.myspring.startup.admin.product.vo.AdminProductVO;

public interface AdminProductService {
	public List<AdminProductVO>AdminProductList() throws Exception;

	public AdminProductVO AdminProductDetail(int productNO);

	public List<AdminProductVO> AdminProductSearch(String name);

}
