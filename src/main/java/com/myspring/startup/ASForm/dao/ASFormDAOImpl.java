package com.myspring.startup.ASForm.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

@Repository("asformDAO")
public class ASFormDAOImpl implements ASFormDAO {
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int insertNewAsForm(Map<String, Object> asformMap) throws DataAccessException {
		return sqlSession.insert("mapper.asform.insertNewAsForm", asformMap);
	}	

}
