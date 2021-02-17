package com.myspring.startup.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller("MainController")
public class MainController {
	
	@RequestMapping(value= {"/","/main/main.do"}, method=RequestMethod.GET)
	public ModelAndView main() {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("/main");
		
		return mav;
	}
}
