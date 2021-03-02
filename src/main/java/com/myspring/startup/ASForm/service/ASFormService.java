package com.myspring.startup.ASForm.service;

import java.util.List;
import java.util.Map;

public interface ASFormService {
	public int addAsForm(Map<String, Object> asformMap) throws Exception;
	public List manufacName() throws Exception;
	public List productName(Map searchProductNameMap) throws Exception;
}
