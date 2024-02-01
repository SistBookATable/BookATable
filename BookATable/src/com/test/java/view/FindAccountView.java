package com.test.java.view;

import java.util.Scanner;

public class FindAccountView {

	public static void showSelectBox() {
		
		System.out.println();
		System.out.println();
		System.out.println("┌───────────────────────────────────────────────────────┐");
		System.out.println("|              계정 찾기 - 찾으실 계정 정보를 선택하세요			■");
		System.out.println("└───────────────────────────────────────────────────────┘");
		System.out.println("==========================================================================================");
		System.out.println();
		System.out.println("■           1. ID 찾기              ■");
		System.out.println("■           2. PW 찾기              ■");
		System.out.println("■           0. 돌아가기              ■");
		System.out.println();
		System.out.println("==========================================================================================");
		System.out.println();
		System.out.print("선택(번호) : ");
	}

	public static int getSelectNum() {
		Scanner scan = new Scanner(System.in);
		int tmp = scan.nextInt();
		scan.nextLine();
		return tmp;
	}
	
	public static String getName() {
		
		
		Scanner scan = new Scanner(System.in);
		String tmp = "";
		
		while(true) {

			System.out.print("이름/대표자명 : ");
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

	public static void showResultID(String id) {
		if(id != null) {

			System.out.println("찾으시는 ID 입니다.");
			System.out.println("[ "+id+" ]");	
		}
		else {
			System.out.println("입력하신 이름 및 전화번호로 가입된 이력이 없습니다.");
		}
		
	}

	public static void showFindIdTitle() {
		System.out.println();
		System.out.println();
		System.out.println("┌───────────────────────────────────────────────────────┐");
		System.out.println("|         ID 찾기 - 이름/대표자명 , 전화번호를 입력해주세요         ■");
		System.out.println("└───────────────────────────────────────────────────────┘");
		
	}

	public static void showFindPwTitle() {
		System.out.println();
		System.out.println();
		System.out.println("┌───────────────────────────────────────────────────────┐");
		System.out.println("|             PW 찾기 - ID , 전화번호를 입력해주세요            ■");
		System.out.println("└───────────────────────────────────────────────────────┘");
		
	}

	public static void showResultPw(String pw) {
		if(pw != null) {

			System.out.println("찾으시는 PW 입니다.");
			System.out.println("[ "+pw+" ]");	
		}
		else {
			System.out.println("입력하신 ID 및 전화번호로 가입된 이력이 없습니다.");
		}
		
	}


}
