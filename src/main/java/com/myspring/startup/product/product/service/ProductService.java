package com.myspring.startup.product.product.service;

import java.util.List;
import java.util.Map;

import com.myspring.startup.product.vo.ProductVO;

public interface ProductService {
	Map ProductList(Map pageMap, String memberId) throws Exception;
	ProductVO ProductDetail(Map pageMap, String memberId) throws Exception;
	Map searchProduct(Map searchMap, String memberId) throws Exception;
	public void applyProduct(Map product, Map component) throws Exception;
	List productGroup(String manufacturer) throws Exception;

}
