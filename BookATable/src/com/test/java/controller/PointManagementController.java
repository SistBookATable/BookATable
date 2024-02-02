package com.test.java.controller;

import com.test.java.model.Member;
import com.test.java.model.User;
import com.test.java.repository.Data;
import com.test.java.view.PointManagementView;

public class PointManagementController {
	
	public void pointManagement() {
		PointManagementView pointManagementView = new PointManagementView();
		PointManagementView.showPointManagement(findNameById(Member.id), findAccountById(Member.id), findPointById(Member.id));
		int choice = PointManagementView.get();
				
		
		
		
		findNameById(Member.id);
		findAccountById(Member.id);
		findPointById(Member.id);


}
	private String findNameById(String id) {
		
		
		String name = "";
		
		for(Member u : Data.memberList) {
			if(u.getId().equals(id)) {
				name = u.getName();
				break;
			}
		}
		return name;
	}
	
	
	private String findAccountById(String id)  {
		
		String account = "";
		
		for(Member u : Data.memberList) {
			if(u.getId().equals(id)) {
				account = u.getAccount();
				break;
			}
		}
		return account;
	}
	
	private int findPointById(String id)  {
		
		int balance = 0;
		
		for(Member u : Data.memberList) {
			if(u.getId().equals(id)) {
				balance = ((User)u).getBalance();
				break;
			}
		}
		return balance;
	}
	
	
	
}
