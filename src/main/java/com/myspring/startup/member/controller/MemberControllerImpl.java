package com.myspring.startup.member.controller;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myspring.startup.member.service.MemberService;
import com.myspring.startup.member.vo.MemberVO;

@Controller("memberController")
@RequestMapping(value="/member/*")
@EnableAspectJAutoProxy
public class MemberControllerImpl implements MemberController{
	@Autowired
	private MemberService memberService;
	@Autowired
	private MemberVO memberVO;
	
	String _cuId;
	
	@Override
	@RequestMapping(value="/login.do", method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView login(@ModelAttribute("member") MemberVO member, RedirectAttributes rAttr, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		try {
			memberVO = memberService.login(member);
			if(memberVO != null) {
				HttpSession session = request.getSession();
				session.setAttribute("member",  memberVO);
				session.setAttribute("isLogOn", true);
				mav.setViewName("redirect:/main/main.do");
			}else {
				mav.addObject("message", "로그인에 실패하였습니다. 아이디 및 비밀번호를 정확히 입력해 주세요.");
				mav.setViewName("redirect:/member/login.do");
			}
		}catch(Exception e){
			mav.setViewName("/member/login");
		}
		return mav;			
	}

	@Override
	@RequestMapping(value="/logout.do", method=RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		HttpSession session=request.getSession();
		session.removeAttribute("isLogOn");
		session.removeAttribute("member");
		mav.setViewName("redirect:/main/main.do");
		return mav;
	}
	
	@Override
	public ModelAndView listMembers(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RequestMapping(value="/addMember.do", method= {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public ResponseEntity addMember(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Map<String, Object> memberJoinMap = new HashMap<String, Object>();
		Enumeration enu = request.getParameterNames();
		while(enu.hasMoreElements()) {
			System.out.println("11111111");
			String name=(String)enu.nextElement();
			String value=request.getParameter(name);		
			memberJoinMap.put(name, value);
		}
		int uno = 0;
		for(String mapkey : memberJoinMap.keySet()) {
			System.out.println(memberJoinMap.get(mapkey));
			if(mapkey.equals("uno")) {
				uno = Integer.parseInt((String.valueOf(memberJoinMap.get(mapkey))));
			}
		}
		memberJoinMap.put("uNo", uno);
		String addr1 = null;
		String addr2 = null;
		for(String mapkey : memberJoinMap.keySet()) {
			if(mapkey.equals("addr1")) {
				addr1 = (String) memberJoinMap.get(mapkey);
			}else if(mapkey.equals("addr2")) {
				addr2 = (String) memberJoinMap.get(mapkey);
			}
		}
		String addr = addr1 + " " + addr2;
		memberJoinMap.put("addr", addr);
		
		String message;
		ResponseEntity resEntity = null;
		HttpHeaders resHeaders = new HttpHeaders();
		resHeaders.add("Content-Type", "text/html; charset=utf-8");
		try {
			if(uno == 3) {
				memberService.addManufac(memberJoinMap);
			}else if(uno == 1) {
				System.out.println("되냐?");
				memberService.addMember(memberJoinMap);
			}
			message = "<script>";
			message += "alert('회원가입이 완료 되었습니다.');";
			message += " location.href='"+request.getContextPath()+"/main/main.do';";
			message += " </script>";
			resEntity = new ResponseEntity<String>(message, resHeaders, HttpStatus.CREATED);
		}catch(Exception e) {
			if(uno==1) {
				message = "<script>";
				message += "alert('회원가입이 실패헀습니다. 다시 시도해 주세요.');";
				message += " location.href='"+request.getContextPath()+"/member/join.do';";
				message += " </script>";
				resEntity = new ResponseEntity<String>(message, resHeaders, HttpStatus.CREATED);
			}else if(uno==3) {
				message = "<script>";
				message += "alert('회원가입이 실패헀습니다. 다시 시도해 주세요.');";
				message += " location.href='"+request.getContextPath()+"/member/manufacJoinView.do';";
				message += " </script>";
				resEntity = new ResponseEntity<String>(message, resHeaders, HttpStatus.CREATED);
			}
			
		}
		
		return resEntity;
		
	}

	@Override
	@RequestMapping(value="/join.do", method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView joinPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/member/join");
		return mav;
	}
	
	@Override
	@RequestMapping(value="/pw.do", method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView pagepw(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/member/pw");
		return mav;
	}
	
	@Override
	@RequestMapping(value="/id.do", method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView pageid(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/member/id");
		return mav;
	}
	
	@Override
	@RequestMapping(value="/lostPw.do", method= {RequestMethod.GET, RequestMethod.POST})
	public ResponseEntity lostPw(HttpServletRequest request, HttpServletResponse response) throws Exception{
		Map<String, Object> lostPwMap = new HashMap<String, Object>();	

		String email = request.getParameter("email");
		String cuId = request.getParameter("cuId");
		
		lostPwMap.put("cuId", cuId);
		lostPwMap.put("email", email);
		
		String message;
		ResponseEntity resEntity = null;
		HttpHeaders resHeaders = new HttpHeaders();
		resHeaders.add("Content-Type", "text/html; charset=utf-8");
		try {
			String pw = memberService.searchLostPw(lostPwMap);
			System.out.println(pw);
			message = "<script>";
			message += "alert('비밀번호를 입력하신 이메일로 보냈습니다. ');";
			message += " location.href='"+request.getContextPath()+"/member/login.do';";
			message += " </script>";
			resEntity = new ResponseEntity<String>(message, resHeaders, HttpStatus.CREATED);
		}catch(Exception e) {
			message = "<script>";
			message += "alert('없는 사용자 입니다. 다시한번 확인해 주세요');";
			message += " location.href='"+request.getContextPath()+"/member/pw.do';";
			message += " </script>";
			resEntity = new ResponseEntity<String>(message, resHeaders, HttpStatus.CREATED);
			e.printStackTrace();
		}
		return resEntity;
	}
	
	@Override
	@RequestMapping(value="/lostId.do", method= {RequestMethod.GET, RequestMethod.POST})
	public ResponseEntity lostId(HttpServletRequest request, HttpServletResponse response) throws Exception{
		Map<String, Object> lostIdMap = new HashMap<String, Object>();	
		ModelAndView mav = new ModelAndView();
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		
		lostIdMap.put("email", email);
		lostIdMap.put("name", name);
		
		String message;
		ResponseEntity resEntity = null;
		HttpHeaders resHeaders = new HttpHeaders();
		resHeaders.add("Content-Type", "text/html; charset=utf-8");
		try {
			_cuId = memberService.searchLostId(lostIdMap);
			System.out.println("c" + _cuId);
			message = "<script>";
			message += " location.href='"+request.getContextPath()+"/member/newId.do';";
			message += " </script>";
			resEntity = new ResponseEntity<String>(message, resHeaders, HttpStatus.CREATED);
		}catch(Exception e) {
			message = "<script>";
			message += "alert('없는 사용자 입니다. 다시한번 확인해 주세요');";
			message += " location.href='"+request.getContextPath()+"/member/id.do';";
			message += " </script>";
			resEntity = new ResponseEntity<String>(message, resHeaders, HttpStatus.CREATED);
			e.printStackTrace();
		}
		return resEntity;
	}
	
	@Override
	@RequestMapping(value="/newId.do", method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView newId(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		System.out.println(_cuId);
		mav.addObject("_cuId", _cuId);
		mav.setViewName("/member/newId");
		return mav;
	}
	
	@Override
	@RequestMapping(value="/selectMember.do", method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView selectMember(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/member/selectMember");
		return mav;
	}
}
