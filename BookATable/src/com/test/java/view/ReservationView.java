package com.test.java.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.test.java.model.Request;
import com.test.java.model.Reservation;
import com.test.java.repository.Data;

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

	public void showTitle() {

		System.out.println();
		System.out.println();
		System.out.println("┌───────────────────────────────────────────────────────┐");
		System.out.println("|                   업체 회원 - 예약관리                    <");
		System.out.println("└───────────────────────────────────────────────────────┘");
		
	}

	public void showSelectBox() {

		System.out.println("==========================================================================================");
		System.out.println();
		System.out.println("■            1. 예약 현황 조회       \t■");
		System.out.println("■            2. 방문 고객 조회       \t■");
		System.out.println("■            0. 이전 화면	         \t■");
		System.out.println();
		System.out.println("==========================================================================================");
		System.out.println();
		System.out.println("선택(번호) : ");
		
	}

	public int getSelectType() {
		Scanner scan = new Scanner(System.in);
		int tmp = scan.nextInt();
		scan.nextLine();
		return tmp;
	}

	public void showReservationList(ArrayList<Reservation> cur) {

		System.out.println();
		System.out.println();
		System.out.println("┌───────────────────────────────────────────────────────┐");
		System.out.println("|                 예약 관리 - 예약 현황 조회                 <");
		System.out.println("└───────────────────────────────────────────────────────┘");
		System.out.println();
		
		String header = String.format("%6s%15s\t%10s\t\t%-15s%-15s", "[예약 시간]","[예약자]","[예약 테이블]","[인원]","[예약 메뉴]");
		System.out.println(header);
		

		for(Reservation r : cur) {
			String tmp = "";
			tmp = String.format("%6s%18s%20s\t%15s명\t",
					r.getReservationTime(),
					r.getUserId(),
					r.getTableCapacity(),
					r.getNumOfPeople());
			
			for(String name : r.getMenulist()) {
				tmp += name + ",";
			}
			
			System.out.println(tmp);
			
		}
		
		View.pause();
		
	}

	public void showNoCurrentResevationMessage() {

		System.out.println();
		System.out.println("현재 예약 내역이 없습니다.");
		System.out.println();
		View.pause();
		
	}

	public void showNoResevationHistoryMessage() {

		System.out.println();
		System.out.println("방문 기록이 없습니다.");
		System.out.println();
		View.pause();
	}

	public void showVistedReservationHeader() {
		System.out.println();
		System.out.println();
		System.out.println("┌───────────────────────────────────────────────────────┐");
		System.out.println("|                 예약 관리 - 방문 고객 조회                 <");
		System.out.println("└───────────────────────────────────────────────────────┘");
		System.out.println();
		
		String header = String.format("%6s%15s%15s\t%10s\t\t%-15s%-15s\t%-15s", "[예약 시간]","[예약자ID]","[예약자]","[예약 테이블]","[인원]","[방문여부]","[예약 메뉴]");
		System.out.println(header);
		
	}
	

	public void showOneReservation(Reservation r, String name) {

		String tmp = "";
		tmp = String.format("%6s%18s%15s%20s인\t%15s명%15s\t",
				r.getReservationTime(),
				r.getUserId(),
				name,
				r.getTableCapacity(),
				r.getNumOfPeople(),
				r.getState());

		for(String menuname : r.getMenulist()) {
			tmp += menuname + ",";
		}
		
		System.out.println(tmp);
		View.pause();
	}
	

}//ReservationView
