package com.myspring.startup.member.service;

import java.util.Map;

import com.myspring.startup.member.vo.MemberVO;

public interface MemberService {
	public MemberVO login(MemberVO memberVO) throws Exception;
	public void addMember(Map<String, Object> memberJoinMap) throws Exception;
	public int searchLostPw(Map<String, Object> lostPwMap) throws Exception;
	public String searchLostId(Map<String, Object> lostIdMap) throws Exception;
	public void addManufac(Map<String, Object> memberJoinMap) throws Exception;
	public String overlapId(String _cuId) throws Exception;
	public void updatePw(Map<String, Object> updatePwMap) throws Exception;
}
