package com.myspring.startup.admin.manufac.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.myspring.startup.admin.manufac.vo.AdminManufacVO;



@Repository("adminManufacDAO")
public class AdminManufacDAOImpl implements AdminManufacDAO{
	@Autowired
	private SqlSession sqlSession;
	
//	제조사승인요청리스트
	@Override
	public List<AdminManufacVO> selectManufacApprovalList(Map<String,Object> pageMap) throws DataAccessException {
		List<AdminManufacVO> manufacList=sqlSession.selectList("mapper.adminManufac.selectManufacApprovalList",pageMap);

		return manufacList;
	}
	
	@Override
	public int selectManufacApprovalListCount(int secNum) {
		int pageNum=sqlSession.selectOne("mapper.adminManufac.selectManufacApprovalListCount",secNum);
		return pageNum;
	}
	
//	제조사상세
	@Override
	public AdminManufacVO selectManufacApprovalDetail(int manufacNO) throws DataAccessException {
		return sqlSession.selectOne("mapper.adminManufac.selectManufacApprovalDetail",manufacNO);
		
	}
	
//	제조사검색
	@Override
	public ArrayList selectByManufac(String name) throws DataAccessException {
		ArrayList List= (ArrayList)sqlSession.selectList("mapper.adminManufac.selectByManufac",name);
		return List;
		
	}
	
//	제조사승인거절
	@Override
	public void updateManufacApprovalStatus(AdminManufacVO adminManufacVO) throws DataAccessException {
		sqlSession.update("mapper.adminManufac.updateManufacApprovalStatus",adminManufacVO);
		
	}
	
}
