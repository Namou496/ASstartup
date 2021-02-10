package com.myspring.startup.ASForm.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.myspring.startup.ASForm.vo.ASFormVO;

@Repository("asformDAO")
public class ASFormDAOImpl implements ASFormDAO {
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void insertNewAsForm(ASFormVO asformVO) throws DataAccessException{
		sqlSession.insert("mapper.asform.insertNewAsForm", asformVO);	//asformVO의 값을 해당 값의 테이블에 추가
	}
}
