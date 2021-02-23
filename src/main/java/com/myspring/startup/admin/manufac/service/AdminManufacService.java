package com.myspring.startup.admin.manufac.service;

import java.util.Map;

import com.myspring.startup.admin.manufac.vo.AdminManufacVO;

public interface AdminManufacService {

	AdminManufacVO AdminManufacDetail(int manufacNo);

	Map<String, Object> AdminManufacList(int secNum, int pageNum) throws Exception;

}
