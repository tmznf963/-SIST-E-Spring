package com.example.service;

import java.util.List;

import com.example.vo.MemberVO;

public interface MemberService {
	int create(MemberVO memberVO);
	MemberVO read(String userid);
	List<MemberVO> readAll();
	int update(MemberVO memberVO);
	int delete(String userid);
}
