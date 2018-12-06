package com.example.vo;

public class Employee {
	private int id;
	private String first_name;
	private String last_name;
	private int salary;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public Employee() {}
	public Employee(String first_name, String last_name, int salary) {
		this.first_name = first_name;
		this.last_name = last_name;
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		return "EmployeeVO [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", salary=" + salary
				+ "]";
	}
	
}
