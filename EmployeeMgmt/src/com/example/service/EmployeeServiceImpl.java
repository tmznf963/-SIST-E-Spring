package com.example.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.EmployeeDAO;
import com.example.vo.EmployeeVO;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeDAO employeeDAO;
	
	@Override
	public void create(EmployeeVO empVO) {
		// TODO Auto-generated method stub

	}

	@Override
	public void read(Map map) {
		this.employeeDAO.read(map);
	}

	@Override
	public void readAll(Map map) {
		this.employeeDAO.read(map);
	}
	
	@Override
	public void readByLoc(Map map) {
		this.employeeDAO.readByLoc(map);
	}
	
	@Override
	public void update(EmployeeVO empVO) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int empno) {
		// TODO Auto-generated method stub

	}

	

}
