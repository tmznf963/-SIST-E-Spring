package com.example;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Student2{
	private String name;
	private int age;
	
	public Student2(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}

	@PreDestroy
	public void destroyMethod() throws Exception {//bean이 소멸될 때
		System.out.println("Called destroyMethod()");
	}

	@PostConstruct
	public void initMethod() throws Exception {//bean이 생성될 때 호출
		System.out.println("Called initMethod()");
	}
}
