package com.test.java.view;

import java.util.ArrayList;
import java.util.Scanner;

public class SignInView {


	/**
	 * 일반회원가입, 업체회원가입 선택 화면 
	 */
	public static void showSelectType() {
		System.out.println();
		System.out.println();
		System.out.println("┌───────────────────────────────────────────────────────┐");
		System.out.println("|              회원 가입 - 회원 그룹을 선택해주세요              ■");
		System.out.println("└───────────────────────────────────────────────────────┘");
		System.out.println("==========================================================================================");

		System.out.println("┌──────────────┐\t┌──────────────┐\t┌───────────────┐");
		System.out.println("|  1. 일반 회원   |\t|  2. 업체 회원   |\t| 0. 회원가입 취소  |");
		System.out.println("└──────────────┘\t└──────────────┘\t└───────────────┘");
		
		System.out.println("■           1. 일반 회원              ■");
		System.out.println("■           2. 업체 회원              ■");
		System.out.println("■           0. 회원 가입 취소          ■");
		System.out.println();
		System.out.println("==========================================================================================");
		System.out.println();
		System.out.print("선택(번호) : ");
	}

	/**
	 * @return
	 * 선택한 번호 반환
	 */
	public static int getSelectType() {
		Scanner scan = new Scanner(System.in);
		int tmp = scan.nextInt();
		scan.nextLine();
		return tmp;
	}

}
