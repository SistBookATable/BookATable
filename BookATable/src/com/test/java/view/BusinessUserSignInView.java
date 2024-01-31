package com.test.java.view;

import java.util.Scanner;

public class BusinessUserSignInView {

	public static String getStoreName() {
		Scanner scan = new Scanner(System.in);
		String tmp = "";
		
		while(true) {

			System.out.print("상호명 : ");
			tmp = scan.nextLine();
			// TODO 유효성 검사 만들기
//			if(isValid(tmp)) {
//				break;
//			}
			break;
		}
				
		return tmp;
	}
	
	public static String getName() {
		Scanner scan = new Scanner(System.in);
		String tmp = "";
		
		while(true) {

			System.out.print("대표자명 : ");
			tmp = scan.nextLine();
			// TODO 유효성 검사 만들기
//			if(isValid(tmp)) {
//				break;
//			}
			break;
		}
				
		return tmp;
	}
	
	public static String getLicenseNumber() {
		Scanner scan = new Scanner(System.in);
		String tmp = "";
		
		while(true) {

			System.out.print("사업자 등록번호 : ");
			tmp = scan.nextLine();
			// TODO 유효성 검사 만들기
//			if(isValid(tmp)) {
//				break;
//			}
			break;
		}
				
		return tmp;
	}
	
	public static String getPhoneNumber() {
		Scanner scan = new Scanner(System.in);
		String tmp = "";
		
		while(true) {

			System.out.print("대표자 전화번호 : ");
			tmp = scan.nextLine();
			// TODO 유효성 검사 만들기
//			if(isValid(tmp)) {
//				break;
//			}
			break;
		}
				
		return tmp;
	}
	
	public static String getStoreTelNumber() {
		Scanner scan = new Scanner(System.in);
		String tmp = "";
		
		while(true) {

			System.out.print("업체 전화번호 : ");
			tmp = scan.nextLine();
			// TODO 유효성 검사 만들기
//			if(isValid(tmp)) {
//				break;
//			}
			break;
		}
				
		return tmp;
	}
	
	public static String getAddress() {
		Scanner scan = new Scanner(System.in);
		String tmp = "";
		
		while(true) {

			System.out.print("위치 : ");
			tmp = scan.nextLine();
			// TODO 유효성 검사 만들기
//			if(isValid(tmp)) {
//				break;
//			}
			break;
		}
				
		return tmp;
	}
	
	public static String getBank() {
		Scanner scan = new Scanner(System.in);
		String tmp = "";
		
		while(true) {

			System.out.print("은행 이름 : ");
			tmp = scan.nextLine();
			// TODO 유효성 검사 만들기
//			if(isValid(tmp)) {
//				break;
//			}
			break;
		}
				
		return tmp;
	}
	
	public static String getAccount() {
		Scanner scan = new Scanner(System.in);
		String tmp = "";
		
		while(true) {

			System.out.print("계좌 번호 : ");
			tmp = scan.nextLine();
			// TODO 유효성 검사 만들기
//			if(isValid(tmp)) {
//				break;
//			}
			break;
		}
				
		return tmp;
	}
	
	public static String getId() {
		Scanner scan = new Scanner(System.in);
		String tmp = "";
		
		while(true) {

			System.out.print("ID : ");
			tmp = scan.nextLine();
			// TODO 유효성 검사 만들기
//			if(isValid(tmp)) {
//				break;
//			}
			break;
		}
				
		return tmp;
	}



	public static String getPw() {
		Scanner scan = new Scanner(System.in);
		String tmp = "";
		
		while(true) {

			System.out.print("PW : ");
			tmp = scan.nextLine();
			// TODO 유효성 검사 만들기
//			if(isValid(tmp)) {
//				break;
//			}
			break;
		}	
		return tmp;
	}
}
