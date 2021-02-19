package com.myspring.startup.ASAfter.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

		ModelAndView mav = new ModelAndView();
		mav.addObject("ASAfterList", list);
		mav.setViewName("/ASAfter/listASAfter");
		
		return mav;
	}

	@RequestMapping(value="/ASAfter/selectUserASAfterList.do", method= {RequestMethod.POST, RequestMethod.GET})
	@Override
	public ModelAndView selectUserASAfterList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		
		MemberVO mfr = (MemberVO)session.getAttribute("member");
				
		String ucuid = mfr.getCuId();
		List<ASAfterVO> userlist = ASAfterService.selectUserASAfterList(ucuid);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("ASAfterList", userlist);
		mav.setViewName("/ASAfter/listASAfter");
		
		return mav;
	}

	@RequestMapping(value="/ASAfter/selectMfrASAfterList.do", method= {RequestMethod.POST, RequestMethod.GET})
	@Override
	public ModelAndView selectMfrASAfterList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		
		MemberVO mfr = (MemberVO)session.getAttribute("member");
				
		String mcuid = mfr.getCuId();
		
		List<ASAfterVO> mfrlist = ASAfterService.selectMfrASAfterList(mcuid);
		
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
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		String date = request.getParameter("respDate");
		
		java.sql.Date resp = new java.sql.Date(df.parse(date).getTime());
		
		int asno = Integer.parseInt(request.getParameter("asno"));
		String cuid = request.getParameter("cuId");
		
		ASrespondVO insertresp = new ASrespondVO();
		
		insertresp.setRespDate(resp);
		insertresp.setAsNo(asno);
		insertresp.setCuId(cuid);
		
		Map<String, Object> updatesta = new HashMap<String, Object>();
		updatesta.put("insertresp", insertresp);
		updatesta.put("asno", asno);
		
		ASAfterService.insertASrespond(updatesta);
		
		ModelAndView mav = new ModelAndView("redirect:/ASAfter/selectASAfterList.do");
		
		return mav;
	}
	
	@RequestMapping(value="/ASAfter/searchASAfterList.do", method= {RequestMethod.POST, RequestMethod.GET})
	@Override
	public ModelAndView searchASAfterList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int condition = Integer.parseInt(request.getParameter("condition"));
		String keyword = request.getParameter("keyword");
		
		Map<String, Object> search = new HashMap<String, Object>();
		search.put("keyword", keyword);
		search.put("condition", condition);
		
		List<ASAfterVO> ASAfterList = ASAfterService.searchASAfterList(search);
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("/ASAfter/listASAfter");
		mav.addObject("ASAfterList", ASAfterList);
		
		return mav;
	}
}