package com.example;

import java.util.Scanner;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.service.UserService;
import com.oracle.vo.UserVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class TestApp {

	@Autowired
	private UserService userService;
	
	@Test 
	public void test1() {
		for(UserVO uservo : this.userService.selectAllUsers()) {
			System.out.println(uservo);
		}
	}
	@Test @Ignore
	public void test() {
		Scanner scan = new Scanner(System.in);
		System.out.print("User ID : "); String userid=scan.next();
		System.out.print("User Name : "); String name =scan.next();
		System.out.print("User Gender : "); String gender=scan.next();
		System.out.print("User City : "); String city=scan.next();
		
		UserVO userVO = new UserVO(userid,name,gender,city);
		this.userService.createUser(userVO);
	}
	@Test @Ignore
	public void test2() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Delete userid : ");
		String userid = scan.next();
		this.userService.deleteUser(userid);
	}
	
	@Test @Ignore
	public void test3() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter userid to update: ");
		String userid = scan.next();
		System.out.println("City : ");
		String city = scan.next();
		
		this.userService.updateUser(userid, city);
		this.test1();
	}
	
	@Test
	public void test4() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Search userid : ");
		String userid = scan.next();
		
		UserVO userVO = this.userService.readUser(userid);
		System.out.println(userVO);
	}
}
