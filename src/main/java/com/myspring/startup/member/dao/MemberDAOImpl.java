package com.myspring.startup.member.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.myspring.startup.member.vo.MemberVO;

@Repository("memberDAO")
public class MemberDAOImpl implements MemberDAO{
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public MemberVO loginById(MemberVO memberVO) throws DataAccessException{
		MemberVO vo = sqlSession.selectOne("mapper.member.loginById", memberVO);
		System.out.println(vo.getCuId());
		if(vo.getuNo()==3) {
			int appStatus = sqlSession.selectOne("mapper.member.appStatus", memberVO.getCuId());
			vo.setApprovalstatus(appStatus);
		}
		return vo;
	}
	
	@Override
	public int insertNewMember(Map<String, Object> memberJoinMap) throws DataAccessException {
		return sqlSession.insert("mapper.member.insertNewMember", memberJoinMap);	//asformVO의 값을 해당 값의 테이블에 추가
	}

	@Override
	public String searchLostPw(Map<String, Object> lostPwMap) {
		String pw = sqlSession.selectOne("mapper.member.lostPw", lostPwMap);
		return pw;
	}

	@Override
	public String searchLostId(Map<String, Object> lostIdMap) throws DataAccessException {
		String _cuId = sqlSession.selectOne("mapper.member.lostId", lostIdMap);
		return _cuId;
	}

	@Override
	public int RecentManufacNo() {
		int RecentManufacNo = sqlSession.selectOne("mapper.member.RecentManufacNo");
		return RecentManufacNo;
	}
	
	@Override
	public int RecentManufacApply() {
		int RecentManufacApply = sqlSession.selectOne("mapper.member.RecentManufacApply");
		return RecentManufacApply;
	}
	
	@Override
	public void applyManufac(Map<String, Object> memberJoinMap) throws DataAccessException{
		sqlSession.insert("mapper.member.insertManufacturer", memberJoinMap);
		sqlSession.insert("mapper.member.insertManufacApply", memberJoinMap);
	}
	
	@Override
	public void insertNewCustomer(Map<String, Object> memberJoinMap) throws DataAccessException{
		sqlSession.insert("mapper.member.insertCustomer", memberJoinMap);
	}

	@Override
	public String overlapId(String cuId) throws DataAccessException {
		String i = sqlSession.selectOne("mapper.member.overlapId", cuId);
		return i;
	}
}
