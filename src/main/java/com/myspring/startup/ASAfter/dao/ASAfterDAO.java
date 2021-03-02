package com.myspring.startup.ASAfter.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.myspring.startup.ASAfter.vo.ASAfterDetailVO;
import com.myspring.startup.ASAfter.vo.ASAfterVO;
import com.myspring.startup.ASAfter.vo.ASrespondVO;
import com.myspring.startup.ASAfter.vo.Criteria;

public interface ASAfterDAO {
	
	public List<ASAfterVO> selectASAfterList(Criteria cri) throws DataAccessException;
	
	public List<ASAfterVO> selectUserASAfterList(Map<String, Object> userpaging) throws DataAccessException;
	
	public List<ASAfterVO> selectMfrASAfterList(Map<String, Object> mfrpaging) throws DataAccessException;
	
	public List<ASAfterDetailVO> ASAfterListDetail(int asno) throws DataAccessException;
	
	public void insertASrespond(ASrespondVO asrespondVO) throws DataAccessException;
	
	public void updateSta(Integer asno) throws DataAccessException;

	public List<ASAfterVO> searchASAfterList(Map<String, Object> search) throws DataAccessException;
	
	public int countASAfterList(Map<String, Object> searchcount) throws DataAccessException;
	
//	public List<ASAfterVO> pagingList(Criteria cri) throws DataAccessException;
}
