package com.perennialsys.controller;

import com.perennialsys.entity.User;
import com.perennialsys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Objects;

@Controller
public class RegisterUserController {

    @Autowired
    UserService userService;

    @GetMapping("/UserRegister")
    public String Employee(Model model) {

        model.addAttribute("userReg", new User());

        return "Registration";
    }

    @GetMapping("/Login")
    public String LoginScreen() {


        return "Login";
    }

    @PostMapping("/UserRegister")
    public String User111(@ModelAttribute("userReg") User newUser, RedirectAttributes redirectAttributes, BindingResult result) {


        User userSaved = userService.registerUser(newUser);
        //logger.trace("A TRACE Message");
        if (Objects.isNull(userSaved)) {
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

}
