package com.ers.error;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Serlvet for error handling
 * @author bcant
 *
 */
@SuppressWarnings("serial")
public class ErrorServlet extends HttpServlet{
	
	/**
	 * Post Mehtod for Serlvet
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Exception e = (Exception)
				request.getAttribute("javax.servlet.error.exception");
		int statusCode = (Integer) 
				request.getAttribute("javax.servlet.error.status_code");
		
		/*
		 * Conditions for handling different errors and exceptions 
		 */
		if(e != null || e instanceof IllegalArgumentException){
			System.out.println(e.getMessage());
			response.sendRedirect("http://wallpapercave.com/wp/r3BPFdb.jpg");
		}else if (statusCode == 404){
			response.sendRedirect("http://localhost:7001/ers/404.jsp");
		}else if(statusCode == 403){
			response.sendRedirect("http://localhost:7001/ers/403.jsp");
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
}
