package com.example.controller;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.service.BoardService;
import com.example.vo.BoardVO;

@Controller
public class BoardController {
	@Autowired
	BoardService boardService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "index";
	}
	
	//write.jsp로 이동
	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String write() {
		return "write"; // webapp/static/write.jsp
	}
	
	//insert
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	@ResponseBody
	public Map insert(@RequestBody BoardVO board) { //json --> Java object
		Map<String, Object> result = new HashMap<String, Object>();
		
		//input type="text" 에 있는것들은 모두 처리 해줘야 함.
		String title = board.getTitle();
		title = title.replaceAll("<","&lt;");
		title = title.replaceAll(">","&gt;");
		title = title.replaceAll("'","''");//db에서 오류남 ' 쓰면
		board.setTitle(title);
		
		String contents = board.getContents();
		contents = contents.replaceAll("<","&lt;");
		contents = contents.replaceAll(">","&gt;");
		contents = contents.replaceAll("'","''");
		contents = contents.replaceAll("\r\n", "<br/>");//Enter
		board.setContents(contents);
		
		this.boardService.insertBoard(board);
		result.put("code", "Insert Success");
		return result;
	}
}
