package com.test.java.view;

import java.util.ArrayList;
import java.util.Scanner;

public class UserSignInView {

	public static String getName() {
		
		
		Scanner scan = new Scanner(System.in);
		String tmp = "";
		
		while(true) {

			System.out.print("이름 : ");
			tmp = scan.nextLine();
			// TODO 유효성 검사 만들기
//			if(isValid(tmp)) {
//				break;
//			}
			break;
		}
				
		return tmp;
	}

	public static String getJumin() {
		
		
		Scanner scan = new Scanner(System.in);
		String tmp = "";
		
		while(true) {

			System.out.print("주민번호 : ");
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

			System.out.print("전화번호 : ");
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

			System.out.print("계좌번호 : ");
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
