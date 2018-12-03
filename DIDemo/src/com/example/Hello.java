package com.example;

public class Hello {
	private String name; //property는 setter를 이용해 값이 받아진다.
	private Printer printer;
	
	public Hello() {}//Default Constructor

	public void setName(String name) {
		this.name = name;
	}
	public void setPrinter(Printer printer) {
		this.printer = printer;
	}
	public String sayHello() {
		return "Hello" + name;
	}
	public void print() {
		this.printer.print(sayHello());
	}
	
}
