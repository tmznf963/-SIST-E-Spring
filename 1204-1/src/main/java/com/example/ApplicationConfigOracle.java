package com.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("oracle")
public class ApplicationConfigOracle {
	@Bean
	public ServerInfo serverInfo() {
		ServerInfo info = new ServerInfo();
		info.setDriverClass("oracle.jdbc.driver.OracleDriver");
		info.setUrl("jdbc:oracle:@192.168.56.4:1521:orcl");
		info.setUser("SCOTT");
		info.setPassword("TIGER");
		return info;
	}
}
