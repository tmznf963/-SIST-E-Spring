package com.example.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.CityDAO;
import com.example.vo.CityVO;

//TestApp에서 부를
@Service("cityService")
public class CityServiceImpl implements CityService {
	//DAO와 바인딩
	@Autowired
	CityDAO cityDAO;
	
	@Override
	public void create(CityVO cityVO) {
		// TODO Auto-generated method stub

	}

	@Override
	public CityVO read(String name) {
		return this.cityDAO.read(name);
	}

	@Override
	public List<CityVO> readAll() {
		return this.cityDAO.readAll();
	}

	@Override
	public void update(CityVO cityVO) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub

	}

}
