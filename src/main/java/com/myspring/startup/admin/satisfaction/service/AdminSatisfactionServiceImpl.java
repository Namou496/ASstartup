package com.myspring.startup.admin.satisfaction.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myspring.startup.Asstarrate.vo.AsstarrateVO;
import com.myspring.startup.admin.product.vo.AdminProductVO;
import com.myspring.startup.admin.satisfaction.dao.AdminSatisfactionDAO;

@Service("AdminSatisfactionService")
public class AdminSatisfactionServiceImpl implements AdminSatisfactionService{

	@Autowired
	private AdminSatisfactionDAO adminSatisfactionDAO;
	
//	만족도리스트
	@Override
	public Map<String,Object> AdminSatisfactionList(int secNum,int pageNum) throws Exception {
		Map<String,Object> pageMap=new HashMap<String,Object>();
		pageMap.put("secNum", secNum);
		pageMap.put("pageNum", pageNum);
		
		List<AsstarrateVO> satisfactionList=adminSatisfactionDAO.selectSatisfactionList(pageMap);
		
		double lastPageNum=adminSatisfactionDAO.selectSatisfactionListCount(secNum);
		lastPageNum=lastPageNum/10;
		Map<String,Object> satisfactionMap=new HashMap<String,Object>();
		satisfactionMap.put("secNum",secNum);
		satisfactionMap.put("lastPageNum",(int)Math.ceil(lastPageNum));
		satisfactionMap.put("pageNum",pageNum);
		satisfactionMap.put("satisfactionList", satisfactionList);
		
		return satisfactionMap;
	}
	
//	제품상세
	@Override
	public AsstarrateVO AdminSatisfactionDetail(int asNo) {
		AsstarrateVO asstarrateVO = adminSatisfactionDAO.selectSatisfactionDetail(asNo);
		return asstarrateVO;
	}
	
	
}
