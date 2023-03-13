package com.ashokit.mvc.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashokit.mvc.entity.LoginEntity;
import com.ashokit.mvc.repository.LoginEntityRepository;
import com.ashokit.mvc.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	LoginEntityRepository loginRepo;
	
	@Override
	public boolean checkUserLogin(String username, String password) {
		Optional<LoginEntity> opt=loginRepo.findById(username);
		if(opt.isPresent())
		{
			LoginEntity loginEntity=opt.get();
			if(password.equals(loginEntity.getPassword()))
			{
				if(loginEntity.getStatus().equals("active"))
				{
					return true;
				}
				else
				{
					return false;
				}
			}
			else
			{
				return false;
			}
		}
		else
		{
			return false;
		}
	}

}
