package com.example;

import java.util.ArrayList;

public class Student {
	private String name;
	private int age;
	private ArrayList<String> hobbies;
	private double height;
	private double weight;
	
	public Student(String name, int age, ArrayList<String> hobbies) {
		super();
		this.name = name;
		this.age = age;
		this.hobbies = hobbies;
	}

	public void setHeight(double height) {
		this.height = height;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", hobbies=" + hobbies + ", height=" + height + ", weight="
				+ weight + "]";
	}
	
}
