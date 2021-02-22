package com.myspring.startup.ASForm.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

public interface ASFormDAO {
	public int insertNewAsForm(Map<String, Object> asformMap) throws DataAccessException;
	public List selectManufacName() throws DataAccessException;
	public List selectProductName(Map searchProductNameMap);
}
