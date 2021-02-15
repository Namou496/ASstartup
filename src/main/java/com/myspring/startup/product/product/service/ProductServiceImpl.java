package com.myspring.startup.product.product.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.myspring.startup.member.vo.MemberVO;
import com.myspring.startup.product.product.dao.ProductDAO;
import com.myspring.startup.product.vo.ProductVO;

@Service("ProductService")
@Transactional(propagation=Propagation.REQUIRED)
public class ProductServiceImpl implements ProductService{
	@Autowired
	private ProductDAO proDAO;
	private MemberVO memberVO;
		//	1)제품리스트(페이징) + 사용자권한
			
			@Override
			public Map ProductList(Map pageMap, String cuId) throws Exception{
				int uno;
				MemberVO memberVO = new MemberVO();
				memberVO.setCuId(cuId);
				uno = proDAO.selectUserRight(memberVO);
				
				if(cuId == null) {
					uno = 1;
				}
				pageMap.put("memberId", cuId);
				pageMap.put("uno", uno);
				List<ProductVO> productList = proDAO.selectProductList(pageMap);
				
				System.out.println("productList.size():" + productList.size());
				for(int i = 0; i < productList.size(); i++) {
					Object[] prod = productList.toArray();
					System.out.println("productList Service:" + prod[i]);
				}
				
				Map productMap = new HashMap();
				
				
				int totProduct = proDAO.selectTotProduct();
				System.out.println("totProduct" + totProduct);
				
				productMap.put("uno", uno);
				productMap.put("productList", productList);
				productMap.put("totProduct", totProduct);
				return productMap;
			}
		//	2)제품상세 + 사용자권한
			@Override
			public ProductVO ProductDetail(Map pageMap, String memberId) throws Exception{
				MemberVO memberVO = new MemberVO();
				System.out.println("memberId22: "+memberId);
				memberVO.setCuId(memberId);
				System.out.println("memberId: "+memberId);
				int uno = proDAO.selectUserRight(memberVO);
				pageMap.put("uno", uno);
				ProductVO proVO = proDAO.selectProductDetail(pageMap);
				
				return proVO;
			}
			@Override
			public List compoDetail(int productNo) throws Exception{
				System.out.println("componentList Service");
				List componentList = proDAO.selectCompo(productNo);
				return componentList;
			}
		//	3)제품검색 + 사용자권한
			@Override
			public List productGroup(String manufacturer) throws Exception{
				List productGroup = proDAO.selectProductGroup(manufacturer);
				System.out.println("productGroupService");
				return productGroup;
			}
			
			@Override
			public Map searchProduct(Map searchMap, String memberId) throws Exception{
				MemberVO memberVO = new MemberVO();
				memberVO.setCuId(memberId);
				int uno = proDAO.selectUserRight(memberVO);
				if(memberId == null) {
					uno = 1;
				}
				searchMap.put("memberId", memberId);
				searchMap.put("uno", uno);
				
				
				
				List<ProductVO> productList = proDAO.searchProduct(searchMap);
				System.out.println("productList.size():" + productList.size());
				int totProduct = proDAO.selectTotProduct();
				
				Map productMap = new HashMap();
				productMap.put("uno", uno);
				productMap.put("productList", productList);
				productMap.put("totProduct", totProduct);
				return productMap;
			}
		//	4)제품등록 부품,제품 최신번호 + 부품등록 및 제품등록
			@Override
			public String manufacName(String cuId) throws Exception{
				String manufacName = proDAO.manufacName(cuId); 
				return manufacName;
			}
			
			@Override
			public int applyProduct(String[] componentName, String[] _componentPart, Map product) throws Exception{
				
				List componentList = new ArrayList<ProductVO>();
				System.out.println("??RecentProd??");
				int RecentProd = proDAO.selectRecentProd();
				System.out.println("RecentProd:"+ RecentProd);
				int RecentCompo = proDAO.selectRecentCompo();
				System.out.println("RecentCompo:"+ RecentCompo);
				int RecentApprNum = proDAO.selectRecentApprNum();
				System.out.println("RecentApprNum:"+ RecentApprNum);
				int componentPart;
				Map component = new HashMap();
				
				for(int i=0; i<componentName.length; i++) {
					ProductVO proVO = new ProductVO();
					int cnt = 1+i;
					System.out.println("cnt:" + cnt);
					if(_componentPart[i].equals("부품")) {
						componentPart=1;
					}else{
						componentPart=2;
					}
					
//					component.put("componentName", componentName[i]);
//					component.put("componentPart", componentPart);
//					component.put("componentNo", RecentCompo+cnt);
//					component.put("productNo", RecentProd+1);
					proVO.setComponentName(componentName[i]);
					proVO.setComponentPart(componentPart);
					proVO.setComponentNo(RecentCompo+cnt);
					proVO.setProductNo(RecentProd+1);
					componentList.add(proVO);
					System.out.println("componentName.length!! --> " + componentName.length);
					System.out.println("componentName["+i+"]:" + componentName[i] + " _  componentPart:" + componentPart);
				}
				
				product.put("productNo", RecentProd+1);
				product.put("approvalNum", RecentApprNum+1);
				
				
				
				proDAO.insertProduct(product);
				proDAO.insertComponent(componentList);
				proDAO.insertProductApply(product);
				return RecentProd+1;
			}
}
