package com.perennialsys.service;

import com.perennialsys.entity.LeaveBalance;
import com.perennialsys.entity.User;
import com.perennialsys.repository.LeaveBalRepository;
import com.perennialsys.repository.RegisterRepository;
import com.perennialsys.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    RegisterRepository registerRepository;

    @Autowired
    LeaveBalRepository leaveBalRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public User registerUser(User newUser) {

        User userSaved = userRepository.save(newUser);

        LeaveBalance leaveBalance = new LeaveBalance();
        leaveBalance.setEmergencyLeave(5);
        leaveBalance.setPaidLeave(16);
        leaveBalance.setUser(userSaved);
        leaveBalRepository.save(leaveBalance);
        //TODO change this
        return userSaved;
    }

}
