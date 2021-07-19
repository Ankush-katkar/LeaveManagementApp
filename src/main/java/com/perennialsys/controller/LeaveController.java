package com.perennialsys.controller;

import com.perennialsys.entity.Leave;
import com.perennialsys.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/leaves")
public class LeaveController {

    @Autowired
    private LeaveService leaveService;


    @GetMapping("/apply")
    public String submitForm(Model model) {
        System.out.println("i am here");
        model.addAttribute("leaveObj", new Leave());
        return "Leave";
    }

    @GetMapping("/status")
    public String leaveStatus(Model model) {

//        List leaveRec = leaveRepository.findAll();
//        model.addAttribute("leaveRec", leaveRec);
//        //  model.addAttributes("leaveRec");
//        System.out.println(leaveRec);
        return "LeaveStatus";
    }


    @PostMapping("/apply")
    public String applyNewLeave(Leave leave, BindingResult result, Model model) {
        leave.setStatus("PENDING");
        leaveService.createNewLeave(leave);
        return "redirect:/leaves/apply";
    }

    @GetMapping("/leave-balance")
    public String submitForm1() {
        return "LeaveBalance";
    }

    /*@PostMapping("/leave-balance")
    public String submitForm1(@ModelAttribute("lb") LeaveBalance lb) {

        LeaveBalance savedlb = leaveBalRepository.save(lb);
        return "redirect:leavebal";

    }*/

    @GetMapping("/{leaveId}/approve")
    public String approveLeave(@PathVariable Long leaveId) {
//        Leave leave = leaveRepository.findById(leaveId).get();
//        leave.setStatus("APPROVED");
//        leaveRepository.save(leave);
        return "redirect:/leavestatus";

    }

    @GetMapping("/{leaveId}/reject")
    public String rejectLeave(@PathVariable Long leaveId) {
//        Leave leave = leaveRepository.findById(leaveId).get();
//        leave.setStatus("REJECTED");
//        leaveRepository.save(leave);
        return "redirect:/leavestatus";

    }


}


