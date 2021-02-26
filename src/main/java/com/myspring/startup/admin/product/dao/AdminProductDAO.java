package com.myspring.startup.admin.product.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.myspring.startup.admin.product.vo.AdminProductVO;

public interface AdminProductDAO {

	//제품승인요청리스트
	public List<AdminProductVO> selectProductApprovalList(Map<String,Object> pageMap) throws DataAccessException;
	//카운트숫자	
	public int selectProductApprovalListCount(int secNum);
	//제품상세
	AdminProductVO selectProductApprovalDetail(int productNO) throws DataAccessException;
	//제품검색
	public List<AdminProductVO> selectByProduct(String name) throws DataAccessException;
	//제품승인거절
	void updateProductApprovalStatus(AdminProductVO adminProductVO) throws DataAccessException;
//	부품목록
	public ArrayList selectProductComponent(int productNO) throws DataAccessException;




}
