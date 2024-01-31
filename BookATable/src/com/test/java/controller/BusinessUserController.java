package com.test.java.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import com.test.java.model.BusinessUser;
import com.test.java.view.BusinessUserView;

public class BusinessUserController {

	private BusinessUserView businessuserview;
	private BusinessUser businessuser;
	private ArrayList<BusinessUser> businessUserList;
	
	public BusinessUserController(BusinessUserView businessuserview, BusinessUser businessuser,
			ArrayList<BusinessUser> businessUserList) {
		this.businessuserview = businessuserview;
		this.businessuser = businessuser;
		this.businessUserList = businessUserList;
	}


	public void addBusinessUser(BusinessUser businessUser) {

	}
	
	public void findById(String inputId) {
		
	}

	public void findBySignOut(Calendar inputSignOut) {
		
	}
	
	public void findStoreByLicense(String license) {
		
	}

	public void deleteUser(String id) {
		
	}
	
	public void login(BusinessUser id, BusinessUser pw) {
		
	}
	
	public void logout() {
		
	}

}
