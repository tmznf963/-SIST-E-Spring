package com.example.test;

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
		//Select All
		for(UserVO user : this.userService.readAll()) {
			System.out.println(user);
		}
	}
	
	@Test @Ignore
	public void test1() {
		//Insert
		UserVO userVO = new UserVO("Spring","봄맨","남","HongDae");
		this.userService.create(userVO);
		test();
	}
	
	@Test
	public void test2() {
		//Select One & update
		test();
		System.out.print("Update userid : " );
		String userid = this.scan.next();
		System.out.println(this.userService.read(userid));
		System.out.print("City : "); String city = this.scan.next();
		UserVO userVO = new UserVO(userid,"","",city);
		this.userService.update(userVO);
		test();//목록뿌리기
		
	}
	@Test @Ignore
	public void test3() {
		//delete
		test();
		System.out.println("Delete userid : ");
		String userid = this.scan.next();
		this.userService.delete(userid);
		test();
	}
}
