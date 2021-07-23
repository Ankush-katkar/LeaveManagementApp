package com.perennialsys.service;

import com.perennialsys.entity.User;

import java.util.List;


public interface UserService {

    User registerUser(User newUser);

    User findByUsername(String userName);

    List getAllRole();

}
