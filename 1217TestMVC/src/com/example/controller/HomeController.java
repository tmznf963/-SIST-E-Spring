package com.example.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.service.MemberService;
import com.example.vo.MemberVO;

@Controller
public class HomeController {
	@Autowired
	MemberService memberService;
	//Controller -> Service -> DAO -> mapper
	//           ?.jsp       <-	 	       <-           <-
	
	@RequestMapping(value="/list.do", method=RequestMethod.GET)
	public String list(Model model) {
		List<MemberVO> list = this.memberService.readAll();
		model.addAttribute("list",list);
		return "list.jsp";
	}
	
	@RequestMapping(value="/join.do", method=RequestMethod.GET)
	public String join() {
		return "register.html";
	}
	
	@RequestMapping(value="/join.do", method=RequestMethod.POST)
	public String join(MemberVO memberVO, Model model) {
		int row = this.memberService.create(memberVO);
		if(row == 1) return "redirect:/list.do";
		else return "redirect:/register.html";
	}
	
	@RequestMapping(value="/view.do",method=RequestMethod.GET)
	public String view(HttpServletRequest request, Model model) {//model은 Spring이 만들어 준다.
		String userid = request.getParameter("userid");
		MemberVO memberVO = this.memberService.read(userid);
		model.addAttribute("member",memberVO);//c:set
		return "view.jsp";
	}
	@RequestMapping(value="/update.do", method=RequestMethod.POST)
	public String update(MemberVO memberVO, Model model) {
		int row = this.memberService.update(memberVO);
		if(row == 1) return "redirect:/list.do";
		else return "redirect:/view.jsp";
	}
	
}
