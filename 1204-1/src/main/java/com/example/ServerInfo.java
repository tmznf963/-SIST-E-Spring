package com.example;

public class ServerInfo {
	private String driverClass;
	private String url;
	private String user;
	private String password;
	
	public String getDriverClass() {
		return driverClass;
	}
	public void setDriverClass(String driverClass) {
		this.driverClass = driverClass;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "ServerInfo [driverClass=" + driverClass + ", url=" + url + ", user=" + user + ", password=" + password
				+ "]";
	}
	
}
