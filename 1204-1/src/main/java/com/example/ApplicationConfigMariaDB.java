package com.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("mariadb")
public class ApplicationConfigMariaDB {
	@Bean
	public ServerInfo serverInfo() {
		ServerInfo info = new ServerInfo();
		info.setDriverClass("org.mariadb.jdbc.Driver");
		info.setUrl("org.mariadb://192.168.56.4:3306/world");
		info.setUser("root");
		info.setPassword("root");
		return info;
	}
}
