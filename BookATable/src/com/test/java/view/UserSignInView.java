package com.test.java.view;

import java.util.Scanner;


public class UserSignInView {

	public static String getName() {
		Scanner scan = new Scanner(System.in);
		String tmp = "";
		System.out.print("이름 : ");
		tmp = scan.nextLine();
		return tmp;
	}

	public static String getJumin() {
		
		Scanner scan = new Scanner(System.in);
		String tmp = "";
		System.out.print("주민번호 [000000-0000000] : ");
		tmp = scan.nextLine();	
		return tmp;
	}

	public static String getPhoneNumber() {
		
		Scanner scan = new Scanner(System.in);
		String tmp = "";
		System.out.print("전화번호 [000-0000-0000] : ");
		tmp = scan.nextLine();
		return tmp;
	}

	public static String getId() {
		
		Scanner scan = new Scanner(System.in);
		String tmp = "";
		System.out.print("ID : ");
		tmp = scan.nextLine();						
		return tmp;
	}

	public static String getPw() {
		
		Scanner scan = new Scanner(System.in);
		String tmp = "";
		System.out.print("PW : ");
		tmp = scan.nextLine();		
		return tmp;
	}
	
	public static String getBank() {

		Scanner scan = new Scanner(System.in);
		String tmp = "";
		System.out.println("연결 계좌의 은행을 선택해 주세요");
		System.out.println("1. SC제일은행");
		System.out.println("2. 신한은행");
		System.out.println("3. 씨티은행");
		System.out.println("4. DGB대구은행");
		System.out.println("5. 케이뱅크");
		System.out.println("6. NH농협은행");
		System.out.println("7. 우리은행");
		System.out.println("8. 부산은행");
		System.out.println("9. 카카오뱅크");
		System.out.println("10. IBK기업은행");
		System.out.println("11. KEB하나은행");
		System.out.print("입력 (번호) : ");
		tmp = scan.nextLine();
		return tmp;
	}
	
	public static String getAccount() {
		
		
		Scanner scan = new Scanner(System.in);
		String tmp = "";
		System.out.print("계좌번호 : ");
		tmp = scan.nextLine();		
		return tmp;
	}
	public static void errorMessage(String string) {

		System.out.println();
		System.out.println(string);
		System.out.println();
		
		
	}
}
