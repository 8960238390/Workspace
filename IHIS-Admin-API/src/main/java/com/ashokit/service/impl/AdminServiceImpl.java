package com.ashokit.service.impl;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashokit.binding.CreateAccount;
import com.ashokit.binding.CreatePlan;
import com.ashokit.binding.LoginForm;
import com.ashokit.binding.UnlockAccForm;
import com.ashokit.entity.CaseWorkersAcctEntity;
import com.ashokit.entity.CitizenPlansEntity;
import com.ashokit.entity.PlanCategoryEntity;
import com.ashokit.entity.StateInsurancePlanEntity;
import com.ashokit.repository.CaseWorkersAcctRepository;
import com.ashokit.repository.CitizenPlansRepository;
import com.ashokit.repository.PlanCtRepository;
import com.ashokit.repository.StateInsurancePlanRepository;
import com.ashokit.service.AdminService;
import com.ashokit.util.EmailUtils;

@Service
public class AdminServiceImpl implements AdminService {

	private Logger logger = LoggerFactory.getLogger(AdminServiceImpl.class);

	@Autowired
	CaseWorkersAcctRepository caseWorkersAcctRepository;

	@Autowired
	CitizenPlansRepository createPlanRepository;
	
	@Autowired
	PlanCtRepository planCtRepository;
	
	@Autowired
	StateInsurancePlanRepository  stateInsurancePlanRepo;

	@Autowired
	EmailUtils emailUtils;

	@Override
	public String createAccount(CreateAccount createAcct) {

		CaseWorkersAcctEntity entity = new CaseWorkersAcctEntity();

		BeanUtils.copyProperties(createAcct, entity);

		entity.setAccStatus("LOCKED");

		entity.setPazzwd(generateRandomPassword(6));

		caseWorkersAcctRepository.save(entity);

		String email = createAcct.getEmailId();
		String subject = "IHIS Registration - Create Account";
		String body = readUnlockAccEMailBody(createAcct);
		boolean isSent = emailUtils.sendEmail(email, subject, body);

		if (isSent) {
			return "SUCCESS";
		}
		return "FAIL";
	}

	@Override
	public String createPlans(CreatePlan createPlan) {

		CitizenPlansEntity entity = new CitizenPlansEntity();

		BeanUtils.copyProperties(createPlan, entity);

		createPlanRepository.save(entity);

		return "plan created ....";
	}

	@Override
	public String deletPlan(int planId) {

		Optional<CitizenPlansEntity> entity = createPlanRepository.findById(planId);

		if (entity.isPresent()) {

			// hard delete
			CitizenPlansEntity appPlanEntity = entity.get();
			createPlanRepository.delete(appPlanEntity);

			// soft delete
			//appPlanEntity.setActiveSw("N");
			//createPlanRepository.save(appPlanEntity);

		}

		return "Record deleted successfully";
	}

	@Override
	public String editPlan(CreatePlan editPlan) {

		CitizenPlansEntity entity = new CitizenPlansEntity();

		BeanUtils.copyProperties(editPlan, entity);

		createPlanRepository.save(entity);

		return "plan Edited ....";
	}

	@Override
	public String emailCheck(String emailId) {

		CaseWorkersAcctEntity entity = caseWorkersAcctRepository.findByEmail(emailId);

		if (entity == null) {
			return "UNIQUE";
		}

		return "DUPLICATE";
	}

	@Override
	public String signIn(LoginForm login) {

		CaseWorkersAcctEntity entity = caseWorkersAcctRepository.findByEmailAndPazzwd(login.getEmail(),
				login.getPazzwd());

		if (entity == null) {

			return "invalid credentials";
		}

		if ("LOCKED".equals(entity.getAccStatus())) {

			return "Your Account is Locked";
		}

		return "SUCESS";
	}

	@Override
	public String forgotPwd(String emailId) {

		CaseWorkersAcctEntity entity = caseWorkersAcctRepository.findByEmail(emailId);
		CreateAccount createAcct = new CreateAccount();
		// BeanUtils.copyProperties(userForm, entity);
		if (entity == null) {
			return "Invalid EmailId";
		}

		String subject = "User Registration - Ashok IT";
		String body = readRecoverPwdEMailBody(createAcct);
		boolean isSent = emailUtils.sendEmail(emailId, subject, body);

		if (isSent) {
			return "Password send to registered email";
		}
		return "ERROR";
	}

	@Override
	public List<String> viewPlans() {
		
		 List<StateInsurancePlanEntity> entity = stateInsurancePlanRepo.findAll();
		
		List<String> viewPlan=new ArrayList<>();
		
		for (StateInsurancePlanEntity entityPlan : entity) {
			viewPlan.add(entityPlan.getPlanName());
			viewPlan.add(String.format("%1$tY-%1$tm-%1$td",entityPlan.getPlanStDate()));
			viewPlan.add(String.format("%1$tY-%1$tm-%1$td",entityPlan.getPlanEnDate()));
			viewPlan.add(entityPlan.getCategoryId());
		}
		
		return viewPlan;
	}

	@Override
	public Map<Integer, String> getCategoryNames() {

		List<PlanCategoryEntity> entities = planCtRepository.findAll();

		Map<Integer, String> planIdNameMap = new HashMap<>();

		for (PlanCategoryEntity entity : entities) {
			planIdNameMap.put(entity.getCategoryId(), entity.getCategoryName());
		}
		return planIdNameMap;
	}

	@Override
	public String accUnlock(UnlockAccForm unlockAcctForm) {

		if (!(unlockAcctForm.getNewPazz().equals(unlockAcctForm.getConfirmNewPazz()))) {

			return "Password and ConfirmPassword should be same ...";
		}

		CaseWorkersAcctEntity entity = caseWorkersAcctRepository.findByEmailAndPazzwd(unlockAcctForm.getEmail(),
				unlockAcctForm.getTempPazz());

		if (entity == null) {
			return "Incorrect Temporary Passeword";
		}

		entity.setPazzwd(unlockAcctForm.getNewPazz());
		entity.setAccStatus("UNLOCKED");

		caseWorkersAcctRepository.save(entity);

		return "accUnlocked ...";
	}

	private static String generateRandomPassword(int len) {

		String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghi" + "jklmnopqrstuvwxyz!@#$%&";
		Random rnd = new Random();
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++)
			sb.append(chars.charAt(rnd.nextInt(chars.length())));

		return sb.toString();
	}

	private String readRecoverPwdEMailBody(CreateAccount createAcct) {

		String mailBody = null;
		StringBuilder sb = new StringBuilder();
		Path filePath = Paths.get("RECOVER-PASSWORD-EMAIL-BODY-TEMPLATE.txt");

		try (Stream<String> stream = Files.lines(filePath)) {
			stream.forEach(line -> sb.append(line));

			mailBody = sb.toString();
			mailBody = mailBody.replace("{FULLNAME}", createAcct.getFullName());
			mailBody = mailBody.replace("{TEMP-PWD}", createAcct.getPazzwd());
			mailBody = mailBody.replace("{EMAIL}", createAcct.getEmailId());

		} catch (Exception e) {
			logger.error("Exception ::" + e.getMessage(), e);
		}

		return mailBody;
	}

	private String readUnlockAccEMailBody(CreateAccount creatAcct) {

		String mailBody = null;
		StringBuilder sb = new StringBuilder();
		Path filePath = Paths.get("UNLOCK-ACC-EMAIL-BODY-TEMPLATE.txt");

		try (Stream<String> stream = Files.lines(filePath)) {
			stream.forEach(line -> sb.append(line));

			mailBody = sb.toString();
			mailBody = mailBody.replace("{FULLNAME}", creatAcct.getFullName());
			mailBody = mailBody.replace("{TEMP-PWD}", creatAcct.getPazzwd());
			mailBody = mailBody.replace("{EMAIL}", creatAcct.getEmailId());

		} catch (Exception e) {
			logger.error("Exception ::" + e.getMessage(), e);
		}

		return mailBody;
	}

}
