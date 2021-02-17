package com.myspring.startup.ASBefore.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.ModelAndView;
public interface ASBeforeController {

	/*전체 리스트조회*/
	public ModelAndView listASBefore(HttpServletRequest request, HttpServletResponse response) throws Exception;
	/*상세 조회*/
	public ModelAndView viewASBefore(HttpServletRequest request, HttpServletResponse response, int asno) throws Exception;
	/*이력 추가*/
	public ResponseEntity addASBefore(HttpServletRequest request, HttpServletResponse response) throws Exception;
	/*ajax 하단 페이징 버튼 기능*/
	public void paging(HttpServletRequest request, HttpServletResponse response) throws Exception;
	/*ajax 처리중,처리끝 각각 리스트 출력 구현*/
	public void ajaxListAsBefore(HttpServletRequest request, HttpServletResponse response) throws Exception;
	/*ajax 부품 리스트 호출*/
	public void repearPartList(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
