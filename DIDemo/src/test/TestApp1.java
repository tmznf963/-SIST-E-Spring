package test;


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
import com.example.StringPrinter;

//spring-test-3.2.3
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:config/beans.xml")
public class TestApp1 { // RunWith  ContextConfiguration  Autowired
	
	@Autowired
	ApplicationContext ctx;
	
	@Test @Ignore
	public void testMethod() { //null 처리
		assertNotNull(this.ctx);
	}
	@Test @Ignore
	public void testMethod1() { //getBean 불러 오는 테스트
		Hello hello = this.ctx.getBean("hello",Hello.class);
		Hello hello2 = (Hello)this.ctx.getBean("hello");
		assertSame(hello,hello2); //주소가 같은가? == Singleton pattern , JUnit == 단위테스트(부품테스트)
	}
	@Test
	public void testMethod2() { //getBean 불러 오는 테스트
		Hello hello = this.ctx.getBean("hello" , Hello.class);
		hello.print();
		StringPrinter printer = this.ctx.getBean("stringPrinter",StringPrinter.class);
		String message = printer.toString();
		assertEquals("Hello한지민", message);//문자열 비교
	}
}
