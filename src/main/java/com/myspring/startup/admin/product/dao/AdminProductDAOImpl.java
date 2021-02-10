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

	@Override
	public List<AdminProductVO> selectProductApprovalList() throws DataAccessException {
		List<AdminProductVO> productList=sqlSession.selectList("mapper.adminProduct.selectProductApprovalList");
		return productList;
	}
}

