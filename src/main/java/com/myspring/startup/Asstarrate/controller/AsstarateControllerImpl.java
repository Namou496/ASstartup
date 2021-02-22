package com.myspring.startup.Asstarrate.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.myspring.startup.Asstarrate.service.AsstarrateService;
import com.myspring.startup.Asstarrate.vo.AsstarrateVO;

@Controller("AsstarrateController")
public class AsstarateControllerImpl implements AsstarateController {

//	�Ѿ���� ���� = asNo / jsp���� �޾Ƽ�,  dao�� �Ű��ش�.
	// int�� �Ѿ�ͼ�, service�� �Ѱ��ش�.
//	�޼ҵ������� @Override�� �� ����.
	@Autowired
	private AsstarrateService AsstarrateService;

	
	@Override
	@RequestMapping(value="/Asstarrate/fillAsstarrate.do", method= {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView fillAsstarrate(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map <String,Object>asForm = new HashMap<String,Object>();
		
		int asNo = Integer.parseInt(request.getParameter("asNo"));
		int resultcontainer = Integer.parseInt(request.getParameter("resultcontainer"));
		String textBox = request.getParameter("textBox");
		ModelAndView mav = new ModelAndView();
		
		asForm.put("asNo", asNo);
		asForm.put("resultcontainer", resultcontainer);
		asForm.put("textBox", textBox);
		
		AsstarrateService.starrateService(asForm);
		mav.setViewName("/main");
		return mav;
		
			
	}
	@RequestMapping(value="/Asstarrate/callStarrate.do" ,method= {RequestMethod.GET,RequestMethod.POST})
	@Override
	public ModelAndView callStarrate(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int asno = Integer.parseInt(request.getParameter("asno"));
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/Asstarrate/callStarrate");
		mav.addObject("asno", asno);
		return mav;
		
		
	}
}
