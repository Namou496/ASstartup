package com.myspring.startup.ASForm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

public interface ASFormController {

	public ModelAndView ASForm(HttpServletRequest request, HttpServletResponse response) throws Exception;

	ResponseEntity addASList(MultipartHttpServletRequest multipartRequest, HttpServletResponse response)
			throws Exception;

	public void selectAjaxProductName(HttpServletRequest request, HttpServletResponse response, String param1, String param2) 
			throws Exception;
}
