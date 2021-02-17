package com.myspring.startup.product.manual.controller;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.myspring.startup.product.manual.service.ManualService;
import com.myspring.startup.product.vo.ProductVO;

import net.sf.json.JSONArray;

@Controller("ManualController")
public class ManualControllerImpl implements ManualController{
	@Autowired
	private ManualService ManualService;
	@Autowired
	private ProductVO ProductVO;
	
//	1) 제품리스트(페이징)
	@Override
	@RequestMapping(value="/Manual/listManual.do", method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView listManual(@RequestParam(value="section", required=false, defaultValue="1") int section,
									@RequestParam(value="pageNum", required=false, defaultValue="1") int pageNum,
									HttpServletRequest request, 
									HttpServletResponse response
									) throws Exception{
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String memberId = "hong";
//		HttpSession session = request.getSession();
//		MemberVO memberId = (MemberVO) session.getAttribute("member");
//		String _memberId = memberId.getCuId();

		String manufacName = ManualService.manufacName(memberId);

		Map pageMap = new HashMap();
		pageMap.put("section", section);
		pageMap.put("pageNum", pageNum);
		pageMap.put("manufacName", manufacName);
		
		Map productMap= ManualService.ProductList(pageMap, memberId); 
			// productMap --> 제품리스트, 전체글수, 제조사이름리스트, 사용자권한
		
		//		페이징 section, pageNum
		productMap.put("section", section);
		productMap.put("pageNum", pageNum);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("pageMap", pageMap);
		mav.addObject("productMap", productMap);
		mav.setViewName("/manual/manualBoard");
		return mav;
		
	}
	
//	2) 제품상세
	@Override
	@RequestMapping(value="/Manual/ManualDetail.do", method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView ManualDetail(@RequestParam(value="section", required=false, defaultValue="1") int section,
									  @RequestParam(value="pageNum", required=false, defaultValue="1") int pageNum,
									  @RequestParam("productNo") int productNo,
									  @RequestParam("manufacName") String manufacName,
									  @RequestParam("uno") int uno,
									  HttpServletRequest request, 
						 			  HttpServletResponse response) throws Exception{
		System.out.println("hi");
		System.out.println("productNo::" + productNo);
		request.setCharacterEncoding("UTF-8");
//		String _section = request.getParameter("section");
//		String _pageNum = request.getParameter("pageNum");
		String memberId = "hong";
//				String memberId = (String) session.getAttribute("memberId");
//		HttpSession session = request.getSession();
//		MemberVO memberId = (MemberVO) session.getAttribute("member");
//		String _memberId = memberId.getCuId();
		

		Map pageMap = new HashMap();
		pageMap.put("section", section);
		pageMap.put("pageNum", pageNum);
		pageMap.put("productNo", productNo);

		
		ProductVO product = ManualService.ManualDetail(pageMap, memberId); //제품상세 정보
		product.setUno(uno);
		product.setManufacName(manufacName);
		ModelAndView mav = new ModelAndView();
		mav.addObject("product", product);
		mav.addObject("pageMap", pageMap);
		mav.setViewName("/manual/manualDetail");
		return mav;
	}
	
//	3) 제품검색
	// ajax 필터
	@Override
	@RequestMapping(value="/Manual/selectManufacturer.do", method= {RequestMethod.GET,RequestMethod.POST})
	public void selectAjaxManufacName(HttpServletRequest req, HttpServletResponse res, String param) 
	throws Exception{
			   res.setCharacterEncoding("UTF-8");
			   
			   // 도 정보 받음
			   String manufacName = param;
			   // 알맞은 동적 select box info 생성
			   List groupList = new ArrayList();
			   groupList = ManualService.productGroup(manufacName);
			   
			   
			   Set groupSet = new HashSet();
			   for(int i=0; i < groupList.size(); i++) {
				   groupSet.add(groupList.get(i));
			   }
			   
			   Iterator iter = groupSet.iterator();
			   JSONArray jsonArray = new JSONArray();
			   while(iter.hasNext()){
				   String mName = (String) iter.next();
				   System.out.println(jsonArray);
			      jsonArray.add(mName);
			   }
			 
			   // jsonArray 넘김
			   PrintWriter pw = res.getWriter();
			   pw.print(jsonArray.toString());
			   pw.flush();
			   pw.close();

	}
	// 제품 검색
	@Override
	@RequestMapping(value="/Manual/searchProduct.do", method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView searchProduct(  @RequestParam(value="section", required=false, defaultValue="1") int section,
			  							@RequestParam(value="pageNum", required=false, defaultValue="1") int pageNum,
			  							@RequestParam(value="productGroup", required=false, defaultValue="") String productGroup,
			  							@RequestParam(value="manufacName", required=false, defaultValue="") String manufacName,
			  							@RequestParam(value="productName", required=false, defaultValue="") String productName,
										HttpServletRequest request, 
										HttpServletResponse response) throws Exception{
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		//		테스트
		HttpSession session = request.getSession();
		
//		MemberVO memberId = (MemberVO) session.getAttribute("member");
//		String _memberId = memberId.getCuId();
		String memberId = "hong";
		
		if(!(productGroup.length() > 0)) {
			productGroup = null;
		}
		if(!(manufacName.length() > 0)) {
			manufacName = null;
		}
		if(!(productName.length() > 0)) {
			productName = null;
		}
		
		Map searchMap = new HashMap();
		searchMap.put("section", section);
		searchMap.put("pageNum", pageNum);
		searchMap.put("productGroup", productGroup);
		searchMap.put("manufacName", manufacName);
		searchMap.put("productName", productName);
		Map productMap = ManualService.searchProduct(searchMap, memberId);
		
		productMap.put("section", section);
		productMap.put("pageNum", pageNum);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("productMap", productMap);
		mav.setViewName("/manual/manualSearch");
		return mav;
		
	}
	
	
	@RequestMapping(value="/member/manufacJoinView.do", method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView manufacJoinView(HttpServletRequest request, 
										HttpServletResponse response) throws Exception{
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/member/manufacJoin");
		return mav;
	}
	
}
