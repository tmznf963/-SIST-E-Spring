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
	public int create(UserVO userVO) {
		return this.userDAO.create(userVO);
	}

	@Override
	public UserVO read(String userid) {
		return this.userDAO.read(userid);
	}

	@Override
	public List<UserVO> readAll() {
		return this.userDAO.readAll();
	}

	@Override
	public int update(UserVO userVO) {
		return this.userDAO.update(userVO);
	}

	@Override
	public void delete(String userid) {
		this.userDAO.delete(userid);
	}

}
