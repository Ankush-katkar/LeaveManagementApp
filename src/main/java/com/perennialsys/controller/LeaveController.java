package com.perennialsys.controller;

import com.perennialsys.entity.Leave;
import com.perennialsys.repository.LeaveRepository;
//import com.perennialsys.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LeaveController {

    @Autowired
    LeaveRepository leaveRepository;

    @GetMapping("/leave" )
    public String submitForm(Model model){
        System.out.println("i am here");
        model.addAttribute("leaveObj", new Leave());
        return "leave";
    }


    @PostMapping("/apply")
    public String addStudent(@ModelAttribute("leaveObj")  Leave leave, BindingResult result, Model model) {
leave.setStatus("PENDING");

        Leave savedLeave = leaveRepository.save(leave);
        return "redirect:dashboard";
    }
   /* @PostMapping("/apply")
    public String submitForm(@ModelAttribute("leaveObj") Leave leave) {

    System.out.println(leave);
//leave.setStatus("PENDING");
        Leave saved =leaveRepository.save(leave);
        return "saved";

    }*/

}


