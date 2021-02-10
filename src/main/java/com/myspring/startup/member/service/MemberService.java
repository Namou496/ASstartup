package com.myspring.startup.member.service;

import com.myspring.startup.member.vo.MemberVO;

public interface MemberService {
	public MemberVO login(MemberVO memberVO) throws Exception;
	public void addMember(MemberVO memberVO) throws Exception;
}
