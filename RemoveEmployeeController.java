package com.capgemini.employeeapp.controller;

import java.io.IOException;
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


@WebServlet("/removeEmployee")
public class RemoveEmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private EmployeeDeo employeeDao;
     private ServletContext context;
   
    public RemoveEmployeeController() {
        super();
     
    }
    
    @Override
    public void init(ServletConfig config) throws ServletException {
    	context=config.getServletContext();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("html/text");
		String empid=request.getParameter("id");
		int empId=Integer.parseInt(empid);
		employeeDao=(EmployeeDeo)context.getAttribute("employeeDao");
		RequestDispatcher dispatcher;
		
		if(employeeDao.deleteEmployee(empId))
		{
//			List<Employee> employees=employeeDao.findAllEmployees();
			request.setAttribute("employeesList", employeeDao.findAllEmployees());
			dispatcher=request.getRequestDispatcher("displayAllEmployees.jsp");
//			response.sendRedirect("getAllEmployees");
			dispatcher.forward(request, response);
		}
		else
		{
			dispatcher = request.getRequestDispatcher("error.jsp");
			dispatcher.forward(request, response);
		}
	}

}
