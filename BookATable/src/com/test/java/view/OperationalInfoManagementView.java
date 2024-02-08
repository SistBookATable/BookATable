package com.test.java.view;

import java.util.Scanner;

public class OperationalInfoManagementView {
	
	public void showChoice(){
		
		System.out.println("==========================================================================================");
		System.out.println();
		System.out.println("■            1. 운영시간 관리         \t■");
		System.out.println("■            2. 메뉴 관리           \t■");
		System.out.println("■            3. 테이블 관리          \t■");
		System.out.println("■            0. 이전 화면           \t■");
		System.out.println();
		System.out.println("==========================================================================================");
		System.out.println();
		System.out.print("선택(번호) : ");
	}

	public static int get() {
		Scanner scan = new Scanner(System.in);
		int temp = scan.nextInt();
		scan.nextLine();
		
		return temp;
	}

}