package com.example.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.service.MemberService;
import com.example.vo.MemberVO;

@Controller
public class MemberController {
	@Autowired
	MemberService memberService;
	
	//update
	@RequestMapping(value="/users", method=RequestMethod.PUT)
	@ResponseBody
	public Map update(@RequestBody MemberVO memberVO) {
		this.memberService.updateMember(memberVO);
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("code","success");
		map.put("data", memberVO);
		return map;
	}
	
	//delete
	@RequestMapping(value="users/{userid}", method=RequestMethod.DELETE)
	@ResponseBody
	public Map delete(@PathVariable String userid) {
		this.memberService.deleteMember(userid);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("code", "success");
		return map;//TDD 테스트주도개발 == postman 사용
	}
	
	
	//selectOne
	@RequestMapping(value="users/{userid}", method=RequestMethod.GET)
	@ResponseBody
	public Map read(@PathVariable String userid) {//java object --> json 으로
		Map<String, Object> map = new HashMap<String,Object>();
		//Service로 보내는 객체
		map.put("userid", userid);
		this.memberService.selectMember(map);
		List<MemberVO> list = (List<MemberVO>)map.get("results");
		MemberVO memberVO = list.get(0);
		//사용자에게 return 객체
		Map<String, Object> re_map = new HashMap<String,Object>();
		re_map.put("code","success");
		re_map.put("data", memberVO);
		//System.out.println(re_map);
		return re_map;
	}
	
	
	
	//insert
	@RequestMapping(value="/users",method=RequestMethod.POST)
	@ResponseBody
	public Map create(@RequestBody MemberVO memberVO) {//json --> Java object
		this.memberService.insertMember(memberVO);
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("code","success");
		map.put("data", memberVO);
		return map;
	}
	
	
	//selectAll
	@RequestMapping(value="/users",method=RequestMethod.GET)
	@ResponseBody
	public Map list() {		//Java object --> json
		Map<String,Object> map = new HashMap<String,Object>();
		this.memberService.select(map);
		List<MemberVO> list = (List<MemberVO>)map.get("results");//mapper의 property값
		
		Map<String,Object> re_map = new HashMap<String,Object>();
		re_map.put("code","success");
		re_map.put("data", list);
		return re_map;
	}
}
