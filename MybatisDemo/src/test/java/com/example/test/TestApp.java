package com.example.test;

import java.util.Scanner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.service.CityService;
import com.example.vo.CityVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class TestApp {
	@Autowired
	CityService cityService;
		
	@Test
	public void test() {
		for(CityVO cityVO : this.cityService.readAll()) {
			System.out.println(cityVO);
		}
	}
	@Test
	public void test1() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Search Name : "); String name = scan.next();
		System.out.println(this.cityService.read(name));
	}

}
