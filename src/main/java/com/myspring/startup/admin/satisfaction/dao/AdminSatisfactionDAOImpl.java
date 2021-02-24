package com.myspring.startup.admin.satisfaction.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.myspring.startup.Asstarrate.vo.AsstarrateVO;
import com.myspring.startup.admin.product.vo.AdminProductVO;

@Repository("adminSatisfactionDAO")
public class AdminSatisfactionDAOImpl implements AdminSatisfactionDAO{
	
	@Autowired
	private SqlSession sqlSession;
	
//	제품승인요청리스트
	
	@Override
	public List<AsstarrateVO> selectSatisfactionList(Map<String,Object> pageMap) throws DataAccessException {
		List<AsstarrateVO> satisfactionList=sqlSession.selectList("mapper.adminSatisfaction.selectSatisfactionList",pageMap);

		return satisfactionList;
	}
	
	@Override
	public int selectSatisfactionListCount(int secNum) {
		int pageNum=sqlSession.selectOne("mapper.adminSatisfaction.selectSatisfactionListCount",secNum);
		return pageNum;
	}
	
//	제품상세
	@Override
	public AsstarrateVO selectSatisfactionDetail(int asNo) throws DataAccessException {
		return sqlSession.selectOne("mapper.adminSatisfaction.selectSatisfactionDetail",asNo);
		
	}
	
	

}
