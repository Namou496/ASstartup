package com.myspring.startup.Asstarrate.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myspring.startup.Asstarrate.dao.AsstarrateDAO;

@Service("AsstarrateService")
public class AsstarrateServiceImpl implements AsstarrateService {
//  controller에서 넘온 정보를 dao로 넘겨준다.
//	메소드위에는 @Override를 꼭 쓴다.
	@Autowired
	AsstarrateDAO AsstarrateDAO;
	
	@Override
	public void starrateService(Map asList)throws Exception{
		
		AsstarrateDAO.starrateService(asList);
	}
}
