package com.perennialsys.controller;

import com.perennialsys.entity.LeaveBalance;
import com.perennialsys.entity.User;
import com.perennialsys.service.LeaveBalService;
import com.perennialsys.service.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Controller
@RequestMapping("/leavebal")
public class LeaveBalController {

    @Autowired
    private LeaveBalService leaveBalService;

    @GetMapping("/status")
    public String getLeaveBalance(Model model) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        // Object user = auth.getPrincipal();
        MyUserDetails user = (MyUserDetails) auth.getPrincipal();
        User userObj = user.getCurrentUser();
        int userId = userObj.getId();

       LeaveBalance leaveBalance = leaveBalService.getLeaveBalance(userId);

        model.addAttribute("leaveBalance",leaveBalance);
        return "LeaveBalanceDetails";
    }

}
