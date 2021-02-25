package com.myspring.startup.admin.manufac.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

public interface AdminManufacController {

	//리스트
	ModelAndView adminManufacList(HttpServletRequest request, HttpServletResponse response) throws Exception;
	//상세
	ModelAndView adminManufacDetail(int manufacNo, HttpServletRequest request, HttpServletResponse response)
			throws Exception;
	//승인거절
	ModelAndView adminManufacApproval(HttpServletRequest request, HttpServletResponse response) throws Exception;

	//검색
	ModelAndView adminManufacSearch(String name, HttpServletRequest request, HttpServletResponse response)
			throws Exception;

}
