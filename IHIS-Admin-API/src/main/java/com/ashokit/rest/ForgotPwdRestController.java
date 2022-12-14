package com.ashokit.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ashokit.service.AdminService;

@RestController
public class ForgotPwdRestController {

	@Autowired
	private AdminService adminService;

	@PostMapping("/forgetPw/{emailId}")
	public String forgotPwd(@PathVariable("emailId") String emailId) {
		return adminService.forgotPwd(emailId);

	}
}
