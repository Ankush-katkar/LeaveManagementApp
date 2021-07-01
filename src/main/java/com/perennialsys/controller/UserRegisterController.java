package com.perennialsys.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.perennialsys.entity.User;
import com.perennialsys.service.UserService;

@Controller
public class UserRegisterController { 
	private static final Logger logger = LoggerFactory.getLogger(UserRegisterController.class);

	
	
	@Autowired
	UserService userService;
	
	@GetMapping("/UserRegister")
	public String Employee(Model model) {
	//logger.info("ankush ");
	//logger.warn("this is warning message");
	//logger.error("error message ");
	//logger.debug("debug message");
	//logger.trace("trace level");
	//System.out.println(10/0);
		model.addAttribute("userReg", new User());
		
		return "Registration";
	}
	@GetMapping("/Login")
	public String LoginScreen() {

		
		return "Login";
	}
	
	@PostMapping("/UserRegister")
	public String User(@ModelAttribute("userReg") User user, RedirectAttributes redirectAttributes, BindingResult result) {


	boolean userSaved=	userService.SaveUser(user);
		logger.trace("A TRACE Message");
	if (userSaved) {
		redirectAttributes.addFlashAttribute("message", "Failed");
		redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
		if (result.hasErrors()) {
			return "redirect:/UserRegister";
		}
		redirectAttributes.addFlashAttribute("message", "Your registration is successful");
		redirectAttributes.addFlashAttribute("alertClass", "alert-success");

	}
	return "redirect:/UserRegister";
		
	}
	
	@GetMapping("/")
	public String dashboard() {
		
		return "dashboard";
	}

}
