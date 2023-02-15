package com.sandeep.myFirstWebApp.login;

import org.springframework.stereotype.Service;

@Service
public class Autherisation {
	public boolean autherise(String username,String password) {
		
		boolean user=username.equalsIgnoreCase("hare");
		boolean pwd= password.equals("krishna");
		return user && pwd;
		
		
	}

}
