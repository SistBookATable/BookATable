package com.test.java.view;

import java.util.Scanner;

import com.test.java.model.Member;
import com.test.java.model.User;

public class PointManagementView {
	
	public static void showPointManagement(String name) {
		System.out.println();
		System.out.println();
		System.out.println("┌───────────────────────────────────────────────────────┐");
		System.out.printf("	|						%s 회원님							|", name); 
		System.out.println("|              	보 유 포 인 트 : 	%d	  			       	|");
		System.out.println("|              	계 좌 번 호   :   %s     	                |");
		System.out.println("|	※충전계좌 변경은 개인정보관리의 등록계좌 변경 메뉴에서 가능합니다※ 	|");
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
	
	public static int get() {
		
		Scanner scan = new Scanner(System.in);
		int temp = scan.nextInt();
		scan.nextLine();
		scan.close();
		
		return temp;
	}

}
