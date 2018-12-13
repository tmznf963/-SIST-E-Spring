package com.example.biz;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RequestController {

	@RequestMapping(value="/confirm", method = RequestMethod.GET)
	public String confirm(HttpServletRequest request, Model model) {
		String username = request.getParameter("username");
		int userage = Integer.parseInt(request.getParameter("userage"));//넘어오는게 String --> int type
		int usergrade = Integer.parseInt(request.getParameter("usergrade"));
		int userclassnum = Integer.parseInt(request.getParameter("userclassnum"));
		
		model.addAttribute("username",username);
		model.addAttribute("userage", userage);
		model.addAttribute("usergrade", usergrade);
		model.addAttribute("userclassnum", userclassnum);
		
		return "confirm"; //confirm.jsp
	}
}
