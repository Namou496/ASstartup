package com.myspring.startup.ASAfter.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.myspring.startup.ASAfter.dao.ASAfterDAO;
import com.myspring.startup.ASAfter.vo.ASAfterDetailVO;
import com.myspring.startup.ASAfter.vo.ASAfterVO;
import com.myspring.startup.ASAfter.vo.ASrespondVO;
import com.myspring.startup.ASBefore.vo.ASBeforeVO;

@Service("ASAfterService")
@Transactional(propagation= Propagation.REQUIRED)

public class ASAfterServiceImpl implements ASAfterService{
	
	@Autowired
	private ASAfterDAO ASAfterdao;

	@Override
	public List<ASAfterVO> selectASAfterList() throws Exception {
		List<ASAfterVO> alllist = ASAfterdao.selectASAfterList();  
		return alllist;
	}

	@Override
	public List<ASAfterVO> selectUserASAfterList(String ucuid) throws Exception {
		List<ASAfterVO> userlist = ASAfterdao.selectUserASAfterList(ucuid);
		return userlist;
	}

	@Override
	public List<ASAfterVO> selectMfrASAfterList(String mcuid) throws Exception {
		List<ASAfterVO> mfrlist = ASAfterdao.selectMfrASAfterList(mcuid);
		return mfrlist;
	}
	
	@Override
	public List<ASAfterDetailVO> ASAfterListDetail(int asno) throws Exception {
		List<ASAfterDetailVO> dtlist = ASAfterdao.ASAfterListDetail(asno);
		return dtlist;
	}
	
	@Override
	public void insertASrespond(ASrespondVO asrespondVO) throws Exception {
		ASAfterdao.insertASrespond(asrespondVO);
	}
}