package com.example.dao;

import java.util.List;

import com.oracle.vo.UserVO;

public interface UserDAO {
	void create(UserVO userVO);
	UserVO read(String userid);
	List<UserVO> readAll();
	void update(String userid);
	void delete(String userid);
}
