package com.capgemini.employeeapp.controller;

import java.io.IOException;

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


@WebServlet("/editEmployee")
public class EditEmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private EmployeeDeo employeeDao;
     private ServletContext context;
    
    public EditEmployeeController() {
        super();
        
    }
    
    @Override
    public void init(ServletConfig config) throws ServletException {
    	context=config.getServletContext();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
		response.setContentType("text/html");
		RequestDispatcher dispatcher= null;
		String id=request.getParameter("id");
		employeeDao=(EmployeeDeo)context.getAttribute("employeeDao");
	System.out.println(id);
		Employee employee=employeeDao.findEmployeeById(Integer.parseInt(id));
		context.setAttribute("employee", employee);
		dispatcher=request.getRequestDispatcher("editEmployee.jsp");
		dispatcher.forward(request, response);
	}
	
	/*
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		
		
		int empid=Integer.parseInt(req.getParameter("empId"));
		String empName=req.getParameter("empName");
		double empSalary=Double.parseDouble(req.getParameter("empSalary"));
		String empDept=req.getParameter("empDept");
		
		
		Employee employee=new Employee(empid,empName,empSalary,empDept);
		context.setAttribute("employeeDao", employeeDao);
		RequestDispatcher dispatcher= null;
		if(employeeDao.updateEmployee(employee)!=null)
		{
			resp.sendRedirect("getAllEmployees");
		}
		else
		{
			dispatcher = req.getRequestDispatcher("error.jsp");
			dispatcher.forward(req, resp);
		}
	}*/

}
