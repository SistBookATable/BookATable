package com.test.java.view;

import java.util.Scanner;
//테이블 관리 화면 출력하는 class
public class TableManagementView {
	//선택 메서드
public void showChoice(){
		
		System.out.println("==========================================================================================");
		System.out.println();
		System.out.println("■           1. 테이블 정보 등록		■");
		System.out.println("■           2. 테이블 정보 수정		■");
		System.out.println("■           3. 테이블 삭제		  	■");
		System.out.println("■           4. 예약 불가 테이블 지정	   	■");
		System.out.println("■           5. 예약 불가 테이블 해제	   	■");
		System.out.println("■           0. 이전 화면으로	    	■");
		System.out.println();
		System.out.println("==========================================================================================");
		System.out.println();
		System.out.print("선택(번호) : ");
	}
//선택한 번호 입력받는 메서드
	public static int get() {
		Scanner scan = new Scanner(System.in);
		int temp = scan.nextInt();
		scan.nextLine();
		
		return temp;
	}

}
