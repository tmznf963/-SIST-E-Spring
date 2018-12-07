package com.example.dao;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.vo.UserVO;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

//applicationContext.xml의 scan에 의해서 불릴 이름
@Repository("userDAO")
public class UserDAOImpl implements UserDAO {
	
	@Override
	public void create(UserVO userVO) {
		Reader rd = null;
		SqlMapClient smc = null;
		try {
			rd = Resources.getResourceAsReader("SqlMapConfig.xml");
			smc = SqlMapClientBuilder.buildSqlMapClient(rd);
			smc.insert("Users.insert",userVO);//namespace.tagnameid
		}catch(IOException | SQLException e) {
			System.out.println(e);
		}
	}
	
	@Override
	public UserVO read(String userid) {
		Reader rd = null;
		SqlMapClient smc = null;
		UserVO userVO = null;
		try {
			rd = Resources.getResourceAsReader("SqlMapConfig.xml");
			smc = SqlMapClientBuilder.buildSqlMapClient(rd);
			userVO = (UserVO)smc.queryForObject("Users.readOne",userid);
		}catch(IOException | SQLException e) {
			System.out.println(e);
		}
		return userVO;
	}
	
	@Override
	public List<UserVO> readAll() {
		Reader rd = null;
		SqlMapClient smc = null;
		List<UserVO> list = null;
		try {
			rd = Resources.getResourceAsReader("SqlMapConfig.xml");
			smc = SqlMapClientBuilder.buildSqlMapClient(rd);
			list = smc.queryForList("Users.readAll");
		}catch(IOException | SQLException e) {
			System.out.println(e);
		}
		return list;
	}
	
	@Override
	public void update(UserVO userVO) {
		Reader rd = null;
		SqlMapClient smc = null;
		try {
			rd = Resources.getResourceAsReader("SqlMapConfig.xml");
			smc = SqlMapClientBuilder.buildSqlMapClient(rd);
			smc.update("Users.update",userVO);//namespace.tagnameid
		}catch(IOException | SQLException e) {
			System.out.println(e);
		}
	}

	@Override
	public void delete(String userid) {
		Reader rd = null;
		SqlMapClient smc = null;
		try {
			rd = Resources.getResourceAsReader("SqlMapConfig.xml");
			smc = SqlMapClientBuilder.buildSqlMapClient(rd);
			smc.delete("Users.delete",userid);//namespace.tagnameid
		}catch(IOException | SQLException e) {
			System.out.println(e);
		}
	}

}
