package com.capgemini.domain;

public class Employee {
	private String empID;
	private String name;
	private double salary;
	private String department;
	public Employee(String empID, String name, double salary, String department) {
		super();
		this.empID = empID;
		this.name = name;
		this.salary = salary;
		this.department = department;
	}
	public String getEmpID() {
		return empID;
	}
	public void setEmpID(String empID) {
		this.empID = empID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	

}


