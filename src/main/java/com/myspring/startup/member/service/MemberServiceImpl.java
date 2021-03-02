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
	public void addMember(Map<String, Object> memberJoinMap) throws Exception {
		memberDAO.insertNewMember(memberJoinMap);
		memberDAO.insertNewCustomer(memberJoinMap);
	}

	@Override
	public int searchLostPw(Map<String, Object> lostPwMap) throws Exception {
		int i = memberDAO.searchLostPw(lostPwMap);
		return i;
		
	}

	@Override
	public String searchLostId(Map<String, Object> lostIdMap) throws Exception {
		String _cuId = memberDAO.searchLostId(lostIdMap);
		return _cuId;
	}
	
	@Override
	public void addManufac(Map<String, Object> memberJoinMap) throws Exception{
		memberDAO.insertNewMember(memberJoinMap);
		int RecentManufacNo = memberDAO.RecentManufacNo();
		int RecentManufacApply = memberDAO.RecentManufacApply();
		
		memberJoinMap.put("manufacNo", RecentManufacNo+1);
		memberJoinMap.put("approvalNum", RecentManufacApply+1);
		
		memberDAO.applyManufac(memberJoinMap);
	}

	@Override
	public String overlapId(String cuId) throws Exception {
		String i = memberDAO.overlapId(cuId);
		return i;
	}

	@Override
	public void updatePw(Map<String, Object> updatePwMap) throws Exception {
		memberDAO.updatePw(updatePwMap);
		
	}
}
