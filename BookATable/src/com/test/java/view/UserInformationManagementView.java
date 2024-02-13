package com.test.java.view;

import java.util.Scanner;

/**
 * UserInformationManagementView는 사용자 정보 조회와 관련된 화면 출력을 담당하는 클래스입니다.
 */
public class UserInformationManagementView {

	/**
     * 사용자 정보 조회 화면의 타이틀을 출력하는 메서드입니다.
     * @param userName 사용자 이름
     */
	public static void showTitle(String userName) {
		System.out.println();
		System.out.println();
		System.out.println("┌───────────────────────────────────────────────────────┐");
		System.out.printf("	|		%s 회원님	개인정보 조회			<\n", userName);
		System.out.println("└───────────────────────────────────────────────────────┘");
		System.out.println();
		System.out.println();
		
		
	}

	/**
     * 사용자 정보를 출력하는 메서드입니다.
     * @param userName    사용자 이름
     * @param id          사용자 ID
     * @param phoneNumber 사용자 전화번호
     * @param birthDate   사용자 생년월일
     * @param account     사용자 계좌
     * @param balance     사용자 잔액
     */
	public static void showUserInformation(String userName, String id, String phoneNumber, String birthDate, String account, String balance) {
		System.out.println("-------------------------------------------------------------------------------------------");
		System.out.println();
		String header = String.format("%-5s\t%-15s\t%-13s\t%-6s\t\t%-16s\t%s", "[이름]","[ID]","[전화번호]","[생년월일]", "[계좌]", "[잔액]");
		System.out.println(header);
		String body = String.format("%-5s\t%-15s\t%-13s\t%-6s\t\t%-16s\t%s원", userName, id, phoneNumber, birthDate, account, balance);
		System.out.println(body);
		System.out.println();
		System.out.println("-------------------------------------------------------------------------------------------");
	}

	/**
     * 사용자에게 선택지를 보여주고 입력을 받는 메서드입니다.
     * @return 사용자 입력 값
     */
	public static void showSelectBox() {
		System.out.println("==========================================================================================");
		System.out.println();
		System.out.println("■           1. 개인정보 수정		   ■");
		System.out.println("■           0. 이전 화면			   ■");
		System.out.println();
		System.out.println("==========================================================================================");
		System.out.println();
		System.out.print("선택(번호) : ");
	}

	/**
     * 선택지를 출력하는 메서드입니다.
     */
	public static int get() {
		Scanner scan = new Scanner(System.in);
		int temp = scan.nextInt();
		scan.nextLine();
		return temp;
	}


}
