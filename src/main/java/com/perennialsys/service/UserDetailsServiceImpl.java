package com.perennialsys.service;

import com.perennialsys.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Objects;

public class UserDetailsServiceImpl implements UserDetailsService {


    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByUsername(username);
        int userId = user.getId();

        if (Objects.isNull(user)) {
            throw new UsernameNotFoundException("Invalid username or password");
        }
        return new MyUserDetails(user);
    }

}
