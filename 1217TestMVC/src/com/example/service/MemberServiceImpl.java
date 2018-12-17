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
	public int create(MemberVO memberVO) {
		return this.memberDAO.create(memberVO);
	}

	@Override
	public MemberVO read(String userid) {
		return this.memberDAO.read(userid);
	}

	@Override
	public List<MemberVO> readAll() {
		return this.memberDAO.readAll();
	}

	@Override
	public int update(MemberVO memberVO) {
		return this.memberDAO.update(memberVO);
	}

	@Override
	public int delete(String userid) {
		// TODO Auto-generated method stub
		return 0;
	}

}
