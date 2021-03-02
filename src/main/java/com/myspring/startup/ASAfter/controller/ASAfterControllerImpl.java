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
import com.myspring.startup.ASAfter.vo.Criteria;
import com.myspring.startup.ASAfter.vo.PageMaker;
import com.myspring.startup.member.vo.MemberVO;

@Controller("ASAfterController")

public class ASAfterControllerImpl implements ASAfterController {

	@Autowired
	private ASAfterService ASAfterService;

	private ASAfterVO ASAftervo;

	private ASAfterDetailVO ASAfterDetailvo;

	private Criteria Criteria;

	private PageMaker Pagemaker;

	@RequestMapping(value = "/ASAfter/selectASAfterList.do", method = { RequestMethod.POST, RequestMethod.GET })
	@Override
	public ModelAndView selectASAfterList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Criteria cri = new Criteria();

		String pageinput = request.getParameter("page");
		if (pageinput != null) {
			int page = Integer.parseInt(pageinput);
			cri.setPage(page);
		}

		String condition = request.getParameter("condition");
		String keyword = request.getParameter("keyword");
		
		HttpSession session = request.getSession();

		MemberVO all = (MemberVO) session.getAttribute("member");
		int uno = all.getuNo();
		
		Map<String, Object> searchcount = new HashMap<String, Object>();
		searchcount.put("condition", condition);
		searchcount.put("keyword", keyword);
		searchcount.put("uNo", uno);
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(ASAfterService.countASAfterList(searchcount));

		List<ASAfterVO> paginglist = ASAfterService.selectASAfterList(cri);

		Map<String, Object> pageMap = new HashMap<String, Object>();
		pageMap.put("paginglist", paginglist);
		pageMap.put("pageMaker", pageMaker);

		ModelAndView mav = new ModelAndView();
		mav.addObject("keyword", keyword);
		mav.addObject("pageMap", pageMap);
		mav.setViewName("/ASAfter/listASAfter");

		return mav;
	}

	@RequestMapping(value = "/ASAfter/selectUserASAfterList.do", method = { RequestMethod.POST, RequestMethod.GET })
	@Override
	public ModelAndView selectUserASAfterList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Criteria cri = new Criteria();

		String pageinput = request.getParameter("page");
		if (pageinput != null) {
			int page = Integer.parseInt(pageinput);
			cri.setPage(page);
		}

		String condition = request.getParameter("condition");
		String keyword = request.getParameter("keyword");
		
		HttpSession session = request.getSession();

		MemberVO user = (MemberVO) session.getAttribute("member");
		String ucuid = user.getCuId();
		int uno = user.getuNo();
		
		Map<String, Object> searchcount = new HashMap<String, Object>();
		searchcount.put("condition", condition);
		searchcount.put("keyword", keyword);
		searchcount.put("cuid", ucuid);
		searchcount.put("uNo", uno);
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(ASAfterService.countASAfterList(searchcount));

		int pageStart = cri.getPageStart();
		int pageEnd = cri.getPageEnd();

		Map<String, Object> userpaging = new HashMap<String, Object>();
		userpaging.put("cuid", ucuid);
		userpaging.put("pageStart", pageStart);
		userpaging.put("pageEnd", pageEnd);

		List<ASAfterVO> userlist = ASAfterService.selectUserASAfterList(userpaging);

		Map<String, Object> pageMap = new HashMap<String, Object>();
		pageMap.put("userlist", userlist);
		pageMap.put("pageMaker", pageMaker);

		ModelAndView mav = new ModelAndView();
		mav.addObject("pageMap", pageMap);
		mav.setViewName("/ASAfter/listASAfter");

		return mav;
	}

	@RequestMapping(value = "/ASAfter/selectMfrASAfterList.do", method = { RequestMethod.POST, RequestMethod.GET })
	@Override
	public ModelAndView selectMfrASAfterList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Criteria cri = new Criteria();

		String pageinput = request.getParameter("page");
		if (pageinput != null) {
			int page = Integer.parseInt(pageinput);
			cri.setPage(page);
		}

		String condition = request.getParameter("condition");
		String keyword = request.getParameter("keyword");
		
		HttpSession session = request.getSession();

		MemberVO mfr = (MemberVO) session.getAttribute("member");
		String mcuid = mfr.getCuId();
		int uno = mfr.getuNo();
		
		Map<String, Object> searchcount = new HashMap<String, Object>();
		searchcount.put("condition", condition);
		searchcount.put("keyword", keyword);
		searchcount.put("cuid", mcuid);
		searchcount.put("uNo", uno);
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(ASAfterService.countASAfterList(searchcount));
		
		int pageStart = cri.getPageStart();
		int pageEnd = cri.getPageEnd();

		Map<String, Object> mfrpaging = new HashMap<String, Object>();
		mfrpaging.put("cuid", mcuid);
		mfrpaging.put("pageStart", pageStart);
		mfrpaging.put("pageEnd", pageEnd);

		List<ASAfterVO> mfrlist = ASAfterService.selectMfrASAfterList(mfrpaging);

		Map<String, Object> pageMap = new HashMap<String, Object>();
		pageMap.put("mfrlist", mfrlist);
		pageMap.put("pageMaker", pageMaker);

		ModelAndView mav = new ModelAndView();
		mav.addObject("pageMap", pageMap);
		mav.setViewName("/ASAfter/listASAfter");

		return mav;
	}

	@RequestMapping(value = "/ASAfter/ASAfterListDetail.do", method = { RequestMethod.POST, RequestMethod.GET })
	@Override
	public ModelAndView ASAfterListDetail(HttpServletRequest request, HttpServletResponse response, int asno)
			throws Exception {
		List<ASAfterDetailVO> detaillist = ASAfterService.ASAfterListDetail(asno);

		ModelAndView mav = new ModelAndView();
		mav.addObject("ASAfterView", detaillist);
		mav.addObject("asno", asno);
		mav.setViewName("/ASAfter/detailListASAfter");

		return mav;
	}

	@RequestMapping(value = "/ASAfter/insertASrespond.do", method = { RequestMethod.POST, RequestMethod.GET })
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

	@RequestMapping(value = "/ASAfter/searchASAfterList.do", method = { RequestMethod.POST, RequestMethod.GET })
	@Override
	public ModelAndView searchASAfterList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Criteria cri = new Criteria();
		
		int condition = Integer.parseInt(request.getParameter("condition"));
		String keyword = request.getParameter("keyword");
		
		HttpSession session = request.getSession();
		
		MemberVO all = (MemberVO) session.getAttribute("member");
		int uno = all.getuNo();
		
		Map<String, Object> searchcount = new HashMap<String, Object>();
		searchcount.put("condition", condition);
		searchcount.put("keyword", keyword);
		searchcount.put("uNo", uno);
		
		String pageinput = request.getParameter("page");
		if (pageinput != null) {
			int page = Integer.parseInt(pageinput);
			cri.setPage(page);
		}
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(ASAfterService.countASAfterList(searchcount));
		
		int pageStart = cri.getPageStart();
		int pageEnd = cri.getPageEnd();
		
		Map<String, Object> search = new HashMap<String, Object>();
		search.put("pageStart", pageStart);
		search.put("pageEnd", pageEnd);
		search.put("keyword", keyword);
		search.put("condition", condition);

		List<ASAfterVO> ASAfterList = ASAfterService.searchASAfterList(search);
		
		Map<String, Object> searchlist = new HashMap<String, Object>();
		searchlist.put("paginglist", ASAfterList);
		searchlist.put("pageMaker", pageMaker);

		ModelAndView mav = new ModelAndView();

		mav.addObject("keyword", keyword);
		mav.setViewName("/ASAfter/listASAfter");
		mav.addObject("pageMap", searchlist);

		return mav;
	}
}