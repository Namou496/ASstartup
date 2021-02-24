package com.myspring.startup.admin.satisfaction.service;

import java.util.Map;

import com.myspring.startup.Asstarrate.vo.AsstarrateVO;

public interface AdminSatisfactionService {

//	만족도리스트
	Map<String, Object> AdminSatisfactionList(int secNum, int pageNum) throws Exception;

//	만족도상세
	AsstarrateVO AdminSatisfactionDetail(int asNo);



}
