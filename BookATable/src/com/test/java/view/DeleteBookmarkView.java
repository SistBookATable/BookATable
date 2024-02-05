package com.test.java.view;

import java.util.Scanner;

public class DeleteBookmarkView {
	
	public static String getStoreName() {
		Scanner scan = new Scanner(System.in);

		System.out.print("즐겨찾기 삭제를 원하는 상호명을 입력해주세요: ");
		String storeName = scan.nextLine();
			
			
		return storeName;
	}
	
	public void message() {
		
		System.out.println("즐겨찾기 삭제되었습니다.");
		
		
	}

}
