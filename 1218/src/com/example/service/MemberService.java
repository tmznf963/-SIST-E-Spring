package com.example.service;

import java.util.Map;

import com.example.vo.MemberVO;

public interface MemberService {
	void insertMember(MemberVO memberVO);
	void selectMember(Map map);
	void select(Map map);
	void updateMember(MemberVO memberVO);
	void deleteMember(String userid);
}
