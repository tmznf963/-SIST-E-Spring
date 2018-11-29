package com.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class SpringBeanJunitSpringTest {
	@Autowired
	private ApplicationContext ctx;
	
	
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
