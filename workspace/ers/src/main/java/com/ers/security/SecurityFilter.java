package com.ers.security;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet for handling filters
 * @author bcant
 *
 */
public class SecurityFilter implements Filter {

	/**
	 * Filter method for sensitive data
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest httpReq = (HttpServletRequest) request;
		
		/*
		 * If User has logged in, let them through
		 */
		if( httpReq.getSession().getAttribute("userData") != null ){
			chain.doFilter(request, response);
		} else{
			HttpServletResponse httpResp = (HttpServletResponse) response;
			httpResp.sendError(403);
		}
	}

	@Override
	public void destroy() {
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

}
