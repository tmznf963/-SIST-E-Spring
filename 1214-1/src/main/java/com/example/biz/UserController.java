package com.example.biz;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.omg.CORBA.Request;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.vo.UserVO;

@Controller
public class UserController {
	@RequestMapping(value = "/confirm", method = RequestMethod.POST)
	public String home(HttpServletRequest request, Model model) throws IOException {
		request.setCharacterEncoding("utf-8");
		String username = request.getParameter("username");
		int userage = Integer.parseInt(request.getParameter("userage"));
		String gender = request.getParameter("gender");
		String city = request.getParameter("city");
		model.addAttribute("username", username);
		model.addAttribute("userage", userage);
		model.addAttribute("gender", gender);
		model.addAttribute("city", city);
		return "home";
	}

	@RequestMapping(value = "/confirm1", method = RequestMethod.POST)
	public String confirm1(@RequestParam("username") String username, 
												@RequestParam("userage") int userage,
												@RequestParam("gender") String gender, 
												@RequestParam("city") String city, Model model) throws IOException {
		model.addAttribute("username", username);
		model.addAttribute("userage", userage);
		model.addAttribute("gender", gender);
		model.addAttribute("city", city);
		return "confirm1"; // /WEB-INF/views/confirm1.jsp
	}
	
	@RequestMapping(value="/confirm2",method=RequestMethod.POST)
	public String confirm2(@RequestParam("username") String username, 
											@RequestParam("userage") int userage,
											@RequestParam("gender") String gender, 
											@RequestParam("city") String city, Model model) {
		UserVO userVO = new UserVO(username,userage,gender,city);
		model.addAttribute("userinfo",userVO);//jsp파일에서 --> c:set value=${userinfo} 값 받기
		return "confirm2"; //views -> confirm2.jsp
	}
	
	@RequestMapping(value="/confirm3",method=RequestMethod.POST)
	public String confirm3(UserVO userVO) {
		
		return "confirm3"; //views -> confirm3.jsp
	}
	
	@RequestMapping(value="/confirm4/{username}/{userage}/{gender}/{city}",method=RequestMethod.GET)
	public String confirm4(@PathVariable String username,
			@PathVariable int userage,
			@PathVariable String gender,
			@PathVariable String city,Model model) {
		model.addAttribute("userVO", new UserVO(username,userage,gender,city));
		//  /1214-1/confirm4/지민/42/여/대전
		return "confirm4";//views --> confirm4.jsp
	}
}
