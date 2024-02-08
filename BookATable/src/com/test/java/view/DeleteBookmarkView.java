package com.test.java.view;

import java.util.Scanner;

public class DeleteBookmarkView {

	public String getStoreName() {
		Scanner scan = new Scanner(System.in);

		System.out.print("즐겨찾기 삭제를 원하는 상호명을 입력해주세요: ");
		String storeName = scan.nextLine();

		return storeName;
	}

	public void deleteSuccess() {
		System.out.println();
		System.out.println("■           즐겨찾기 삭제되었습니다.			   ■");
		System.out.println();
		View.pause();
	}

	public void deleteFail() {
		System.out.println();
		System.out.println("■           해당 상호명을 즐겨찾기에서 찾을 수 없습니다.			   ■");
		System.out.println();
		View.pause();

	}

}
