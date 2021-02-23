package com.myspring.startup.admin.manufac.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myspring.startup.admin.manufac.dao.AdminManufacDAO;
import com.myspring.startup.admin.manufac.vo.AdminManufacVO;


@Service("AdminManufacService")
public class AdminManufacServiceImpl implements AdminManufacService {

	
	@Autowired
		private AdminManufacDAO adminManufacDAO;

//		제조사승인요청리스트
	@Override
		public Map<String,Object> AdminManufacList(int secNum,int pageNum) throws Exception {
			Map<String,Object> pageMap=new HashMap<String,Object>();
			pageMap.put("secNum", secNum);
			pageMap.put("pageNum", pageNum);
			
			List<AdminManufacVO> manufacList=adminManufacDAO.selectManufacApprovalList(pageMap);
			
			double lastPageNum=adminManufacDAO.selectManufacApprovalListCount(secNum);
			lastPageNum=lastPageNum/10;
			Map<String,Object> manufacMap=new HashMap<String,Object>();
			manufacMap.put("secNum",secNum);
			manufacMap.put("lastPageNum",(int)Math.ceil(lastPageNum));
			manufacMap.put("pageNum",pageNum);
			manufacMap.put("manufacList", manufacList);
			
			return manufacMap;
		}

//		제조사상세
	@Override
		public AdminManufacVO AdminManufacDetail(int manufacNO) {
			AdminManufacVO adminManufacVO = adminManufacDAO.selectManufacApprovalDetail(manufacNO);
			return adminManufacVO;
		}
	
}
