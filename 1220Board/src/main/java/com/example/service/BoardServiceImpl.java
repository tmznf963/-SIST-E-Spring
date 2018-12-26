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
		this.boardDAO.create(board);//row값 1 check
	}

	@Override
	public void updateBoard(BoardVO board) {
		this.boardDAO.update(board);
	}

	@Override
	public void answerBoard(BoardVO board) {
		this.boardDAO.answer(board);
	}

	@Override
	public void selectBoard(Map map) {
		this.boardDAO.read(map);
	}

	@Override
	public void select(Map map) {
		this.boardDAO.readAll(map);
	}

	@Override
	public void getTotalCount(Map map) {
		this.boardDAO.getTotalCount(map);
	}

	@Override
	public void deleteBoard(int idx) {
		this.boardDAO.delete(idx);
	}

}
