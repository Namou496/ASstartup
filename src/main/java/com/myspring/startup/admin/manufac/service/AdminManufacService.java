package com.myspring.startup.admin.manufac.service;

import java.util.List;
import java.util.Map;

import com.myspring.startup.admin.manufac.vo.AdminManufacVO;

public interface AdminManufacService {

	//상세
	AdminManufacVO AdminManufacDetail(int manufacNo);
	//리스트
	Map<String, Object> AdminManufacList(int secNum, int pageNum) throws Exception;

	//승인거절
	void AdminManufacApproval(AdminManufacVO adminManufacVO);

	//검색
	List<AdminManufacVO> AdminManufacSearch(String name);

}
