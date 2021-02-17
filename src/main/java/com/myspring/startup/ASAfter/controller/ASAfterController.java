package com.myspring.startup.ASAfter.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.myspring.startup.ASAfter.vo.ASrespondVO;

public interface ASAfterController {

	public ModelAndView selectASAfterList(HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	public ModelAndView selectUserASAfterList(HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	public ModelAndView selectMfrASAfterList(HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	public ModelAndView ASAfterListDetail(HttpServletRequest request, HttpServletResponse response, int asno) throws Exception;
	
	public ModelAndView insertASrespond(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
