package com.myspring.startup.admin.product.controller;

import java.util.HashMap;
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

import com.myspring.startup.ASForm.service.ASFormService;
import com.myspring.startup.ASForm.vo.ASFormVO;
import com.myspring.startup.admin.product.service.AdminProductService;
import com.myspring.startup.admin.product.vo.AdminProductVO;
import com.myspring.startup.product.vo.ProductVO;

@Controller("AdminProductController")
public class AdminProductControllerImpl implements AdminProductController {

	@Autowired
	private AdminProductService adminProductService;
	
	//제품승인요청리스트
	@Override
	@RequestMapping(value="/admin/product/adminProductList.do" ,method={RequestMethod.GET, RequestMethod.POST})
	public ModelAndView adminProductList(HttpServletRequest request, HttpServletResponse response)  throws Exception {
		
		List<AdminProductVO> newProductList=adminProductService.AdminProductList();
		
		ModelAndView mav = new ModelAndView();
		mav.addObject(newProductList);
		mav.setViewName("/product/adminProductList");
		return mav;
		
	}

	//제품상세
	@Override
	public ModelAndView AdminProductDetail(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		return null;
	}

	


	//제품 승인및거절

}
