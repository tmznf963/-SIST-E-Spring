package com.example;

public class Hello {//참조 하는 애
	private String name;
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
