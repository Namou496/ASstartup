package com.myspring.startup.product.manual.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.myspring.startup.member.vo.MemberVO;
import com.myspring.startup.product.vo.ProductVO;

@Repository("ManualDAO")
public class ManualDAOImpl implements ManualDAO{
	@Autowired
	private ProductVO prodVO;
	@Autowired
	private SqlSession sqlSession;
	
	
	//	0) 사용자권한 - 리스트에서 가져와야 한다.
	@Override
	public int selectUserRight(MemberVO memberVO) throws Exception{
		String cuid = memberVO.getCuId();
		int userRight = sqlSession.selectOne("mapper.Manual.selectUserRight", cuid);
		return userRight;
	}
	
	//	1)제품리스트(페이징)		*
	@Override
	public List<ProductVO> selectProductList(Map pageMap) throws Exception{
		List productList = new ArrayList<ProductVO>();
		productList = (ArrayList)sqlSession.selectList("mapper.Manual.selectManualList", pageMap);
		return productList;
	}
	@Override
	public int selectTotProduct() throws Exception{
		int totProduct = sqlSession.selectOne("mapper.Manual.selectTotProduct");
		return totProduct;
	}
	
	//	2)제품상세
	@Override
	public ProductVO selectManualDetail(Map pageMap) throws Exception{
		ProductVO proVO = new ProductVO();
		proVO = sqlSession.selectOne("mapper.Manual.selectManualDetail", pageMap);
		return proVO;
	}
	
	@Override
	public String manufacName(String cuId) throws Exception{
		return sqlSession.selectOne("mapper.Manual.manufacName", cuId);
	}
	
	@Override
	public List manufacNameList() throws Exception{
		List manufacNameList = new ArrayList();
		manufacNameList = sqlSession.selectList("mapper.Manual.manufacNameList");
		System.out.println("manufacNameList" + manufacNameList);
		return manufacNameList;
	}
	
	//	3)제품검색
	@Override
	public List<ProductVO> searchManual(Map searchMap) throws Exception{
		List productList = new ArrayList<ProductVO>();
		productList = (ArrayList)sqlSession.selectList("mapper.Manual.searchManual", searchMap);
		return productList;
	}
	@Override
	public List selectProductGroup(String manufacName) throws DataAccessException{
		List productGroup = sqlSession.selectList("mapper.Manual.selectProductGroup", manufacName);
		return productGroup;
	}
}
