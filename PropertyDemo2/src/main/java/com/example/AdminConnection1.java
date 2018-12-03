package com.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


public class AdminConnection1 {
	private String adminId;
	private String adminPasswd;
	private String subAdminId;
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
