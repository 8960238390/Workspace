package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.PropertyBean;

@RestController
public class PropertyController {

	@Value("${secret_key}")
	private String secretKey;
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private PropertyBean propertyBean;
	
	@GetMapping("/way1")
	public String wayone() {
		return secretKey;
	}
	
	@GetMapping("/way2")
	public String wayTwo() {
		
		return environment.getRequiredProperty("app.username");
	}
	
	@GetMapping("/way3")
	public Map<String, String> wayThree() {
		
		
		Map<String, String> properties = new HashMap<>();
		properties.put("username", propertyBean.getUsername());
		properties.put("pazzword", propertyBean.getPazzword());
		
		return properties;
	}
}
