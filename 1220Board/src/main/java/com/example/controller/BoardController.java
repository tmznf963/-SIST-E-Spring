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
	//write.jsp로 이동
	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String write() {
		return "write"; // webapp/static/write.jsp
	}
	
	//selectAll					첫 페이지
	@RequestMapping(value = "/{page}", method = RequestMethod.POST)
	@ResponseBody		//나갈 때 object --> json
	public Map list(@PathVariable int page) {//--> 현재페이지
		Map<String,Object> countMap = new HashMap<String,Object>();
		this.boardService.getTotalCount(countMap);
		int totalCount = (Integer)countMap.get("result");
		int pageSize = 10;
		int totalPage = (totalCount%pageSize == 0) ? totalCount/pageSize : totalCount/pageSize +1; //전체페이지
		if(totalPage < page) page = totalPage;
		
		int pageCount = 10; //한 페이지에 뿌릴 수 있는 갯수는 10개씩
		
		int start = (page-1) * pageCount +1;//시작페이지가 1일 때 ex)1
		int end = start + pageCount -1;//끝페이지							ex)10
		
		int startPage = ((page - 1) * pageCount / pageCount) + 1;//2
		int endPage = startPage + pageCount - 1;//11
		if(endPage> totalPage) endPage = totalPage;
		
		Map<String, Object> results = new HashMap<String, Object>();//전체 레코드
		results.put("start", start);
		results.put("end", end);
		this.boardService.select(results);//Map
		List<BoardVO> list = (List<BoardVO>) results.get("results");//mapper의 property값
		
		Map<String,Object> map = new HashMap<String,Object>(); //사용자한테 전달할 Map
		map.put("code", Boolean.TRUE);
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		map.put("totalPage", totalPage);
		map.put("pageSize", pageSize);
		map.put("page", page);
		map.put("data", list);
		return map;
	}
	

	//selectOne					         /board/3page/2글번호
	@RequestMapping(value="/{page}/{idx}",method=RequestMethod.GET)
	@ResponseBody					//나갈 때 object --> json
	public ModelAndView read(@PathVariable int page, @PathVariable int idx) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("idx", idx);//idx넣기
		this.boardService.selectBoard(map);
		List<BoardVO> list = (List<BoardVO>)map.get("result");
		ModelAndView mav = new ModelAndView();
		mav.addObject("data",list.get(0));//반대쪽 jsp --> ${data}
		mav.addObject("page", page);//							  ${page}
		mav.setViewName("view");// --> /static/view.jsp
		return mav;
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
	
	//답글 insert
	@RequestMapping(value = "answer", method = RequestMethod.POST)
	@ResponseBody
	public Map answer(@RequestBody BoardVO board) {
		board.setLev(board.getLev() + 1);
		board.setStep(board.getStep() + 1);
		this.boardService.answerBoard(board);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("code", Boolean.TRUE);
		return result;
	}
	
	////답글 페이지 이동
	@RequestMapping(value="answer/{page}/{idx}",method=RequestMethod.GET)
	@ResponseBody					//나갈 때 object --> json
	public ModelAndView answer(@PathVariable int page, @PathVariable int idx) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("idx", idx);//idx넣기
		this.boardService.selectBoard(map);
		List<BoardVO> list = (List<BoardVO>)map.get("result");
		ModelAndView mav = new ModelAndView();
		mav.addObject("data",list.get(0));//반대쪽 jsp --> <c:set var="board" value="${data}" />
		mav.addObject("page", page);//							  ${page}
		mav.setViewName("answer");// --> /static/answer.jsp
		return mav;
	}
	
	
}
