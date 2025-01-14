package com.example;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
//		Printer printer = new StringPrinter();
//		Hello hello = new Hello();
//		hello.setName("한지민");
//		hello.setPrinter(printer);
//		hello.print();
//		System.out.println(printer.toString());
		//String configXml = "classpath:applicationContext.xml";
		
		
		//1. IoC Container 생성하자.
		String configXml = "config/beans.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configXml);
		
		//2. Hello Bean 가져오기
		Hello hello = ctx.getBean("hello",Hello.class);
		hello.print();
		Printer printer = (StringPrinter)ctx.getBean("stringPrinter");
		System.out.println(printer.toString());
		
		Hello hello2 = (Hello)ctx.getBean("hello");
		System.out.println(hello); //주소가 같음 == 싱글톤패턴(xml사용 객체 생성)
		System.out.println(hello2);
	}
}
