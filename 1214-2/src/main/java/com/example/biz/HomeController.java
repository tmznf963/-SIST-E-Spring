package com.example.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.service.MemberService;
import com.example.vo.MemberVO;

@Controller
public class HomeController {
	@Autowired
	MemberService memberService;
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(MemberVO memberVO , Model model) {//INSERT
		int row = this.memberService.create(memberVO);
		if(row==1) model.addAttribute("status","Insert Success");
		else model.addAttribute("status","Inert Failure");//.jsp --> ${status}
		return "create";//veiws --> create.jsp
	}
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String list(Model model) {//selectALL
		List<MemberVO> list = this.memberService.readAll();
		model.addAttribute("userlist", list);
		return "list";// views --> list.jsp
	}
	
	@RequestMapping(value="/view/{userid}",method=RequestMethod.GET)
	public String view(@PathVariable String userid, Model model) {//selectONE
		MemberVO memberVO = this.memberService.read(userid);
		model.addAttribute("member",memberVO);//c:set
		return "view";
	}
	
	@RequestMapping(value="/delete/{userid}",method=RequestMethod.GET)
	public String delete(@PathVariable String userid) {//DELETE
		this.memberService.delete(userid);
		return "redirect:/list";//삭제 후 list.jsp이동
	}
	
	@RequestMapping(value="/update" , method=RequestMethod.POST)
	public String update(@RequestParam("userid") String userid,
			@RequestParam("userage") int userage,
			@RequestParam("gender") String gender,
			@RequestParam("city") String city) {
		this.memberService.update(new MemberVO(userid,"",userage,gender,city));
		return "redirect:/list";
	}

}
