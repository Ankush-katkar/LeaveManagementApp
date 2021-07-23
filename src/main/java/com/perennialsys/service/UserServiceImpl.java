package com.perennialsys.service;

import com.perennialsys.entity.LeaveBalance;
import com.perennialsys.entity.Role;
import com.perennialsys.entity.User;
import com.perennialsys.repository.LeaveBalRepository;
import com.perennialsys.repository.RegisterRepository;
import com.perennialsys.repository.RoleRepository;
import com.perennialsys.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    RegisterRepository registerRepository;

    @Autowired
    LeaveBalRepository leaveBalRepository;

    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;

    @Override
    public User registerUser(User newUser) {
        LOGGER.info("Entering >> registerUser()");

       List roleSet= newUser.getRoles();

     //   List<Role> roleSet=roleRepository.findAll();


    newUser.setRoles(roleSet);

/*
//code for default role
        Role roleUser = roleRepository.findBySpecificName("EMP");
        newUser.addRole(roleUser);
        */
        newUser = userRepository.save(newUser);

        LeaveBalance leaveBalance = new LeaveBalance(5, 16, newUser);
        leaveBalRepository.save(leaveBalance);

        LOGGER.info("Entering >> registerUser()");
        return newUser;
    }

    @Override
    public User findByUsername(String userName) {
        return userRepository.findByUsername(userName);
    }

    public List getAllRole() {
        List preRole = roleRepository.findAll();
        return preRole;
    }
}
