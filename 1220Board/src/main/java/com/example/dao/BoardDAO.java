package com.example.dao;

import java.util.Map;

import com.example.vo.BoardVO;

public interface BoardDAO {
	void create(BoardVO board);
	void update(BoardVO board);
	void answer(BoardVO board);//댓글
	
	void read(Map map);//detail
	void readAll(Map map);//list
	void getTotalCount(Map map);//페이징

	void delete(int idx);
}
