package com.test.java.controller;

import com.test.java.model.BusinessUser;
import com.test.java.model.Store;
import com.test.java.view.BusinessUserSignInView;

public class BusinessUserSignInController {

	public static boolean signIn() {
		String storeName = BusinessUserSignInView.getStoreName();
		String name = BusinessUserSignInView.getName();
		String licenseNumber = BusinessUserSignInView.getLicenseNumber();
		String phoneNumber = BusinessUserSignInView.getPhoneNumber();
		String storeTelNumber = BusinessUserSignInView.getStoreTelNumber();
		String bank = BusinessUserSignInView.getBank();
		String address = BusinessUserSignInView.getAddress();
		String account = BusinessUserSignInView.getAccount();
		String id = BusinessUserSignInView.getId();
		String pw = BusinessUserSignInView.getPw();
		
		
		BusinessUser businessUser = new BusinessUser(id,pw,name,licenseNumber, phoneNumber, bank, account);
		
		Store store = new Store(licenseNumber,storeName, storeTelNumber, address);
		
//		//유효성 검사
//		if(isValid(store) && isValid(businessUser)) {
//			return true;
//		}
		
		return false;
	}


}
