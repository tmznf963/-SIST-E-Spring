package com.example.test;

import static org.junit.Assert.assertSame;

import java.util.Scanner;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.service.UserService;
import com.example.vo.UserVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class TestApp {
	private Scanner scan;
	
	@Before
	public void init() {
		this.scan = new Scanner(System.in);
	}
	
	@Autowired
	UserService userService;

	
	@Test @Ignore
	public void test() {
		//select all
		for(UserVO userVO : this.userService.readAll()) {
			System.out.println(userVO);
		}
	}
	
	@Test @Ignore
	public void test1() {
		//INSERT(create)
		System.out.println("INSERT userid : "); String userid = scan.next();
		System.out.println("INSERT name : "); String name = scan.next();
		System.out.println("INSERT gender : "); String gender = scan.next();
		System.out.println("INSERT city : "); String city = scan.next();
		UserVO userVO = new UserVO(userid,name,gender,city);
		int row = this.userService.create(userVO);
		assertSame(1,row);
		test();
	}
	
	@Test @Ignore
	public void test2() {
		//select one
		test();
		System.out.println("Select One userid : "); 
		String userid = scan.next();
		System.out.println(this.userService.read(userid));
	}
	
	@Test @Ignore
	public void test3() {
		//UPDATE
		test();
		System.out.println("update userid: ");
		String userid = scan.next();
		System.out.println("update city: ");
		String city = scan.next();
		UserVO userVO = new UserVO(userid,"","",city);
		int row = this.userService.update(userVO);
		assertSame(1,row); //맞으면 성공
		test();
	}
	
	@Test
	public void test4() {
		test();
		System.out.println("DELETE userid : ");
		String userid = this.scan.next();
		this.userService.delete(userid);
		test();
	}
}
