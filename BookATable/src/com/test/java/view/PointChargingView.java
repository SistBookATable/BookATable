package com.test.java.view;
import java.util.Scanner;

import java.util.Scanner;

/**
 *  포인트 충전과 관련된 View 클래스입니다.
 */

public class PointChargingView {
	
	/**
	 * 충전할 금액을 입력받는 메서드입니다.
	 * @return 입력된 충전 금액
	 */
	
	public static int getAmountCharging() {
		Scanner scan = new Scanner(System.in);
		int tmp = 0;

		while (true) {
			System.out.print("충전 금액 입력: ");
			tmp = scan.nextInt();
			scan.nextLine();
			break;
		}
		return tmp;
	}

	/**
	 * 사용자의 비밀번호를 입력받는 메서드입니다.
	 * @return 입력된 비밀번호
	 */
	public static String getPw() {
		Scanner scan = new Scanner(System.in);
		String tmp = "";

		while (true) {
			System.out.print("비밀번호 입력: ");
			tmp = scan.nextLine();
			break;
		}
		return tmp;
	}
	/**
	 * 충전 결과를 출력하는 메서드입니다. 
	 * @param amountCharging 충전된 금액
	 */
	public void showPointCharging(int amountCharging) {
		System.out.println();
		System.out.printf("■         %d 포인트가 충전되었습니다.		 ■", amountCharging);
		System.out.println();
		View.pause();
		
	}

}