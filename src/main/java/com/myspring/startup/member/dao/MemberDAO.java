package com.myspring.startup.member.dao;

import org.springframework.dao.DataAccessException;

import com.myspring.startup.member.vo.MemberVO;

public interface MemberDAO {
	public MemberVO loginById(MemberVO memberVO) throws DataAccessException;
	
}
