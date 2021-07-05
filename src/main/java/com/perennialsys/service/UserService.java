package com.perennialsys.service;

import com.perennialsys.entity.RegisterUser;
import org.springframework.stereotype.Service;

import com.perennialsys.entity.User;


public interface UserService {
	
	public boolean  save(RegisterUser us);

}
