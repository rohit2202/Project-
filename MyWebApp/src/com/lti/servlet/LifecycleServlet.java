package com.lti.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LifecycleServlet
 */
@WebServlet("/LifecycleServlet")
public class LifecycleServlet extends HttpServlet {
	
	public void init() throws ServletException{
		System.out.println("in init");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in get ");
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
@Override
public void destroy() {
	// TODO Auto-generated method stub
	System.out.println("in destroy");
	super.destroy();
}

	
}
