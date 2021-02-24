package com.myspring.startup.admin.member.service;

import java.util.Map;

import com.myspring.startup.member.vo.MemberVO;

public interface AdminMemberService {

//	멤버리스트
	Map<String, Object> AdminMemberList(int secNum, int pageNum) throws Exception;

//	멤버상세
	MemberVO AdminMemberDetail(String cuId);

}
