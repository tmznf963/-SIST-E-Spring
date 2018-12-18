package com.example.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.vo.MemberVO;

@Repository("memberDAO")
public class MemberDAOImple implements MemberDAO {
	@Autowired
	SqlSession sqlSession;

	@Override
	public void create(MemberVO memberVO) {
		this.sqlSession.insert("Member.insertSP",memberVO);//namespace.id
	}

	@Override
	public void read(Map map) {
		this.sqlSession.selectOne("Member.selectOneSP",map);
	}

	@Override
	public void readAll(Map map) {//list
		this.sqlSession.selectList("Member.selectAllSP",map);//namespace.id [mapper.xml]
	}

	@Override
	public void update(MemberVO memberVO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String userid) {
		// TODO Auto-generated method stub
		
	}
	
	
}
