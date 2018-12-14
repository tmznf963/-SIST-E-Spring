package com.example.biz;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class TestApp {
	private ApplicationContext ctx;
	
	@Before
	public void init() {
		this.ctx = new GenericXmlApplicationContext("file:src/main/webapp/WEB-INF/spring**/root-context.xml");
	}
	@Test
	public void test() {
		JdbcTemplate jdbcTemplate = this.ctx.getBean("jdbcTemplate", JdbcTemplate.class);
		System.out.println(jdbcTemplate);
	}

}
