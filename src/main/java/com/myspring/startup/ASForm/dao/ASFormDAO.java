package com.myspring.startup.ASForm.dao;

import java.util.Map;

import org.springframework.dao.DataAccessException;

public interface ASFormDAO {
	public int insertNewAsForm(Map<String, Object> asformMap) throws DataAccessException;
}
