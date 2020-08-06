package com.lti.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet//
 */
@WebServlet("/shitisreal.exe")
public class HelloServlet extends HttpServlet {

	protected void doPostt(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.write("<html><body>");
		//I added a comment
		out.write("<h1>Who is beter</h1>");
		out.write("<h1>Who is beter</h1>");
		out.write("<h2>Moosewalla is better than Karan Aujla</h2>");
		out.write("</body></html>");
	}


	

}
 