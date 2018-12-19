package com.example.dao;

import java.util.List;

import com.example.vo.MemberVO;

public interface MemberDAO {
	MemberVO read(String userid);
	List<MemberVO> readAll();
}
