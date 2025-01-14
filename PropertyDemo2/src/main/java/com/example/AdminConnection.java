package com.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("adminConnection")
public class AdminConnection {
	@Value("${admin.id}")
	private String adminId;
	@Value("${admin.pwd}")
	private String adminPasswd;
	@Value("${sub.admin.id}")
	private String subAdminId;
	@Value("${sub.admin.pwd}")
	private String subAdminPasswd;
	
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	public String getAdminPasswd() {
		return adminPasswd;
	}
	public void setAdminPasswd(String adminPasswd) {
		this.adminPasswd = adminPasswd;
	}
	public String getSubAdminId() {
		return subAdminId;
	}
	public void setSubAdminId(String subAdminId) {
		this.subAdminId = subAdminId;
	}
	public String getSubAdminPasswd() {
		return subAdminPasswd;
	}
	public void setSubAdminPasswd(String subAdminPasswd) {
		this.subAdminPasswd = subAdminPasswd;
	}
	
	@Override
	public String toString() {
		return "AdminConnection [adminId=" + adminId + ", adminPasswd=" + adminPasswd + ", subAdminId=" + subAdminId
				+ ", subAdminPasswd=" + subAdminPasswd + "]";
	}
	
}
