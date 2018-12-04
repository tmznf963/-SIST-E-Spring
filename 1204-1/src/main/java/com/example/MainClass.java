package com.example;

import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class MainClass {
	public static void main(String[] args) {
		String choice = selectDB().toLowerCase();
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.getEnvironment().setActiveProfiles(choice);
		ctx.register(ApplicationConfigMariaDB.class,ApplicationConfigOracle.class);//ServerInfo에 값 넣기
		ctx.refresh();
		ServerInfo serverInfo = (ServerInfo) ctx.getBean("serverInfo");
		System.out.println(serverInfo);
		ctx.close();

	}
	public static String selectDB() {
		Scanner scan = new Scanner(System.in);
		System.out.println("oracle");
		System.out.println("mariadb");
		System.out.println("어떤 Database를 사용하시겠습니가?");
		return scan.next();//== nextline
	}
}
