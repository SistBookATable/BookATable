package com.test.java.repository;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;

import com.test.java.model.BusinessUser;
import com.test.java.model.Member;
import com.test.java.model.User;
import com.test.java.view.SignOutUserManagementView;

public class MemberRepository {
	
	public static Member findOneById(String id) {
		for(Member m : Data.memberList) {
			if(m.getId().equals(id)) {
				return m;
			}
		}
		return null;
	}
	
	public static ArrayList<Member> findAll() {
		return Data.memberList;
	}

	public static boolean isValidName(String name) {
		
		for(Member m : Data.memberList) {
			if(m.getName().equals(name)) {
				return true;
			}
		}
		
		return false;
	}

	public static boolean checkDuplicate(String id) {
		for(Member m : Data.memberList) {
			if(m.getId().equals(id)) {
				return false;
			}
		}
		return true;
	}

	
	

	public static void deleteUser(String id) {
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


	private static boolean ableToDelete(Member m) {
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

	public static ArrayList<User> findAllUser() {
		ArrayList<User> tmp = new ArrayList<>();
		for(Member m : Data.memberList) {
			if(m.getUserType()==1 && m.getSignOut().equals("null")) {
				tmp.add((User)m);
			}
		}
		return tmp;
	}

	public static ArrayList<User> findAllSingOutUser() {
		ArrayList<User> tmp = new ArrayList<>();
		for(Member m : Data.memberList) {
			if(m.getUserType()==1 && !m.getSignOut().equals("null")) {
				tmp.add((User)m);
			}
		}
		return tmp;
		
	}
	public static ArrayList<BusinessUser> findAllBusinessUser() {
		ArrayList<BusinessUser> tmp = new ArrayList<>();
		for(Member m : Data.memberList) {
			if(m.getUserType()==2&& m.getSignOut().equals("null")) {
				tmp.add((BusinessUser)m);
			}
		}
		return tmp;
	}
	
	public static ArrayList<BusinessUser> findAllSingOutBusinessUser() {
		ArrayList<BusinessUser> tmp = new ArrayList<>();
		for(Member m : Data.memberList) {
			if(m.getUserType()==1 && !m.getSignOut().equals("null")) {
				tmp.add((BusinessUser)m);
			}
		}
		return tmp;
		
	}

	public static void add(String id, String pw, String name, String phone, String jumin, int i, int j, int k,
			String bank, String account, String string, String now, String string2) {
		
		User user = new User(id, pw, name, phone, jumin, i, j, k, bank, account, string, now, string2);
		Data.memberList.add(user);
	}
	public static void addBusinessUser(int userType, String id, String pw, String name, String licenseNumber, String phoneNumber,
			String bank, String account, String now, String signOut) {
		
		BusinessUser businessUser = new BusinessUser(2, id, pw, name,  licenseNumber, phoneNumber, bank, account, now, signOut);
		Data.memberList.add(businessUser);
	}
}
