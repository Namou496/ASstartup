package com.myspring.startup.product.manual.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

public interface ManualController {

	ModelAndView listManual(int section, int pageNum, HttpServletRequest request, HttpServletResponse response)
			throws Exception;

	ModelAndView ManualDetail(int section, int pageNum, int productNo, String manufacName, int uno,
			HttpServletRequest request, HttpServletResponse response) throws Exception;

	void selectAjaxManufacName(HttpServletRequest req, HttpServletResponse res, String param) throws Exception;

	ModelAndView searchProduct(int section, int pageNum, String productGroup, String manufacName, String productName,
			HttpServletRequest request, HttpServletResponse response) throws Exception;

}
