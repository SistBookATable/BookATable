package com.test.java.view;

import java.util.Scanner;

public class UnableReservationTableView {
	
	public static int getTableCapacity() {
		int temp=0;
		Scanner scan = new Scanner(System.in);
		System.out.println("예약 불가로 전환할 테이블 사이즈를 입력하세요 : ");
		temp=scan.nextInt();
		return temp;
	}

}
