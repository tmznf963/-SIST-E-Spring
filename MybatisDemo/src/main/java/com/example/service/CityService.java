package com.example.service;

import java.util.List;
import java.util.Map;

import com.example.vo.CityVO;

public interface CityService {
	void create(CityVO cityVO);
	CityVO read(String name);
	//void readAll(Map map);
	List<CityVO> readAll();
	void update(CityVO cityVO);
	void delete(int id);
}
