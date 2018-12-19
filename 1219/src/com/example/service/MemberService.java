package com.example.service;

import java.util.List;

import com.example.vo.MemberVO;

public interface MemberService {
	MemberVO selectMember(String userid);
	List<MemberVO> select();
}
