package com.example.myapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class mavController {
	
	@RequestMapping("/demo")
	public ModelAndView demo() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("userid","gamma");//key:value (String:Object)
		mav.addObject("userpasswd","123123");
		mav.setViewName("/demo"); //demo.jsp
		return mav;
	}
}
