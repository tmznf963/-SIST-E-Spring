package com.example.myapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
	@RequestMapping("/view") //Default 'GET'
	public String view(Model model) {
		model.addAttribute("currentDate", new java.util.Date());//key : value (String : object) == Page,Session,request,Application
		return "view"; // /WEB-INF/views/view + .jsp
	}
	
	@RequestMapping("/view1")
	public String view1(Model model) {
		model.addAttribute("username","한지민");
		model.addAttribute("userage","24");
		model.addAttribute("usergrade","3");
		model.addAttribute("userclassroom","5");
		return "view1"; //    /WEB-INF/views/view1  +  .jsp  [물리경로]
		//[논리경로]
	}
	
	@RequestMapping("/view2")
	public String view2(Model model) {
		String[] array ={"a","b","c","d"};
		model.addAttribute("fruits",array);//key : value
		return "view2";
	}
}
