package com.example.dao;

import java.util.List;

import com.example.vo.UserVO;

public interface UserDAO {
	int create(UserVO userVO);
	UserVO read(String userid);
	List<UserVO> readAll();
	int update(UserVO userVO);
	void delete(String userid);
}
