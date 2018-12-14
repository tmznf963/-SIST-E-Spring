package com.example.dao;

import java.util.List;

import com.example.vo.MemberVO;

public interface MemberDAO {
	int create(MemberVO memberVO);
	MemberVO read(String userid);
	List<MemberVO> readAll();
	int update(MemberVO memberVO);
	int delete(String userid);
}
