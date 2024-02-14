package com.test.java.view;

import java.util.Scanner;

/**
 * UpdatePwView는 사용자에게 비밀번호 변경과 관련된 화면을 제공하는 클래스입니다.
 */
public class UpdatePwView {

	/**
     * 사용자로부터 변경할 비밀번호를 입력받는 메서드입니다.
     *
     * @return 변경할 비밀번호
     */
	public static String getPw() {
		System.out.print("변경할 비밀번호 입력: ");
		Scanner scan = new Scanner(System.in);
		String temp = scan.nextLine();
		return temp;
	}

	/**
     * 비밀번호가 유효하지 않을 때의 에러 메시지를 출력하는 메서드입니다.
     */
	public static void showErrorMessage() {
		System.out.println();
		System.out.println("PW는 특수문자(!,@,#,$,%,^,&,*)를 1자 이상 포함하는 5자로 작성하십시오");
		System.out.println();
		View.pause();
	}

	 /**
     * 비밀번호 변경이 완료되었을 때의 메시지를 출력하는 메서드입니다.
     */
	public static void showUpdatePwMessage() {
		System.out.println();
		System.out.println("비밀번호가 변경되었습니다.");
		System.out.println();
		View.pause();
	}

}
