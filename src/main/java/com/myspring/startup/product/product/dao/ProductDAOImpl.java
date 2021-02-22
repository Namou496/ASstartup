package com.myspring.startup.product.product.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.myspring.startup.member.vo.MemberVO;
import com.myspring.startup.product.vo.ProductVO;

@Repository("ProductDAO")
public class ProductDAOImpl implements ProductDAO{
	@Autowired
	private ProductVO prodVO;
	@Autowired
	private SqlSession sqlSession;
	
		//	1)제품리스트(페이징)		*
			@Override
			public List<ProductVO> selectProductList(Map pageMap) throws Exception{
				List productList = new ArrayList<ProductVO>();
				productList = (ArrayList)sqlSession.selectList("mapper.Product.selectProductList", pageMap);
				return productList;
		}
			
		//	2)제품상세
			@Override
			public ProductVO selectProductDetail(Map pageMap) throws Exception{
				ProductVO proVO = new ProductVO();
				proVO = sqlSession.selectOne("mapper.Product.selectProductDetail", pageMap);
				return proVO;
			}
			@Override
			public List selectCompo(int productNo) throws Exception{
				List componentList = new ArrayList();
				componentList = sqlSession.selectList("mapper.Product.selectCompo", productNo);
				return componentList;
			}
		//	3)제품검색
			@Override
			public List<ProductVO> searchProduct(Map searchMap) throws Exception{
				List productList = new ArrayList<ProductVO>();
				productList = (ArrayList)sqlSession.selectList("mapper.Product.searchProduct", searchMap);
				return productList;
			}
			@Override
			public List selectProductGroup(String manufacName) throws DataAccessException{
				List productGroup = sqlSession.selectList("mapper.Product.selectProductGroup", manufacName);
				return productGroup;
			}
		//  4-1)제품등록-최신 번호 가져오기
			@Override
			public int selectRecentProd() throws Exception{
				int productNo = sqlSession.selectOne("mapper.Product.selectRecentProd");
				return productNo;
			}
//* 제조사 이름 가져오기
			@Override
			public String manufacName(String cuId) throws Exception{
				return sqlSession.selectOne("mapper.Product.manufacName", cuId);
			}
			//  4-2)부품등록-최신 번호 가져오기
			@Override
			public int selectRecentCompo() throws Exception{
				int componentNo = sqlSession.selectOne("mapper.Product.selectRecentCompo");
				return componentNo;
			}
		//	4-3)제품등록
			@Override
			public void insertProduct(Map product) throws DataAccessException{
				sqlSession.insert("mapper.Product.insertProduct", product);

			}
		//	4-4)부품등록
			@Override
			public void insertComponent(List componentList) throws Exception{
				System.out.println("componentList::" + componentList.toString());
				sqlSession.insert("mapper.Product.insertComponent", componentList);
			}
		//	4-5)제품 승인등록- 최신번호 가져오기
			@Override
			public int selectRecentApprNum() throws Exception{
				int approvalNum = sqlSession.selectOne("mapper.Product.selectRecentApprNum");
				return approvalNum;
			}
		//  4-6)제품 승인등록		
			@Override
			public void insertProductApply(Map product) throws Exception{
				sqlSession.insert("mapper.Product.insertProductApply", product);
			}
		//	0) 사용자권한 - 리스트에서 가져와야 한다.
			@Override
			public int selectUserRight(MemberVO memberVO) throws Exception{
				String cuid = memberVO.getCuId();
				int userRight = sqlSession.selectOne("mapper.Product.selectUserRight", cuid);
				return userRight;
			}
}
