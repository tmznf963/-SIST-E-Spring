package com.example.service;

import java.util.Map;

import com.example.vo.BoardVO;

public interface BoardService {
	void insertBoard(BoardVO board);
	void updateBoard(BoardVO board);
	void answerBoard(BoardVO board); //댓글

	void selectBoard(Map map);//detail
	void select(Map map);//list
	void getTotalCount(Map map);//페이징
	
	void deleteBoard(int idx);
}
