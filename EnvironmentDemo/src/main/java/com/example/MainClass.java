package com.example;

import java.io.IOException;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.io.support.ResourcePropertySource;

public class MainClass {
	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = new GenericXmlApplicationContext();
		ConfigurableEnvironment env = ctx.getEnvironment();
		
		MutablePropertySources propertySouces = env.getPropertySources();
		//내가 원하는 정보를 얻을 때까지 모든 propertySources를 앞에서 부터 차례로 모두 검색함.
		try{
			propertySouces.addLast(new ResourcePropertySource("classpath:admin.properties"));
			//property 추가
			System.out.println(env.getProperty("admin.id")); //property 추출
			System.out.println(env.getProperty("admin.passwd"));
		}catch(IOException ex){}
		
		GenericXmlApplicationContext gCtx = (GenericXmlApplicationContext)ctx;
		gCtx.load("classpath:applicationContext.xml");
		gCtx.refresh();
		
		AdminConnection adminConnection = gCtx.getBean("adminConnection",
				AdminConnection.class);
		System.out.println("admin ID : " + adminConnection.getAdminId());
		System.out.println("admin PWD : " + adminConnection.getAdminPasswd());
		
		gCtx.close();
		ctx.close();
	}
}
