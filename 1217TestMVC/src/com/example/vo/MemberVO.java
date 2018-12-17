package com.example.vo;

public class MemberVO {
	private String userid;
	private String name;
	private int age;
	private String gender;
	private String city;
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	@Override
	public String toString() {
		return "MemberVO [userid=" + userid + ", name=" + name + ", age=" + age + ", gender=" + gender + ", city="
				+ city + "]";
	}
	
}
