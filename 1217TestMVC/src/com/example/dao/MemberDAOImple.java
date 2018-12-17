package com.example.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.vo.MemberVO;

@Repository("memberDAO")
public class MemberDAOImple implements MemberDAO {
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public int create(MemberVO memberVO) {
		return this.sqlSession.insert("Member.insert",memberVO);
	}

	@Override
	public MemberVO read(String userid) {
		return this.sqlSession.selectOne("Member.selectOne",userid);
	}

	@Override
	public List<MemberVO> readAll() {
		return this.sqlSession.selectList("Member.selectAll");//namespace.id
	}

	@Override
	public int update(MemberVO memberVO) {
		return this.sqlSession.update("Member.update",memberVO);
	}

	@Override
	public int delete(String userid) {
		// TODO Auto-generated method stub
		return 0;
	}

}
