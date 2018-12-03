package com.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

@Configuration
public class ApplicationConfig {
	@Value("${admin.id}")
	private String adminId;
	@Value("${admin.pwd}")
	private String adminPasswd;
	@Value("${sub.admin.id}")
	private String subAdminId;
	@Value("${sub.admin.pwd}")
	private String subAdminPasswd;

	@Bean
	public static PropertySourcesPlaceholderConfigurer Properties() {
		PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
		Resource resource =  new ClassPathResource("primary.properties");
		Resource resource1 = new ClassPathResource("secondary.properties");
		Resource[] array= new Resource[2];
		array[0] = resource;
		array[1] = resource1;
		configurer.setLocations(array);
		return configurer;
	}

	@Bean
	public AdminConnection1 adminConnection1() {
		AdminConnection1 adminConnection1 = new AdminConnection1();
		adminConnection1.setAdminId(adminId);
		adminConnection1.setAdminPasswd(adminPasswd);
		adminConnection1.setSubAdminId(subAdminId);
		adminConnection1.setSubAdminPasswd(subAdminPasswd);
		return adminConnection1;
	}
}
