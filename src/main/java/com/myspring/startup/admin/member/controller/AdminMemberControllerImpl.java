package com.myspring.startup.admin.member.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.myspring.startup.admin.member.service.AdminMemberService;
import com.myspring.startup.admin.product.vo.AdminProductVO;
import com.myspring.startup.member.vo.MemberVO;


@Controller("AdminMemberController")
public class AdminMemberControllerImpl implements AdminMemberController{

	@Autowired
	private AdminMemberService adminMemberService;
	@Autowired
	private MemberVO memberVO;
	
	//멤버리스트
		@Override
		@RequestMapping(value="/admin/member/adminMemberList.do" ,method={RequestMethod.GET, RequestMethod.POST})
		public ModelAndView adminMemberList(HttpServletRequest request, HttpServletResponse response)  throws Exception {
			
			String section=request.getParameter("section");
			String page=request.getParameter("page");
			
			
			
			int secNum=1;
			if( section!=null) {
				secNum=Integer.parseInt(section);
			}
			
			int pageNum=1;
			if( page!=null) {
				pageNum=Integer.parseInt(page);
			}
			
			System.out.println("secNum:"+secNum);
			System.out.println("pageNum:"+pageNum);
			
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");
			
			Map<String,Object> MemberMap=adminMemberService.AdminMemberList(secNum,pageNum);
			ModelAndView mav = new ModelAndView("/member/adminMemberList");
			mav.addObject("memberMap",MemberMap);

			
			return mav;
			
		}

			//멤버 상세
			@Override
			@RequestMapping(value = "/admin/member/adminMemberDetail.do", method = {RequestMethod.GET, RequestMethod.POST })
			public ModelAndView adminMemberDetail(@RequestParam("cuId") String cuId, HttpServletRequest request, HttpServletResponse response) throws Exception {
				
				memberVO=adminMemberService.AdminMemberDetail(cuId);
				ModelAndView mav = new ModelAndView("/member/adminMemberDetail");
				mav.addObject("memberDetail", memberVO);
				return mav;
			}
			
			//멤버삭제
			@Override
			@RequestMapping(value = "/admin/member/adminMemberDelete.do", method = {RequestMethod.GET, RequestMethod.POST })
			public ModelAndView adminMemberDelete(@RequestParam("cuId") String cuId,HttpServletRequest request, HttpServletResponse response) throws Exception{
				
				adminMemberService.AdminMemberDelete(cuId);
				ModelAndView mav = new ModelAndView("redirect:/admin/member/adminMemberList.do");
				mav.addObject("memberDelete", memberVO);
				return mav;
			}

			//멤버수정
//			@Override
//			@RequestMapping(value = "/admin/member/adminMemberModify.do", method = {RequestMethod.GET, RequestMethod.POST })
//			public ModelAndView adminMemberModify(HttpServletRequest request, HttpServletResponse response) throws Exception {
//			
//				String cuId=request.getParameter("cuId");
//				String name=request.getParameter("name");
//				String addr=request.getParameter("addr");
//				String email=request.getParameter("email");
//				
//				MemberVO memberVO=new MemberVO();
//
//				memberVO.setCuId(cuId);
//				memberVO.setName(name);
//				memberVO.setAddr(addr);
//				memberVO.setEmail(email);
//				
//				ModelAndView mav = new ModelAndView("/member/adminMemberDetail");
//				
//				adminMemberService.AdminMemberModify(memberVO);
//				
//				return mav;
//			}
			
//			멤버수정페이지로이동
			@Override
			@RequestMapping(value = "/admin/member/adminMemberModifyPage.do", method = {RequestMethod.GET, RequestMethod.POST })
			public ModelAndView adminMemberModifyPage(@RequestParam("cuId") String cuId, HttpServletRequest request, HttpServletResponse response) throws Exception {
				
				memberVO=adminMemberService.AdminMemberDetail(cuId);
				ModelAndView mav = new ModelAndView("/member/adminMemberModifyPage");
				mav.addObject("memberDetail", memberVO);
				return mav;
			}
//			
			
	
}
