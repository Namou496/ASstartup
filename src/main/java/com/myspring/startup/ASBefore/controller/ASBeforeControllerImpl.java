package com.myspring.startup.ASBefore.controller;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.myspring.startup.ASBefore.service.ASBeforeService;
import com.myspring.startup.ASBefore.vo.ASBeforeListVO;
import com.myspring.startup.ASBefore.vo.ASBeforeRepearPartVO;
import com.myspring.startup.ASBefore.vo.ASBeforeVO;
import com.myspring.startup.ASBefore.vo.TestMemberVO;


@Controller("ASBeforeController")
public class ASBeforeControllerImpl implements ASBeforeController{
	
	@Autowired
	private ASBeforeService ASbeforeService;
	
	@Autowired 
	private ASBeforeListVO ASbeforeListVO;
	
	@Autowired
	private ASBeforeVO ASbeforeVO;
	
	private static final Logger logger = LoggerFactory.getLogger(ASBeforeControllerImpl.class);
	
	
	@Override
	@RequestMapping(value="/ASBefore/listASBefore.do", method= {RequestMethod.GET,RequestMethod.POST})/*통합구현시 get삭제*/
	public ModelAndView listASBefore(
			HttpServletRequest request, HttpServletResponse response
	) throws Exception {
		request.setCharacterEncoding("utf-8");
		
		TestMemberVO member = new TestMemberVO();// start!!! 테스트목적 임시 member객체
		
		member.setCuid("king");
		member.setuNo(4);
		
		HttpSession session = request.getSession();
		session.setAttribute("member", member); //end:테스트 종료후 삭제
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("/ASBefore/listASBefore");
		
		return mav;
		
		
	}
	
	@Override
	@RequestMapping(value="/ASBefore/paging.do", method= {RequestMethod.POST})
	public void paging(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		Map<String,Object> requestMap = new HashMap<String, Object>();
		TestMemberVO member=(TestMemberVO)session.getAttribute("member");
		
		String cuId = member.getCuid();
		int uNo = member.getuNo();
		int sta = Integer.parseInt(request.getParameter("sta"));
		
		requestMap.put("uNo", uNo);
		requestMap.put("cuId", cuId);
		requestMap.put("sta", sta);
		
		int paging = ASbeforeService.countASBeforeList(requestMap);
		
		JSONObject json = new JSONObject();
		
		json.put("paging", paging);
		
		String outJson=json.toString();
		
		out.print(outJson);
		
	}
	
	@Override
	@RequestMapping(value="/ASBefore/ASBeforeListAjax.do", method= {RequestMethod.POST})
	public void ajaxListAsBefore(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		TestMemberVO member=(TestMemberVO)session.getAttribute("member");
		
		String cuId = member.getCuid();
		int uNo = member.getuNo();
		int inSta = Integer.parseInt(request.getParameter("sta"));

		Map<String,Object> requestMap = new HashMap<String, Object>();
		
		requestMap.put("cuId", cuId);
		requestMap.put("uNo", uNo);
		requestMap.put("sta", inSta);
		
		List<ASBeforeListVO> list=ASbeforeService.listASBeforeAjax(requestMap);
		
		JSONArray jsonArray = new JSONArray();
		JSONObject totalJson = new JSONObject();
		
		
		for(ASBeforeListVO ASBeforeList : list) {
			JSONObject json = new JSONObject();
			json.put("asno", ASBeforeList.getAsno());
			json.put("name", ASBeforeList.getName());
			json.put("prodgroup", ASBeforeList.getProdgroup());
			json.put("addr", ASBeforeList.getAddr());
			
			String meeting="";
			switch(ASBeforeList.getMeeting()) {
			case 1:
				meeting = "방문";
				break;
			case 2:
				meeting = "내방";
				break;
			}
			json.put("meeting", meeting);
			
			
			json.put("respDate", ASBeforeList.getRespDate().toString());
			
			
			String sta="";
			switch(ASBeforeList.getSta()) {
			case 2:
				 sta = "처리중";
				break;
			case 3:
				 sta = "처리완료";
				break;
			}
			json.put("sta", sta);
			
			
			jsonArray.add(json);
			
			
		}
		
		totalJson.put("ASBeforeList", jsonArray);
		
		String outJson = totalJson.toString();
		
		out.print(outJson);
		
		
	}
	
	@Override
	@RequestMapping(value = "/ASBefore/viewASBefore.do", method = {RequestMethod.POST,RequestMethod.GET})
	public ModelAndView viewASBefore(
			HttpServletRequest request, 
			HttpServletResponse response, 
			@RequestParam("asno") int asno
	)throws Exception {
		Map<String, Object> requestMap = new HashMap<String, Object>();
		
		requestMap.put("asno", asno);
		
		Map<String,Object> ASbeforeMap=ASbeforeService.viewASBefore(requestMap);
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("ASbeforeMap", ASbeforeMap);
		
		mav.setViewName("/ASBefore/viewASBefore");
		
		return mav;
		
		
	}
	
	@Override
	@RequestMapping(value="/ASBefore/repearPartList.do", method = RequestMethod.POST)
	public void repearPartList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		int productNo=Integer.parseInt(request.getParameter("productNo"));
		
		Map<String,Object> requestMap = new HashMap<String,Object>();
		
		requestMap.put("productNo", productNo);
		
		List<ASBeforeRepearPartVO> list=ASbeforeService.listRepearPartAjax(requestMap);
		
		JSONObject costJson =new JSONObject();
		JSONObject partNoJson = new JSONObject();
		JSONArray jsonArray = new JSONArray();
		
		for(ASBeforeRepearPartVO RepearPart : list) {
			costJson.put(RepearPart.getName(), RepearPart.getPrice());
			partNoJson.put(RepearPart.getName(), RepearPart.getComponentNo());
		}
		
		jsonArray.add(costJson);
		jsonArray.add(partNoJson);
		
		String outJson = jsonArray.toString();
		
		logger.info(outJson);
		
		out.print(outJson);
		
	}
	
	
	@Override
	@RequestMapping(value="/ASBefore/addASBefore.do", method= RequestMethod.POST)
	@ResponseBody
	public ResponseEntity addASBefore(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int asno = Integer.parseInt(request.getParameter("asno"));
		String asComment = request.getParameter("asComment");
		int manCost = Integer.parseInt(request.getParameter("manCost"));
		int serviceCost = Integer.parseInt(request.getParameter("serviceCost"));
		String partList = request.getParameter("partList");

		Map<String,Object> requestMap = new HashMap<String, Object>();
		
		ASbeforeVO.setAsno(asno);
		ASbeforeVO.setAsComment(asComment);
		ASbeforeVO.setManCost(manCost);
		ASbeforeVO.setServiceCost(serviceCost);
		
		requestMap.put("ASBeofre", ASbeforeVO);
		requestMap.put("asno", asno);
		
		if(!partList.equals("NotPart")) {
			JSONParser parser = new JSONParser();
			JSONArray jsonArray = (JSONArray)parser.parse(partList);
			List<Map<String,Object>> AScomponentLogList = new ArrayList<Map<String,Object>>();
			for(int i=0; i<jsonArray.size(); i++) {
				JSONObject tempJson = (JSONObject)jsonArray.get(i);
				Object partNo = tempJson.get("partNo");
				Object amount = tempJson.get("amount");
				
				Map<String,Object> map = new HashMap<String, Object>();
				
				map.put("asno", asno);
				map.put("partNo", partNo);
				map.put("amount",amount);
				
				AScomponentLogList.add(map);
			}
			requestMap.put("AScomponentLogList", AScomponentLogList);
		}
		
		String message;
		
		try {
			ASbeforeService.addASBefore(requestMap);
			message="<script>"
						+ "alert('처리완료');"
						+ "location.href='"+request.getContextPath()+"/ASBefore/viewASBefore.do?asno="+asno+"';"
					+"</script>";
		}catch(Exception e) {
			e.printStackTrace();
			message="<script>"
						+ "alert('처리에실패했습니다. 사이트 관리자에게문의하세요.');"
						+ "location.href='"+request.getContextPath()+"/ASBefore/viewASBefore.do?asno="+asno+"&sta=2';"
					+"</script>";
		}
		ResponseEntity resEnt = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
		
		return resEnt;
		
	}
	
	
	
}
