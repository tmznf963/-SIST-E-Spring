package com.example.test;

import static org.junit.Assert.assertNotNull;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TestApp {
	private SqlSession sqlSession;
	
	@Test
	public void test() {
		String config = "classpath:applicationContext.xml";
		ApplicationContext ctx = new GenericXmlApplicationContext(config);
		this.sqlSession = ctx.getBean("sqlSession",SqlSession.class);
		assertNotNull(this.sqlSession);
	}

}

//DB 연결 확인 Test
