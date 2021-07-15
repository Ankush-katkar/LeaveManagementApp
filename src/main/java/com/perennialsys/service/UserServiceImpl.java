package com.perennialsys.service;

import com.perennialsys.entity.RegisterUser;
import com.perennialsys.repository.RegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.perennialsys.repository.UserRepository;
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	RegisterRepository registerRepository;
	
	@Override
	public boolean save(RegisterUser us) {

		RegisterUser userSaved=	registerRepository.save(us);
		//TODO change this
		return true;
	}

}
