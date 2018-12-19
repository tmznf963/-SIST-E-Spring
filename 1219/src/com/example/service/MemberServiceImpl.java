package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.MemberDAO;
import com.example.vo.MemberVO;

@Service("memberService")
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	MemberDAO memberDAO;

	@Override
	public MemberVO selectMember(String userid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MemberVO> select() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
