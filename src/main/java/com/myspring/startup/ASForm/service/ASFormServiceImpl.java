package com.myspring.startup.ASForm.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.myspring.startup.ASForm.dao.ASFormDAO;

@Service("asformService")
@Transactional(propagation=Propagation.REQUIRED)
public class ASFormServiceImpl implements ASFormService{
	@Autowired
	private ASFormDAO asformDAO;

	@Override
	public int addAsForm(Map<String, Object> asformMap) {
		return asformDAO.insertNewAsForm(asformMap);
	}
	
	@Override
	public List manufacName() throws Exception {
		List manufacName = asformDAO.selectManufacName();
		
		return manufacName;
	}

	@Override
	public List productName(Map searchProductNameMap) {
		List productNameList = asformDAO.selectProductName(searchProductNameMap);
		return productNameList;
	}

}
