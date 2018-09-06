package com.capgemini.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/CreditCard")
public class CreditCardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public CreditCardServlet() {
        super();
     
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		String cvv = request.getParameter("cvv");
		String expiryMonth = request.getParameter("expiryMonth");
		String expiryYear = request.getParameter("expiryYear");
		String cardNumber = request.getParameter("cardNumber");
		
		out.println("<head>"
				+ "<style>"
				+ "table, th, td {  border: 5px solid black; border-collapse:collapse;}"
				+ " th,td{ padding:10px; }"
				+ "</style></head>"
				+ "<body bgcolor = 'cyan'><table><tr><th>Name</th><th>Card Number</th><th>cvv</th><th>Valid Till</th></tr>");
		out.println("<tr><td>" + name + "</td><td>" +cardNumber + "</td><td>"
				+ cvv + "</td><td>" + expiryMonth + "/" + expiryYear + "</td></tr></table></body>");
	}

}
