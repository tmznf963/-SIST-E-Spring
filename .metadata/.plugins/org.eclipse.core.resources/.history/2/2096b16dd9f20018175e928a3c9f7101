package com.example;

public class Proxy {
	private int firstNum, secondNum;
	private Calculator calc;
	
	public void setCalculator(Calculator calc) {
		this.calc = new Calculator();
	}
	public void setFirstNum(int firstNum) {
		this.firstNum = firstNum;
	}
	public void setSecondNum(int secondNum) {
		this.secondNum = secondNum;
	}
	public void addService() {
		this.calc.add(this.firstNum, this.secondNum);
	}
	public void subtractService() {
		this.calc.subtract(this.firstNum, this.secondNum);
	}
	public void multiplyService() {
		this.calc.multiply(this.firstNum, this.secondNum);
	}
	public void divideService() {
		this.calc.divide(this.firstNum, this.secondNum);
	}
}
