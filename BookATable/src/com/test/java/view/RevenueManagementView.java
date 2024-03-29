package com.test.java.view;

import java.util.Scanner;

public class RevenueManagementView {

	public void showTitle() {

		System.out.println();
		System.out.println();
		System.out.println("┌───────────────────────────────────────────────────────┐");
		System.out.println("|                    업체 회원 - 수익 관리                  	|");
		System.out.println("└───────────────────────────────────────────────────────┘");
		
		
	}

	public void showCase1Title() {

		System.out.println();
		System.out.println();
		System.out.println("┌───────────────────────────────────────────────────────┐");
		System.out.println("|                  업체 회원 - 예상 매출 조회                	|");
		System.out.println("└───────────────────────────────────────────────────────┘");
		
		
	}
	
	public void showCase2Title() {

		System.out.println();
		System.out.println();
		System.out.println("┌───────────────────────────────────────────────────────┐");
		System.out.println("|                 업체 회원 - 정산 예약금 조회                	|");
		System.out.println("└───────────────────────────────────────────────────────┘");
		
		
	}
	
	
	public void showSelectBox() {

		System.out.println("==========================================================================================");
		System.out.println();
		System.out.println("■            1. 예상 매출 조회       \t■");
		System.out.println("■            2. 정산 예약금 조회       \t■");
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

	public void showRevenue(int revenue, String today, String name) {


		System.out.println("\t■■■■■■■■■■■■■■■■ " + name + " ■■■■■■■■■■■■■■■■");
		System.out.println("==========================================================================================");
		System.out.println();
		System.out.printf("\t  예상 매출 : %,d원 (%s)\n",revenue,today);
		System.out.println();
		System.out.println("==========================================================================================");
		System.out.println();
		System.out.println("\t(예상 매출은 예약 내역 변동에 따라 달라질 수 있습니다.)");
		
		View.pause();
	}

	public void hasNoHistoryMessage() {

		System.out.println();
		System.out.println("금일 예약 내역이 없습니다.");
		System.out.println();
		View.pause();
		
	}

	public void showDeposit(String firstDay, String today, String storeName, String userName, int i) {


		System.out.println("\t■■■■■■■■■■■■■■■■ " + storeName + " ■■■■■■■■■■■■■■■■");
		System.out.println("==========================================================================================");
		System.out.println();
		System.out.printf("\t %,d원이 %s사장님 계좌로 입금되었습니다.\n",i,userName);
		System.out.printf("\t (조회일자 : %s ~ %s)\n",firstDay,today);
		System.out.println();
		System.out.println("==========================================================================================");
		System.out.println();
		System.out.println("\t(⋇현재 화면의 금액과 실제 입금받은 금액이 상이한 경우,\n"
				+ "\t\t1:1 문의사항을 이용해주세요.)\n");
		
		View.pause();
	}

}
