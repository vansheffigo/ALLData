package com.in28minutes.springboot.mysampleproject.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {

	@RequestMapping("say-hello")
	@ResponseBody
	public String sayHello() {
		return "Hello!What are you learning today?";
	}

	@RequestMapping("say-hello-html")
	@ResponseBody
	public String sayHelloHtml() {
		StringBuffer sb = new StringBuffer();
		sb.append("<html>");
		sb.append("<head>");
		sb.append("<title>");
		sb.append("Homecomming");
		sb.append("</title>");
		sb.append("</head>");
		sb.append("<body>");
		sb.append("hello World");
		sb.append("</body>");
		sb.append("</html>");
		return sb.toString();
	}

	// say-hello.jsp
	@RequestMapping("say-hello-jsp")
	public String sayHelloJsp() {
		return "sayhello";
	}
}
