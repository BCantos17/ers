package com.ers.web;

import java.io.IOException;
import java.util.ArrayList;

import javax.naming.AuthenticationException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ers.bean.Reimbursement;
import com.ers.bean.User;
import com.ers.middle.BusinessDelegate;

/**
 * Controller for handling login and logout features for the user
 * @author bcant
 *
 */
class UserController {

	/**
	 * Grabs the username and password the User inputted on the page 
	 * and matches them to the username and password to the database
	 * Passes an exception if not found
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void doLogin( HttpServletRequest request, HttpServletResponse response )throws ServletException, IOException {
		String username = request.getParameter( "username" );
		String password = request.getParameter( "password" );
		//String has = BCrypt.hashpw();
		try {
			User userSession = new BusinessDelegate().login( username, password );
			ArrayList<Reimbursement> reimb = new BusinessDelegate().getAll();
			request.getSession().setAttribute( "userData", userSession );
			request.getSession().setAttribute( "reimbData", reimb );
			request.getRequestDispatcher( "/WEB-INF/pages/HomePage.jsp").forward(request, response );
		} catch ( AuthenticationException e ) {
			request.setAttribute( "invalid", "Invalid username and/or password. Please try again." );
			request.getRequestDispatcher( "LoginPage.jsp" ).forward( request, response );
		}
	}
	
	/**
	 * Destroys session when user logs out
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void doLogout( HttpServletRequest request, HttpServletResponse response )throws ServletException, IOException {
		request.getSession().invalidate();
		response.sendRedirect( "http://localhost:7001/ers/LoginPage.jsp" );
		return;
	}
}
