package com.myspring.startup.admin.product.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.myspring.startup.admin.product.vo.AdminProductVO;

@Repository("adminProductDAO")
public class AdminProductDAOImpl  implements AdminProductDAO{
	@Autowired
	private SqlSession sqlSession;

//	제품승인요청리스트
	@Override
	public List<AdminProductVO> selectProductApprovalList() throws DataAccessException {
		List<AdminProductVO> productList=sqlSession.selectList("mapper.adminProduct.selectProductApprovalList");
		return productList;
	}
	
//	제품상세
	@Override
	public AdminProductVO selectProductApprovalDetail(int productNO) throws DataAccessException {
		return sqlSession.selectOne("mapper.adminProduct.selectProductApprovalDetail",productNO);
		
	}
	
//	제품검색
	@Override
	public ArrayList selectByProduct(String name) throws DataAccessException {
		ArrayList List= (ArrayList)sqlSession.selectList("mapper.adminProduct.selectByProduct",name);
		return List;
		
	}
	
//	제품승인거절
	@Override
	public void updateProductApprovalStatus(AdminProductVO adminProductVO) throws DataAccessException {
		sqlSession.update("mapper.adminProduct.updateProductApprovalStatus",adminProductVO);
		
	}
	

}

