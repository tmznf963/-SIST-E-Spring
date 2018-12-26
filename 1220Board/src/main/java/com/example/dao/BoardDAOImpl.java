package com.example.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.vo.BoardVO;

@Repository("boardDAO")
public class BoardDAOImpl implements BoardDAO {
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public void create(BoardVO board) {
		this.sqlSession.insert("Board.insertSP",board);//namespace.id
	}

	@Override
	public void update(BoardVO board) {
		this.sqlSession.update("Board.updateSP",board);
	}

	@Override
	public void answer(BoardVO board) {
		this.answer_update(board.getGrp(), board.getStep());
		this.sqlSession.insert("Board.answerInsertSP", board);
	}
	
	private void answer_update(int grp, int step) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("grp", grp);
		map.put("step", step);
		this.sqlSession.update("Board.answerUpdateSP", map);//step증가
	}
	
	@Override
	public void read(Map map) {
		this.sqlSession.selectOne("Board.selectOneSP",map);
	}

	@Override
	public void readAll(Map map) {
		this.sqlSession.selectList("Board.selectAllSP",map);
	}

	@Override
	public void getTotalCount(Map map) {
		this.sqlSession.selectOne("Board.selectTotalCountSP",map);
	}

	@Override
	public void delete(int idx) {
		this.sqlSession.delete("Board.deleteSP",idx);
	}

}
