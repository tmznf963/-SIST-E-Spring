package com.example.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.vo.MemberVO;

@Repository("memberDAO")
public class MemberDAOImple implements MemberDAO {
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public MemberVO read(String userid) {
		return null;
	}

	@Override
	public List<MemberVO> readAll() {
		return null;
	}

}
