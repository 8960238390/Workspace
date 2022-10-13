package com.ashokit.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ashokit.binding.CreatePlan;
import com.ashokit.service.AdminService;

@RestController
public class ViewPlanController {
	
	@Autowired
	AdminService adminService;
	
	@GetMapping("/viewPlans")
	public List<String> displayPlanNames() {

		return adminService.viewPlans();
	}

	@DeleteMapping("/plan/{pid}")
	public ResponseEntity<String> deletePlan(@PathVariable int pid){
		
		String deletePlan = adminService.deletPlan(pid);
		return new ResponseEntity<>(deletePlan, HttpStatus.OK);
	}
	
	@PostMapping("/editPlan")
	public String editPlan(@RequestBody CreatePlan editPlan) {
		return adminService.editPlan(editPlan);
	}
}
