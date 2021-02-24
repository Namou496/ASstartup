package com.myspring.startup.admin.satisfaction.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

public interface AdminSatisfactionController {

	ModelAndView adminSatisfactionList(HttpServletRequest request, HttpServletResponse response) throws Exception;

	ModelAndView adminSatisfactionDetail(int asNo, HttpServletRequest request, HttpServletResponse response)
			throws Exception;
	

}
