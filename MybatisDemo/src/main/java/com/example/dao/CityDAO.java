package com.example.dao;

import java.util.List;
import java.util.Map;

import com.example.vo.CityVO;

public interface CityDAO {
	void create(CityVO cityVO);//insert
	CityVO read(String name);//detail
	//void readAll(Map map);//list
	List<CityVO> readAll();
	void update(CityVO cityVO);//수정
	void delete(int id);//삭제
}
