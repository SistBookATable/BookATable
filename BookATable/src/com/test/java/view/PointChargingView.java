package com.test.java.view;
import java.util.InputMismatchException;
>>>>>>> be92b070f0bdd7fe2b9ee5371a8032c292cc96f6
import java.util.Scanner;

import com.test.java.model.Member;

public class PointChargingView {
	
	public static int getAmountCharging() {
		
		Scanner scan = new Scanner(System.in);

		int tmp = 0;
		
		while(true) {
			System.out.print("충전 금액 입력: ");
			tmp = scan.nextInt();
			scan.nextLine();
			break;
	
		}
		return tmp;
	}
	
	public static String getPw() {
		
		Scanner scan = new Scanner(System.in);
		String tmp = "";
		
		while(true) {
			System.out.print("비밀번호 입력: ");
			tmp = scan.nextLine();
			//TODO 유효성 검사 만들기
			break;
		}
		return tmp;
	}
	
	public String showPointCharging(int amountCharging) {
		String tmp = "";
		tmp = amountCharging + "포인트가 충전되었습니다.";
		return tmp;
	}

}