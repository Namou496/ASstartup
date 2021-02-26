package com.myspring.startup.admin.satisfaction.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.myspring.startup.Asstarrate.vo.AsstarrateVO;
import com.myspring.startup.admin.satisfaction.service.AdminSatisfactionService;

@Controller("AdminSatisfactionController")
public class AdminSatisfactionControllerImpl implements AdminSatisfactionController {

	@Autowired
	private AdminSatisfactionService adminSatisfactionService;
	@Autowired
	private AsstarrateVO asstarrateVO;
	
	//만족도리스트
	@Override
	@RequestMapping(value="/admin/satisfaction/adminSatisfactionList.do" ,method={RequestMethod.GET, RequestMethod.POST})
	public ModelAndView adminSatisfactionList(HttpServletRequest request, HttpServletResponse response)  throws Exception {
		
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
		
		Map<String,Object> SatisfactionMap=adminSatisfactionService.AdminSatisfactionList(secNum,pageNum);
		ModelAndView mav = new ModelAndView("/satisfaction/adminSatisfactionList");
		mav.addObject("satisfactionMap",SatisfactionMap);

		
		return mav;
		
	}

		// 만족도상세
		@Override
		@RequestMapping(value = "/admin/satisfaction/adminSatisfactionDetail.do", method = {RequestMethod.GET, RequestMethod.POST })
		public ModelAndView adminSatisfactionDetail(@RequestParam("asNo") int asNo, HttpServletRequest request, HttpServletResponse response) throws Exception {
			
			asstarrateVO=adminSatisfactionService.AdminSatisfactionDetail(asNo);
			ModelAndView mav = new ModelAndView("/satisfaction/adminSatisfactionDetail");
			mav.addObject("satisfactionDetail", asstarrateVO);
			return mav;
		}
	
}
