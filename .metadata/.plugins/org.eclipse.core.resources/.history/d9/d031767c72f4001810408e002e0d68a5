package com.example;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		String configXml = "classpath:applicationContext.xml";
		//IoC Container 생성
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load(configXml);
		ctx.refresh();
		Student student1 = ctx.getBean("student1",Student.class);
		System.out.println(student1);
		Student student2 = ctx.getBean("student2",Student.class);
		System.out.println(student2);
		
		//Container 소멸
		ctx.close();
	}
}
