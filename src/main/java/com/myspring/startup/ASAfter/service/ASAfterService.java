package com.myspring.startup.ASAfter.service;

import java.util.List;
import java.util.Map;

import com.myspring.startup.ASAfter.vo.ASAfterDetailVO;
import com.myspring.startup.ASAfter.vo.ASAfterVO;

public interface ASAfterService {

	public List<ASAfterVO> selectASAfterList() throws Exception;
	
	public List<ASAfterVO> selectUserASAfterList(String ucuid) throws Exception;
	
	public List<ASAfterVO> selectMfrASAfterList(String mcuid) throws Exception;
	
	public List<ASAfterDetailVO> ASAfterListDetail(int asno) throws Exception;
	
	public void insertASrespond(Map<String, Object> updatesta) throws Exception;
	
	public List<ASAfterVO> searchASAfterList(Map<String, Object> search) throws Exception;
}
