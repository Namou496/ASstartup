package com.myspring.startup.ASAfter.service;

import java.util.List;
import java.util.Map;

import com.myspring.startup.ASAfter.vo.ASAfterDetailVO;
import com.myspring.startup.ASAfter.vo.ASAfterVO;
import com.myspring.startup.ASAfter.vo.Criteria;

public interface ASAfterService {

	public List<ASAfterVO> selectASAfterList(Criteria cri) throws Exception;
	
	public List<ASAfterVO> selectUserASAfterList(Map<String, Object> userpaging) throws Exception;
	
	public List<ASAfterVO> selectMfrASAfterList(Map<String, Object> mfrpaging) throws Exception;
	
	public List<ASAfterDetailVO> ASAfterListDetail(int asno) throws Exception;
	
	public void insertASrespond(Map<String, Object> updatesta) throws Exception;
	
	public List<ASAfterVO> searchASAfterList(Map<String, Object> search) throws Exception;
	
	public int countASAfterList(Map<String, Object> searchcount) throws Exception;
	
//	public List<ASAfterVO> pagingList(Criteria cri) throws Exception;
}
