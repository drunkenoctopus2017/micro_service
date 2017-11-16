package com.revature.login.service.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.revature.login.service.model.SystemUser;

@Repository
public interface SystemUserRepository extends CrudRepository<SystemUser, Integer> {
	
}
