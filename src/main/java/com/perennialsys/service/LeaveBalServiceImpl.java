package com.perennialsys.service;

import com.perennialsys.entity.LeaveBalance;
import com.perennialsys.repository.LeaveBalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LeaveBalServiceImpl implements LeaveBalService{
    @Autowired
    private LeaveBalRepository leaveBalRepository;

    @Override
    public LeaveBalance getLeaveBalance(int userId) {

     LeaveBalance leaveBalance=  leaveBalRepository.findByUserId(userId);


        return leaveBalance;
    }
}
