package com.test.java.view;

import java.util.Scanner;
// 운영정보관리 선택 화면 출력하는 class
public class OperationalInfoManagementView {
	// 선택하는 메서드
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
//선택한 숫자 입력받는 메서드
	public static int get() {
		Scanner scan = new Scanner(System.in);
		int temp = scan.nextInt();
		scan.nextLine();
		
		return temp;
	}

}