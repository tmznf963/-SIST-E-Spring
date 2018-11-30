package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//<bean id="hello" class="com.example.Hello">
@Component("hello")
public class Hello {//���� �ϴ� ��
	@Value("한지민") //<property name="name" value="한지민"/>
	private String name;
	
	@Autowired
	@Qualifier("stringPrinter")  //<property name="printer"><ref bean="stringPrinter"/></property>
	private Printer printer;
	
	public String sayHello() {
		return "Hello " + name;
	}
	public void print() {
		this.printer.print(sayHello());
	}
	
}
