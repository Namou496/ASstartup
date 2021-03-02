package com.myspring.startup.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myspring.startup.member.vo.MemberVO;

public interface MemberController {
	public ModelAndView joinPage(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView login(@ModelAttribute("member") MemberVO member,
                              RedirectAttributes rAttr,
                              HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView pagepw(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView pageid(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ResponseEntity lostPw(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ResponseEntity lostId(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView newId(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ResponseEntity addMember(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView selectMember(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public void overlapId(HttpServletRequest request, HttpServletResponse response, String param) throws Exception;
}
