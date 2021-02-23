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
		
//		//제품승인 및 거절
//		@Override
//		@RequestMapping(value = "/admin/product/adminProductApproval.do", method = {RequestMethod.GET, RequestMethod.POST })
//		public ModelAndView adminProductApproval(HttpServletRequest request, HttpServletResponse response) throws Exception{
//			
//			int productNO=Integer.parseInt(request.getParameter("productNO"));
//			int approvalStatus=Integer.parseInt(request.getParameter("approvalStatus"));
//			String rejectionReason=request.getParameter("rejectionReason");
//			
//			AdminProductVO adminProductVO=new AdminProductVO();
//
//			adminProductVO.setProductNO(productNO);
//			adminProductVO.setApprovalStatus(approvalStatus);
//			adminProductVO.setRejectionReason(rejectionReason);
//			
//			adminProductService.AdminProductApproval(adminProductVO);
//			
//			ModelAndView mav = new ModelAndView("redirect:/admin/product/adminProductList.do");
//			
//			return mav;
//			
//		}
//		
//		
//		//제품명으로검색
//		
//		@Override
//		@RequestMapping(value = "/admin/product/adminProductSearch.do", method = {RequestMethod.GET, RequestMethod.POST })
//		public ModelAndView adminProductSearch(@RequestParam("name") String name, HttpServletRequest request, HttpServletResponse response) throws Exception {
//			
//			List<AdminProductVO> searchList=adminProductService.AdminProductSearch(name);
//			ModelAndView mav = new ModelAndView("/product/adminProductSearch");
//			mav.addObject("searchList",searchList );
//			return mav;
//		
//		} 

}