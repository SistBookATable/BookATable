package com.test.java.view;

import java.util.Scanner;

public class PointGiftView {
	
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

	public void withDrawal() {

			System.out.println();
			System.out.println("■          잘못된 아이디입니다.	   	■");
			System.out.println();
			View.pause();
			
		}

	public void overAmount() {
		
		System.out.println();
		System.out.println("■          현재 보유한 포인트 금액을 초과합니다.	   	■");
		System.out.println();
		View.pause();
		
		
	}

	public void showPointGift(String name) {
		
		System.out.println();
		System.out.printf("■          %s님에게 포인트를 선물했습니다.	   	■", name);
		System.out.println();
		View.pause();
		
	}


}
