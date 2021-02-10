package com.myspring.startup.product.product.controller;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.myspring.startup.product.product.service.ProductService;
import com.myspring.startup.product.vo.ProductVO;

import net.sf.json.JSONArray;

@Controller("ProductController")
public class ProductControllerImpl implements ProductController{
	private static String CURR_FILE_REPO_PATH = "C:\\Users\\du2sa\\Desktop\\work\\Java\\test\\startUp";
	
	
	@Autowired
	private ProductService ProductService;
	@Autowired
	private ProductVO ProductVO;
	
//	1) 제품리스트(페이징)
	@Override
	@RequestMapping(value="/Product/listProduct.do", method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView listProduct(HttpServletRequest request, 
									HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		System.out.println("gd");
		String memberId = "park";  //테스트용
		//123123123
		String _section = request.getParameter("section");
		String _pageNum = request.getParameter("pageNum");
		int section = Integer.parseInt(((_section == null)? "1" : _section));
		int pageNum = Integer.parseInt(((_pageNum == null)? "1" : _pageNum));
//		int section = 1;
//		int pageNum = 1;
		HttpSession session = request.getSession();
//		String memberId = (String) session.getAttribute("memberId");

		System.out.println("memberId:" + memberId);
		
		Map pageMap = new HashMap();
		pageMap.put("section", section);
		pageMap.put("pageNum", pageNum);
		

		Map productMap= ProductService.ProductList(pageMap, memberId);
		productMap.put("section", section);
		productMap.put("pageNum", pageNum);
		
		
//		테스트 중
		System.out.println("section:" + section);
		System.out.println("pageNum:" + pageNum);
		System.out.println("productList.size()"+productMap.size());
		for(int i = 0; i < productMap.size(); i++) {
			System.out.println("productList:" + productMap.get(i));
		}
		System.out.println("memberId:" + memberId);
//		테스트 중

		ModelAndView mav = new ModelAndView();
		mav.addObject("productMap", productMap);
		mav.setViewName("/product/productApplyBoard");
		return mav;
		
	}
//	2) 제품상세
	@Override
	@RequestMapping(value="/Product/ProductDetail.do", method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView ProductDetail(HttpServletRequest request, 
						 			  HttpServletResponse response) throws Exception{
		System.out.println("hi");
		request.setCharacterEncoding("UTF-8");
		String _section = request.getParameter("section");
		String _pageNum = request.getParameter("pageNum");
		System.out.println("section:"+ _section+" pageNum:"+ _pageNum);
		int section = Integer.parseInt(_section);
		int pageNum = Integer.parseInt(_pageNum);
		
//		String memberId = (String) session.getAttribute("memberId");
		String memberId = "park";  
		String productNo = request.getParameter("productNo");

		if(section == 0) {
			section = 1;
		}
		if(pageNum == 0) {
			pageNum = 1;
		}
		Map pageMap = new HashMap();
		pageMap.put("section", section);
		pageMap.put("pageNum", pageNum);
		pageMap.put("productNo", productNo);
		System.out.println("memberId: "+memberId);
		ProductVO product = ProductService.ProductDetail(pageMap, memberId);
		System.out.println("section:" + section);
		System.out.println("pageNum:" + pageNum);
		System.out.println("memberId:" + memberId);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("product", product);
		mav.addObject("pageMap", pageMap);
		mav.setViewName("/product/productApplyDetail");
		return mav;
	}
//	3) 제품검색
	@Override
	@RequestMapping(value="/Product/selectManufacturer.do", method= {RequestMethod.GET,RequestMethod.POST})
	public void selectAjaxManufacName(HttpServletRequest req, HttpServletResponse res, String param) 
	throws Exception{
			   res.setCharacterEncoding("UTF-8");
			   
			   // 도 정보 받음
			   String manufacName = param;
			   System.out.println("하이");
			   System.out.println("manufacturer:" + manufacName);
			   // 알맞은 동적 select box info 생성
			   List groupList = new ArrayList();
			   System.out.println("하이");
			   groupList = ProductService.productGroup(manufacName);
			   System.out.println("하이");
			   // jsonArray에 추가
			   JSONArray jsonArray = new JSONArray();
			   for (int i = 0; i < groupList.size(); i++) {
			      jsonArray.add(groupList.get(i));
			      System.out.println("groupList:" + groupList.get(i));
			   }
			 
			   // jsonArray 넘김
			   PrintWriter pw = res.getWriter();
			   pw.print(jsonArray.toString());
			   pw.flush();
			   pw.close();

	}
	
	@Override
	@RequestMapping(value="/Product/searchProduct.do", method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView searchProduct(HttpServletRequest request, 
									HttpServletResponse response) throws Exception{
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
//		테스트
		String memberId = "park";  //테스트용
		//123123123
		String _section = request.getParameter("section");
		String _pageNum = request.getParameter("pageNum");
		int section = Integer.parseInt(((_section == null)? "1" : _section));
		int pageNum = Integer.parseInt(((_pageNum == null)? "1" : _pageNum));
//		테스트
		String productGroup = request.getParameter("productGroup");
		String manufacName = request.getParameter("manufacName");
		String productName = request.getParameter("productName");
		
		if(!(productGroup.length() > 0)) {
			productGroup = null;
		}
		if(!(manufacName.length() > 0)) {
			manufacName = null;
		}
		if(!(productName.length() > 0)) {
			productName = null;
		}
		
		System.out.println("productGroup:" + productGroup);
		System.out.println("manufacName:"+manufacName);
		System.out.println("productName:"+productName);
		
		HttpSession session = request.getSession();
//		String memberId = (String) session.getAttribute("memberId");
		Map searchMap = new HashMap();
		searchMap.put("section", section);
		searchMap.put("pageNum", pageNum);
		searchMap.put("productGroup", productGroup);
		searchMap.put("manufacName", manufacName);
		searchMap.put("productName", productName);
		Map productMap = ProductService.searchProduct(searchMap, memberId);
//		테스트 중
		System.out.println("section:" + section);
		System.out.println("pageNum:" + pageNum);
		for(int i = 0; i < productMap.size(); i++) {
			System.out.println("productList:" + productMap.get(i));
		}
		System.out.println("memberId:" + memberId);
		System.out.println("productMap.size():" + productMap.size());
//		테스트 중
		
		productMap.put("section", section);
		productMap.put("pageNum", pageNum);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("productMap", productMap);
		mav.setViewName("/product/searchProduct");
		return mav;
		
	}
//	4) 제품등록(미완)
	//	Fileupload부분이 필요하다.
	@Override
	@RequestMapping(value="/Product/applyProductView.do", method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView applyProduct(HttpServletRequest request, 
									 HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("UTF-8");
		String _section = request.getParameter("section");
		String _pageNum = request.getParameter("pageNum");

		int section = 0;
		int pageNum = 0;
		if(_section == null) {
			section = 1;
		}
		if(_pageNum == null) {
			pageNum = 1;
		}
		System.out.println("section:"+ section+" pageNum:"+ pageNum);
		Map pageMap = new HashMap();
		pageMap.put("section", section);
		pageMap.put("pageNum", pageNum);
		ModelAndView mav = new ModelAndView();
		mav.addObject("pageMap", pageMap);
		mav.setViewName("/product/productApplyView");
		return mav;
	}
	@Override
	@RequestMapping(value="/Product/applyProduct.do", method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView applyProduct(MultipartHttpServletRequest multipartRequest, 
									 HttpServletResponse response) throws Exception{
		multipartRequest.setCharacterEncoding("utf-8");
		upload(multipartRequest, response);
//		product
		int uno = 3;
		String 	productName = multipartRequest.getParameter("productName");
		String 	productGroup = multipartRequest.getParameter("productGroup");
		String 	useManual = multipartRequest.getParameter("useManual");
		String 	asManual = multipartRequest.getParameter("asManual");
		String 	productImage = multipartRequest.getParameter("productImage");
//		component
		Map product = new HashMap();
		product.put("productName", productName);
		product.put("productGroup", productGroup);
		product.put("useManual", useManual);
		product.put("asManual", asManual);
		product.put("productImage", productImage);

//		List component = new ArrayList();
		Map<String, Integer> component = new HashMap<String, Integer>();
		String[] componentName = multipartRequest.getParameterValues("componentName");
		for(int i=0; i < componentName.length; i++) {
			String[] componentPart = multipartRequest.getParameterValues("componentPart");

			component.put(componentName[i], Integer.parseInt(componentPart[i]));
		}
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/product/productApply");
		return mav;
	}
	
	private Map upload(MultipartHttpServletRequest multipartRequest,
							   HttpServletResponse response) throws Exception{
		int uno = 3;
		Map map = new HashMap();
		Enumeration enu = multipartRequest.getParameterNames();
		while(enu.hasMoreElements()) {
			
			String name = (String)enu.nextElement();
			String value = multipartRequest.getParameter(name);
			map.put(name, value);
		}
		
		List fileList = fileProcess(multipartRequest, uno);
		
		return map;
	}
	private List fileProcess(MultipartHttpServletRequest multipartRequest, int uno) throws Exception{
		String productName = multipartRequest.getParameter("productName");
		List fileList = new ArrayList();
		Iterator<String> fileNames = multipartRequest.getFileNames();
		
		while(fileNames.hasNext()) {
			
			String fileName = fileNames.next();
			MultipartFile mFile = multipartRequest.getFile(fileName);
			String originalFileName = mFile.getOriginalFilename();
			fileList.add(originalFileName);
			
			
			
			String manufacPath = CURR_FILE_REPO_PATH+"\\"+"manufacturer" + "\\" + productName + "\\" + fileName;
			String manufacPath_original = CURR_FILE_REPO_PATH+"\\"+"manufacturer" + "\\" + productName + "\\" + originalFileName;
			String userPath = CURR_FILE_REPO_PATH+"\\"+"user" + "\\" + fileName;
			String userPath_original =  CURR_FILE_REPO_PATH+"\\"+"user" + "\\" + originalFileName;
			String asPath = CURR_FILE_REPO_PATH+"\\"+"as" + "\\" + fileName;
			String asPath_original = CURR_FILE_REPO_PATH+"\\"+"as" + "\\" + originalFileName;
			
			if(uno == 3) {
				File file = new File(manufacPath);
				if(mFile.getSize()!=0) {
					if(! file.exists()) {
						if(file.getParentFile().mkdirs()) {
							file.createNewFile();
						}
					}
					mFile.transferTo(new File(manufacPath_original));
				}
				
			}
			
			if(uno == 1) {
				File file = new File(userPath);
				if(mFile.getSize()!=0) {
					if(! file.exists()) {
						if(file.getParentFile().mkdirs()) {
							file.createNewFile();
						}
					}
					mFile.transferTo(new File(userPath_original));
				}
				
			}
			
			if(uno == 2) {
				File file = new File(userPath);
				if(mFile.getSize()!=0) {
					if(! file.exists()) {
						if(file.getParentFile().mkdirs()) {
							file.createNewFile();
						}
					}
					mFile.transferTo(new File(asPath_original));
				}
				
			}
			
			
			
		}
		return fileList;
	}
}
