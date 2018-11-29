package com.example;

import java.util.List;

public class Hello {
	private List<String> names;
	private Printer printer;


	public List<String> getNames() {
		return names;
	}

	public void setNames(List<String> names) {
		this.names = names;
	}

	public void setPrinter(Printer printer) {
		this.printer = printer;
	}

//	public String sayHello() {
//		return "Hello " + names;
//	}
//
//	public void print() {
//		this.printer.print(sayHello());
//	}
}
