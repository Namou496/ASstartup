package com.myspring.startup.admin.product.controller;

import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.myspring.startup.ASForm.service.ASFormService;
import com.myspring.startup.ASForm.vo.ASFormVO;
import com.myspring.startup.admin.product.service.AdminProductService;
import com.myspring.startup.admin.product.vo.AdminProductVO;
import com.myspring.startup.product.vo.ProductVO;

import oracle.net.aso.e;

@Controller("AdminProductController")
public class AdminProductControllerImpl implements AdminProductController {

	@Autowired
	private AdminProductService adminProductService;
	@Autowired
	private AdminProductVO adminProductVO;
	
	//제품승인요청리스트
	@Override
	@RequestMapping(value="/admin/product/adminProductList.do" ,method={RequestMethod.GET, RequestMethod.POST})
	public ModelAndView adminProductList(HttpServletRequest request, HttpServletResponse response)  throws Exception {
		
		List<AdminProductVO> ProductList=adminProductService.AdminProductList();
		ModelAndView mav = new ModelAndView("/product/adminProductList");
		mav.addObject("productList",ProductList);
		return mav;
		
	}

		// 제품상세
		@Override
		@RequestMapping(value = "/admin/product/adminProductDetail.do", method = {RequestMethod.GET, RequestMethod.POST })
		public ModelAndView adminProductDetail(@RequestParam("productNo") int productNo, HttpServletRequest request, HttpServletResponse response) throws Exception {
			
			adminProductVO=adminProductService.AdminProductDetail(productNo);
			ModelAndView mav = new ModelAndView("/product/adminProductDetail");
			mav.addObject("productDetail", adminProductVO);
			return mav;
		}
		
		//제품승인 및 거절
		@Override
		@ResponseBody
		@RequestMapping(value = "/admin/product/adminProductApproval.do", method = {RequestMethod.GET, RequestMethod.POST })
		public HashMap<String, String> adminProductApproval(HttpServletRequest request, HttpServletResponse response) throws Exception{
			HashMap<String,String> approvalMap=new HashMap<String,String>();
			
			String val[]=null;
			String productNO=request.getParameter("productNO");
			String approvalType=request.getParameter("approvalType");
			String value =request.getParameter("value");
			if(approvalType.equals("rejectionReason")){
				approvalMap.put("rejectionReason",val[0]);
				
			}else if(approvalType.equals("ok")) {
				approvalMap.put("",)
			}
			
			return approvalMap;
			
		}
		
		
	
		//제품명으로검색
		
		@Override
		@RequestMapping(value = "/admin/product/adminProductSearch.do", method = {RequestMethod.GET, RequestMethod.POST })
		public ModelAndView adminProductSearch(@RequestParam("name") String name, HttpServletRequest request, HttpServletResponse response) throws Exception {
			
			List<AdminProductVO> searchList=adminProductService.AdminProductSearch(name);
			ModelAndView mav = new ModelAndView("/product/adminProductSearch");
			mav.addObject("searchList",searchList );
			return mav;
		
		} 
		
		


}
