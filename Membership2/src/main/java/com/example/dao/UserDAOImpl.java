package com.example.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Repository;

import com.example.vo.UserVO;

@Repository("userDAO")
public class UserDAOImpl implements UserDAO {

	@Override
	public int create(UserVO userVO) {
		Reader rd = null;
		SqlSession session = null;
		int row = -1;
		try {
			rd=Resources.getResourceAsReader("mybatis-config.xml");
			session = new SqlSessionFactoryBuilder().build(rd).openSession();
			row = session.insert("insert",userVO);//xml tag id + 받은 파라미터 값
			session.commit();
		}catch(IOException e) {
			System.out.println(e);
		}
		return row;
	}

	@Override
	public UserVO read(String userid) {
		Reader rd = null;
		SqlSession session = null;
		UserVO userVO = null;
		try {
			rd=Resources.getResourceAsReader("mybatis-config.xml");
			session = new SqlSessionFactoryBuilder().build(rd).openSession();
			userVO = (UserVO)session.selectOne("read",userid);// tag id , 받은 파라미터 값
		}catch(IOException e) {
			System.out.println(e);
		}
		return userVO;
	}

	@Override
	public List<UserVO> readAll() {
		Reader rd = null;
		SqlSession session = null;
		List<UserVO> list = null;
		try {
			rd = Resources.getResourceAsReader("mybatis-config.xml");
			session = new SqlSessionFactoryBuilder().build(rd).openSession();
			list = session.selectList("readAll");//xml tag id
		} catch (IOException e) {
			System.out.println(e);
		}
		return list;
	}

	@Override
	public int update(UserVO userVO) {
		Reader rd = null;
		SqlSession session = null;
		int row = -1;
		try {
			rd=Resources.getResourceAsReader("mybatis-config.xml");
			session = new SqlSessionFactoryBuilder().build(rd).openSession();
			row = session.update("update",userVO);//xml tag id + 받은 파라미터 값
			session.commit();
		}catch(IOException e) {
			System.out.println(e);
			session.rollback();
		}
		return row;
	}

	@Override
	public void delete(String userid) {
		Reader rd = null;
		SqlSession session = null;
		try {
			rd=Resources.getResourceAsReader("mybatis-config.xml");
			session = new SqlSessionFactoryBuilder().build(rd).openSession();
			session.delete("delete",userid);//xml tag id + 받은 파라미터 값
			session.commit();
		}catch(IOException e) {
			System.out.println(e);
			session.rollback();
		}
	}

}
