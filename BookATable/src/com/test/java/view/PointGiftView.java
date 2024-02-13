package com.test.java.view;

import java.util.Scanner;

/**
 * 포인트 선물 관련 View 클래스입니다.
 */

public class PointGiftView {
	
	/**
	 * 선물할 대상의 ID 입력받는 메서드입니다.
	 * @return 사용자가 입력한 ID
	 */
	
	public static String getId() {
		
		Scanner scan = new Scanner(System.in);
		
		String tmp = "";
		
		while(true) {
			System.out.print("선물을 원하시는 ID를 입력하세요: ");
			tmp = scan.nextLine();
			//TODO 유효성 검사 만들기
			break;
		}
		return tmp;	
	}
	
	/**
	 * 선물할 포인트 금액 입력받는 메서드입니다.
	 * @return 사용자가 입력한 포인트 금액
	 */
	public static int getAmountGift() {
		
		Scanner scan = new Scanner(System.in);
		
		int tmp = 0;
		
		while(true) {
			System.out.print("선물할 포인트 금액을 입력하세요: ");
			tmp = scan.nextInt();
			scan.nextLine();
			break;
		}
		
		return tmp;
	}

	/**
	 * 존재하지 않는 회원일 경우 메시지를 출력하는 메서드입니다.
	 */
	public void withDrawal() {

			System.out.println();
			System.out.println("■          잘못된 아이디입니다.	   	■");
			System.out.println();
			View.pause();
			
		}

	/**
	 * 현재 보유한 포인트 금액을 초과할 경우 메시지를 출력하는 메서드입니다.
	 */
	public void overAmount() {
		
		System.out.println();
		System.out.println("■          현재 보유한 포인트 금액을 초과합니다.	   	■");
		System.out.println();
		View.pause();
		
		
	}

	/**
	 * 포인트 선물 완료 메시지를 출력하는 메서드입니다.
	 * @param name 선물 받을 대상의 이름
	 */
	public void showPointGift(String name) {
		
		System.out.println();
		System.out.printf("■          %s님에게 포인트를 선물했습니다.	   	■", name);
		System.out.println();
		View.pause();
		
	}


}
