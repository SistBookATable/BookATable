package com.test.java.view;

import java.util.Scanner;

public class FavoriteStoreManagementView {
	
	public static void showFavoriteStoreManagement() {
		System.out.println();
		System.out.println();
		System.out.println("==========================================================================================");
		System.out.println();
		System.out.println("■           1. 작성 리뷰 조회		   ■");
		System.out.println("■           2. 즐겨찾기 조회		   ■");
		System.out.println("■           3. 즐겨찾기 삭제		   ■");
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
		
		return temp;
	}

}
