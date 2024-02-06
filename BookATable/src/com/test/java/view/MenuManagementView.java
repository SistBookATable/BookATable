package com.test.java.view;

import java.util.Scanner;

public class MenuManagementView {

public void showChoice(){
		
		System.out.println("==========================================================================================");
		System.out.println();
		System.out.println("■           1. 메뉴 등록			   ■");
		System.out.println("■           2. 메뉴 수정			   ■");
		System.out.println("■           3. 메뉴 삭제		   ■");
		System.out.println("■           0. 이전 화면으로 돌아가기	   	■");
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