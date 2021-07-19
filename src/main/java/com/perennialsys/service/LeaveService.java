package com.perennialsys.service;

import com.perennialsys.entity.Leave;
import com.perennialsys.entity.LeaveBalance;
import com.perennialsys.entity.User;

public interface LeaveService {

    String createNewLeave(Leave leave);

    LeaveBalance findByUserId(int userId);

}
