package com.example;

public class Student {
	private String name;
	private int age;
	private String phone;
	
	public Student(String name, int age, String phone) {
		this.name = name;
		this.age = age;
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", phone=" + phone + "]";
	}
	
}
