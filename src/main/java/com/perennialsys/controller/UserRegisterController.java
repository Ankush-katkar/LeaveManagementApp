package com.perennialsys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserRegisterController {
//	private static final Logger logger = LoggerFactory.getLogger(UserRegisterController.class);


    @GetMapping("/")
    public String dashboard() {

        return "dashboard";
    }

}
