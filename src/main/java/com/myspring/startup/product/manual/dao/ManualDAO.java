package com.myspring.startup.product.manual.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.myspring.startup.member.vo.MemberVO;
import com.myspring.startup.product.vo.ProductVO;

public interface ManualDAO {

	int selectUserRight(MemberVO memberVO) throws Exception;
	List<ProductVO> selectProductList(Map pageMap) throws Exception;
	String manufacName(String cuId) throws Exception;
	ProductVO selectManualDetail(Map pageMap) throws Exception;
	List<ProductVO> searchManual(Map searchMap) throws Exception;
	List selectProductGroup(String manufacName) throws DataAccessException;
	List manufacNameList() throws Exception;

}
