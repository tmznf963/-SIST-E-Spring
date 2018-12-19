package com.example.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.MemberDAO;
import com.example.vo.MemberVO;

@Service("memberService")
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	MemberDAO memberDAO;

	@Override
	public void insertMember(MemberVO memberVO) {
		this.memberDAO.create(memberVO);
	}

	@Override
	public void selectMember(Map map) {
		this.memberDAO.read(map);
	}

	@Override
	public void select(Map map) {//list
		this.memberDAO.readAll(map);//Call By Reference
	}

	@Override
	public void updateMember(MemberVO memberVO) {
		this.memberDAO.update(memberVO);
	}

	@Override
	public void deleteMember(String userid) {
		this.memberDAO.delete(userid);
	}
	
	

}
