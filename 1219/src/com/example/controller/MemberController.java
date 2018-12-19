package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.service.MemberService;

@Controller
public class MemberController {
	@Autowired
	MemberService memberService;
	
}
