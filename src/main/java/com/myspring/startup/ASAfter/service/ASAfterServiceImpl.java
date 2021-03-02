package com.myspring.startup.ASAfter.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.myspring.startup.ASAfter.dao.ASAfterDAO;
import com.myspring.startup.ASAfter.vo.ASAfterDetailVO;
import com.myspring.startup.ASAfter.vo.ASAfterVO;
import com.myspring.startup.ASAfter.vo.ASrespondVO;
import com.myspring.startup.ASAfter.vo.Criteria;

@Service("ASAfterService")
@Transactional(propagation = Propagation.REQUIRED)

public class ASAfterServiceImpl implements ASAfterService {

	@Autowired
	private ASAfterDAO ASAfterdao;

	@Override
	public List<ASAfterVO> selectASAfterList(Criteria cri) throws Exception {
		List<ASAfterVO> alllist = ASAfterdao.selectASAfterList(cri);
		return alllist;
	}

	@Override
	public List<ASAfterVO> selectUserASAfterList(Map<String, Object> userpaging) throws Exception {
		List<ASAfterVO> userlist = ASAfterdao.selectUserASAfterList(userpaging);
		return userlist;
	}

	@Override
	public List<ASAfterVO> selectMfrASAfterList(Map<String, Object> mfrpaging) throws Exception {
		List<ASAfterVO> mfrlist = ASAfterdao.selectMfrASAfterList(mfrpaging);
		return mfrlist;
	}

	@Override
	public List<ASAfterDetailVO> ASAfterListDetail(int asno) throws Exception {
		List<ASAfterDetailVO> dtlist = ASAfterdao.ASAfterListDetail(asno);
		return dtlist;
	}

	@Override
	public void insertASrespond(Map<String, Object> updatesta) throws Exception {
		ASAfterdao.insertASrespond((ASrespondVO) updatesta.get("insertresp"));
		ASAfterdao.updateSta((Integer) updatesta.get("asno"));
	}

	@Override
	public List<ASAfterVO> searchASAfterList(Map<String, Object> search) throws Exception {
		List<ASAfterVO> searchlist = ASAfterdao.searchASAfterList(search);
		return searchlist;
	}
	
	@Override
	public int countASAfterList(Map<String, Object> searchcount) throws Exception {
		return ASAfterdao.countASAfterList(searchcount);
	}
//	@Override
//	public List<ASAfterVO> pagingList(Criteria cri) throws Exception {
//		List<ASAfterVO> paginglist = ASAfterdao.pagingList(cri);
//		return paginglist;
//	}
}