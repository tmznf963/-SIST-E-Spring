package com.example.dao;

import java.util.Map;

import com.example.vo.EmployeeVO;

//스토드프로시저 = return type void
public interface EmployeeDAO {
	void create(EmployeeVO empVO);
	void read(Map map);
	void readAll(Map map);
	void readByLoc(Map map);
	void update(EmployeeVO empVO);
	void delete(int empno);
}
