package com.myspring.startup.product.product.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

public interface ProductController {
	ModelAndView listProduct(HttpServletRequest request, HttpServletResponse response) throws Exception;
	ModelAndView ProductDetail(HttpServletRequest request, HttpServletResponse response) throws Exception;
	ModelAndView searchProduct(HttpServletRequest request, HttpServletResponse response) throws Exception;
	ModelAndView applyProduct(MultipartHttpServletRequest multipartRequest, HttpServletResponse response)
			throws Exception;
	ModelAndView applyProduct(HttpServletRequest request, HttpServletResponse response) throws Exception;
	void selectAjaxManufacName(HttpServletRequest req, HttpServletResponse res, String param) throws Exception;

}
