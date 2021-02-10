package com.myspring.startup.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	@Override
	@RequestMapping(value="/login.do", method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView login(@ModelAttribute("member") MemberVO member, RedirectAttributes rAttr, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
//		member.setCuId("hong");
//		member.setPw("12345");
		try {
			memberVO = memberService.login(member);
			if(memberVO != null) {
				HttpSession session = request.getSession();
				session.setAttribute("member",  memberVO);
				session.setAttribute("isLogOn", true);
				mav.setViewName("redirect:/ASForm/ASForm.do");
			}else {
				rAttr.addAttribute("result", "loginFailed");
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
		session.removeAttribute("memberInfo");
		mav.setViewName("redirect:/main/main.do");
		return mav;
	}
	
	@Override
	public ModelAndView listMembers(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ModelAndView addMember(MemberVO memberVO, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ModelAndView removeMember(String id, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
