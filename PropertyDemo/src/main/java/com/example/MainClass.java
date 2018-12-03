package com.example;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:applicationContext.xml");
		ctx.refresh();
		
		MyDataSource dataSource = ctx.getBean("dataSource",MyDataSource.class);
		System.out.println(dataSource);
		ctx.close();
	}
}
