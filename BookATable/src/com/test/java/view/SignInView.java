package com.test.java.view;

import java.util.ArrayList;
import java.util.Scanner;

public class SignInView {

	/**
	 * 회원 가입 정보 입력
	 * @return ArrayList<String>
	 * {이름,주민번호,전화번호,계좌번호,id,pw}
	 */
	public static ArrayList<String> getInput() {
		
		Scanner scan = new Scanner(System.in);
		ArrayList<String> temp = new ArrayList<>();

		System.out.print("이름 : ");
		temp.add(scan.nextLine());
		System.out.print("주민번호 : ");
		temp.add(scan.nextLine());
		System.out.print("전화번호 : ");
		temp.add(scan.nextLine());
		System.out.print("계좌번호 : ");
		temp.add(scan.nextLine());
		System.out.print("ID : ");
		temp.add(scan.nextLine());
		System.out.print("PW : ");
		temp.add(scan.nextLine());
		
		
		return temp;
	}

	public static void showSelectType() {
		System.out.println("1. 일반 회원");
		System.out.println("2. 업체 회원");
		System.out.println("0. 회원 가입 취소");
		System.out.println();
		System.out.print("선택(번호) : ");
	}

	public static int getSelectType() {
		Scanner scan = new Scanner(System.in);
		int tmp = scan.nextInt();
		scan.nextLine();
		return tmp;
	}

}
