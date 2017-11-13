package com.revature.login.service.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.login.service.model.SystemUser;

@RestController
public class LoginController {
	
	@GetMapping("/")
	public String helloBoot() {
		System.out.println("Get Mapping -Get Request /");
		return new String("Helooo!!");
	}
	
	//----The following may be moved to the data service----//
	//@Autowired
	//SystemUserRepository userRepo;
	
	@GetMapping("/test")
	//@Transactional
	public SystemUser getUser() {
		
		int findId = 1;
		
		//if (!userRepo.exists(findId)) {
			SystemUser newUser = new SystemUser();
			newUser.setId(findId);
			newUser.setFirstName("Demo");
			newUser.setLastName("User");
			newUser.setPassword("password");
			newUser.setUsername("demouser");
			//newUser = userRepo.save(newUser);
			System.out.println("Created new user: " + newUser);
			return newUser;
		//}
		
		//SystemUser testUser = userRepo.findOne(1);
		//System.out.println("testUser: " + testUser.toString());
		//return testUser;
	}
	
	
	@GetMapping("/getAllUsers")
	//@Transactional
	public List<SystemUser> getAllUsers() {
		
		int findId = 1;
		
		List<SystemUser> users = new ArrayList<>();
		
		
		//if (!userRepo.exists(findId)) {
			SystemUser newUser = new SystemUser();
			newUser.setId(findId++);
			newUser.setFirstName("Demo");
			newUser.setLastName("User");
			newUser.setUsername("nullname");
			newUser.setPassword("password");
			//newUser = userRepo.save(newUser);
			//System.out.println("Created new user: " + newUser);
			//return newUser;
		//}
			
		users.add(newUser);
		
		newUser = new SystemUser();
		newUser.setId(findId++);
		newUser.setFirstName("Patrick");
		newUser.setLastName("Runyan");
		newUser.setUsername("jpwrunyan");
		newUser.setPassword("jetfuel");
		users.add(newUser);
		
		newUser = new SystemUser();
		newUser.setId(findId++);
		newUser.setFirstName("Jibril");
		newUser.setLastName("Burleigh");
		newUser.setUsername("thisthatthethird");
		newUser.setPassword("b");
		users.add(newUser);
		
		newUser = new SystemUser();
		newUser.setId(findId++);
		newUser.setFirstName("Ben");
		newUser.setLastName("Rogers");
		newUser.setUsername("brogers");
		newUser.setPassword("g00dpassword");
		users.add(newUser);
		
		newUser = new SystemUser();
		newUser.setId(findId++);
		newUser.setFirstName("Elvis");
		newUser.setLastName("Yang");
		newUser.setUsername("waveeyang");
		newUser.setPassword("picksomethingIdontknow");
		users.add(newUser);
		
		//SystemUser testUser = userRepo.findOne(1);
		//System.out.println("testUser: " + testUser.toString());
		//return testUser;
		System.out.println("users: " + users);
		return users;
	}
	
	@PostMapping(path="/addUser", consumes = "application/json", produces = "application/json")
	@ResponseBody
	public SystemUser addUser(@RequestBody SystemUser user){
		user.setId(new Date().getTime());
		List<SystemUser> allUsers = this.getAllUsers();
		allUsers.add(user);
		
		return user;
	}
	
}
