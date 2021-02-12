package com.myspring.startup.ASBefore.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.myspring.startup.ASBefore.vo.ASBeforeListVO;
import com.myspring.startup.ASBefore.vo.ASBeforeRepearPartVO;
import com.myspring.startup.ASBefore.vo.ASBeforeVO;


@Repository("ASbeforeDAO")
public class ASBeforeDAOImpl implements ASBeforeDAO{
	@Autowired
	private SqlSession sqlSession;
	
	
	@Override
	public ASBeforeVO selectASBeforeView(Map<String, Object> requestMap) throws DataAccessException{
		ASBeforeVO ASBefore = sqlSession.selectOne("mapper.ASBefore.selectASBeforeView", requestMap);
		return ASBefore;
		
		
	}
	
	@Override
	public int selectCost() throws DataAccessException{
		int serviceCost = sqlSession.selectOne("mapper.ASBefore.selectCost");
		return serviceCost;
		
		
	}
	
	@Override
	public int selectASBeforeListCount(Map<String, Object> requestMap) {
		int ListCount = sqlSession.selectOne("mapper.ASBefore.selectASBeforeListCount",requestMap);
		return ListCount;
		
	}
	
	@Override
	public List<ASBeforeListVO> selectASBeforeListAjax(Map<String,Object> requestMap) throws DataAccessException {
		List<ASBeforeListVO> ASBeforeList = 
				sqlSession.selectList("mapper.ASBefore.selectASBeforeListAjax", requestMap);
		return ASBeforeList;
		
		
	}
	
	@Override
	public List<ASBeforeRepearPartVO> selectRepearPartListAjax(Map<String, Object> requestMap)
			throws DataAccessException {
		List<ASBeforeRepearPartVO> RefearPartList = 
				sqlSession.selectList("mapper.ASBefore.selectRepearPartListAjax",requestMap);
		return RefearPartList;
		
		
	}
	
	@Override
	public void updateASFormSta(int asno) throws DataAccessException {
		sqlSession.update("mapper.ASBefore.updateASFormSta", asno);
		
		
	}
	
	@Override
	public void updateASRespondASBefore(ASBeforeVO ASBefore) throws DataAccessException {
		sqlSession.update("mapper.ASBefore.updateASRespondASBefore", ASBefore);
		
		
	}
	
	@Override
	public void insertAScomponentLog(List<Map<String, Object>> AScomponentLogList) throws DataAccessException {
		sqlSession.insert("mapper.ASBefore.insertAScomponentLog", AScomponentLogList);
		
		
	}
	
	@Override
	public List<ASBeforeRepearPartVO> selectASBeofreRepearPartList(int asno) throws DataAccessException {
		List<ASBeforeRepearPartVO> repearPartList = sqlSession.selectList("mapper.ASBefore.selectASBeofreRepearPartList", asno);
		return repearPartList;
		
		
	}
	
}
