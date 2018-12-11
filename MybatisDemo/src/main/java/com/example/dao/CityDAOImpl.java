package com.example.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.vo.CityVO;

//service에서 부를 이름
@Repository("cityDAO")
public class CityDAOImpl implements CityDAO {
	//SqlSession과 바인딩
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public void create(CityVO cityVO) {

	}

	@Override
	public CityVO read(String name) {
		return this.sqlSession.selectOne("City.selectOne",name);
	}

	@Override
	public List<CityVO> readAll() {
		return this.sqlSession.selectList("City.selectAll");//namespace.id
	}

	@Override
	public void update(CityVO cityVO) {

	}

	@Override
	public void delete(int id) {

	}

}
