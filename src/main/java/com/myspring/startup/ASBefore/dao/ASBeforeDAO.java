package com.myspring.startup.ASBefore.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.myspring.startup.ASBefore.vo.ASBeforeListVO;
import com.myspring.startup.ASBefore.vo.ASBeforeRepearPartVO;
import com.myspring.startup.ASBefore.vo.ASBeforeVO;

public interface ASBeforeDAO{
	/*이력 상세 호출*/
	public ASBeforeVO selectASBeforeView(Map<String, Object> requestMap) throws DataAccessException;
	/*출장비 호출*/
	public int selectCost() throws DataAccessException;
/*이력 작성들*/
	/*ASForm sta업데이트*/
	public void updateASFormSta(int asno) throws DataAccessException;
	/*ASRespond 업데이트*/
	public void updateASRespondASBefore(ASBeforeVO ASBefore) throws DataAccessException;
	/*AScomponentLog 추가*/
	public void insertAScomponentLog(List<Map<String, Object>> AScomponentLogList) throws DataAccessException;
	/*ajax 리스트 count호출*/
	public int selectASBeforeListCount(Map<String, Object> requestMap) throws DataAccessException;
	/*ajax 리스트 호출*/
	public List<ASBeforeListVO> selectASBeforeListAjax(Map<String,Object> requestMap) throws DataAccessException;
	/*ajax 부품리스트 호출*/
	public List<ASBeforeRepearPartVO> selectRepearPartListAjax(Map<String,Object> requestMap)throws DataAccessException;
	/*처리완료된 소모품 리스트 호출*/
	public List<ASBeforeRepearPartVO> selectASBeofreRepearPartList(int asno)throws DataAccessException;
}
