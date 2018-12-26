package com.example.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.vo.ReplyVO;

@Repository("replyDAO")
public class ReplyDAOImpl implements ReplyDAO {
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public List<ReplyVO> list(int parent) {
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("parent", parent);//property에 대입
		this.sqlSession.selectList("Reply.select", map);//mapper가 hashMap으로 받으니
		List<ReplyVO> list = (List<ReplyVO>)map.get("results");//property="results"
		return list;
	}

	@Override
	public void create(ReplyVO replyVO) {
		this.sqlSession.insert("Reply.insert",replyVO);
	}

	@Override
	public void update(ReplyVO replyVO) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("idx", replyVO.getIdx());
		map.put("text", replyVO.getText());
		this.sqlSession.update("Reply.update",map);
	}

	@Override
	public void delete(int idx) {
		this.sqlSession.delete("Reply.delete",idx);
	}

}
