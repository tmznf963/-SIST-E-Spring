package com.example.demo;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	String [] names = {"조용필", "이미자", "설운도"};
	int [] ages = {56, 60, 70};
	String [] addresses = {"서울특별시", "부산광역시", "대전광역시"};
	@RequestMapping("/{userid}")
	public StudentVO index(@PathVariable int userid) {
		return new StudentVO(userid, names[userid], ages[userid], addresses[userid]);
	}
}
