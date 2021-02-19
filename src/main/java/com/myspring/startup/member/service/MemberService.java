package com.myspring.startup.member.service;

import java.util.Map;

import com.myspring.startup.member.vo.MemberVO;

public interface MemberService {
	public MemberVO login(MemberVO memberVO) throws Exception;
	public int addMember(Map<String, Object> memberJoinMap) throws Exception;
	public String searchLostPw(Map<String, Object> lostPwMap) throws Exception;
	public String searchLostId(Map<String, Object> lostIdMap) throws Exception;
}
