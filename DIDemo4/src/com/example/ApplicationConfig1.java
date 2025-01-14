package com.example;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//어노테이션을 이용한 주입
@Configuration
public class ApplicationConfig1 {
	@Bean
	public Student student1() {
		ArrayList<String> hobbies = new ArrayList<String>(5);
		hobbies.add("독서"); hobbies.add("수예"); hobbies.add("바둑");
		Student student1 = new Student("한지민",24,hobbies);
		student1.setHeight(160.5); student1.setWeight(56.3);
		return student1;
	}
	@Bean
	public StudentInfo studentInfo() {
		ArrayList<String> hobbies = new ArrayList<String>(5);
		hobbies.add("등산");   hobbies.add("낚시");  
		Student student2 = new Student("이미자", 34, hobbies);
		student2.setHeight(170.5);  student2.setWeight(66.3);
		StudentInfo studentInfo = new StudentInfo();
		studentInfo.setStudent(student2);
		return studentInfo;
	}
}
