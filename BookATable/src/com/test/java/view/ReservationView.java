package com.test.java.view;

import java.util.Scanner;

public class ReservationView {
	
	public int getReservationNum() {
		
		Scanner scan=new Scanner(System.in);
		int tmp=0;
		
		while(true) {
			System.out.print("인원 수(숫자) : ");
			tmp=scan.nextInt();
			//유효성 검사{
		//
			// break;    }
			break;
		}
		
		return tmp;
	}
	
	public String getReservationDate() {
			
			Scanner scan=new Scanner(System.in);
			String tmp="";
			
			while(true) {
				//예약 달력
				System.out.print("예약 날짜(월일 0000) : ");
				tmp=scan.nextLine();
				//유효성 검사{
			//
				// break;    }
				break;
			}
			
			return tmp;
		}
		
	
	public String getReservationTime() {
		
		Scanner scan=new Scanner(System.in);
		String tmp="";
		
		while(true) {
			//예약 타임 표
			System.out.print("예약 시간(00:00) : ");
			tmp=scan.nextLine();
			//유효성 검사{
		//
			// break;    }
			break;
		}
		
		return tmp;
	}
	
	
	public String getReservationMenu() {
			
			Scanner scan=new Scanner(System.in);
			String tmp="";
			
			while(true) {
				//메뉴 리스트
				System.out.print("예약 메뉴(메뉴 번호, 주문 개수) : ");
				tmp=scan.nextLine();
				//유효성 검사{
			//
				// break;    }
				break;
			}
			
			return tmp;
		}
	
	public String showReservation(int num, String date, String time, String menu) {
		String tmp="";
		tmp=num+","+date+","+time+","+menu;
		return tmp;
	}
	
	
	

}//ReservationView
