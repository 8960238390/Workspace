package com.security.jwtExample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.security.jwtExample.domain.Role;
import com.security.jwtExample.domain.User;
import com.security.jwtExample.repo.RoleRepo;
import com.security.jwtExample.repo.UserRepo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	
	private UserRepo userRepo;	
	private RoleRepo roleRepo;

	@Override
	public User saveUser(User user) {

		log.info("Saving new user {} to database",user.getName());

		if (user != null) {
			userRepo.save(user);

		}

		return user;
	}

	@Override
	public Role saveRole(Role role) {

		log.info("Saving new role {} to database",role.getName());
		if (role != null) {
			roleRepo.save(role);
		}
		return role;
	}

	@Override
	public boolean addRoleToUser(String userName, String roleName) {

		log.info("adding given role {} to given user {}",userName,roleName);
		boolean status = false;

		User user = userRepo.findByUsername(userName);
		Role role = roleRepo.findByName(roleName);

		if (user != null && role != null) {
			status = user.getRoles().add(role);
		}

		return status;
	}

	@Override
	public User getUser(String userName) {

		log.info("Retriving user by given username {} ",userName);
		return userRepo.findByUsername(userName);

	}

	@Override
	public List<User> getUsers() {

		log.info("Retriving all user from database");
		return userRepo.findAll();
	}

}
