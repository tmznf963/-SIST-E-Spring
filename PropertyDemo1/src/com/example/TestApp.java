package com.example;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TestApp {
	private ApplicationContext ctx;
	@Before
	public void init() {
		this.ctx = new GenericXmlApplicationContext("classpath:config/bean.xml");
	}
	@Test
	public void test() {
		assertNotNull(this.ctx);
	}
	@Test
	public void test1() {
		//Hello hello2 = this.ctx.getBean("hello",Hello.class);
		Hello hello = (Hello)this.ctx.getBean("hello");
		hello.print();
		Printer printer = (StringPrinter)this.ctx.getBean("stringPrinter");
		System.out.println(printer);
		System.out.println("names.size = " + hello.getNames().size());
		for(String str : hello.getNames()) {
			System.out.println(str);
		}
	}

}
