package com.myspring.startup.product.product.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.myspring.startup.member.vo.MemberVO;

public interface ProductController {
	ModelAndView listProduct(int section, int pageNum, HttpServletRequest request, HttpServletResponse response)
			throws Exception;
	ModelAndView ProductDetail(int section, int pageNum, int productNo, HttpServletRequest request,
			HttpServletResponse response) throws Exception;
	ModelAndView searchProduct(int section, int pageNum, String productGroup, String manufacName, String productName,
			HttpServletRequest request, HttpServletResponse response) throws Exception;
	ModelAndView applyProduct(MultipartHttpServletRequest multipartRequest, HttpServletResponse response)
			throws Exception;
	void selectAjaxManufacName(HttpServletRequest req, HttpServletResponse res, String param) throws Exception;
	ModelAndView applyProductView(HttpServletRequest request, HttpServletResponse response, int section, int pageNum,
			String manufacName, MemberVO member) throws Exception;









}
