package com.test.java.view;

import java.util.Scanner;

public class BusinessUserInquiryView {
	
	public void showChoice(){
		
		System.out.println("1. 문의하기");
		System.out.println("2. 문의 내역 조회");
		System.out.println("0. 뒤로 가기");
		
		
	}
	
	public static int get() {
		Scanner scan=new Scanner(System.in);
		System.out.println("선택(번호) : ");
		int temp=0;
		temp=scan.nextInt();
		return temp;
	}

}
