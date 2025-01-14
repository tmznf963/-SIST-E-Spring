package com.example.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.example.Hello;
import com.example.Printer;
import com.example.StringPrinter;

public class HelloBeanTest {
	private ApplicationContext ctx;
	@Before
	public void init() {
		this.ctx = new GenericXmlApplicationContext("config/beans.xml");
	}
	@Test @Ignore
	public void test() {
		assertNotNull(this.ctx);//null이 아니면 true
	}
	@Test @Ignore
	public void test1() {
		Hello hello = this.ctx.getBean("hello",Hello.class);
		Hello hello2 = (Hello)this.ctx.getBean("hello");
		assertSame(hello,hello2);//주소값 비교
	}
	@Test @Ignore
	public void test2() {
		Printer printer = this.ctx.getBean("stringPrinter",StringPrinter.class);//자식 --> 부모로 형변환
		printer.print("Good Morning");
		assertEquals("Good Morning",printer.toString());
	}
	@Test @Ignore
	public void test3() {
//		Printer printer = this.ctx.getBean("stringPrinter",StringPrinter.class);
//		Hello hello = (Hello)this.ctx.getBean("hello");
//		hello.print();
//		assertEquals("Hello 한지민",printer.toString());
	}
	@Test
	public void test4() {
		Hello hello = this.ctx.getBean("hello",Hello.class);
		assertSame(3,hello.getNames().size());//(예상값,실제값);
	}

}
