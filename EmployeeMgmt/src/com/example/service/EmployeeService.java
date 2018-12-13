package com.example.service;

import java.util.Map;

import com.example.vo.EmployeeVO;

public interface EmployeeService {
	void create(EmployeeVO empVO);
	void read(Map map);
	void readAll(Map map);
	void readByLoc(Map map);
	void update(EmployeeVO empVO);
	void delete(int empno);
}
