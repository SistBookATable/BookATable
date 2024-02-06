package com.test.java.repository;

import java.util.regex.Pattern;

public class Validation {
	public static boolean isValidId(String id) {
		if (id.equals(""))
			return false;
		else
			return true;
	}

	/**
	 * 1. 특수문자 1개 이상 2. 5글자 이상
	 */
	public static boolean isValidPw(String pw) {
		return Pattern.matches("^(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{5,}$", pw);
	}

	public static boolean isValidAccount(String account) {
		return Pattern.matches("^(\\d{1,})(-(\\d{1,})){1,}", account);
	}

	public static boolean isValidBank(String bank) {
		if (Pattern.matches("^[0-9]+$", bank)) {
			if (Integer.parseInt(bank) <= 11 && Integer.parseInt(bank) > 0) {
				return true;
			}
		}
		return false;
	}

	public static boolean isValidPhone(String phone) {
		return Pattern.matches("^01(?:0|1|[6-9])-(?:\\d{3}|\\d{4})-\\d{4}$", phone);
	}

	/**
	 * 1. 14자리 2. 중간에 '-'
	 */
	public static boolean isValidJumin(String jumin) {
		return Pattern.matches("^[0-9]{6}-[1234][0-9]{6}$", jumin);
	}

	/**
	 * 1. 한글, 영문만 입력 가능(자음, 모음도 안됨) 2. 빈 값인 경우 불가능 3. 2글자 미만인 경우 불가능
	 */
	public static boolean isValidName(String name) {
		return Pattern.matches("^[가-힣a-zA-Z]+", name);
	}
}
