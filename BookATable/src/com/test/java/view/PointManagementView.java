package com.test.java.view;

import java.util.Scanner;

import com.test.java.model.Member;
import com.test.java.model.User;

/**
 * 포인트 관리 메뉴를 출력하는 View 클래스입니다.
 */
public class PointManagementView {
	
	/**
	 * 포인트 관리 메뉴를 출력하는 메서드입니다. 
	 * @param name 사용자 이름
	 * @param account 사용자 계좌번호 
	 * @param balance 사용자 포인트잔액
	 */
	public static void showPointManagement(String name, String account, int balance) {
		System.out.println();
		System.out.println();
		System.out.println("┌───────────────────────────────────────────────────────┐");
		System.out.printf("			%s 회원님				\n", name); 
		System.out.printf("              	보 유 포 인 트 : 	%d	  		\n", balance);
		System.out.printf("              	계 좌 번 호   :   %s     	    \n", account);
		System.out.println("※충전계좌 변경은 개인정보관리의 등록계좌 변경 메뉴에서 가능합니다※");
		System.out.println("└───────────────────────────────────────────────────────┘");
		System.out.println("==========================================================================================");
		System.out.println();
		System.out.println("■           1. 포인트 충전			   ■");
		System.out.println("■           2. 포인트 환불			   ■");
		System.out.println("■           3. 포인트 선물하기		   ■");
		System.out.println("■           4. 포인트 사용내역		   ■");
		System.out.println("■           0. 이전 화면			   ■");
		System.out.println();
		System.out.println("==========================================================================================");
		System.out.println();
		System.out.print("선택(번호) : ");
	}
	
	/**
	 * 사용자로부터 메뉴 선택을 입력받는 메서드
	 * @return 사용자가 선택한 메뉴 번호
	 */
	public static int get() {
		
		Scanner scan = new Scanner(System.in);
		int temp = scan.nextInt();
		scan.nextLine();
		return temp;
	}

}
