package com.myspring.startup.member.controller;

import java.io.PrintWriter;
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

import net.sf.json.JSONArray;

@Controller("memberController")
@RequestMapping(value="/member/*")
@EnableAspectJAutoProxy
public class MemberControllerImpl implements MemberController{
	@Autowired
	private MemberService memberService;
	@Autowired
	private MemberVO memberVO;
	
	String _cuId;
	
	//로그인 페이지 실행
	@Override
	@RequestMapping(value="/login.do", method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView login(@ModelAttribute("member") MemberVO member, RedirectAttributes rAttr, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		try {
			HttpSession session = request.getSession();
			memberVO = memberService.login(member);
			if(memberVO != null) {
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

	//로그아웃
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

	//회원가입 후 처리
	@Override
	@RequestMapping(value="/addMember.do", method= {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public ResponseEntity addMember(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Map<String, Object> memberJoinMap = new HashMap<String, Object>();
		Enumeration enu = request.getParameterNames();
		while(enu.hasMoreElements()) {
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
			}else if(uno == 1 || uno == 2) {
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
				message += "alert('회원가입이 실패했습니다. 다시 시도해 주세요.');";
				message += " location.href='"+request.getContextPath()+"/member/join.do';";
				message += " </script>";
				resEntity = new ResponseEntity<String>(message, resHeaders, HttpStatus.CREATED);
			}else if(uno==3) {
				message = "<script>";
				message += "alert('회원가입이 실패했습니다. 다시 시도해 주세요.');";
				message += " location.href='"+request.getContextPath()+"/member/manufacJoinView.do';";
				message += " </script>";
				resEntity = new ResponseEntity<String>(message, resHeaders, HttpStatus.CREATED);
			}
		}
		return resEntity;
	}

	//회원가입 페이지 실행
	@Override
	@RequestMapping(value="/join.do", method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView joinPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/member/join");
		return mav;
	}
	
	//비밀번호 찾기 페이지 실행
	@Override
	@RequestMapping(value="/pw.do", method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView pagepw(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/member/pw");
		return mav;
	}
	
	//아이디 찾기 페이지 실행
	@Override
	@RequestMapping(value="/id.do", method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView pageid(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/member/id");
		return mav;
	}
	
	//비밀번호 찾기 실행 후 페이지
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
			int i = memberService.searchLostPw(lostPwMap);
			if(i==1) {
				message = "<script>";
				message += " location.href='"+request.getContextPath()+"/member/repw.do';";
				message += " </script>";
				resEntity = new ResponseEntity<String>(message, resHeaders, HttpStatus.CREATED);
			}else {
				message = "<script>";
				message += "alert('사용자 정보를 찾지 못하였습니다.');";
				message += " location.href='"+request.getContextPath()+"/member/pw.do';";
				message += " </script>";
				resEntity = new ResponseEntity<String>(message, resHeaders, HttpStatus.CREATED);
			}
		}catch(Exception e) {
			message = "<script>";
			message += "alert('없는 사용자 입니다. 다시한번 확인해 주세요');";
			message += " location.href='"+request.getContextPath()+"/member/pw.do';";
			message += " </script>";
			resEntity = new ResponseEntity<String>(message, resHeaders, HttpStatus.CREATED);
		}
		return resEntity;
	}
	
	//비밀번호 변경 페이지
	@Override
	@RequestMapping(value="/repw.do", method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView pw_re(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/member/repw");
		return mav;
	}
	//비밀번호 변경 페이지 실행
	@Override
	@RequestMapping(value="/updatePw.do", method= {RequestMethod.GET, RequestMethod.POST})
	public ResponseEntity updatePw(HttpServletRequest request, HttpServletResponse response) throws Exception{
		Map<String, Object> updatePwMap = new HashMap<String, Object>();	

		String cuId = request.getParameter("cuId");
		String pw = request.getParameter("pw");
		
		updatePwMap.put("cuId", cuId);
		updatePwMap.put("pw", pw);
		
		String message;
		ResponseEntity resEntity = null;
		HttpHeaders resHeaders = new HttpHeaders();
		resHeaders.add("Content-Type", "text/html; charset=utf-8");
		try {
			memberService.updatePw(updatePwMap);
			message = "<script>";
			message += "alert('비밀번호가 변경되었습니다. ');";
			message += " location.href='"+request.getContextPath()+"/member/login.do';";
			message += " </script>";
			resEntity = new ResponseEntity<String>(message, resHeaders, HttpStatus.CREATED);
		}catch(Exception e) {
			message = "<script>";
			message += "alert('알 수 없는 오류가 발생하였습니다.');";
			message += " location.href='"+request.getContextPath()+"/main/main.do';";
			message += " </script>";
			resEntity = new ResponseEntity<String>(message, resHeaders, HttpStatus.CREATED);
		}
		return resEntity;
	}	
	
	//아이디 찾기 실행 후 페이지
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
		}
		return resEntity;
	}
	
	//찾은 아이디 출력
	@Override
	@RequestMapping(value="/newId.do", method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView newId(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.addObject("_cuId", _cuId);
		mav.setViewName("/member/newId");
		return mav;
	}
	
	//회원가입 종류(멤버) 선택
	@Override
	@RequestMapping(value="/selectMember.do", method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView selectMember(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/member/selectMember");
		return mav;
	}
	
	//회원가입 아이디 중복검사
	@Override
	@RequestMapping(value="/overlapId.do", method= {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public void overlapId(HttpServletRequest request, HttpServletResponse response, String param) throws Exception {
		response.setCharacterEncoding("UTF-8");

		String _cuId = param;
		String message;
		ResponseEntity resEntity = null;
		HttpHeaders resHeaders = new HttpHeaders();
		resHeaders.add("Content-Type", "text/html; charset=utf-8");
		String i = memberService.overlapId(_cuId);
		JSONArray jsonArray = new JSONArray();

		jsonArray.add(i);
	 
		   // jsonArray 넘김
		   PrintWriter pw = response.getWriter();
		   pw.print(jsonArray.toString());
		   pw.flush();
		   pw.close();	
	}
}
