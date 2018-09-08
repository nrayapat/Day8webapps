package com.capgemini.employeeapp.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.capgemini.employeeapp.dao.EmployeeDeo;
import com.capgemini.employeeapp.model.Employee;

/**
 * Servlet implementation class updateEmployee
 */
@WebServlet("/updateEmployee")
public class updateEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeeDeo employeeDao;
    private ServletContext context;
    
    public updateEmployee() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
    public void init(ServletConfig config) throws ServletException {
    	context=config.getServletContext();
    }

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int empid=Integer.parseInt(request.getParameter("empId"));
		String empName=request.getParameter("empName");
		double empSalary=Double.parseDouble(request.getParameter("empSalary"));
		String empDept=request.getParameter("empDept");
		
		employeeDao=(EmployeeDeo) context.getAttribute("employeeDao");
		employeeDao.updateEmployee(new Employee(empid,empName,empSalary,empDept));
		context.setAttribute("employeeDao", employeeDao);
		List<Employee> employeeList=new ArrayList<Employee>();
		employeeList=employeeDao.findAllEmployees();
		request.setAttribute("employeesList", employeeList);
		 RequestDispatcher dispatcher=request.getRequestDispatcher("displayAllEmployees.jsp");
		 dispatcher.forward(request, response);
		
	}

}
