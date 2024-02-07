package com.test.java.controller;

import java.util.Calendar;

import com.test.java.model.BusinessUser;
import com.test.java.model.Member;
import com.test.java.model.Store;
import com.test.java.repository.Data;
import com.test.java.repository.MemberRepository;
import com.test.java.repository.Validation;
import com.test.java.view.BusinessUserSignInView;
import com.test.java.view.UserSignInView;
import com.test.java.view.View;

public class BusinessUserSignInController {

	/**
	 * @return boolean 업체회원 회원가입이 완료되면 true 가입이 중단되면 false
	 */
	public static boolean signIn() {
		String name = "";
		String licenseNumber = "";
		String phoneNumber = "";
		String id = "";
		String pw = "";
		String bank = "";
		String account = "";
		String storeName = "";
		String storeTelNumber = "";
		String address = "";
		String menuCategory = "";

		Calendar c = Calendar.getInstance();
		String now = String.format("%tF", c);

		while (true) {
			name = BusinessUserSignInView.getName();
			if (Validation.isValidName(name)) {
				break;
			} else {
				BusinessUserSignInView.errorMessage();
			}
		}

		while (true) {
			licenseNumber = BusinessUserSignInView.getLicenseNumber();
			if (Validation.isValidLisenceNumber(licenseNumber)) {
				break;
			} else {
				BusinessUserSignInView.errorMessage();
			}
		}
		while (true) {
			phoneNumber = BusinessUserSignInView.getPhoneNumber();
			if (Validation.isValidPhone(phoneNumber)) {
				break;
			} else {
				BusinessUserSignInView.errorMessage();
			}
		}
		while (true) {
			id = BusinessUserSignInView.getId();
			if (Validation.isValidId(id)) {
				if (MemberRepository.checkDuplicate(id)) {
					break;
				} else {
					UserSignInView.errorMessage("이미 존재하는 ID입니다. 다시 작성하십시오");
				}
			} else {
				UserSignInView.errorMessage("ID는 1자 이상 작성하십시오");
			}
		}
		
		while (true) {
			pw = BusinessUserSignInView.getPw();
			if (Validation.isValidPw(pw)) {
				break;
			} else {
				BusinessUserSignInView.errorMessage();
			}
		}

		while (true) {
			bank = BusinessUserSignInView.getBank();
			if (Validation.isValidBank(bank)) {
				break;
			} else {
				BusinessUserSignInView.errorMessage();
			}
		}

		while (true) {
			account = BusinessUserSignInView.getAccount();
			if (Validation.isValidAccount(account)) {
				break;
			} else {
				BusinessUserSignInView.errorMessage();
			}
		}

		while (true) {
			storeName = BusinessUserSignInView.getStoreName();
			if (Validation.isValidStoreName(storeName)) {
				break;
			} else {
				BusinessUserSignInView.errorMessage();
			}
		}

		while (true) {
			storeTelNumber = BusinessUserSignInView.getStoreTelNumber();
			if (Validation.isValidStoreTelNumber(storeTelNumber)) {
				break;
			} else {
				BusinessUserSignInView.errorMessage();
			}
		}
		
		while (true) {
			address = BusinessUserSignInView.getAddress();
			if (Validation.isValidAddress(address)) {
				break;
			} else {
				BusinessUserSignInView.errorMessage();
			}
		}
		
		while (true) {
			String detailAddress = BusinessUserSignInView.getDetailAddress();
			if (Validation.isValidDetailAddress(detailAddress)) {
				address += detailAddress;
				break;
			} else {
				BusinessUserSignInView.errorMessage();
			}
		}
		
		while (true) {
			menuCategory = BusinessUserSignInView.getMenuCategory();
			if (Validation.isValidMenuCategory(menuCategory)) {
				break;
			} else {
				BusinessUserSignInView.errorMessage();
			}
		}

		BusinessUser businessUser = new BusinessUser(2, id, pw, name, licenseNumber, phoneNumber, bank, account, now,
				null);
		Store store = new Store(licenseNumber, storeName, storeTelNumber, address, menuCategory);

		Data.memberList.add(businessUser);
		Data.storeList.add(store);

		System.out.println("회원가입이 완료되었습니다.");

		for (Member b : Data.memberList) {
			System.out.println(b);
		}

		for (Store s : Data.storeList) {
			System.out.println(s);
		}

		View.pause();
		
		return true;
	}

}
