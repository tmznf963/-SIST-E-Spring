package com.example.myapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/bbs")
public class StudentController {
	@RequestMapping("/get")
	public ModelAndView getStudent() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("hakbun","1101");
		mav.addObject("name","한송이");
		mav.setViewName("/get");//jsp
		return mav;
	}
	
	@RequestMapping("/insert")
	public ModelAndView insertStudent() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg","InsertSuccess");
		mav.setViewName("/insert");//jsp
		return mav;
	}
	
	@RequestMapping("/update")
	public ModelAndView updateStudent() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg","Update Success");
		mav.setViewName("/update");//jsp
		return mav;
	}
	
	@RequestMapping("/delete")
	public ModelAndView deleteStudent() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg","Delete Success");
		mav.setViewName("/delete");//delete.jsp
		return mav;
	}
}
