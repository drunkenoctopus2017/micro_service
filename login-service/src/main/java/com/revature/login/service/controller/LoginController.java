package com.revature.login.service.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.login.service.model.SystemUser;
import com.revature.login.service.repository.SystemUserRepository;

@RestController
public class LoginController {
	
	@GetMapping("/")
	public String helloBoot() {
		System.out.println("Get Mapping -Get Request /");
		return new String("Helooo!");
	}
	
	//----The following may be moved to the data service----//
	@Autowired
	SystemUserRepository userRepo;
	
	@GetMapping("/test")
	@Transactional
	public SystemUser getUser() {
		
		int findId = 1;
		
		if (!userRepo.exists(findId)) {
			SystemUser newUser = new SystemUser();
			newUser.setId(findId);
			newUser.setFirstName("Demo");
			newUser.setLastName("User");
			newUser.setPassword("password");
			newUser = userRepo.save(newUser);
			System.out.println("Created new user: " + newUser);
		}
		
		SystemUser testUser = userRepo.findOne(1);
		System.out.println("testUser: " + testUser.toString());
		return testUser;
	}
	
}
