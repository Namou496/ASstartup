package com.myspring.startup.admin.product.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

public interface AdminProductController {


	//제품승인요청리스트
	public ModelAndView adminProductList(HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	//제품상세
	public ModelAndView adminProductDetail(int productNO, HttpServletRequest request, HttpServletResponse response)
			throws Exception;
	//제품검색
	public ModelAndView adminProductSearch(String name, HttpServletRequest request, HttpServletResponse response)
			throws Exception;

	//제품승인거절
	public ModelAndView adminProductApproval(HttpServletRequest request, HttpServletResponse response) throws Exception;

//	제품가격설정
	public ModelAndView adminProductComponentPrice(HttpServletRequest request, HttpServletResponse response) throws Exception;


	

	
	

}
