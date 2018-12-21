package com.example.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.service.BoardService;
import com.example.vo.BoardVO;

@Controller
public class BoardController {
	private static Logger logger = Logger.getLogger(BoardController.class);
	
	@Autowired
	BoardService boardService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "index";
	}
	
	//selectAll					첫 페이지
	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ResponseBody		//나갈 때 object --> json
	public Map list() {
		Map<String,Object> map = new HashMap<String,Object>();
		this.boardService.select(map);
		List<BoardVO> list = (List<BoardVO>)map.get("results");//maaper의 peoperty값
		Map<String,Object> data = new HashMap<String,Object>();
		data.put("code", Boolean.TRUE);
		data.put("data", list);
		return data;
	}
	

	//selectOne					         /board/3
	@RequestMapping(value="/{idx}",method=RequestMethod.GET)
	@ResponseBody					//나갈 때 object --> json
	public ModelAndView read(@PathVariable int idx) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("idx", idx);//집어넣어
		this.boardService.selectBoard(map);
		List<BoardVO> list = (List<BoardVO>)map.get("result");
		ModelAndView mav = new ModelAndView();
		mav.addObject("data",list.get(0));//반대쪽 jsp --> ${data}
		mav.setViewName("view");// --> /static/view.jsp
		return mav;
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
		contents = contents.replaceAll("\r\n", "<br/>");//Enter
		contents = contents.replaceAll("<","&lt;");
		contents = contents.replaceAll(">","&gt;");
		contents = contents.replaceAll("'","''");
		board.setContents(contents);
		
		this.boardService.insertBoard(board);
		result.put("code", Boolean.TRUE); //성공
		return result;
	}
	
	//delete
	@RequestMapping(value="/{idx}",method=RequestMethod.DELETE)
	@ResponseBody
	public Map delete(@PathVariable int idx) {
		this.boardService.deleteBoard(idx);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("code", Boolean.TRUE);
		return map;
	}
	
	//update
	@RequestMapping(value="/{idx}",method=RequestMethod.PUT)
	@ResponseBody
	public Map update(@PathVariable int idx, @RequestBody BoardVO board) {
		board.setIdx(idx);
		this.boardService.updateBoard(board);;
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("code", Boolean.TRUE);
		return map;
	}
	
//	//1000개 돌리는 메소드
//	@RequestMapping(value = "test",method=RequestMethod.GET)
//	public void test() {
//		for (int i = 1; i <= 1000; i++) {
//			BoardVO board = new BoardVO();
//			board.setName("한지민");
//			board.setEmail("aaa@aaa.com");
//			board.setTitle("이 글은"+i + "번째 글입니다.");
//			board.setContents("이 글은"+i + "번째 글입니다.");
//			this.boardService.insertBoard(board);
//		}
//	}
	
}
