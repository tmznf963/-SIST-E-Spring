package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
//		Printer printer = new StringPrinter();
//		Hello hello = new Hello("한지민",printer);
//		hello.print();
//		System.out.println(printer.toString());
		ApplicationContext ctx = new GenericXmlApplicationContext("config/beans.xml");
		Hello hello = (Hello)ctx.getBean("hello");
		hello.print();
		Printer printer = (StringPrinter)ctx.getBean("stringPrinter");//beans.xml 의 id 값
		System.out.println(printer.toString());
	}
}
