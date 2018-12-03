package com.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainClass1 {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		AdminConnection1 adminConnection1 = ctx.getBean("adminConnection1",AdminConnection1.class);
		System.out.println(adminConnection1);
	}
}
