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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.myspring.startup.member.vo.MemberVO;
import com.myspring.startup.product.product.service.ProductService;
import com.myspring.startup.product.vo.ProductVO;

import net.sf.json.JSONArray;

@Controller("ProductController")
public class ProductControllerImpl implements ProductController{
//	private static String CURR_FILE_REPO_PATH = "C:\\Users\\du2sa\\Desktop\\work\\Java\\test\\startUp";
	private static String CURR_FILE_REPO_PATH = "D:\\작업";
	
	
	@Autowired
	private ProductService ProductService;
	@Autowired
	private ProductVO ProductVO;
	
//	1) 제품리스트(페이징)
	@Override
	@RequestMapping(value="/Product/listProduct.do", method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView listProduct(@RequestParam(value="section", required=false, defaultValue="1") int section,
									@RequestParam(value="pageNum", required=false, defaultValue="1") int pageNum,
									HttpServletRequest request, 
									HttpServletResponse response
									) throws Exception{
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		ModelAndView mav = new ModelAndView();
		PrintWriter pw = response.getWriter();
		//ㅁ
		try {		
			HttpSession session = request.getSession();
			MemberVO memberId = (MemberVO) session.getAttribute("member");
			String _memberId = memberId.getCuId();
	
			String manufacName = ProductService.manufacName(_memberId);
	
			Map pageMap = new HashMap();
			pageMap.put("section", section);
			pageMap.put("pageNum", pageNum);
			pageMap.put("manufacName", manufacName);
			
			Map productMap= ProductService.ProductList(pageMap, _memberId); 
			// productMap --> 제품리스트, 전체글수, 제조사이름리스트, 사용자권한
			
			//		페이징 section, pageNum
			productMap.put("section", section);
			productMap.put("pageNum", pageNum);
			
	
			mav.addObject("pageMap", pageMap);
			mav.addObject("productMap", productMap);
			mav.setViewName("/product/productApplyBoard");
		} catch(Exception e) {
			pw.print("<script>"+"alert('죄송합니다. 제조사 회원이 아닙니다. 제조사 로그인 후 이용하세요.');"+"location.href='"+request.getContextPath()
			+ "/main/main.do';"
			+ "</script>");
		}
		return mav;
	}
	
//	2) 제품상세
	@Override
	@RequestMapping(value="/Product/ProductDetail.do", method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView ProductDetail(@RequestParam(value="section", required=false, defaultValue="1") int section,
									  @RequestParam(value="pageNum", required=false, defaultValue="1") int pageNum,
									  @RequestParam("productNo") int productNo,
									  HttpServletRequest request, 
						 			  HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		ModelAndView mav = new ModelAndView();
		PrintWriter pw = response.getWriter();
		try {
			String _section = request.getParameter("section");
			String _pageNum = request.getParameter("pageNum");
			HttpSession session = request.getSession();
			MemberVO memberId = (MemberVO) session.getAttribute("member");
			String _memberId = memberId.getCuId();
			
	
			Map pageMap = new HashMap();
			pageMap.put("section", section);
			pageMap.put("pageNum", pageNum);
			pageMap.put("productNo", productNo);
			
			ProductVO product = ProductService.ProductDetail(pageMap, _memberId); //제품상세 정보
			List componentList = ProductService.compoDetail(product.getProductNo()); //부품리스트
		
			mav.addObject("product", product);
			mav.addObject("pageMap", pageMap);
			mav.addObject("componentList", componentList);
			mav.setViewName("/product/productApplyDetail");
		} catch(Exception e) {
			pw.print("<script>"+"alert('죄송합니다. 제조사 회원이 아닙니다. 제조사 로그인 후 이용하세요.');"+"location.href='"+request.getContextPath()
			+ "/main/main.do';"
			+ "</script>");
		}
		return mav;
	}
//	3) 제품검색
	// ajax 필터
	@Override
	@RequestMapping(value="/Product/selectManufacturer.do", method= {RequestMethod.GET,RequestMethod.POST})
	public void selectAjaxManufacName(HttpServletRequest req, HttpServletResponse res, String param) 
	throws Exception{
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = res.getWriter();
		try {
			   String manufacName = param;
			   // 알맞은 동적 select box info 생성
			   List groupList = new ArrayList();
			   groupList = ProductService.productGroup(manufacName);
			   // jsonArray에 추가
			   JSONArray jsonArray = new JSONArray();
			   for (int i = 0; i < groupList.size(); i++) {
			      jsonArray.add(groupList.get(i));
			   }
			 
			   // jsonArray 넘김
			   pw.print(jsonArray.toString());
			   pw.flush();
			   pw.close();
		} catch(Exception e) {
			pw.print("<script>"+"alert('죄송합니다. 등록되지 않은 상품 입니다.');" + "</script>");
		}

	}
	// 제품 검색
	@Override
	@RequestMapping(value="/Product/searchProduct.do", method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView searchProduct(  @RequestParam(value="section", required=false, defaultValue="1") int section,
			  							@RequestParam(value="pageNum", required=false, defaultValue="1") int pageNum,
			  							@RequestParam(value="productGroup", required=false, defaultValue="") String productGroup,
			  							@RequestParam(value="manufacName", required=false, defaultValue="") String manufacName,
			  							@RequestParam(value="productName", required=false, defaultValue="") String productName,
										HttpServletRequest request, 
										HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		ModelAndView mav = new ModelAndView();
		PrintWriter pw = response.getWriter();
		try {
			HttpSession session = request.getSession();
			MemberVO memberId = (MemberVO) session.getAttribute("member");
			String _memberId = memberId.getCuId();
			
			// ""값  mybatis에 맞게 형변환
			if(!(productGroup.length() > 0)) {
				productGroup = null;
			}
			if(!(manufacName.length() > 0)) {
				manufacName = null;
			}
			if(!(productName.length() > 0)) {
				productName = null;
			}
			
			Map searchMap = new HashMap();
			searchMap.put("section", section);
			searchMap.put("pageNum", pageNum);
			searchMap.put("productGroup", productGroup);
			searchMap.put("manufacName", manufacName);
			searchMap.put("productName", productName);
			Map productMap = ProductService.searchProduct(searchMap, _memberId);
			
			productMap.put("section", section);
			productMap.put("pageNum", pageNum);
			
			mav.addObject("productMap", productMap);
			mav.setViewName("/product/searchProduct");
		} catch (Exception e) {
			pw.print("<script>"+"alert('죄송합니다. 잘못된 접근입니다. 메인페이지로 돌아갑니다.');"+"location.href='"+request.getContextPath()
			+ "/main/main.do';"
			+ "</script>");
		}
		return mav;
	}
//	4) 제품등록
	// 제품등록페이지
	@Override
	@RequestMapping(value="/Product/applyProductView.do", method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView applyProductView(HttpServletRequest request,
			 						HttpServletResponse response,
									 @RequestParam(value="section", required=false, defaultValue="1") int section,
									 @RequestParam(value="pageNum", required=false, defaultValue="1") int pageNum,
									 @RequestParam(value="manufacName", required=false, defaultValue="") String manufacName,
									 @ModelAttribute("member") MemberVO member
									 ) throws Exception{
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		ModelAndView mav = new ModelAndView();
		PrintWriter pw = response.getWriter();
		
		HttpSession session = request.getSession();
		member = (MemberVO) session.getAttribute("member");
		
		int approvalStatus = member.getApprovalstatus();
		System.out.println("approvalStatus"+approvalStatus);
		
		

		try {
			if(approvalStatus!=1) {
				pw.print("<script>"+"alert('죄송합니다. 비승인 회원은 이용하실 수 없습니다.');"+"location.href='"+request.getContextPath()
				+ "/Product/listProduct.do';"
				+ "</script>");
			}else{
				List GroupList = ProductService.productGroup(manufacName);
				Map pageMap = new HashMap();
				pageMap.put("section", section);
				pageMap.put("pageNum", pageNum);
				pageMap.put("manufacName", manufacName);
				pageMap.put("GroupList", GroupList);
				pageMap.put("approvalStatus", approvalStatus);
				mav.addObject("pageMap", pageMap);
				mav.setViewName("/product/productApplyView");
			}
			
		} catch(Exception e) {
			pw.print("<script>"+"alert('죄송합니다. 잘못된 접근입니다. 다시 로그인 하세요.');"+"location.href='"+request.getContextPath()
			+ "/main/main.do';"
			+ "</script>");
		}
		

		return mav;
	}
	// 제품등록
	@Override
	@RequestMapping(value="/Product/applyProduct.do", method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView applyProduct(MultipartHttpServletRequest multipartRequest, 
									 HttpServletResponse response) throws Exception{
		multipartRequest.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		ModelAndView mav = new ModelAndView();
		PrintWriter pw = response.getWriter();
		try {
		//uploadFile 이름 가져오기
			Map product = upload(multipartRequest, response);
			HttpSession session = multipartRequest.getSession();
			MemberVO memberId = (MemberVO) session.getAttribute("member");
			String _memberId = memberId.getCuId();
			String productGroup = multipartRequest.getParameter("productGroup");
			
			product.put("cuId", _memberId);
			product.put("productGroup", productGroup);
		
		//upload될 파일이름 DB에 넣을 준비
			List fileList;
			fileList = (List) product.get("fileList");
			for(int i=0; i<fileList.size();i++) {
					product.put("useManual", fileList.get(0));
					product.put("asManual", fileList.get(1));
					product.put("productImage", fileList.get(2));
					System.out.println("fileList::" + fileList.get(i));
			}
			
		//입력된 부품 및 소모품 이름 가져오기
			String[] componentName = multipartRequest.getParameterValues("componentName");
			String[] componentPart = multipartRequest.getParameterValues("componentPart");
			for (int i = 0; i < componentName.length; i++) {
				System.out.println(componentName[i]);
				}
		//제품정보 입력
			int productNo=ProductService.applyProduct(componentName, componentPart, product);
			product.put("productNo", productNo);
			mav.addObject("product", product);
			pw.print("<script>"+"alert('요청완료!!');"+"location.href='"+multipartRequest.getContextPath()
						+ "/Product/listProduct.do';"
						+ "</script>");
		} catch(Exception e) {
			pw.print("<script>"+"alert('죄송합니다. 잘못된 접근입니다.');"+"location.href='"+multipartRequest.getContextPath()
			+ "/main/main.do';"
			+ "</script>");
		}
		return mav;
	}
	
	//파일업로드
	private Map upload(MultipartHttpServletRequest multipartRequest,
							   HttpServletResponse response) throws Exception{
		int uno = 3;
		Map map = new HashMap();
		Enumeration enu = multipartRequest.getParameterNames();
		while(enu.hasMoreElements()) {
			
			String name = (String)enu.nextElement();
			String value = multipartRequest.getParameter(name);
			System.out.println(name + ", " + value);
			map.put(name, value);
		}
		
		List fileList = fileProcess(multipartRequest, uno);
		map.put("fileList", fileList);
		return map;
	}
	private List fileProcess(MultipartHttpServletRequest multipartRequest, int uno) throws Exception{
		String productName = multipartRequest.getParameter("productName");
		List fileList = new ArrayList();
		Iterator<String> fileNames = multipartRequest.getFileNames();
		int i=0;
		while(fileNames.hasNext()) {
			String fileName = fileNames.next();
			MultipartFile mFile = multipartRequest.getFile(fileName);
			String originalFileName = mFile.getOriginalFilename();
			fileList.add(originalFileName);
			
			String manufacPath = CURR_FILE_REPO_PATH+"\\"+"manufacturer" + "\\" + productName + "\\" + fileName;
			String manufacPath_useManual = CURR_FILE_REPO_PATH+"\\"+"manufacturer" + "\\" + productName + "\\"+ "useManual" + "\\";
			String manufacPath_asManual = CURR_FILE_REPO_PATH+"\\"+"manufacturer" + "\\" + productName + "\\" + "asManual" + "\\";
			String manufacPath_original = CURR_FILE_REPO_PATH+"\\"+"manufacturer" + "\\" + productName + "\\" + originalFileName;
			
			if(uno == 3) {
				//				useMaunual
				if(i == 0) {
				File file = new File(manufacPath_useManual + fileName);
					if(mFile.getSize()!=0) {
						if(! file.exists()) {
							if(file.getParentFile().mkdirs()) {
								file.createNewFile();
								
							}
						}
						mFile.transferTo(new File(manufacPath_useManual + originalFileName));
						file.delete();
						System.out.println("useManual");
					}
					//				asManual
				} else if(i == 1) {
				File file = new File(manufacPath_asManual  + fileName);
					if(mFile.getSize()!=0) {
						if(! file.exists()) {
							if(file.getParentFile().mkdirs()) {
								file.createNewFile();
							}
						}
						System.out.println("ASManual");
						mFile.transferTo(new File(manufacPath_asManual + originalFileName));
						file.delete();
					}
					//				productImage
				} else {
					File file = new File(manufacPath);
					if(mFile.getSize()!=0) {
						if(! file.exists()) {
							if(file.getParentFile().mkdirs()) {
								file.createNewFile();
							}
						}
						mFile.transferTo(new File(manufacPath_original));
						System.out.println("IMAGE");
					}
				
				}
				
			}
			
			i++;
		}
		return fileList;
	}
}
