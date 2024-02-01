package com.test.java.controller;

import com.test.java.model.Member;
import com.test.java.repository.Data;
import com.test.java.view.SignInUserManagementView;

public class SignInUserManagementController {

	public void signInUserManagement() {
		
		SignInUserManagementView.findAllUser();
		
	}

}
