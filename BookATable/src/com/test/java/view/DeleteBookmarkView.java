package com.test.java.view;

import java.util.Scanner;

/**
 * 즐겨찾기 삭제 화면을 담당하는 View 클래스입니다.
 */
public class DeleteBookmarkView {

	/**
	 * 사용자로부터 삭제할 상호명을 입력받는 메서드입니다.
	 * @return 삭제할 상호명
	 */
	public String getStoreName() {
		Scanner scan = new Scanner(System.in);

		System.out.print("즐겨찾기 삭제를 원하는 상호명을 입력해주세요: ");
		String storeName = scan.nextLine();

		return storeName;
	}

	/**
	 * 즐겨찾기 삭제가 성공했음을 출력하는 메서드입니다
	 */
	public void deleteSuccess() {
		System.out.println();
		System.out.println("■           즐겨찾기 삭제되었습니다.			   ■");
		System.out.println();
		View.pause();
	}

	/**
	 * 즐겨찾기 삭제가 실패했음을 출력하는 메서드입니다
	 */
	public void deleteFail() {
		System.out.println();
		System.out.println("■           해당 상호명을 즐겨찾기에서 찾을 수 없습니다.			   ■");
		System.out.println();
		View.pause();

	}

}
