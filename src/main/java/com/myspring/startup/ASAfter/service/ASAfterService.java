package com.myspring.startup.ASAfter.service;

import java.sql.Date;
import java.util.List;

import com.myspring.startup.ASAfter.vo.ASAfterDetailVO;
import com.myspring.startup.ASAfter.vo.ASAfterVO;
import com.myspring.startup.ASAfter.vo.ASrespondVO;
import com.myspring.startup.ASBefore.vo.ASBeforeVO;

public interface ASAfterService {

	public List<ASAfterVO> selectASAfterList() throws Exception;
	
	public List<ASAfterVO> selectUserASAfterList(String ucuid) throws Exception;
	
	public List<ASAfterVO> selectMfrASAfterList(String mcuid) throws Exception;
	
	public List<ASAfterDetailVO> ASAfterListDetail(int asno) throws Exception;
	
	public void insertASrespond(ASrespondVO asrespondVO) throws Exception;
}
