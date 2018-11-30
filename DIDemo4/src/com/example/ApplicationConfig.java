package com.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//어노테이션을 이용한 주입
@Configuration
public class ApplicationConfig {
	// <bean id="sonata" class="com.example.Sonata" />

	@Bean
	public Sonata sonata() {
		Sonata sonata = new Sonata();
		return sonata;
	}

	@Bean
	public Carnival carnival() {
		Carnival carnival = new Carnival();
		return carnival;
	}
}
