package com.example;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//Maven --> update project

//@RunWith(SpringJUnit4ClassRunner.class)
public class TestApp {
//@Autowired 사용 못함
	private AnnotationConfigApplicationContext ctx;
	
	@Before
	public void init() {
		this.ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);
	}
	@Test
	public void test() {
		assertNotNull(this.ctx);
	}
	@Test
	public void test1() {
		Student student1 = (Student)this.ctx.getBean("student1");
		System.out.println(student1);
		Student student2 = this.ctx.getBean("student2",Student.class);
		System.out.println(student2);
		assertNotSame(student1,student2);
	}

}
