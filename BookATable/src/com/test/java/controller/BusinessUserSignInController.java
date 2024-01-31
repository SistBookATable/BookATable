package com.test.java.controller;

import com.test.java.model.BusinessUser;
import com.test.java.model.Member;
import com.test.java.model.Store;
import com.test.java.repository.Data;
import com.test.java.view.BusinessUserSignInView;

public class BusinessUserSignInController {
	
	/**
	 * @return boolean
	 * 업체회원 회원가입이 완료되면 true
	 * 가입이 중단되면 false
	 */
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
		
		Data.memberList.add(businessUser);
		Data.storeList.add(store);
		
		for(Member b : Data.memberList) {
			System.out.println(b);
		}
		
		for(Store s : Data.storeList) {
			System.out.println(s);
		}
		
		return false;
	}


}
