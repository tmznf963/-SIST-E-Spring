package com.example.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.Hello;
import com.example.Printer;
import com.example.StringPrinter;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:config/beans.xml")
public class HelloBeanJUnitSpringTest {
	@Autowired
	private ApplicationContext ctx;
	
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
		Hello hello = (Hello)this.ctx.getBean("hello");
		for(String str: hello.getNames()) {
			System.out.println(str);
		}
	}

}
