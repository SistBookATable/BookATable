package com.test.java.controller;

import com.test.java.model.Member;
import com.test.java.repository.Data;
import com.test.java.view.PointManagementView;

public class PointManagementController {
	
	public void pointManagement() {
		PointManagementView pointManagementView = new PointManagementView();
		PointManagementView.showPointManagement(findNameById(Member.id));
		int choice = PointManagementView.get();
				
		
		findNameById(Member.id);
		findAccountById(Member.id);


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
	
	
	
}
