package com.example;

import org.springframework.stereotype.Component;

//<bean id="stringPrinter" class="com.example.StringPrinter"></bean>
@Component("stringPrinter")
public class StringPrinter implements Printer {
	private StringBuffer buffer = new StringBuffer();

	@Override
	public void print(String message) {
		this.buffer.append(message);
	}

	public String toString() {
		return this.buffer.toString();
	}

}
