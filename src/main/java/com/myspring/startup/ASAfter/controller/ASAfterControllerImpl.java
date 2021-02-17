package com.myspring.startup.ASAfter.controller;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.myspring.startup.ASAfter.service.ASAfterService;
import com.myspring.startup.ASAfter.vo.ASAfterDetailVO;
import com.myspring.startup.ASAfter.vo.ASAfterVO;
import com.myspring.startup.ASAfter.vo.ASrespondVO;
import com.myspring.startup.member.vo.MemberVO;

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
		// 로그인 가정
		MemberVO memberVO = new MemberVO();
		
		memberVO.setCuId("hong");
		memberVO.setuNo(2);
		HttpSession session = request.getSession();
		session.setAttribute("member", memberVO);
		//
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
		mav.addObject("asno",asno);
		mav.setViewName("/ASAfter/detailListASAfter");
		
		return mav;
	}
	
	@RequestMapping(value="/ASAfter/insertASrespond.do", method= {RequestMethod.POST, RequestMethod.GET})
	@Override
	public ModelAndView insertASrespond(HttpServletRequest request, HttpServletResponse response) throws Exception {
		DateFormat df = new SimpleDateFormat();
		
		String date = request.getParameter("respDate");
		int asno = Integer.parseInt(request.getParameter("asno"));
		String cuid = request.getParameter("cuId");
		
		ASrespondVO insertresp = new ASrespondVO();
		
//		insertresp.setRespDate(respdate);
//		insertresp.setAsNo(asno);
//		insertresp.setCuId(cuid);
		
//		ASAfterService.insertASrespond(insertresp);
		
		ModelAndView mav = new ModelAndView();
		
		return mav;
	}
	
}