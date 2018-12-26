package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.ReplyDAO;
import com.example.vo.ReplyVO;

@Service("replyService")
public class ReplyServiceImpl implements ReplyService {
	@Autowired
	ReplyDAO replyDAO;
	
	@Override
	public List<ReplyVO> list(int parent) {
		return this.replyDAO.list(parent);
	}

	@Override
	public void create(ReplyVO replyVO) {
		this.replyDAO.create(replyVO);
	}

	@Override
	public void update(ReplyVO replyVO) {
		this.replyDAO.update(replyVO);
	}

	@Override
	public void delete(int idx) {
		this.replyDAO.delete(idx);
	}

}
