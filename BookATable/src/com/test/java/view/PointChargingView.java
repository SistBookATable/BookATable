package com.test.java.view;

import java.util.Scanner;

import com.test.java.model.Member;

public class PointChargingView {
	
	private static Scanner scan = new Scanner(System.in);
	
	
	public void showPointChargingView() {	

		System.out.println();
		System.out.println();
		System.out.println("┌───────────────────────────────────────────────────────┐");
		System.out.println("|                		포인트 충전하기	                    ■");
		System.out.println("└───────────────────────────────────────────────────────┘");
		System.out.println();

	
	}

	public static int getamountCharging() {
		int tmp = 0;
		
		while(true) {
			System.out.print("포인트 충전금액: ");
			tmp = scan.nextInt();
			//TODO 유효성 검사 만들기, 숫자 외 입력시 "잘못된 입력입니다" 출력 후 이전 화면 이동
//			if(isValid(tmp)) {
//				break;
//			}
			break;
		}
		
		return tmp;
	}
	
	
	public static String getPw() {
		String tmp ="";
		while(true) {
			
			System.out.print("비밀번호 입력: ");
			tmp = scan.nextLine();
			
			//TODO 유효성 검사 만들기, 본인 비밀번호가 아닐 경우, "잘못된 비밀번호입니다." 출력
//			if(isValid(tmp)) {
//				break;
//			}
			break;
		}
		 return tmp;
		 
	}
	
	// 유효성 검사에 모두 통과되었을 경우, "포인트 충전되었습니다." 출력. 
	public void displayMessage(String message) {
		System.out.println(message);
	}
}