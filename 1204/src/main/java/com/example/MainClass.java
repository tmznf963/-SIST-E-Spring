package com.example;

import java.util.Scanner;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		String choice = selectDB();
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.getEnvironment().setActiveProfiles(choice);
		ctx.load("classpath:oracle.xml","classpath:mariadb.xml");
		ctx.refresh();
		
		ServerInfo serverInfo = ctx.getBean("serverInfo",ServerInfo.class);
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
