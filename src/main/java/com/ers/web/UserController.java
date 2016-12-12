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

class UserController {

	public void doAll( HttpServletRequest request, HttpServletResponse response )throws ServletException, IOException {
		String username = request.getParameter( "username" );
		String password = request.getParameter( "password" );
		try {
			User userSession = new BusinessDelegate().login( username, password );
			ArrayList<Reimbursement> reimbSession = new BusinessDelegate().getAll();
			request.getSession().setAttribute( "userData", userSession );
			request.getSession().setAttribute( "reimbData", reimbSession );
			request.getRequestDispatcher( "/WEB-INF/pages/HomePage.jsp").forward(request, response );
		} catch ( AuthenticationException e ) {
			request.setAttribute( "invalid", "Invalid username and/or password. Please try again." );
			request.getRequestDispatcher( "LoginPage.jsp" ).forward( request, response );
		}
	}
}
