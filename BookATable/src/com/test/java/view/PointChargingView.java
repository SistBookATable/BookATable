package com.test.java.view;
import java.util.Scanner;

import com.test.java.model.Member;

public class PointChargingView {
	
	public int getAmountCharging() {
		Scanner scan = new Scanner(System.in);
		int tmp = 0;
		
		//TODO 유효성 검사 나중에
			System.out.print("포인트 충전금액: ");
			tmp = scan.nextInt();
			return tmp;
		}
	
	
	public String getPw() {
		
		Scanner scan = new Scanner(System.in);
		String tmp = "";

		// TODO 유효성 검사 나중에 
			System.out.print("비밀번호 입력: ");
			tmp = scan.nextLine();

				return tmp;	
	}
	
	public void showPointCharging (int amountCharging) {
		System.out.println("----------------------");
		System.out.printf("%d 포인트가 충전되었습니다.", amountCharging);
		System.out.println("----------------------");
	}
}
	