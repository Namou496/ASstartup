package com.myspring.startup.admin.manufac.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.myspring.startup.admin.manufac.service.AdminManufacService;
import com.myspring.startup.admin.manufac.vo.AdminManufacVO;


@Controller("AdminManufacController")
public class AdminManufacControllerImpl implements AdminManufacController {

	@Autowired
	private AdminManufacService adminManufacService;
	@Autowired
	private AdminManufacVO adminManufacVO;
	
	//제품승인요청리스트
	@Override
	@RequestMapping(value="/admin/manufac/adminManufacList.do" ,method={RequestMethod.GET, RequestMethod.POST})
	public ModelAndView adminManufacList(HttpServletRequest request, HttpServletResponse response)  throws Exception {
		
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
		
		Map<String,Object> ManufacMap=adminManufacService.AdminManufacList(secNum,pageNum);
		ModelAndView mav = new ModelAndView("/manufac/adminManufacList");
		mav.addObject("manufacMap",ManufacMap);

		
		return mav;
		
	}

		// 제품상세
		@Override
		@RequestMapping(value = "/admin/manufac/adminManufacDetail.do", method = {RequestMethod.GET, RequestMethod.POST })
		public ModelAndView adminManufacDetail(@RequestParam("manufacNo") int manufacNo, HttpServletRequest request, HttpServletResponse response) throws Exception {
			
			adminManufacVO=adminManufacService.AdminManufacDetail(manufacNo);
			ModelAndView mav = new ModelAndView("/manufac/adminManufacDetail");
			mav.addObject("manufacDetail", adminManufacVO);
			return mav;
		}
		
		//제조사승인 및 거절
		@Override
		@RequestMapping(value = "/admin/manufac/adminManufacApproval.do", method = {RequestMethod.GET, RequestMethod.POST })
		public ModelAndView adminManufacApproval(HttpServletRequest request, HttpServletResponse response) throws Exception{
			
			AdminManufacVO adminManufacVO=new AdminManufacVO();
			
			int approvalStatus=Integer.parseInt(request.getParameter("approvalStatus"));
			System.out.println("approvalStatus: "+ approvalStatus);
			String rejectionReason=request.getParameter("rejectionReason");
			String cuId=request.getParameter("cuId");
			
			adminManufacVO.setCuId(cuId);
			adminManufacVO.setApprovalStatus(approvalStatus);
			adminManufacVO.setRejectionReason(rejectionReason);
			ModelAndView mav = new ModelAndView();
			try {
				adminManufacService.AdminManufacApproval(adminManufacVO);
				mav.setViewName("redirect:/admin/manufac/adminManufacList.do");
			}catch(Exception e){
				e.printStackTrace();
			}
			return mav;
			
		}
		
		
		//제조사명으로검색
		
		@Override
		@RequestMapping(value = "/admin/manufac/adminManufacSearch.do", method = {RequestMethod.GET, RequestMethod.POST })
		public ModelAndView adminManufacSearch(@RequestParam("name") String name, HttpServletRequest request, HttpServletResponse response) throws Exception {
			
			List<AdminManufacVO> searchList=adminManufacService.AdminManufacSearch(name);
			ModelAndView mav = new ModelAndView("/manufac/adminManufacSearch");
			mav.addObject("searchList",searchList );
			return mav;
		
		} 

}