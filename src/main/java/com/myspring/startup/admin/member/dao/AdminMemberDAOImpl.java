package com.myspring.startup.admin.member.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.myspring.startup.member.vo.MemberVO;

@Repository("adminMemberDAO")
public class AdminMemberDAOImpl implements AdminMemberDAO{
	
	@Autowired
	private SqlSession sqlSession;
	
//	멤버리스트
	@Override
	public List<MemberVO> selectMemberList(Map<String,Object> pageMap) throws DataAccessException {
		List<MemberVO> memberList=sqlSession.selectList("mapper.adminMember.selectMemberList",pageMap);

		return memberList;
	}
	
	@Override
	public int selectMemberListCount(int secNum) {
		int pageNum=sqlSession.selectOne("mapper.adminMember.selectMemberListCount",secNum);
		return pageNum;
	}
	
//	멤버상세
	@Override
	public MemberVO selectMemberDetail(String cuId) throws DataAccessException {
		return sqlSession.selectOne("mapper.adminMember.selectMemberDetail",cuId);
		
	}
	
//	멤버삭제
	@Override
	public void deleteMember(String cuId) throws DataAccessException {
		sqlSession.delete("mapper.adminMember.deleteMember",cuId);
	}
	
	
//	멤버수정
//	@Override
//	public void modifyMember(MemberVO memberVO) throws DataAccessException {
//		sqlSession.update("mapper.adminMember.modifyMember",memberVO);
//		
//	}
	
//	멤버수정페이지


}
