package com.capgemini.employeeapp.dao;

import java.util.List;

import com.capgemini.employeeapp.model.Employee;

public interface EmployeeDeo {
	public List<Employee> findAllEmployees();
	public Employee findEmployeeById(int employeeId);
	public boolean deleteEmployee(int employeeid);
	public boolean addEmployee(Employee employee);
	public Employee updateEmployee(Employee employee);
	
}
