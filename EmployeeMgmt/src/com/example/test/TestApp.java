package com.example.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.service.EmployeeService;
import com.example.vo.EmployeeVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:beans.xml")
public class TestApp {
	private Scanner scan;

	@Autowired
	EmployeeService empService;
	
	@Before
	public void init() {
		this.scan = new Scanner(System.in);
	}
	
	@Test @Ignore
	public void test() {
		Map<String,Object> map = new HashMap<String,Object>();
		this.empService.readAll(map);
		List<EmployeeVO> list = (List<EmployeeVO>)map.get("result");//map.get(key);
		for(EmployeeVO empVO : list) {
			System.out.println(empVO);//toString();
		}
	}
	
	@Test @Ignore
	public void test1() {
		test();
		int empno = scan.nextInt();
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("empno", empno);//IN 마다 put
		this.empService.read(map);
		
		List<EmployeeVO> list = (List<EmployeeVO>)map.get("result");
		System.out.println(list.get(0));
	}
	
	@Test
	public void test2() {
		System.out.println("근무지 : "); 
		String loc=scan.next();
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("loc", loc);
		this.empService.readByLoc(map);
		List<EmployeeVO> list = (List<EmployeeVO>)map.get("result");
		for(EmployeeVO empVO : list) {
			System.out.printf("%s(%d) , %d, %s ,%s\n" , empVO.getEname(),
												empVO.getEmpno(), empVO.getDeptno(),
												empVO.getDname(),empVO.getLoc());
		}
	}

}
