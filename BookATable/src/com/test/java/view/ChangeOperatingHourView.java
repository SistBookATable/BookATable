package com.test.java.view;

import java.util.Scanner;
// 운영 시간 변경 화면 보여주는 class
public class ChangeOperatingHourView {

	public void changeOperatingHour(String licenseNumber) {
		
		
		
	}
	//수정 할 요일 입력 받는 메서드
	public static String getDay() {
	      
	      Scanner scan = new Scanner(System.in);
	      String tmp = "";
	      System.out.print("1. 수정 할 요일 : ");
	      tmp = scan.nextLine();
	      scan.close();
	      return tmp;
	   }
	// 영업 시작 시각 입력 받는 메서드
	public static String getOpen() {
	      
	      Scanner scan = new Scanner(System.in);
	      String tmp = "";
	      System.out.print("2. 영업 시작 시각 등록(0000) : ");
	      tmp = scan.nextLine();
	      scan.close();
	      return tmp;
	   }
	// 영업 종료 시각 입력 받는 메서드
	public static String getClose() {
	      
	      Scanner scan = new Scanner(System.in);
	      String tmp = "";
	      System.out.print("3. 영업 종료 시각 등록(0000) : ");
	      tmp = scan.nextLine();
	      scan.close();
	      return tmp;
	   }
	
}