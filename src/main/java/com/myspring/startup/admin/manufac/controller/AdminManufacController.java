package com.myspring.startup.admin.manufac.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

public interface AdminManufacController {

	ModelAndView adminManufacList(HttpServletRequest request, HttpServletResponse response) throws Exception;

	ModelAndView adminManufacDetail(int manufacNo, HttpServletRequest request, HttpServletResponse response)
			throws Exception;

}
