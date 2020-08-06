package com.lti.servlet;

import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.SendResult;
import java.util.*;
import com.lti.service.DatabaseLoginService;
import com.lti.service.LoginService;

//--WRITE A AJAVASCRIPT CODE FUNCTIONWHIHC WILL BE CALLED BY ONLOAD EVENT INSIDE A FUNCTION READ THE COOKIES THAT ARE CREATED IF COOKIES ARE PRESENT THAN REDIRECT TO WELCOME PAGE.
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("uname");
		String password = request.getParameter("pwd");
			
		//LoginService loginservice = new LoginService() ;
		//boolean isValid = loginservice.authenticate(username, password);
		DatabaseLoginService databaseloginservice = new DatabaseLoginService();
		boolean isValid = databaseloginservice.authenticate(username, password);
		
		if(isValid) {
			
			String rememberme = request.getParameter("reme");
			if(rememberme!= null) {
				Cookie c1 = new Cookie("username", username);
				c1.setMaxAge(60*60);
				String basicBase64format = Base64.getEncoder().encodeToString(password.getBytes()); // Base64 encoding for password import java.util
				Cookie c2 = new Cookie("passwordd", basicBase64format);
				c2.setMaxAge(60*60);
				response.addCookie(c1);
				response.addCookie(c2);
			}
			response.sendRedirect("home1.html");
		}
		else {
			response.sendRedirect("login.html");
		}
		
	}


}
