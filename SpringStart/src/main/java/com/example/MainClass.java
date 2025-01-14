package com.example;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		String configXml = "classpath:applicationContext.xml";
		 AbstractApplicationContext ctx = 
				 new GenericXmlApplicationContext(configXml);
		 //Proxy proxy = new Proxy();
		 Proxy proxy = ctx.getBean("proxy",Proxy.class);//xml이 setter해 준다.
		 proxy.addService();
		 proxy.subtractService();
		 proxy.multiplyService();
		 proxy.divideService();
		 
		 ctx.close();//xml 닫아주기
	}
}
