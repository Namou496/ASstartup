package com.myspring.startup.member.dao;

import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.myspring.startup.member.vo.MemberVO;

public interface MemberDAO {
	public MemberVO loginById(MemberVO memberVO) throws DataAccessException;
	public int insertNewMember(Map<String, Object> memberJoinMap) throws DataAccessException;
	public int searchLostPw(Map<String, Object> lostPwMap) throws DataAccessException;
	public String searchLostId(Map<String, Object> lostIdMap) throws DataAccessException;
	public int RecentManufacNo() throws DataAccessException;
	public int RecentManufacApply() throws DataAccessException;
	public void applyManufac(Map<String, Object> memberJoinMap) throws DataAccessException;
	public void insertNewCustomer(Map<String, Object> memberJoinMap) throws DataAccessException;
	public String overlapId(String cuId) throws DataAccessException;
	public void updatePw(Map<String, Object> updatePwMap) throws DataAccessException;	
}
