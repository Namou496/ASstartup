package com.myspring.startup.admin.product.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

public interface AdminProductController {

	public ModelAndView AdminProductDetail(HttpServletRequest request, HttpServletResponse response) throws Exception;

	public ModelAndView adminProductList(HttpServletRequest request, HttpServletResponse response) throws Exception;

	

}
