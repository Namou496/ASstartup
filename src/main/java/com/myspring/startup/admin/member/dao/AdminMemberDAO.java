package com.myspring.startup.admin.member.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.myspring.startup.member.vo.MemberVO;

public interface AdminMemberDAO {

//	멤버리스트
	List<MemberVO> selectMemberList(Map<String, Object> pageMap) throws DataAccessException;

	int selectMemberListCount(int secNum);

//	멤버상세
	MemberVO selectMemberDetail(String cuId) throws DataAccessException;

}
