package com.myspring.startup.ASAfter.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.myspring.startup.ASAfter.vo.ASAfterDetailVO;
import com.myspring.startup.ASAfter.vo.ASAfterVO;
import com.myspring.startup.ASAfter.vo.ASrespondVO;

@Repository("ASAfterDAO")

public class ASAfterDAOImpl implements ASAfterDAO{
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<ASAfterVO> selectASAfterList() throws DataAccessException {
		List<ASAfterVO> ASAfterList = sqlSession.selectList("mapper.ASAfter.selectASAfterList");
		return ASAfterList;
	}
	
	@Override
	public List<ASAfterVO> selectUserASAfterList(String ucuid) throws DataAccessException {
		List<ASAfterVO> ASAfterList = sqlSession.selectList("mapper.ASAfter.selectUserASAfterList", ucuid);
		return ASAfterList;
	}
	
	@Override
	public List<ASAfterVO> selectMfrASAfterList(String mcuid) throws DataAccessException {
		List<ASAfterVO> ASAfterList = sqlSession.selectList("mapper.ASAfter.selectMfrASAfterList", mcuid);
		return ASAfterList;
	}
	
	@Override
	public List<ASAfterDetailVO> ASAfterListDetail(int asno) throws DataAccessException {
		List<ASAfterDetailVO> ASAfterListDetail = sqlSession.selectList("mapper.ASAfter.ASAfterListDetail", asno);
		return ASAfterListDetail;
	}
	
	@Override
	public void insertASrespond(ASrespondVO asrespondvo) throws DataAccessException {
		sqlSession.insert("mapper.ASAfter.insertASrespond", asrespondvo);
	}
	
	@Override
	public void updateSta(Integer asno) throws DataAccessException {
		sqlSession.update("mapper.ASAfter.updateSta", asno);
		
	}
	
	@Override
	public List<ASAfterVO> searchASAfterList(Map<String, Object> search) throws DataAccessException {
		List<ASAfterVO> searchList = sqlSession.selectList("mapper.ASAfter.searchASAfterList", search);
		return searchList;
	}
}