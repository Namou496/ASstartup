package com.myspring.startup.product.manual.service;

import java.util.List;
import java.util.Map;

import com.myspring.startup.product.vo.ProductVO;

public interface ManualService {

	Map ProductList(Map pageMap, String cuId) throws Exception;
	String manufacName(String cuId) throws Exception;
	ProductVO ManualDetail(Map pageMap, String memberId) throws Exception;
	List productGroup(String manufacturer) throws Exception;
	Map searchProduct(Map searchMap, String memberId) throws Exception;

}
