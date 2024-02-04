package com.test.java.view;

import java.util.Scanner;

public class PointChargingView {

	public static int getAmountCharging() {
		Scanner scan = new Scanner(System.in);
		int tmp = 0;

		while (true) {
			System.out.print("충전 금액 입력: ");
			tmp = scan.nextInt();
			scan.nextLine();
			// TODO 유효성 검사 만들기
//			if(isValid(tmp)) {
//				break;
//			}
			break;
		}
		return tmp;
	}

	public static String getPw() {
		Scanner scan = new Scanner(System.in);
		String tmp = "";

		while (true) {
			System.out.print("비밀번호 입력: ");
			tmp = scan.nextLine();
			// TODO 유효성 검사 만들기
			// TODO 유효성 검사 만들기
//			if(isValid(tmp)) {
//				break;
//			}
			break;
		}
		return tmp;
	}

}