package com.myspring.startup.Asstarrate.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository("AsstarrateDAO")
public class AsstarrateDAOImpl implements AsstarrateDAO {
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public List 메소드명(int 메개변수) {
		return null;
	}
	
}
