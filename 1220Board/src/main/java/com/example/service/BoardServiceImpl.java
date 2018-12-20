package com.example.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.BoardDAO;
import com.example.vo.BoardVO;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
	@Autowired
	BoardDAO boardDAO;
	
	@Override
	public void insertBoard(BoardVO board) {
		this.boardDAO.create(board);
	}

	@Override
	public void updateBoard(BoardVO board) {

	}

	@Override
	public void answerBoard(BoardVO board) {

	}

	@Override
	public void selectBoard(Map map) {

	}

	@Override
	public void select(Map map) {

	}

	@Override
	public void getTotalCount(Map map) {

	}

	@Override
	public void deleteBoard(int idx) {

	}

}
