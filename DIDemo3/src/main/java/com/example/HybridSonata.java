package com.example;

public class HybridSonata extends Sonata implements Car{
	@Override
	public void drive() {
		System.out.println("I'm driving Hybird car with Sonata");
	}
}
