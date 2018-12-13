package com.example.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.vo.EmployeeVO;

@Repository("empVO")
public class EmployeeDAOImpl implements EmployeeDAO {
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public void create(EmployeeVO empVO) {
		// TODO Auto-generated method stub

	}

	@Override
	public void read(Map map) {
		this.sqlSession.selectOne("Employee.seletOne",map);
	}

	@Override
	public void readAll(Map map) {
		this.sqlSession.selectList("Employee.selectAll",map);//"namespace.id"
	}
	
	@Override
	public void readByLoc(Map map) {
		this.sqlSession.selectList("Employee.selectByLoc", map);
	}

	@Override
	public void delete(int empno) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(EmployeeVO empVO) {
		// TODO Auto-generated method stub
		
	}

	

}
