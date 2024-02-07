package com.test.java.view;

import java.util.Scanner;


public class UserSignInView {

	public static String getName() {
		Scanner scan = new Scanner(System.in);
		String tmp = "";		
		System.out.println("==========================================================================================");
		System.out.println("■            이름을 입력해주세요 \t\t■");
		System.out.println("     회원가입을 종료하려면 \'0\'을 입력해주세요  ");
		System.out.println("==========================================================================================");
		System.out.println();
		System.out.print("이름 : ");
		tmp = scan.nextLine();
		return tmp;
	}

	public static String getJumin() {
		
		Scanner scan = new Scanner(System.in);
		String tmp = "";
		System.out.println("==========================================================================================");
		System.out.println("■            주민번호를 입력해주세요 \t\t■");
		System.out.println("     회원가입을 종료하려면 \'0\'을 입력해주세요  ");
		System.out.println("==========================================================================================");
		System.out.println();
		System.out.print("주민번호 [000000-0000000] : ");
		tmp = scan.nextLine();	
		return tmp;
	}

	public static String getPhoneNumber() {
		
		Scanner scan = new Scanner(System.in);
		String tmp = "";
		System.out.println("==========================================================================================");
		System.out.println("■            전화번호를 입력해주세요 \t\t■");
		System.out.println("     회원가입을 종료하려면 \'0\'을 입력해주세요  ");
		System.out.println("==========================================================================================");
		System.out.println();
		System.out.print("전화번호 [000-0000-0000] : ");
		tmp = scan.nextLine();
		return tmp;
	}


	public static String getId() {
		
		Scanner scan = new Scanner(System.in);
		String tmp = "";
		System.out.println("==========================================================================================");
		System.out.println("■            ID를 입력해주세요 \t\t■");
		System.out.println("     회원가입을 종료하려면 \'0\'을 입력해주세요  ");
		System.out.println("==========================================================================================");
		System.out.println();
		System.out.print("ID : ");
		tmp = scan.nextLine();						
		return tmp;
	}

	public static String getPw() {
		
		Scanner scan = new Scanner(System.in);
		String tmp = "";
		System.out.println("==========================================================================================");
		System.out.println("■            비밀번호를 입력해주세요 \t\t■");
		System.out.println("     회원가입을 종료하려면 \'0\'을 입력해주세요  ");
		System.out.println("==========================================================================================");
		System.out.println();
		System.out.print("PW : ");
		tmp = scan.nextLine();		
		return tmp;
	}
	
	public static String getBank() {

		Scanner scan = new Scanner(System.in);
		String tmp = "";
		System.out.println("==========================================================================================");
		System.out.println("■            사용계좌 은행을 선택해 주세요 \t\t■");
		System.out.println("     회원가입을 종료하려면 \'0\'을 입력해주세요  ");
		System.out.println();
		System.out.println("01. SC제일은행	(11자)");
		System.out.println("02. 신한은행	(12자)");
		System.out.println("03. 씨티은행	(12자)");
		System.out.println("04. DGB대구은행	(12자)");
		System.out.println("05. 케이뱅크	(12자)");
		System.out.println("06. NH농협은행	(13자)");
		System.out.println("07. 우리은행	(13자)");
		System.out.println("08. 부산은행	(13자)");
		System.out.println("09. 카카오뱅크	(13자)");
		System.out.println("10. IBK기업은행	(14자)");
		System.out.println("11. KEB하나은행	(14자)");
		System.out.println("==========================================================================================");
		System.out.println();
		System.out.print("입력 (번호) : ");
		tmp = scan.nextLine();
		return tmp;
	}
	
	public static String getAccount() {
		
		
		Scanner scan = new Scanner(System.in);
		String tmp = "";
		System.out.println("“-”를 제외하고 숫자만 작성하십시오.");
		tmp = scan.nextLine();		
		return tmp;
	}
	public static void errorMessage(String string) {

		System.out.println();
		System.out.println(string);
		System.out.println();
		
		
	}

	public static void pause() {
		View.pause();
		
	}

	public static void showCancelMessage() {
		System.out.println("==========================================================================================");
		System.out.println();
		System.out.println("        회원 가입이 취소됩니다.");
		System.out.println();
		System.out.println("==========================================================================================");
		System.out.println();
		View.pause();
	}
}
