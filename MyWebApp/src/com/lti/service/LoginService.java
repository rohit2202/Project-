package com.lti.service;

import java.util.HashMap;

public class LoginService {
	
	private HashMap<String, String> users = new HashMap<String, String>();
	/*public LoginService() {
		users.put("rohit", "123");
		users.put("john", "321");
		users.put("hello", "123");
		}*/
	public boolean authenticate(String username, String password) {
		// TODO Auto-generated method stub
		if(users.containsKey(username)) {
			if(users.get(username).equals("password"))
					return true;
			else return false;
			
			//return true;
		}
		else 
			return false;
			
		
	}

	
}
