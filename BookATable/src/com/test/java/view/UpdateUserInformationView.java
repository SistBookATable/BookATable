package com.test.java.view;

import java.util.Scanner;

/**
 * UpdateUserInformationView는 사용자 정보 수정 화면을 담당하는 클래스입니다.
 */
public class UpdateUserInformationView {

	 /**
     * 사용자 정보 수정 화면을 표시하는 메서드입니다.
     */
	public static void show() {
		System.out.println();
		System.out.println();
		System.out.println("┌───────────────────────────────────────────────────────┐");
		System.out.println("|        개인정보 수정 - 원하시는 항목을 선택해주세요				<");
		System.out.println("└───────────────────────────────────────────────────────┘");
		System.out.println();
	}

	 /**
     * 사용자가 선택할 수 있는 메뉴를 표시하는 메서드입니다.
     */
	public static void showSelectBox() {
		System.out.println("==========================================================================================");
		System.out.println();
		System.out.println("■           1. 비밀번호 변경                  ■");
		System.out.println("■           2. 출금계좌 변경                  ■");
		System.out.println("■           3. 전화번호 변경                  ■");
		System.out.println("■           0. 뒤로 가기                     ■");
		System.out.println();
		System.out.println("==========================================================================================");
		System.out.println();
		System.out.println("선택(번호) : ");
		
	}

	 /**
     * 사용자의 입력을 받는 메서드입니다.
     *
     * @return 사용자의 선택 번호
     */
	public static int get() {
		Scanner scan = new Scanner(System.in);
		int temp = scan.nextInt();
		scan.nextLine();
		return temp;
	}
	
	/**
     * 사용자의 비밀번호를 입력받는 메서드입니다.
     *
     * @return 사용자의 비밀번호
     */
	public static String getPw() {
		System.out.print("비밀번호 입력: ");
		Scanner scan = new Scanner(System.in);
		String temp = scan.nextLine();
		return temp;
	}

	 /**
     * 비밀번호 입력 오류 메시지를 표시하는 메서드입니다.
     */
	public static void showErrorMessage() {
		System.out.println();
		System.out.println("비밀번호를 잘못 입력하셨습니다.");
		System.out.println();
		View.pause();
	}

}
