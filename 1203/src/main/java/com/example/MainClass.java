package com.example;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		 GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		 ctx.load("classpath:applicationContext.xml");//이때 컨테이너 만들어짐
		 ctx.refresh();//bean이 만들어짐
		 Student2 student2 = ctx.getBean("student2",Student2.class);
		 System.out.println(student2);
		 
		 ctx.close();
	}
}
