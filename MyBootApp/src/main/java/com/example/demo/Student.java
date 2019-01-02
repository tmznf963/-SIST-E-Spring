package com.example.demo;

public class Student {
	private int userid;
	private String name;
	private int age;
	private String address;
	
	public Student(int userid, String name, int age, String address) {
		this.userid = userid;
		this.name = name;
		this.age = age;
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "Student [userid=" + userid + ", name=" + name + ", age=" + age + ", address=" + address + "]";
	}
	
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
