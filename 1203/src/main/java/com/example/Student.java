package com.example;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Student implements InitializingBean, DisposableBean{
	private String name;
	private int age;
	
	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}

	@Override
	public void destroy() throws Exception {//bean이 소멸될 때
		System.out.println("Called destroy()");
	}

	@Override
	public void afterPropertiesSet() throws Exception {//bean이 생성될 때 호출
		System.out.println("Called afterPropertiesSet()");
	}
}
