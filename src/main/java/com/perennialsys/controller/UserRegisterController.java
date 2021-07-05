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
//	private static final Logger logger = LoggerFactory.getLogger(UserRegisterController.class);

	

	@GetMapping("/")
	public String dashboard() {
		
		return "dashboard";
	}

}
