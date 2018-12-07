package com.example.dao;

import java.util.List;

import com.example.vo.UserVO;

public interface UserDAO {
	void create(UserVO userVO);
	UserVO read(String userid);
	List<UserVO> readAll();
	void update(UserVO userVO);
	void delete(String userid);
}
