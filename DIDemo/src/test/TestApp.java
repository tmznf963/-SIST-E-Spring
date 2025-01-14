package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.example.Hello;
import com.example.StringPrinter;

public class TestApp { // before -> test -> after
	private ApplicationContext ctx;
	@Before
	public void testBefore() {
		this.ctx = new GenericXmlApplicationContext("config/beans.xml");
	}
	@Test @Ignore
	public void testMethod() {
		assertNotNull(this.ctx);
	}
	@Test @Ignore
	public void testMethod1() {
		Hello hello = this.ctx.getBean("hello",Hello.class);
		Hello hello2 = (Hello)this.ctx.getBean("hello");
		assertSame(hello,hello2); //주소가 같은가? == Singleton pattern , JUnit == 단위테스트(부품테스트)
	}
	@Test
	public void testMethod2() {
		Hello hello = this.ctx.getBean("hello" , Hello.class);
		hello.print();
		StringPrinter printer = this.ctx.getBean("stringPrinter",StringPrinter.class);
		String message = printer.toString();
		assertEquals("Hello한지민", message);//문자열 비교
	}
}
