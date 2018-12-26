package com.example.service;

import java.util.List;

import com.example.vo.ReplyVO;

public interface ReplyService {
	List<ReplyVO> list(int parent);
	void create(ReplyVO replyVO);
	void update(ReplyVO replyVO);
	void delete(int idx);
}
