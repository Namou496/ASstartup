package com.myspring.startup.admin.member.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.myspring.startup.member.vo.MemberVO;

public interface AdminMemberDAO {

//	멤버리스트
	public List<MemberVO> selectMemberList(Map<String, Object> pageMap) throws DataAccessException;

	public int selectMemberListCount(int secNum);

//	멤버상세
	public MemberVO selectMemberDetail(String cuId) throws DataAccessException;

//	멤버삭제
	public void deleteMember(String cuId) throws DataAccessException;

//	멤버수정
	public void modifyMember(MemberVO memberVO) throws DataAccessException;


	
}
