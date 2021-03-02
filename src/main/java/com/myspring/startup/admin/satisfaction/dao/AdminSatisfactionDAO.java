package com.myspring.startup.admin.satisfaction.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.myspring.startup.Asstarrate.vo.AsstarrateVO;

public interface AdminSatisfactionDAO {

//	만족도리스트
	List<AsstarrateVO> selectSatisfactionList(Map<String, Object> pageMap) throws DataAccessException;

//	전체만족도개수
	int selectSatisfactionListCount(int secNum);

//	만족도상세
	AsstarrateVO selectSatisfactionDetail(int asNo) throws DataAccessException;

	

}
