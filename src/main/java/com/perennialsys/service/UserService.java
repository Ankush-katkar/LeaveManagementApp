package com.perennialsys.service;

import com.perennialsys.entity.User;


public interface UserService {

    User registerUser(User newUser);

    User findByUsername(String userName);

}
