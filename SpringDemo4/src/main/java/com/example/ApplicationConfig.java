package com.example;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath:applicationContext.xml")//어노테이션에서 xml을 사용하기 위한 추가
public class ApplicationConfig {
	@Bean
	public Student student1() {
		ArrayList<String> hobbies = new ArrayList<String>(5);
		hobbies.add("독서"); hobbies.add("수예"); hobbies.add("바둑");
		Student student1 = new Student("한지민",24,hobbies);
		student1.setHeight(160.5); student1.setWeight(56.3);
		return student1;
	}
}
