package com.sandeep.myFirstWebApp.login;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

//import ch.qos.logback.classic.Logger;

@Controller
@SessionAttributes("name")
public class WelcomeController {
	
	@RequestMapping(value="/")
	public String showWelcomePage(ModelMap model) {
		model.put("name",getLogggedIn());
		return "welcome";
	}
	public String getLogggedIn() {
		return SecurityContextHolder.getContext().getAuthentication().getName();
	   }
	
	/*
	 * @RequestMapping(value="login",method = RequestMethod.POST) public String
	 * welcomePage(@RequestParam String name,
	 * 
	 * @RequestParam String password, ModelMap model) { model.put("name", name);
	 * model.put("errormessage", "Wrong Password. Enter right password ");
	 * 
	 * if(autherisation.autherise(name, password)) return "welcome"; else {
	 * //model.put("errormessage", "Wrong Password. Enter right password "); return
	 * "login"; } }
	 */
}
