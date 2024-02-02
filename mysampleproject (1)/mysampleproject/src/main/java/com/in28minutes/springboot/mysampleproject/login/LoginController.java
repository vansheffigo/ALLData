package com.in28minutes.springboot.mysampleproject.login;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
//import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class LoginController {
//	private Logger logger =LoggerFactory.getLogger(getClass());

	// localhost:8080/login?name=ranga

	private AuthenticationService authenticationService;

	public LoginController(AuthenticationService authenticationService) {
		super();
		this.authenticationService = authenticationService;
	}

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String gotoLoginPage() {

		return "login";
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String gotoWelcomePage(@RequestParam String name, @RequestParam String password, ModelMap model) {
		if (authenticationService.authenticate(name, password)) {
			model.put("name", name);

			return "Welcome";
		}

		model.put("ErrorMessage", "INvalid credentails");
		return "login";
	}

	// Model-> anything that you want to pass through controller to jsp is through
	// model
//	public String gotoLoginPage(@RequestParam String name,ModelMap model ) {
//		model.put("name", name);
//		logger.debug("Request param is {}",name);
//		logger.info("Printing at Info level");
//		logger.warn("Printing at warn level");
//		//sysout  not used for production code
//		return "login";
//	}
}
