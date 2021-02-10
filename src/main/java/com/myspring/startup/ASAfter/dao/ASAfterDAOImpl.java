package com.myspring.startup.ASAfter.dao;

import java.sql.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.myspring.startup.ASAfter.vo.ASAfterDetailVO;
import com.myspring.startup.ASAfter.vo.ASAfterVO;

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
	
//	@Override
//	public List<ASAfterDetailVO> insertASAfterListDetail(int asno, Date respDate, String cuid) {
//		
//		return null;
//	}
}