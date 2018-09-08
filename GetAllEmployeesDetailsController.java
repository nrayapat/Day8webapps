package com.capgemini.employeeapp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.capgemini.employeeapp.dao.EmployeeDeo;
import com.capgemini.employeeapp.model.Employee;


@WebServlet("/getAllEmployees")
public class GetAllEmployeesDetailsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private EmployeeDeo employeeDao;
       private ServletContext context;
  
       
       
       public GetAllEmployeesDetailsController() {
        super();
       
    }

       
       @Override
    public void init(ServletConfig config) throws ServletException {
    	context=config.getServletContext();
    }
       
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("html/text");
	
		employeeDao=(EmployeeDeo)context.getAttribute("employeeDao");
		List<Employee> employees=employeeDao.findAllEmployees();
		request.setAttribute("employeesList", employees);
		RequestDispatcher dispatcher=request.getRequestDispatcher("displayAllEmployees.jsp");
		dispatcher.forward(request, response);
		
		
		
	}

}
