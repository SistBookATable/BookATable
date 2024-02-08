package com.test.java.controller;

import java.util.Calendar;

import com.test.java.model.BusinessUser;
import com.test.java.model.Member;
import com.test.java.model.Store;
import com.test.java.repository.Data;
import com.test.java.repository.MemberRepository;
import com.test.java.repository.StoreRepository;
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
				if(MemberRepository.checkDuplicate(licenseNumber)) {
					break;
				} else {
					UserSignInView.errorMessage("이미 들록된 사업자 번호입니다. 다시 작성하십시오");
				}
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
			bank = Validation.banks[Integer.parseInt(bank)];
			break;
		} else {
			if(bank.equals("0"))
			{
				BusinessUserSignInView.showCancelMessage();
				return false;
			}
			UserSignInView.errorMessage("은행 리스트에 해당하는 번호를 선택해 주십시오");
		}
	}
	while (true) {
		account = BusinessUserSignInView.getAccount();
		if (Validation.isValidAccount(account,bank)) {
			break;
		} else {
			if(account.equals("0"))
			{
				BusinessUserSignInView.showCancelMessage();
				return false;
			}
			UserSignInView.errorMessage("입력하신 은행과 계좌번호 형식이 일치하지 않습니다.");
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
			String returnAddress = Validation.isValidAddress(address);
			if (returnAddress!=null) {
				address = returnAddress + " ";
				break;
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

		

		MemberRepository.addBusinessUser(2, id, pw, name, licenseNumber, phoneNumber, bank, account, now, "null");
		StoreRepository.add(licenseNumber, storeName, storeTelNumber, address, menuCategory);

		System.out.println("회원가입이 완료되었습니다.");

		BusinessUserSignInView.pause();
		return true;
	}

}
