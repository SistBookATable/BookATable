package com.test.java.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import com.test.java.model.User;
import com.test.java.view.UserView;

public class UserControlloer {
	
	private UserView userview;
	private ArrayList<User> userList;
	
	public UserControlloer(UserView userview, ArrayList<User> userList) {
		this.userview = userview;
		this.userList = userList;
	}


	public void addUser(User user) {
		
	}
	

	public void findById(String id, String name, String phoneNumber) {
		
	}


	public void findBySignOut(Calendar SignOut) {
		
	}
	
	public void deleteUser(String id) {
		
	}

	public void login(User id, User pw) {
		
	}

	public void logout() {

	}
	
}
