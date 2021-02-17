package com.myspring.startup.product.product.dao;

import java.util.List;
import java.util.Map;

import com.myspring.startup.member.vo.MemberVO;
import com.myspring.startup.product.vo.ProductVO;

public interface ProductDAO {

	List<ProductVO> selectProductList(Map pageMap) throws Exception;
	ProductVO selectProductDetail(Map pageMap) throws Exception;
	List<ProductVO> searchProduct(Map searchMap) throws Exception;
	int selectRecentProd() throws Exception;
	int selectRecentCompo() throws Exception;
	int selectRecentApprNum() throws Exception;
	int selectUserRight(MemberVO memberVO) throws Exception;
	void insertProduct(Map product) throws Exception;
	void insertComponent(List<ProductVO> componentList) throws Exception;
	void insertProductApply(Map product) throws Exception;
	int selectTotProduct() throws Exception;
	public List selectProductGroup(String manufacName) throws Exception;
	String manufacName(String cuId) throws Exception;
	List selectCompo(int productNo) throws Exception;



	

}
