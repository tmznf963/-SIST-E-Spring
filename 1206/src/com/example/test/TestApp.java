package com.example.test;

import java.util.Scanner;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.example.dao.EmployeeDAO;
import com.example.vo.EmployeeVO;

public class TestApp {
	private ApplicationContext ctx;
	
	@Before
	public void init() {
		this.ctx = new GenericXmlApplicationContext("applicationContext.xml");
	}
	
	/*@Test @Ignore
	public void test() {
		EmployeeDAO dao = this.ctx.getBean("employeeDAO",EmployeeDAO.class);
		Boolean flag = dao.insert(new EmployeeVO(4,"설운도",4300000));
//		System.out.println(flag.booleanValue() ? "Insert Success" : "Insert Faliure");
		System.out.println(flag.booleanValue());
	}*/
	
	/*@Test @Ignore
	public void test1() {
		//Select All
		EmployeeDAO dao = this.ctx.getBean("employeeDAO",EmployeeDAO.class);
		for(EmployeeVO employeeVO : dao.readAll()) {
			System.out.println(employeeVO);
		}
	}*/
	
	/*@Test @Ignore
	public void test2() {
		//Select Single
		Scanner scan = new Scanner(System.in);
		System.out.print( "Enter Select ID : "); int id = scan.nextInt();
		EmployeeDAO dao = this.ctx.getBean("employeeDAO",EmployeeDAO.class);
		System.out.println(dao.read(id));
	}*/
	
	@Test
	public void test3() {
		//Update
		Scanner scan = new Scanner(System.in);
		System.out.print( "Enter Update ID : "); int id = scan.nextInt();
		System.out.print( "수정할 이름 : "); String name = scan.next();
		System.out.print( "수정할 월급 : "); double salary = scan.nextDouble();
		EmployeeVO employeeVO = new EmployeeVO(id,name,salary);
		EmployeeDAO dao = this.ctx.getBean("employeeDAO",EmployeeDAO.class);
		dao.update(employeeVO);
	}

}
