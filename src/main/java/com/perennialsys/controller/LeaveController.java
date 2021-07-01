package com.perennialsys.controller;

import com.perennialsys.entity.Leave;
import com.perennialsys.repository.LeaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LeaveController {

    @Autowired
    private LeaveRepository leaveRepository;

    @GetMapping(name="/leaveapply" )
    public String submitForm(Model model){
        model.addAttribute("leaveObj", new Leave());
        return "leave";
    }


    @PostMapping("/leaveapply")
    public String submitForm(@RequestBody Leave leave   ) {
        leave.setStatus("PENDING");

        leaveRepository.save(leave);
            return "Your leave request submitted successfully , Required ADMIN/LEAD Permission !";
        }

}


