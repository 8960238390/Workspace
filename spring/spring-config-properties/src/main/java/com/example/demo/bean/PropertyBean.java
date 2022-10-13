package com.example.demo.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "app.local")
public class PropertyBean {

	private String username;
	private String pazzword;
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPazzword() {
		return pazzword;
	}
	public void setPazzword(String pazzword) {
		this.pazzword = pazzword;
	}
	
	@Override
	public String toString() {
		return "PropertyBean [username=" + username + ", pazzword=" + pazzword + "]";
	}
}
