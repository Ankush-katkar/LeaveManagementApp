package com.perennialsys.controller;

import com.perennialsys.entity.User;
import com.perennialsys.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * User related enpoints
 *
 * @author Ankush Katkar
 * @since 16-07-2021
 */
@Controller
@RequestMapping("/users")
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @GetMapping("/UserRegister")
    public String Employee(Model model) {
        model.addAttribute("userReg", new User());
        return "Registration";
    }

    @GetMapping("/Login")
    public String LoginScreen() {
        return "Login";
    }

    /**
     * This endpoint will register new user
     * * @param newUser
     *
     * @param redirectAttributes
     * @param result
     * @return
     */
    @PostMapping("/userRegister")
    public String registerNewUser(@ModelAttribute("userReg") User newUser, RedirectAttributes redirectAttributes, BindingResult result, Model model) {
        LOGGER.info("Entering >> registerNewUser()");


        User userSaved = userService.registerUser(newUser);
        if (Objects.isNull(userSaved)) {
            redirectAttributes.addFlashAttribute("message", "Failed");
            redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
            if (result.hasErrors()) {
                return "redirect:/users/UserRegister";
            }
            redirectAttributes.addFlashAttribute("message", "Your registration is successful");
            redirectAttributes.addFlashAttribute("alertClass", "alert-success");

        }
        LOGGER.info("returning >> registerNewUser()");
        return "redirect:/users/UserRegister";

    }

    @GetMapping("/")
    public String dashboard() {

        return "Dashboard";
    }
}
