package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.UserDAO;
import com.example.vo.UserVO;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	UserDAO userDAO;
	
	@Override
	public void createUser(UserVO userVO) {
		this.userDAO.create(userVO);
	}

	@Override
	public UserVO readUser(String userid) {
		return this.userDAO.read(userid);
	}

	@Override
	public List<UserVO> selectAllUsers() {
		return this.userDAO.readAll();
	}

	@Override
	public void updateUser(String userid, String city) {
		this.userDAO.update(userid, city);
	}

	@Override
	public void deleteUser(String userid) {
		this.userDAO.delete(userid);
	}

}
