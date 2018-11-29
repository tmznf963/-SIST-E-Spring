package com.example;

import java.util.List;

public class Hello {
	private String name;
	private Printer printer;


	public Hello(String name, Printer printer) {
		this.name = name;
		this.printer = printer;
	}

	public String sayHello() {
		return "Hello " + name;
	}

	public void print() {
		this.printer.print(sayHello());
	}
}
