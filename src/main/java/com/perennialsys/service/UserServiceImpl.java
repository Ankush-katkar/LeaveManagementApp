package com.perennialsys.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.perennialsys.entity.User;
import com.perennialsys.repository.UserRepository;
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;
	
	@Override
	public boolean SaveUser(User user) {

		User userSaved=	userRepository.save(user);
		
		return userSaved.getId() != null;
	}

}
