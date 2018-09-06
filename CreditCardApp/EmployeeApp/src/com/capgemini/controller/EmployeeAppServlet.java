package com.capgemini.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.capgemini.domain.Employee;

/**
 * Servlet implementation class EmployeesServlet
 */
@WebServlet("/employee")
public class EmployeeAppServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArrayList<Employee> employee = new ArrayList<>();
	ServletContext context;
	Employee emp1;
	Employee emp2;
	Employee emp3;
	Employee emp4;
	Employee emp5;

	public void init(ServletConfig config) throws ServletException {
		context = config.getServletContext();
		
		employee.add(emp1 = new Employee("567fr","Nikki",25000,"IT"));
		employee.add(emp2 = new Employee("876dr","Akhil",35000,"AI"));
		employee.add(emp3 = new Employee("678@1","Nik",45000,"Software"));
		employee.add(emp4 = new Employee("16@GF","N",55000,"Analyst"));
		employee.add(emp5 = new Employee("456ef","Nikhil",65000,"IT"));
	}

	public EmployeeAppServlet() {
		super();
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text.html");
		PrintWriter out = response.getWriter();
		String empID = request.getParameter("empID");
		boolean fl=false;
		for(Employee employ: employee) {
			
			if(employ.getEmpID().equals(empID)) {
				fl=true;
				out.println("<p>EmpId= "+employ.getEmpID()+"<br><br>"+"Name= "+employ.getName()+"<br><br>"+"Salary="+employ.getSalary()+"<br><br>"+"Department"+employ.getDepartment()+"</p>");
				
			}
			
		}
		if(fl);
		else {
			out.println("Employee ID not found");
		}
		out.close();
		

	}

}



