package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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
public class TestApp {
	@Autowired
	private ApplicationContext ctx;
	
	@Test
	public void test() {
		assertNotNull(this.ctx);
	}
	@Test
	public void test1() {
		Hello hello = this.ctx.getBean("hello", Hello.class);
		hello.print();
		Printer printer = this.ctx.getBean("stringPrinter", StringPrinter.class);
		assertEquals("Hello 한지민", printer.toString());
	}
}
