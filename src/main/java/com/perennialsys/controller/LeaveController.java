package com.perennialsys.controller;

import com.perennialsys.entity.Leave;
import com.perennialsys.service.LeaveService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private static final Logger LOGGER = LoggerFactory.getLogger(LeaveController.class);

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
        LOGGER.info("Entering >>  leaveStatus()");
        List leaveRec = leaveService.leaveStatus();
        model.addAttribute("leaveRec", leaveRec);
        LOGGER.info("Returning >> leaveStatus()");
        return "LeaveStatus";
    }


    @PostMapping("/apply")
    public String applyNewLeave(Leave leave, BindingResult result, Model model) {
        LOGGER.info("Entering >> applyNewLeave()");
        leave.setStatus("PENDING");
        leaveService.createNewLeave(leave);
        LOGGER.info("Returning >> applyNewLeave()");
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
        LOGGER.info("Entering >> leaveApprove()");
        String leaveRec = leaveService.approveLeave(leaveId);
        LOGGER.info("Returning >> leaveApprove()");
        return "redirect:/leaves/status";

    }

    @GetMapping("/{leaveId}/reject")
    public String rejectLeave(@PathVariable int leaveId) {
        LOGGER.info("Entering >> leaveReject()");
        String leave = leaveService.rejectValue(leaveId);
        LOGGER.info("Returning from >> leaveReject()");
        return "redirect:/leaves/status";

    }


}


