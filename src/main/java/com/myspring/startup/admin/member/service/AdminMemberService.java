package com.myspring.startup.admin.member.service;

import java.util.Map;

import com.myspring.startup.member.vo.MemberVO;

public interface AdminMemberService {

//	멤버리스트
	public Map<String, Object> AdminMemberList(int secNum, int pageNum) throws Exception;

//	멤버상세
	public MemberVO AdminMemberDetail(String cuId);

//	멤버삭제
	public void AdminMemberDelete(String cuId);

//	멤버수정페이지
	public MemberVO AdminMemberModifyPage(String cuId);
	
//	멤버수정
//	public void AdminMemberModify(MemberVO memberVO);



}
