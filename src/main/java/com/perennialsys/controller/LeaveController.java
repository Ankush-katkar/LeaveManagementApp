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

import java.util.List;

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
    public String  leaveStatus(Leave leave ,Model model) {
        List leaveRec = leaveService.leaveStatus();
        model.addAttribute("leaveRec", leaveRec);
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
    public String approveLeave(@PathVariable int leaveId, Model model) {
        String leaveRec = leaveService.approveLeave(leaveId);

        return "redirect:/leaves/status";

    }

    @GetMapping("/{leaveId}/reject")
    public String rejectLeave(@PathVariable int leaveId) {
        String leave = leaveService.rejectValue(leaveId);

        return "redirect:/leaves/status";

    }


}


