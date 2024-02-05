package com.test.java.view;

import java.util.Scanner;

public class BookmarkHistoryView {
	
	public void showBookmarkHistory(String name, String storeName, String storeTelNumber, String menuName) {
		
		System.out.println("------------------------------------------------------------------------------------------");
		System.out.println();
		System.out.printf("■           %s님 즐겨찾기		   ■", name);
		System.out.println();
		System.out.println("------------------------------------------------------------------------------------------");

		System.out.println();
		System.out.println("[상호명]\t[전화번호]\t\t[메뉴]");
		System.out.printf("%s %s %s", storeName, storeTelNumber, menuName);
		System.out.println();
		System.out.println("------------------------------------------------------------------------------------------");
		System.out.println();
		System.out.println("■           1. 상세페이지 이동		   ■");
		System.out.println("■           2. 즐겨찾기 삭제		   ■");
		System.out.println("■           0. 이전 화면			   ■");
		System.out.println();
		System.out.println("------------------------------------------------------------------------------------------");
		
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
