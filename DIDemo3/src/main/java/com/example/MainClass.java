package com.example;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {		
//		Car car = new Sonata();
//		car.drive();
//		car = new HybridSonata();
//		car.drive();
		String configXml = "classpath:applicationContext.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configXml);
		Car car = ctx.getBean("sonata",Sonata.class);
		car.drive();
		ctx.close();
	}
}
