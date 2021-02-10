package com.myspring.startup.ASAfter.dao;

import java.sql.Date;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.myspring.startup.ASAfter.vo.ASAfterDetailVO;
import com.myspring.startup.ASAfter.vo.ASAfterVO;

public interface ASAfterDAO {
	
	public List<ASAfterVO> selectASAfterList() throws DataAccessException;
	
	public List<ASAfterVO> selectUserASAfterList(String ucuid) throws DataAccessException;
	
	public List<ASAfterVO> selectMfrASAfterList(String mcuid) throws DataAccessException;
	
	public List<ASAfterDetailVO> ASAfterListDetail(int asno) throws DataAccessException;
	
//	public List<ASAfterDetailVO> insertASAfterListDetail(int asno, Date respDate, String cuid);
}
