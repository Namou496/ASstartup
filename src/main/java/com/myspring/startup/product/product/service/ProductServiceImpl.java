package com.myspring.startup.product.product.service;

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
				String manufacName;
				MemberVO memberVO = new MemberVO();
				memberVO.setCuId(cuId);
				
				uno = proDAO.selectUserRight(memberVO);
				if(cuId == null) {
					uno = 1;
				}
				pageMap.put("memberId", cuId);
				pageMap.put("uno", uno);
				
				List<ProductVO> productList = proDAO.selectProductList(pageMap);
				
				//				셀렉트박스/제조사이름
				Set manufac = new HashSet();
				for(ProductVO proVO: productList) {
					manufacName = proVO.getManufacName();
					manufac.add(manufacName);
				}
				
				Iterator iter = manufac.iterator();
				List manufacSearch = new ArrayList();
				while(iter.hasNext()) {
					manufacName = (String) iter.next();
					manufacSearch.add(manufacName);
				}
				//				셀렉트박스/제조사이름--end
				
				Map productMap = new HashMap();

				//				페이징/ 전체 글 갯수
				int totProduct = proDAO.selectTotProduct();
				
				productMap.put("uno", uno);
				productMap.put("productList", productList);
				productMap.put("manufacSearch", manufacSearch);
				productMap.put("totProduct", totProduct);
				return productMap;
			}
//	2)제품상세 + 사용자권한
			@Override
			public ProductVO ProductDetail(Map pageMap, String memberId) throws Exception{
				MemberVO memberVO = new MemberVO();
				memberVO.setCuId(memberId);
				int uno = proDAO.selectUserRight(memberVO);
				pageMap.put("uno", uno);
				ProductVO proVO = proDAO.selectProductDetail(pageMap);
				
				return proVO;
			}
			@Override
			public List compoDetail(int productNo) throws Exception{
				List componentList = proDAO.selectCompo(productNo);
				return componentList;
			}
//	3)제품검색 + 사용자권한
			@Override
			public List productGroup(String manufacturer) throws Exception{
				List productGroup = proDAO.selectProductGroup(manufacturer);
				return productGroup;
			}
			
			@Override
			public Map searchProduct(Map searchMap, String memberId) throws Exception{
				MemberVO memberVO = new MemberVO();
				String manufacName;
				memberVO.setCuId(memberId);
				int uno = proDAO.selectUserRight(memberVO);
				if(memberId == null) {
					uno = 1;
				}
				searchMap.put("memberId", memberId);
				searchMap.put("uno", uno);
				List<ProductVO> productList = proDAO.searchProduct(searchMap);
				
				//				셀렉트박스/제조사이름
				Set manufac = new HashSet();
				for(ProductVO proVO: productList) {
					manufacName = proVO.getManufacName();
					manufac.add(manufacName);
				}
				
				Iterator iter = manufac.iterator();
				List manufacSearch = new ArrayList();
				while(iter.hasNext()) {
					manufacName = (String) iter.next();
					manufacSearch.add(manufacName);
				}
				//				셀렉트박스/제조사이름--end
				
				
				int totProduct = proDAO.selectTotProduct();
				
				Map productMap = new HashMap();
				productMap.put("uno", uno);
				productMap.put("productList", productList);
				productMap.put("manufacSearch", manufacSearch);
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
				int RecentProd = proDAO.selectRecentProd();
				int RecentCompo = proDAO.selectRecentCompo();
				int RecentApprNum = proDAO.selectRecentApprNum();
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
					
					proVO.setComponentName(componentName[i]);
					proVO.setComponentPart(componentPart);
					proVO.setComponentNo(RecentCompo+cnt);
					proVO.setProductNo(RecentProd+1);
					componentList.add(proVO);
				}
				
				product.put("productNo", RecentProd+1);
				product.put("approvalNum", RecentApprNum+1);
				
				proDAO.insertProduct(product);
				proDAO.insertComponent(componentList);
				proDAO.insertProductApply(product);
				return RecentProd+1;
			}
}
