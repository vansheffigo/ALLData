package com.springboot.Restapi.helloworld;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@Controller when creating web application we want to map to view so we use controller but when we return the object  as it is then rest controller
@RestController
public class HelloWorldResource {

	@RequestMapping("/hello-world")
	public String helloWorld() {
		return "Hello World";
	}
	// Path Variable or Path params

	@RequestMapping("/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello World");
	}

	@RequestMapping("/hello-world-path-param/{name}")
	public HelloWorldBean helloWorldPathParam(@PathVariable String name) {
		return new HelloWorldBean("Hello World" + name);
	}

	@RequestMapping("/hello-world-path-param/{name}/message/{message}")
	public HelloWorldBean helloWorldMultiplePathParam(@PathVariable String name, @PathVariable String message) {
		return new HelloWorldBean("Hello World" + name + "," + message);
	}
}
