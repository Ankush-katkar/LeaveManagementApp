package com.perennialsys.controller;

import com.perennialsys.entity.Leave;
import com.perennialsys.entity.LeaveBalance;
import com.perennialsys.repository.LeaveRepository;
//import com.perennialsys.service.LeaveService;
import org.apache.logging.log4j.spi.LoggerContextKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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

    @GetMapping("/leavestatus")
    public String leaveStatus(Model model){

        List leaveRec = leaveRepository.findAll();
        model.addAttribute("leaveRec",leaveRec);
      //  model.addAttributes("leaveRec");
     System.out.println(leaveRec);
        return "leavestatus";
    }


    @PostMapping("/apply")
    public String addStudent(@ModelAttribute("leaveObj")  Leave leave, BindingResult result, Model model) {
leave.setStatus("PENDING");

        Leave savedLeave = leaveRepository.save(leave);
        return "redirect:leave";
    }

    @GetMapping("/leavebal")
    public String submitForm1(){

        return "leavebal";
    }
    @PostMapping("/leavebal")
    public String submitForm1(@ModelAttribute("lb") LeaveBalance lb) {

        LeaveBalance savedlb =leaveRepository.saveBal(lb);
        return "saved";

    }

    @GetMapping("/approveLeave/{leaveId}")
       public String approveLeave(@PathVariable Long leaveId){
        Leave leave = leaveRepository.findById(leaveId).get();
        leave.setStatus("APPROVED");
        leaveRepository.save(leave);
        return "redirect:/leavestatus";

       }

    @GetMapping("/rejectLeave/{leaveId}")
    public String rejectLeave(@PathVariable Long leaveId){
        Leave leave = leaveRepository.findById(leaveId).get();
        leave.setStatus("REJECTED");
        leaveRepository.save(leave);
        return "redirect:/leavestatus";

    }

}


