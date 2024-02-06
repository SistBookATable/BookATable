package com.test.java.repository;

import java.util.Arrays;
import java.util.function.Predicate;
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
		return Pattern.matches("^01(?:0|1|[6-9])-(\\d{3,4})-\\d{4}$", phone);
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
		return Pattern.matches("^[가-힣a-zA-Z]{2,}", name);
	}
	/**
	 * 1. 한글, 영문만 입력 가능(자음, 모음도 안됨) 2. 빈 값인 경우 불가능 3. (주)제외하고 2글자 미만인 경우 불가능 4.특수문자는 '(주)' 오는 경우만 허용
	 */
	public static boolean isValidStoreName(String storeName) {
		if(Pattern.matches("?:((주))?^[가-힣a-zA-Z]{2,}|^[가-힣a-zA-Z]{2,}((주))?", storeName)) {
			
			return true ;
		}
		return false ;
	}
	public static boolean isValidStoreTelNumber(String storeTelNumber) {
		if(Pattern.matches("^0(2|3[1-3]|4[12]|5[1-5]|6[1-4])-(\\d{3,4})-(\\d{4})$", storeTelNumber)) {
			
			return true ;
		}
		return false ;
	}
	
	/**
	 * 사업자등록번호 유효성검사
	 * 1. 000-00-00000 형식 / 2. 000: 101~999 / 3. 00: 01-79,80,81,84-87 / 4. 0000[0] : 0000은 0~9999 & [0] 각각의 숫자 조작하여 유효성 판단함
	 */
	public static boolean isValidLisenceNumber(String lisenceNumber) {
		
		int[] VALID_LOGIC = {1, 3, 7, 1, 3, 7, 1, 3, 5};
		int sum = 0;
		
		//입력 양식 유효성 검사
		if (!Pattern.matches("^([1-9][0-9][1-9]|[2-9]00)-(?:[0-7]?\\d|8[014567])-(\\d{5})$", lisenceNumber)) {
			return false;
		}
		//문자열에서 - 을 제거함
		String replaceLisenceNumber = lisenceNumber.replaceAll("-", "");
		System.out.println(replaceLisenceNumber);
		//문자열 문자을 int형으로 변환후, VALID_LOGIC[]의 요소값과 곱한 후 누적함
		for(int i = 0 ; i < VALID_LOGIC.length ;i++) {
			sum =+(int)replaceLisenceNumber.charAt(i)*VALID_LOGIC[i];
			//마지막 인덱스는, 곱한 값을 10으로 나눈 후 한번 더 더해줌
			if(i==VALID_LOGIC.length-1) {
				sum =+(int)replaceLisenceNumber.charAt(i)*VALID_LOGIC[i]/10;
			}
		}
		int check = 10 - sum/10;
		//사업자 번호의 마지막 숫자와 위의 과정에서 나온 연산 값이 같으면 유효한 값
		if((int)replaceLisenceNumber.charAt(9)==check) {
			return true;
		}
		return false;
	}
	
	public static boolean isValidMenuCategory(String menuCategory) {
		if(menuCategory==""||menuCategory==null) {
			return false;
		}
		
		String[] categoryList = {"한식","중식","일식","양식","육류","해산물","찜/탕","분식","치킨","피자","기타"};
		// 익명 객체를 생성하여, 배열을 스트림으로 변경후 람다식으로 유효성 확인
//	    Predicate<String> containsMenuCategory = 
//	    		category -> Arrays.stream(categoryList).anyMatch(category::equals);
	    return Arrays.stream(categoryList).anyMatch(menuCategory::equals);
	}
	
	
}
