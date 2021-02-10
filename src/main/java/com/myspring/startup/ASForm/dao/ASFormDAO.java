package com.myspring.startup.ASForm.dao;

import org.springframework.dao.DataAccessException;

import com.myspring.startup.ASForm.vo.ASFormVO;

public interface ASFormDAO {
	public void insertNewAsForm(ASFormVO asformVO) throws DataAccessException;
}
