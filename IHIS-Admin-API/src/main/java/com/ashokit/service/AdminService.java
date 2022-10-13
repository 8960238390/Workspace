package com.ashokit.service;

import java.util.List;
import java.util.Map;

import com.ashokit.binding.CreateAccount;
import com.ashokit.binding.CreatePlan;
import com.ashokit.binding.LoginForm;
import com.ashokit.binding.UnlockAccForm;

public interface AdminService {
	
	public String createAccount(CreateAccount createAcct);
	
	public String createPlans(CreatePlan createplan);
	
	public List<String> viewPlans();
	
	public String deletPlan(int planId);
	
	public String editPlan(CreatePlan editPlan);
	
	public String emailCheck(String emailId);

	public Map<Integer, String> getCategoryNames();
	
	public String signIn(LoginForm user);

	public String forgotPwd(String emailId);
		
	public String accUnlock(UnlockAccForm unlockAccForm);

}
