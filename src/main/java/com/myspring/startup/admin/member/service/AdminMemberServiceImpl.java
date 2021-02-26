package com.myspring.startup.admin.member.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myspring.startup.admin.member.dao.AdminMemberDAO;
import com.myspring.startup.admin.product.vo.AdminProductVO;
import com.myspring.startup.member.vo.MemberVO;

@Service("AdminMemberService")
public class AdminMemberServiceImpl implements AdminMemberService{
	
	@Autowired
	private AdminMemberDAO adminMemberDAO;
	
//	멤버리스트
	@Override
	public Map<String,Object> AdminMemberList(int secNum,int pageNum) throws Exception {
		Map<String,Object> pageMap=new HashMap<String,Object>();
		pageMap.put("secNum", secNum);
		pageMap.put("pageNum", pageNum);
		
		List<MemberVO> memberList=adminMemberDAO.selectMemberList(pageMap);
		
		double lastPageNum=adminMemberDAO.selectMemberListCount(secNum);
		lastPageNum=lastPageNum/10;
		Map<String,Object> memberMap=new HashMap<String,Object>();
		memberMap.put("secNum",secNum);
		memberMap.put("lastPageNum",(int)Math.ceil(lastPageNum));
		memberMap.put("pageNum",pageNum);
		memberMap.put("memberList", memberList);
		
		return memberMap;
	}
	
//	멤버상세
	@Override
	public MemberVO AdminMemberDetail(String cuId) {
		MemberVO memberVO = adminMemberDAO.selectMemberDetail(cuId);
		return memberVO;
	}
	
//	멤버삭제
	@Override
	public void AdminMemberDelete(String cuId) {
		adminMemberDAO.deleteMember(cuId);
	}
	
//	멤버수정
//	@Override
//	public void AdminMemberModify(MemberVO memberVO) {
//		adminMemberDAO.modifyMember(memberVO);
//		
//	}
	
//	멤버수정상세페이지
	@Override
	public MemberVO AdminMemberModifyPage(String cuId) {
		MemberVO memberVO = adminMemberDAO.selectMemberDetail(cuId);
		return memberVO;
	}
//	

}
