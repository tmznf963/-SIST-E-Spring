package com.example;

import org.springframework.stereotype.Component;

@Component("consolePrinter") //id값 주기
public class ConsolePrinter implements Printer {
	@Override
	public void print(String message) {
		System.out.println(message);
	}

}
