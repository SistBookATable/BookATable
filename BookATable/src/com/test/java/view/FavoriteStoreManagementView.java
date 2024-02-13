package com.test.java.view;

import java.util.Scanner;

/**
 * 사용자에게 즐겨찾는 매장 관리 화면을 보여주는 View 클래스입니다.
 */
public class FavoriteStoreManagementView {
	
	/**
	 * 즐겨찾는 매장 관리 화면을 출력하는 메서드입니다.
	 * 사용자가 선택할 수 있는 메뉴를 보여줍니다.
	 */
	public static void showFavoriteStoreManagement() {
		System.out.println();
		System.out.println();
		System.out.println("==========================================================================================");
		System.out.println();
		System.out.println("■           1. 작성 리뷰 조회		   ■");
		System.out.println("■           2. 즐겨찾기 조회 및 삭제		   ■");
//		System.out.println("■           3. 즐겨찾기 삭제		   ■");
		System.out.println("■           0. 이전 화면			   ■");
		System.out.println();
		System.out.println("==========================================================================================");
		System.out.println();
		System.out.print("선택(번호) : ");
	}
	
	/**
	 * 사용자의 선택을 입력받는 메서드입니다.
	 * @return 사용자가 선택한 번호
	 */
	public static int get() {
		
		Scanner scan = new Scanner(System.in);
		int temp = scan.nextInt();
		scan.nextLine();
		
		return temp;
	}

}
