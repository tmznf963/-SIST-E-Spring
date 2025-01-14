package com.example;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:beans.xml");
		AdminConnection ac = ctx.getBean("adminConnection", AdminConnection.class);
		System.out.println(ac);
		ctx.close();
	}
}
