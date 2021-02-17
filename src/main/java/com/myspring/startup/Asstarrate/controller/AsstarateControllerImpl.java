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

//	넘어오는 정보 = asNo / jsp에서 받아서,  dao로 옮겨준다.
	// int로 넘어와서, service로 넘겨준다.
//	메소드위에는 @Override를 꼭 쓴다.
	@Autowired
	private AsstarrateService AsstarrateService;
	
	private AsstarrateVO AsstarrateVO;
	
	@Override
	@RequestMapping(value="", method= {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView fillAsstarrate(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map asList = new HashMap();
		
		int asNum = Integer.parseInt(request.getParameter("asNo"));
		int star = Integer.parseInt(request.getParameter("star"));
		String text = request.getParameter("textBox");
		ModelAndView mav = new ModelAndView();
		
		asList.put("asNo", asNum);
		asList.put("star", star);
		asList.put("textBox", text);
		
		
		
		return mav;
		
		
	}
}
