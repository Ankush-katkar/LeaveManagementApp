package com.perennialsys.service;

import com.perennialsys.entity.Leave;
import com.perennialsys.entity.LeaveBalance;
import com.perennialsys.entity.User;

import java.util.List;

public interface LeaveService {

    String createNewLeave(Leave leave);

    LeaveBalance findByUserId(int userId);

    public String rejectValue(int leaveId);

    public String approveLeave(int leaveId);

    public String cancelLeave(int leaveId);

    public List leaveStatus();
}
