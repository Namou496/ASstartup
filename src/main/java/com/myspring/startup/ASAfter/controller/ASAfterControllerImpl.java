package com.myspring.startup.ASAfter.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.omg.Dynamic.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.myspring.startup.ASAfter.service.ASAfterService;
import com.myspring.startup.ASAfter.vo.ASAfterDetailVO;
import com.myspring.startup.ASAfter.vo.ASAfterVO;
import com.myspring.startup.ASBefore.vo.TestMemberVO;

@Controller("ASAfterController")

public class ASAfterControllerImpl implements ASAfterController {

	@Autowired
	private ASAfterService ASAfterService;

	private ASAfterVO ASAftervo;

	private ASAfterDetailVO ASAfterDetailvo;

	@Override
	@RequestMapping(value="/ASAfter/selectASAfterList.do", method= {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView selectASAfterList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<ASAfterVO> list = ASAfterService.selectASAfterList();
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("ASAfterList", list);
		mav.setViewName("/ASAfter/listASAfter");
		
		return mav;
	}

	@RequestMapping(value="/ASAfter/selectUserASAfterList.do", method= {RequestMethod.POST, RequestMethod.GET})
	@Override
	public ModelAndView selectUserASAfterList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<ASAfterVO> userlist = ASAfterService.selectUserASAfterList("hong");
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("ASAfterList", userlist);
		mav.setViewName("/ASAfter/listASAfter");
		
		return mav;
	}

	@RequestMapping(value="/ASAfter/selectMfrASAfterList.do", method= {RequestMethod.POST, RequestMethod.GET})
	@Override
	public ModelAndView selectMfrASAfterList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<ASAfterVO> mfrlist = ASAfterService.selectMfrASAfterList("ga");
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("ASAfterList", mfrlist);
		mav.setViewName("/ASAfter/listASAfter");
		
		return mav;
	}
	
	@RequestMapping(value="/ASAfter/ASAfterListDetail.do", method= {RequestMethod.POST, RequestMethod.GET})
	@Override
	public ModelAndView ASAfterListDetail(HttpServletRequest request, HttpServletResponse response, int asno) throws Exception {
		List<ASAfterDetailVO> detaillist = ASAfterService.ASAfterListDetail(asno);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("ASAfterView", detaillist);
		mav.setViewName("/ASAfter/detailListASAfter");
		
		return mav;
	}
}