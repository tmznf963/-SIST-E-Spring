package com.example;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		AbstractApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:applicationContext.xml","classpath:applicationContext1.xml");
		Student student1 = (Student)ctx.getBean("student1");
		System.out.println(student1);
		Student student2 = ctx.getBean("student2",Student.class);
		if(student1 == student2) System.out.println("Equals");
		else System.out.println("Different");
		
		Product product1 = (Product)ctx.getBean("product");
		Product product2 = ctx.getBean("product",Product.class);
		System.out.println(product1);
		if(product1 == product2) System.out.println("Equals");
		else System.out.println("Different");
						
																							
	}
}
