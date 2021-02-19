package com.myspring.startup.ASAfter.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.myspring.startup.ASAfter.vo.ASAfterDetailVO;
import com.myspring.startup.ASAfter.vo.ASAfterVO;
import com.myspring.startup.ASAfter.vo.ASrespondVO;

public interface ASAfterDAO {
	
	public List<ASAfterVO> selectASAfterList() throws DataAccessException;
	
	public List<ASAfterVO> selectUserASAfterList(String ucuid) throws DataAccessException;
	
	public List<ASAfterVO> selectMfrASAfterList(String mcuid) throws DataAccessException;
	
	public List<ASAfterDetailVO> ASAfterListDetail(int asno) throws DataAccessException;
	
	public void insertASrespond(ASrespondVO asrespondVO) throws DataAccessException;
	
	public void updateSta(Integer asno) throws DataAccessException;

	public List<ASAfterVO> searchASAfterList(Map<String, Object> search) throws DataAccessException;
}
