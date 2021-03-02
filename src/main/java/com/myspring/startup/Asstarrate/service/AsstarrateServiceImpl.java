package com.myspring.startup.Asstarrate.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myspring.startup.Asstarrate.dao.AsstarrateDAO;

@Service("AsstarrateService")
public class AsstarrateServiceImpl implements AsstarrateService {
//  controller���� �ѿ� ������ dao�� �Ѱ��ش�.
//	�޼ҵ������� @Override�� �� ����.
	@Autowired
	AsstarrateDAO AsstarrateDAO;
	
	@Override
	public void starrateService(Map<String,Object>asForm)throws Exception{
		
		AsstarrateDAO.starrateService(asForm);
	}
}
