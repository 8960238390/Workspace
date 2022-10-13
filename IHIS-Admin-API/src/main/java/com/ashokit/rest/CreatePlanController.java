package com.ashokit.rest;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ashokit.binding.CreatePlan;
import com.ashokit.service.AdminService;

@RestController
public class CreatePlanController {
	
	@Autowired
	AdminService adminService;
	
	@GetMapping("/ctNames")
	public Map<Integer, String> getCtNames() {

		return adminService.getCategoryNames();
	}
	
	@GetMapping("/email/{emailId}")
	public ResponseEntity<String> emailCheck(@PathVariable("emailId") String emailId) {
		String msg = adminService.emailCheck(emailId);
		return new ResponseEntity<>(msg, HttpStatus.OK);
	}

	@PostMapping("/creatPlan")
	public String creatPlan(@RequestBody CreatePlan createPlan) {
		return adminService.createPlans(createPlan);
	}
	
}
