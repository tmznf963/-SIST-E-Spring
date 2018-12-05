package com.example.service;

import java.util.List;

import com.example.vo.UserVO;

//void == return 안하는 애들
public interface UserService {
	void createUser(UserVO userVO);
	UserVO readUser(String userid);
	List<UserVO> selectAllUsers();
	void updateUser(String userid, String city);
	void deleteUser(String userid);
	
}
