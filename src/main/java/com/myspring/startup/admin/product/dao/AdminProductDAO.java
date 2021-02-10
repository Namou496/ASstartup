package com.myspring.startup.admin.product.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.myspring.startup.admin.product.vo.AdminProductVO;

public interface AdminProductDAO {

	public List<AdminProductVO> selectProductApprovalList() throws DataAccessException;

}
