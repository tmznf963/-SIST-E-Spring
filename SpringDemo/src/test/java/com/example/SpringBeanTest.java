package com.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SpringBeanTest {
	private ApplicationContext ctx;
	@Before
	public void init() {
		this.ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");		
	}
	
	@Test
	public void test() {
		assertNotNull(this.ctx);
	}
	@Test
	public void test1() {
		MyInfo info = this.ctx.getBean("myInfo",MyInfo.class);
		MyInfo info1 = (MyInfo)this.ctx.getBean("myInfo");
		assertSame(info,info1);//singleton pattern
	}
	@Test
	public void test2() {
		MyInfo info = this.ctx.getBean("myInfo",MyInfo.class);
		assertEquals("한지민",info.getName());
	}

}
