package com.myspring.startup.Asstarrate.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository("AsstarrateDAO")
public class AsstarrateDAOImpl implements AsstarrateDAO {
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public void starrateService(Map asList)throws Exception {
		int AsstarrateService = sqlSession.update("mapper.Asstarrate.insertAsstarrate",asList);
	}
	
}
