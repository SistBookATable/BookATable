package com.test.java.controller;

import java.util.Calendar;

import com.test.java.model.Member;
import com.test.java.model.User;
import com.test.java.repository.Data;
import com.test.java.repository.MemberRepository;
import com.test.java.repository.Validation;
import com.test.java.view.UserSignInView;
import com.test.java.view.View;

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

		while (true) {
			name = UserSignInView.getName();
			if (Validation.isValidName(name)) {
				break;
			} else {
				UserSignInView.errorMessage("이름은 한글과 영문자로만 구성되어야 하고 총 1자 이상 작성하십시오. ");
			}
		}
		while (true) {
			jumin = UserSignInView.getJumin();
			if (Validation.isValidJumin(jumin)) {
				break;
			} else {
				UserSignInView.errorMessage("주민번호를 숫자와 “-”로만 구성하여 [000000-000000]형식으로 작성하십시오.");
			}
		}
		while (true) {
			phone = UserSignInView.getPhoneNumber();
			if (Validation.isValidPhone(phone)) {
				break;
			} else {
				UserSignInView.errorMessage("“전화번호를 숫자와 “-”로만 구성하여  [000-0000-0000] 형식으로 작성하십시오");
			}
		}
		
		while (true) {
			bank = UserSignInView.getBank();
			if (Validation.isValidBank(bank)) {
				break;
			} else {
				UserSignInView.errorMessage("은행 리스트에 해당하는 번호를 선택해 주십시오");
			}
		}
		while (true) {
			account = UserSignInView.getAccount();
			if (Validation.isValidAccount(account)) {
				break;
			} else {
				UserSignInView.errorMessage("계좌번호를 숫자와 “-”로 구성하고 10자~14자 이내로 작성하십시오");
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
				UserSignInView.errorMessage("ID는 1자 이상 작성하십시오");
			}
		}
		while (true) {
			pw = UserSignInView.getPw();
			if (Validation.isValidPw(pw)) {
				break;
			} else {
				UserSignInView.errorMessage("PW는 특수문자(!,@,#,$,%,^,&,*)를 1자 이상 포함하는 5자로 작성하십시오");
			}
		}

		Calendar c = Calendar.getInstance();
		String now = String.format("%tF", c);

		User user = new User(id, pw, name, phone, jumin, 0, 0, 0, "null", account, "null", now, "null");


		System.out.println("회원가입이 완료되었습니다.");
		Data.memberList.add(user);
		for (Member u : Data.memberList) {
			System.out.println(u);
		}

		View.pause();

		return true;
	}



}