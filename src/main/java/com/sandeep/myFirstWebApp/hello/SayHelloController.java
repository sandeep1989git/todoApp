package com.sandeep.myFirstWebApp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class SayHelloController {

	//http://localhost:8080/say-hello
	@RequestMapping("say-hello")
	@ResponseBody
	public String sayHello() {
		return "Hello World";
	}
	
	
	@RequestMapping("say-hello-jsp")
	
	public String sayHellojsp() {
		return "sayHello";
	}
}
