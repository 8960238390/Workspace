package com.security.jwtExample.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.security.jwtExample.domain.User;

public interface UserRepo extends JpaRepository<User, Long>{

	User findByUsername(String username);
}
