package com.example;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

public class AdminConnection implements EnvironmentAware, InitializingBean, DisposableBean{
	private Environment env;
	private String adminId;
	private String adminPasswd;
	
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

	@Override
	public void destroy() throws Exception {
		System.out.println("Called destroy()");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Called afterPropertiesSet");
		this.setAdminId(this.env.getProperty("admin.id"));
		this.setAdminPasswd(this.env.getProperty("admin.passwd"));
	}

	public void setEnv(Environment env) {
		this.env = env;
	}

	@Override
	public void setEnvironment(Environment environment) {
		System.out.println("Called setEnvironment()");
		this.setEnv(environment);
	}
	
}
