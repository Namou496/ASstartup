package com.myspring.startup.ASBefore.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.myspring.startup.ASBefore.dao.ASBeforeDAO;
import com.myspring.startup.ASBefore.vo.ASBeforeListVO;
import com.myspring.startup.ASBefore.vo.ASBeforeRepearPartVO;
import com.myspring.startup.ASBefore.vo.ASBeforeVO;


@Service("ASbeforeService")
@Transactional(propagation= Propagation.REQUIRED)
public class ASBeforeServiceImpl implements ASBeforeService{
	@Autowired
	private ASBeforeDAO ASbeforeDAO; 

	
	@Override
	public int countASBeforeList(Map<String, Object> requestMap) throws Exception {
		int listCount = ASbeforeDAO.selectASBeforeListCount(requestMap);
		return listCount;
		
		
	}
	
	@Override
	public List<ASBeforeListVO> listASBeforeAjax(Map<String, Object> requestMap) throws Exception {
		List<ASBeforeListVO> ASBeforeList = ASbeforeDAO.selectASBeforeListAjax(requestMap);
		return ASBeforeList;
		
		
	}
	
	@Override
	public Map<String,Object> viewASBefore(Map<String, Object> requestMap) throws Exception {
		Map<String,Object> ASBefore = new HashMap<String, Object>(); 
		
		ASBeforeVO vo = ASbeforeDAO.selectASBeforeView(requestMap);
		
		Integer sta= vo.getSta();
		
		if(sta==2) {
			int serviceCost=ASbeforeDAO.selectCost();
			vo.setServiceCost(serviceCost);
		}else{
			int asno=vo.getAsno();
			List<ASBeforeRepearPartVO> RepearPartList = ASbeforeDAO.selectASBeofreRepearPartList(asno);
			ASBefore.put("repearPartList", RepearPartList);
		}
		ASBefore.put("ASbefore", vo);
		
		return ASBefore;
		
	}
	
	@Override
	public List<ASBeforeRepearPartVO> listRepearPartAjax(Map<String, Object> requestMap) throws Exception {
		List<ASBeforeRepearPartVO> RefearPartList = ASbeforeDAO.selectRepearPartListAjax(requestMap);
		return RefearPartList;
		
		
	}
	
	@Override
	public void addASBefore(Map<String, Object> requestMap) throws Exception {
		int asno= (Integer)requestMap.get("asno");
		ASBeforeVO ASBefore = (ASBeforeVO)requestMap.get("ASBeofre");
		List<Map<String, Object>> AScomponentLogList = (List<Map<String, Object>>)requestMap.get("AScomponentLogList");
		
		ASbeforeDAO.updateASFormSta(asno);
		ASbeforeDAO.updateASRespondASBefore(ASBefore);
		if(AScomponentLogList!=null && AScomponentLogList.size()>0) {
			ASbeforeDAO.insertAScomponentLog(AScomponentLogList);
		}
	}
	
	

}
