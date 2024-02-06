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
	
	

	public String showPointGift(String id, String name) {
		String tmp = "";
		tmp = name + "님에게 포인트를 선물했습니다.";
		return tmp;
	}


}
