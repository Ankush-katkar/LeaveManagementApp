package com.perennialsys.service;

import com.perennialsys.entity.LeaveBalance;

import java.util.Optional;

public interface LeaveBalService {
    public LeaveBalance getLeaveBalance(int userId);
}
