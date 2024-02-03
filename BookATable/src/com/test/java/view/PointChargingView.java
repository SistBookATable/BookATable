package com.test.java.view;
import java.util.Scanner;

import com.test.java.model.Member;

public class PointChargingView {
	private static Scanner scan = new Scanner(System.in);
	
	public static int getAmountCharging() {

		int tmp = 0;
		
		while(true) {
			System.out.print("충전 금액 입력: ");
			tmp = scan.nextInt();
			scan.nextLine();
			break;
				
			//TODO 유효성 검사 만들기
//			if(isValid(tmp)) {
//				break;
//			}
		}
		return tmp;
	}
	
	public static String getPw() {
		
		String tmp = "";
		
		while(true) {
			System.out.print("비밀번호 입력: ");
			tmp = scan.nextLine();
			//TODO 유효성 검사 만들기
			break;
		}
		return tmp;
	}

}