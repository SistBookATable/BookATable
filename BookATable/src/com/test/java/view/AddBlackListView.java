package com.test.java.view;

import java.util.Scanner;

/**
 * 블랙리스트 등록과 관련된 사용자 인터페이스를 담당하는 뷰 클래스입니다.
 */
public class AddBlackListView {
	
	 /**
     * 블랙리스트 등록 또는 뒤로 가기 옵션을 화면에 표시합니다.
     */
	public void showSelectBox() {

		System.out.println("==========================================================================================");
		System.out.println();
		System.out.println("■           1. 블랙리스트 등록       \t■");
		System.out.println("■           0. 뒤로 가기           \t■");
		System.out.println();
		System.out.println("==========================================================================================");
		System.out.println();
		System.out.println("선택(번호) : ");
	}
	
	/**
     * 사용자로부터 선택한 옵션의 번호를 받아옵니다.
     *
     * @return 사용자 선택 번호
     */
	public int getSelectType() {
		return View.getSelectType();
	}
	
	 /**
     * 잘못된 입력값이 있을 경우 안내 메시지를 출력합니다.
     */
	public void incorrectInputMessgae() {

		System.out.println("==========================================================================================");
		System.out.println();
		System.out.println("        유효하지 않은 입력값입니다.");
		System.out.println("    (1, 0) 중에 하나를 입력해주세요");
		System.out.println();
		System.out.println("==========================================================================================");
		System.out.println();
		
		View.pause();
		
	}


	/**
     * 사용자로부터 블랙리스트에 추가할 아이디를 입력 받는 화면을 표시합니다.
     */
	public void showUserIdInputBox() {
		System.out.println();
		System.out.println("블랙리스트 등록할 아이디를 입력해주세요");
		System.out.print("선택(ID) : ");
		
	}
	
	/**
     * 사용자로부터 입력 받은 아이디를 반환합니다.
     *
     * @return 사용자 입력 아이디
     */
	public String getUserId() {
		Scanner scan = new Scanner(System.in);
		String tmp = scan.nextLine();
		return tmp;
	}
	
	/**
     * 잘못된 사용자 아이디가 입력되었을 때 안내 메시지를 출력합니다.
     */
	public void incorrectUserIDMessage() {
		System.out.println("==========================================================================================");
		System.out.println();
		System.out.println("        유효하지 않은 입력값입니다.");
		System.out.println("  위의 리스트에 있는 사용자 ID를 입력해주세요");
		System.out.println();
		System.out.println("==========================================================================================");
		System.out.println();
		
		View.pause();
		
	}

	/**
     * 이미 블랙리스트에 등록된 사용자일 경우의 안내 메시지를 출력합니다.
     */
	public void alreadyBlackListMessage() {
		System.out.println("==========================================================================================");
		System.out.println();
		System.out.println("        이미 블랙리스트에 등록된 회원입니다.");
		System.out.println();
		System.out.println("==========================================================================================");
		System.out.println();
		
		View.pause();
		
	}

	/**
     * 블랙리스트 등록이 성공했을 때의 안내 메시지를 출력합니다.
     */
	public void successMessage() {
		System.out.println("==========================================================================================");
		System.out.println();
		System.out.println("        블랙리스트로 등록 되었습니다.");
		System.out.println();
		System.out.println("==========================================================================================");
		System.out.println();
		
		View.pause();
		
	}

}
