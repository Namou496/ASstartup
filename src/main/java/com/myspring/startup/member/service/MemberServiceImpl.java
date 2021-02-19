package com.myspring.startup.member.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.myspring.startup.member.dao.MemberDAO;
import com.myspring.startup.member.vo.MemberVO;

@Service("memberService")
@Transactional(propagation=Propagation.REQUIRED)
public class MemberServiceImpl implements MemberService{
	@Autowired
	private MemberDAO memberDAO;
	
	public MemberVO login(MemberVO memberVO) throws Exception{
		return memberDAO.loginById(memberVO);
	}

	@Override
	public int addMember(Map<String, Object> memberJoinMap) throws Exception {
		return memberDAO.insertNewMember(memberJoinMap);
		
	}

	@Override
	public String searchLostPw(Map<String, Object> lostPwMap) throws Exception {
		String pw = memberDAO.searchLostPw(lostPwMap);
		return pw;
		
	}

	@Override
	public String searchLostId(Map<String, Object> lostIdMap) throws Exception {
		String _cuId = memberDAO.searchLostId(lostIdMap);
		return _cuId;
	}
}
