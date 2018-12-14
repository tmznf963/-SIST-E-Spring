package com.example.vo;

public class MemberVO {
	private String userid;
	private String username;
	private int userage;
	private String gender;
	private String city;
	
	public MemberVO() {}
	public MemberVO(String userid, String username, int userage, String gender, String city) {
		this.userid = userid;
		this.username = username;
		this.userage = userage;
		this.gender = gender;
		this.city = city;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getUserage() {
		return userage;
	}
	public void setUserage(int userage) {
		this.userage = userage;
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
		return "MemberVO [userid=" + userid + ", username=" + username + ", userage=" + userage + ", gender=" + gender
				+ ", city=" + city + "]";
	}
}
