package com.myspring.startup.product.product.service;

import java.util.List;
import java.util.Map;

import com.myspring.startup.product.vo.ProductVO;

public interface ProductService {
	Map ProductList(Map pageMap, String memberId) throws Exception;
	ProductVO ProductDetail(Map pageMap, String memberId) throws Exception;
	Map searchProduct(Map searchMap, String memberId) throws Exception;
	List productGroup(String manufacturer) throws Exception;
	String manufacName(String cuId) throws Exception;
	public int applyProduct(String[] componentName, String[] componentPart, Map product) throws Exception;
	List compoDetail(int productNo) throws Exception;

}
