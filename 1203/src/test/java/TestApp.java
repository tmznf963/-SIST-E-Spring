import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.example.Student2;

public class TestApp {
	private ApplicationContext ctx;
	@Before
	public void init() {
		this.ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");
	}
	@Test
	public void test() {
		Student2 student = this.ctx.getBean("student2",Student2.class);
		Student2 student2 = (Student2)this.ctx.getBean("student2");
		System.out.println(student);
		System.out.println(student2);
		assertNotSame(student,student2);
	}

}
