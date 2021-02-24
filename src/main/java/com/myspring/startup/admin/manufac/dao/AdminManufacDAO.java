package com.myspring.startup.admin.manufac.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.myspring.startup.admin.manufac.vo.AdminManufacVO;

public interface AdminManufacDAO {

	//제조사승인요청목록
	List<AdminManufacVO> selectManufacApprovalList(Map<String, Object> pageMap) throws DataAccessException;
	//요청갯수
	int selectManufacApprovalListCount(int secNum);

	//제조사상세
	AdminManufacVO selectManufacApprovalDetail(int manufacNO) throws DataAccessException;
	
	List selectByManufac(String name);
	
	void updateManufacApprovalStatus(AdminManufacVO adminManufacVO);

}
