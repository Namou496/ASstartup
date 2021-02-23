package com.myspring.startup.product.manual.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.myspring.startup.member.vo.MemberVO;
import com.myspring.startup.product.manual.dao.ManualDAO;
import com.myspring.startup.product.vo.ProductVO;

@Service("ManualService")
@Transactional(propagation=Propagation.REQUIRED)
public class ManualServiceImpl implements ManualService{
	@Autowired
	private ManualDAO ManuDAO;
	private MemberVO memberVO;
	
//	1)제품리스트(페이징) + 사용자권한
	
			@Override
			public Map ProductList(Map pageMap, String cuId) throws Exception{
				int uno;
				String manufacName;
				MemberVO memberVO = new MemberVO();
				memberVO.setCuId(cuId);
				
				uno = ManuDAO.selectUserRight(memberVO);
				System.out.println("uno: " + uno);
				if(cuId == null) {
					uno = 1;
				}
				pageMap.put("memberId", cuId);
				pageMap.put("uno", uno);
				
				List<ProductVO> productList = ManuDAO.selectProductList(pageMap);
				
				List manufacNameList = ManuDAO.manufacNameList();
				
				Map productMap = new HashMap();

				//				페이징/ 전체 글 갯수
				int totProduct = productList.size();
				
				productMap.put("uno", uno);
				productMap.put("productList", productList);
				productMap.put("manufacNameList", manufacNameList);
				productMap.put("totProduct", totProduct);
				return productMap;
			}
			
			@Override
			public String manufacName(String cuId) throws Exception{
				String manufacName = ManuDAO.manufacName(cuId); 
				return manufacName;
			}
//			2)제품상세 + 사용자권한
					@Override
					public ProductVO ManualDetail(Map pageMap, String memberId) throws Exception{
						MemberVO memberVO = new MemberVO();
						memberVO.setCuId(memberId);
						int uno = ManuDAO.selectUserRight(memberVO);
						pageMap.put("uno", uno);
						ProductVO proVO = ManuDAO.selectManualDetail(pageMap);
						
						return proVO;
					}
					
//					3)제품검색 + 사용자권한
					@Override
					public List productGroup(String manufacturer) throws Exception{
						List productGroup = ManuDAO.selectProductGroup(manufacturer);
						return productGroup;
					}
					
					@Override
					public Map searchProduct(Map searchMap, String memberId) throws Exception{
						int uno;
						String manufacName;
						MemberVO memberVO = new MemberVO();
						memberVO.setCuId(memberId);
						if(memberId!=null) {
							uno = ManuDAO.selectUserRight(memberVO);
						} else {
							uno = 1;
						}
						System.out.println("uno::"+ uno);
						searchMap.put("memberId", memberId);
						searchMap.put("uno", uno);
						
						//				셀렉트박스/제조사이름
						List productList = ManuDAO.searchManual(searchMap);
						List manufacNameList = ManuDAO.manufacNameList();

						//				셀렉트박스/제조사이름--end
						
						int totProduct = productList.size();
						
						Map productMap = new HashMap();
						productMap.put("uno", uno);
						productMap.put("productList", productList);
						productMap.put("manufacNameList", manufacNameList);
						productMap.put("totProduct", totProduct);
						return productMap;
					}
}
