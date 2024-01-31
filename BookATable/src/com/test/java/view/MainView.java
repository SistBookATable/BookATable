package com.test.java.view;

import java.util.Scanner;

public class MainView {

	/**
	 * 로고 출력
	 */
	public static void logo() {
		// TODO 로고 출력화면 만들기 
		
	}
	

	/**
	 * 선택화면 출력
	 * 
	 */
	public static void show() {
		System.out.println("1. 회원 가입");
		System.out.println("2. 로그인");
		System.out.println("3. 계정 찾기");
		System.out.println("4. 음식점 검색");
	}

	/**
	 * 선택한 인덱스 반환
	 */
	public static int get() {
		
		Scanner scan = new Scanner(System.in);
		int temp = 0;
		System.out.print("선택(번호): ");
		
		temp = scan.nextInt();
		scan.nextLine();
		return temp;
	}

	

}
