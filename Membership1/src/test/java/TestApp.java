import java.util.Scanner;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.service.UserService;
import com.example.vo.UserVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class TestApp {
	
	private Scanner scan;
	@Before
	public void init() {//메소드 첫 시작
		this.scan = new Scanner(System.in);
	}
	
	@Autowired
	UserService userService;
	
	@Test @Ignore
	public void test() {
		//INSERT
		System.out.println("Enter your userid : "); String userid = scan.next();
		System.out.println("Enter your name : "); String name = scan.next();
		System.out.println("Enter your gender : "); String gender = scan.next();
		System.out.println("Enter your city : "); String city = scan.next();
		
		UserVO userVO = new UserVO(userid, name, gender, city);
		this.userService.createUser(userVO);
	}
	
	@Test @Ignore
	public void test1() {
		//DELETE
		System.out.println("Enter Delete userid : "); 
		String userid = this.scan.next();
		this.userService.deleteUser(userid);
	}
	
	@Test @Ignore
	public void test2() {
		//UPDATE
		System.out.println("Enter Update userid : ");
		String userid = this.scan.next();
		System.out.println("Enter city name : ");
		String city = this.scan.next();
		
		this.userService.updateUser(userid, city);
	}
	
	@Test
	public void test3() {
		//SELECT ALL
		for(UserVO userVO : this.userService.selectAllUsers()) {
			System.out.println(userVO);
		}
	}
	
	@Test
	public void test4() {
		//SELECT Single
		System.out.println("Enter select userid : ");
		String userid = this.scan.next();
		UserVO userVO = this.userService.readUser(userid);
		System.out.println(userVO);
	}
}
