package com.example.dao;

import java.util.Map;

import com.example.vo.MemberVO;

public interface MemberDAO {
	void create(MemberVO memberVO);
	void read(Map map);
	void readAll(Map map);
	void update(MemberVO memberVO);
	void delete(String userid);
}
