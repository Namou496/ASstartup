package com.myspring.startup.ASBefore.service;

import java.util.List;
import java.util.Map;

import com.myspring.startup.ASBefore.vo.ASBeforeListVO;
import com.myspring.startup.ASBefore.vo.ASBeforeRepearPartVO;
import com.myspring.startup.ASBefore.vo.ASBeforeVO;

public interface ASBeforeService {
	/*상세 조회*/
	public Map<String, Object> viewASBefore(Map<String, Object> requestMap) throws Exception;
	/*이력 추가*/
	public void addASBefore(Map<String, Object> requestMap) throws Exception;
	/*ajax 리스트 count호출*/
	public int countASBeforeList(Map<String, Object> requestMap) throws Exception;
	/*ajax 리스트 호출*/
	public List<ASBeforeListVO> listASBeforeAjax(Map<String,Object> requestMap) throws Exception;
	/*ajax 부품리스트 호출*/
	public List<ASBeforeRepearPartVO> listRepearPartAjax(Map<String,Object> requestMap) throws Exception;
	/*처리완료된 부품 리스트 호출*/
}
