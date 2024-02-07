package com.test.java.controller;

import java.util.Calendar;

import com.test.java.repository.MemberRepository;
import com.test.java.repository.Validation;
import com.test.java.view.UserSignInView;

public class UserSignInController {
	
	/**
	 * @return boolean 일반회원 회원가입이 완료되면 true 가입이 중단되면 false
	 */
	public static boolean signIn() {
		String name = "";
		String jumin = "";
		String phone = "";
		String bank = "";
		String account = "";
		String id = "";
		String pw = "";
		
		Calendar c = Calendar.getInstance();
		String now = String.format("%tF", c);

		while (true) {
			name = UserSignInView.getName();
			if (Validation.isValidName(name)) {
				break;
			} else {
				if(name.equals("0"))
				{
					UserSignInView.showCancelMessage();
					return false;
				}
				UserSignInView.errorMessage("이름은 한글과 영문자로만 구성되어야 하고 총 2자 이상 작성하십시오. ");
			}
		}
		
		while (true) {
			jumin = UserSignInView.getJumin();
			if (Validation.isValidJumin(jumin)) {
				break;
			} else {
				if(jumin.equals("0"))
				{
					UserSignInView.showCancelMessage();
					return false;
				}
				UserSignInView.errorMessage("주민번호를 숫자와 “-”로만 구성하여 [000000-000000]형식으로 작성하십시오.");
			}
		}
		while (true) {
			phone = UserSignInView.getPhoneNumber();
			if (Validation.isValidPhone(phone)) {
				break;
			} else {
				if(phone.equals("0"))
				{
					UserSignInView.showCancelMessage();
					return false;
				}
				UserSignInView.errorMessage("전화번호를 숫자와 “-”로만 구성하여  [000-0000-0000] 형식으로 작성하십시오");
			}
		}
		
		while (true) {
			bank = UserSignInView.getBank();
			if (Validation.isValidBank(bank)) {
				bank = Validation.banks[Integer.parseInt(bank)];
				break;
			} else {
				if(bank.equals("0"))
				{
					UserSignInView.showCancelMessage();
					return false;
				}
				UserSignInView.errorMessage("은행 리스트에 해당하는 번호를 선택해 주십시오");
			}
		}
		while (true) {
			account = UserSignInView.getAccount();
			if (Validation.isValidAccount(account,bank)) {
				break;
			} else {
				if(account.equals("0"))
				{
					UserSignInView.showCancelMessage();
					return false;
				}
				UserSignInView.errorMessage("입력하신 은행과 계좌번호 형식이 일치하지 않습니다.");
			}
		}
		while (true) {
			id = UserSignInView.getId();
			if (Validation.isValidId(id)) {
				if (MemberRepository.checkDuplicate(id)) {
					break;
				} else {
					UserSignInView.errorMessage("이미 존재하는 ID입니다. 다시 작성하십시오");
				}
			} else {
				if(id.equals("0"))
				{
					UserSignInView.showCancelMessage();
					return false;
				}
				UserSignInView.errorMessage("ID는 1자 이상 작성하십시오");
			}
		}
		while (true) {
			pw = UserSignInView.getPw();
			if (Validation.isValidPw(pw)) {
				break;
			} else {
				if(pw.equals("0"))
				{
					UserSignInView.showCancelMessage();
					return false;
				}
				UserSignInView.errorMessage("PW는 특수문자(!,@,#,$,%,^,&,*)를 1자 이상 포함하는 5자 이상으로 작성하십시오");
			}
		}


		MemberRepository.add(id, pw, name, phone, jumin, 0, 0, 0, bank, account, "null", now, "null");
		
		UserSignInView.pause();
		return true;
	}



}