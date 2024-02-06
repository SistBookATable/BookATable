package com.test.java.view;

import java.util.Scanner;

public class ChangeBreakHourView {
	
	public  void changeBreakHour(String licenseNumber) {
		// 
		
	}
	
	
	public static String getDay() {
	      
	      Scanner scan = new Scanner(System.in);
	      String tmp = "";
	      System.out.print("1. 수정 할 요일 : ");
	      tmp = scan.nextLine();
	      return tmp;
	   }
	
	public static String getOpen() {
	      
	      Scanner scan = new Scanner(System.in);
	      String tmp = "";
	      System.out.print("2. 휴게 시작 시각 등록(00:00) : ");
	      tmp = scan.nextLine();
	      return tmp;
	   }
	
	public static String getClose() {
	      
	      Scanner scan = new Scanner(System.in);
	      String tmp = "";
	      System.out.print("3. 휴게 종료 시각 등록(00:00) : ");
	      tmp = scan.nextLine();
	      return tmp;
	   }

	

}