package com.test.java.view;

public class CustomerManagementView {

	public void showTitle() {
		System.out.println();
		System.out.println();
		System.out.println("┌───────────────────────────────────────────────────────┐");
		System.out.println("|                   업체 회원 - 고객 관리                  	|");
		System.out.println("└───────────────────────────────────────────────────────┘");
	}
	public void showSelectBox() {

		System.out.println("==========================================================================================");
		System.out.println();
		System.out.println("■            1. 단골 고객 관리       \t■");
		System.out.println("■            2. 블랙리스트 관리      \t■");
		System.out.println("■            0. 이전 화면	         \t■");
		System.out.println();
		System.out.println("==========================================================================================");
		System.out.println();
		System.out.print("선택(번호) : ");
		
		
	}
	public int getSelectType() {
		return View.getSelectType();
	}
	public void incorrectInputMessage() {
		System.out.println("==========================================================================================");
		System.out.println();
		System.out.println("        유효하지 않은 입력값입니다.");
		System.out.println("     (1, 2, 0) 중에 하나를 입력해주세요");
		System.out.println();
		System.out.println("==========================================================================================");
		System.out.println();
		
		View.pause();
	}
	public void hasNoHistory() {


		System.out.println("==========================================================================================");
		System.out.println();
		System.out.println("        단골 고객이 없습니다.");
		System.out.println();
		System.out.println("==========================================================================================");
		System.out.println();
		
		View.pause();
		
	}
	public void showCustomerList(String userName, int count, String menuName, int cnt) {
		System.out.printf("\t%d\t%s\t%s(%d회)\n", count, userName, menuName, cnt);	
	}
	public void showCustomerTitle() {
		System.out.println();
		System.out.println();
		System.out.println("┌───────────────────────────────────────────────────────┐");
		System.out.println("|           업체 회원 - 고객 관리 - 단골 고객 리스트            	|");
		System.out.println("└───────────────────────────────────────────────────────┘");
		System.out.println();
		System.out.printf("\t%s\t%s\t%s\n", "이용횟수","회원명","최다 주문 메뉴");	
	}
	public void pause() {
		View.pause();
		
	}
	public void hasNoBlackList() {

		System.out.println("==========================================================================================");
		System.out.println();
		System.out.println("       노쇼 고객이 없습니다.");
		System.out.println();
		System.out.println("==========================================================================================");
		System.out.println();
		
		View.pause();
	}
	public void showBlackListTitle() {
		System.out.println();
		System.out.println();
		System.out.println("┌───────────────────────────────────────────────────────┐");
		System.out.println("|              업체 회원 - 고객 관리 - 블랙리스트              	|");
		System.out.println("└───────────────────────────────────────────────────────┘");
		System.out.println();
		System.out.printf("\t%s\t%s\t%s\n", "노쇼횟수","회원ID","사용 제한 여부");	
		
	}
	public void showBlackList(int count, String key, boolean stop) {
		System.out.printf("\t%d\t%s\t%s\n", count, key, stop==true? "사용제한":"");	
		
	}
	
	

}
