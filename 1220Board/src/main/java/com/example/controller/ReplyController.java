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

import com.example.service.ReplyService;
import com.example.vo.ReplyVO;

@Controller
public class ReplyController {
	@Autowired
	ReplyService replyService;

	//reply Insert						 /board/reply
	@RequestMapping(value="/reply",method=RequestMethod.POST)
	@ResponseBody
	public Map insert(@RequestBody ReplyVO replyVO) {//작성자,댓글내용,게시글부모번호
		Map<String,Object> map = new HashMap<String,Object>();
		this.replyService.create(replyVO);
		map.put("code", Boolean.TRUE);
		return map;
	}
	
	//reply All Select										//parseInt(idx) 로 받아야 함
	@RequestMapping(value="/reply/all/{parent}",method=RequestMethod.GET)
	@ResponseBody
	public Map list(@PathVariable int parent) {
		Map<String,Object> map = new HashMap<String,Object>();
		List<ReplyVO> list = this.replyService.list(parent);
		map.put("code", Boolean.TRUE);
		map.put("data", list);
		return map;
	}
	
	//reply Delete
	@RequestMapping(value="/reply/{idx}",method=RequestMethod.DELETE)
	@ResponseBody
	public Map delete(@PathVariable int idx) {
		Map<String,Object> map = new HashMap<String,Object>();
		this.replyService.delete(idx);
		map.put("code",Boolean.TRUE);
		return map;
	}
	
	//reply Update
		@RequestMapping(value="/reply",method=RequestMethod.PUT)
		@ResponseBody
		public Map update(@RequestBody ReplyVO replyVO) { //json으로 받으려면 @RequestBody
			System.out.println(replyVO);
			Map<String,Object> map = new HashMap<String,Object>();
			this.replyService.update(replyVO);
			map.put("code",Boolean.TRUE);
			return map;
		}
}
