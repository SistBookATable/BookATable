package com.test.java.controller;

import java.util.Calendar;
import java.util.Iterator;

import com.test.java.model.Member;
import com.test.java.repository.Data;
import com.test.java.view.SignInUserManagementView;
import com.test.java.view.SignOutUserManagementView;

public class SignOutUserManagementController {

	public void signOutUserManagement() {
		
		boolean loop = true;
		while(loop) {

			SignOutUserManagementView.findAllSignOutUser();
			SignOutUserManagementView.showSelectBox();
			int choice = SignInUserManagementView.getSelectType();
			
			if(choice == 1) {
				//아이디 입력 받기
				String id = SignInUserManagementView.getId();
				deleteUser(id);
				
			}
			else if(choice == 0) {
				loop = false;
			}
			
		}
	}


	private void deleteUser(String id) {
		Iterator it = Data.memberList.iterator();
		
		while(it.hasNext()) {
			Member m = (Member)it.next();

			if(m.getId().equals(id)) {

				if(ableToDelete(m)) {
					it.remove();
					SignOutUserManagementView.deleteSuccessMessage();
				}
				else {
					SignOutUserManagementView.deleteCancleMessage();
				}
			}	
		}
	}


	private boolean ableToDelete(Member m) {
		Calendar now = Calendar.getInstance();
		Calendar selected = Calendar.getInstance();
		int year = Integer.parseInt(m.getSignOut().split("-")[0]) ;
		int month = Integer.parseInt(m.getSignOut().split("-")[1]);
		int day = Integer.parseInt(m.getSignOut().split("-")[2]);
		
		selected.set(year, month-1, day);
		
		int gap = (int) ((now.getTimeInMillis() - selected.getTimeInMillis())/1000/3600/24);
		
		if(gap > 30) {
			return true;
		}
		return false;
	}
}
