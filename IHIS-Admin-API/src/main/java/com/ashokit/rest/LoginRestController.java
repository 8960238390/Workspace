package com.ashokit.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ashokit.binding.LoginForm;
import com.ashokit.binding.UnlockAccForm;
import com.ashokit.service.AdminService;

@RestController
public class LoginRestController {

	@Autowired
	private AdminService adminService;

	@PostMapping("/login")
	public String login(@RequestBody LoginForm form) {
		return adminService.signIn(form);

	}
}
