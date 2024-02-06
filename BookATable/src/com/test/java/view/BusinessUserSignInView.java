package com.test.java.view;

import java.util.Scanner;

public class BusinessUserSignInView {

	public static String getStoreName() {
		
		Scanner scan = new Scanner(System.in);
		String tmp = "";

		System.out.print("상호명 : ");
//		System.out.println("※ 한글/영문자/특수문자 포함만 문자는 '(주)'만 가능/1글자 이상");
		tmp = scan.nextLine();
		return tmp;
	}

	public static String getName() {
		Scanner scan = new Scanner(System.in);
		String tmp = "";

		System.out.print("대표자명 : ");
		tmp = scan.nextLine();
		return tmp;
	}

	public static String getLicenseNumber() {
		Scanner scan = new Scanner(System.in);
		String tmp = "";
		final int[] LICENSE_LOGIC = { 1, 3, 7, 1, 3, 7, 1, 3, 5, 1 };

		System.out.print("사업자 등록번호 [000-00-00000] : ");
		tmp = scan.nextLine();

		return tmp;
	}


	public static String getPhoneNumber() {
		Scanner scan = new Scanner(System.in);
		String tmp = "";

		System.out.print("대표자 전화번호 [000-000-000]: ");
		tmp = scan.nextLine();

		return tmp;
	}

	public static String getStoreTelNumber() {
		Scanner scan = new Scanner(System.in);
		String tmp = "";

		System.out.print("업체 전화번호 [00-000-000] : ");
		tmp = scan.nextLine();

		return tmp;
	}

	public static String getAddress() {
		Scanner scan = new Scanner(System.in);
		String tmp = "";

		System.out.print("업체 주소 : ");
		tmp = scan.nextLine();

		return tmp;
	}

	public static String getBank() {
		Scanner scan = new Scanner(System.in);
		String tmp = "";
		

			System.out.print("은행 이름 : ");
			tmp = scan.nextLine();
				
		return tmp;
	}

	public static String getAccount() {
		Scanner scan = new Scanner(System.in);
		String tmp = "";

		System.out.print("계좌 번호 : ");
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

	public static String getmenuType() {
		Scanner scan = new Scanner(System.in);
		String tmp = "";

		System.out.print("음식 분야 : ");
		tmp = scan.nextLine();
		return tmp;
	}
}
