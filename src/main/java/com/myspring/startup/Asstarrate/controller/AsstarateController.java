package com.myspring.startup.Asstarrate.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

public interface AsstarateController {
	
	public ModelAndView fillAsstarrate(HttpServletRequest request, HttpServletResponse response) throws Exception; 
	
}
