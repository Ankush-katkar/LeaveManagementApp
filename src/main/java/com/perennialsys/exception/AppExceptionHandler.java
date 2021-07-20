package com.perennialsys.exception;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@ControllerAdvice
public class AppExceptionHandler {

@ExceptionHandler(value=InSufficientLeaveBalance.class)
public String handleInsufficientBalException(){

    return "/403";

}

}
