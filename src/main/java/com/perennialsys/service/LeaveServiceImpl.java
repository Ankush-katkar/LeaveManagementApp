package com.perennialsys.service;

import com.perennialsys.entity.Leave;
import com.perennialsys.entity.LeaveBalance;
import com.perennialsys.entity.User;
import com.perennialsys.exception.InSufficientLeaveBalance;
import com.perennialsys.repository.LeaveBalRepository;
import com.perennialsys.repository.LeaveRepository;
import com.perennialsys.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class LeaveServiceImpl implements LeaveService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private LeaveRepository leaveRepository;
    @Autowired
    private LeaveBalRepository leaveBalRepository;
    private Object userdetails;

    public static long getDifferenceDays(LocalDate d1, LocalDate d2) {
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MM yyyy");
        return ChronoUnit.DAYS.between(d1, d2);
    }


    @Override
    public String createNewLeave(Leave leave) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        // Object user = auth.getPrincipal();
        MyUserDetails user = (MyUserDetails) auth.getPrincipal();
        User userObj = user.getCurrentUser();
        int userId = userObj.getId();

        LeaveBalance leavebal = leaveBalRepository.findByUserId(userId);

        int paidLeave = leavebal.getPaidLeave();
        int emgLeave = leavebal.getEmergencyLeave();
        LocalDate d1 = leave.getLeaveFromDate();
        LocalDate d2 = leave.getLeaveToDate();
        long diff = getDifferenceDays(d1, d2);
        leave.setNoOfDays(diff);
        String leaveType = leave.getLeaveType();
        if (leaveType.equals("el")) {
            if (emgLeave > 0)
                leavebal.setEmergencyLeave((int) (emgLeave - diff));
            else
                throw new InSufficientLeaveBalance("Leave balance not available");
        }
        if (leaveType.equals("pl")) {
            if (paidLeave > 0)
                leavebal.setPaidLeave((int) (paidLeave - diff));
            else
                throw new InSufficientLeaveBalance("Leave balance not available");
        }
        leave.setUser(userObj);
        leaveBalRepository.save(leavebal);
        leaveRepository.save(leave);
        return "success";
    }

    @Override
    public LeaveBalance findByUserId(int userId) {
        LeaveBalance usrObj = leaveBalRepository.findByUserId(userId);
        return usrObj;
    }

    @Override
    public String rejectValue(@PathVariable int leaveId) {
        Leave leave = leaveRepository.findById(leaveId).get();
        leave.setStatus("REJECTED");
        leaveRepository.save(leave);
        return "leave";
    }

    @Override
    public String approveLeave(@PathVariable int leaveId) {
        Leave leave = leaveRepository.findById(leaveId).get();
        leave.setStatus("APPROVED");
        leaveRepository.save(leave);
        return "success";
    }

    @Override
    public String cancelLeave(int leaveId) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        // Object user = auth.getPrincipal();
        MyUserDetails user = (MyUserDetails) auth.getPrincipal();
        User userObj = user.getCurrentUser();
        int userId = userObj.getId();

        Leave leaveCancel = leaveRepository.findById(leaveId).get();
        LeaveBalance leaveBalance = leaveBalRepository.findByUserId(userId);

        String status= leaveCancel.getStatus();
      if(status.equals("APPROVED")) {
            int paidLeave = leaveBalance.getPaidLeave();
            int emergencyLeave = leaveBalance.getEmergencyLeave();
            String leaveType = leaveCancel.getLeaveType();
            Long noOfDays = leaveCancel.getNoOfDays();
            if (leaveType.equals("el")) {
                leaveBalance.setEmergencyLeave((int) (emergencyLeave + noOfDays));
            }
            if (leaveType.equals("pl")) {
                leaveBalance.setPaidLeave((int) (paidLeave + noOfDays));
            }
        }
        leaveCancel.setStatus("CANCEL");
        leaveBalRepository.save(leaveBalance);

        return "leaveCancel";
    }

    @Override
    public List leaveStatus() {
        List leaveRecord = leaveRepository.findAll();
        return leaveRecord;
    }

}
