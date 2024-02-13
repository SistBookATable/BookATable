package com.test.java.view;

import java.util.Scanner;

/**
 * UpdatePhoneNumberView는 전화번호 변경과 관련된 사용자 인터페이스를 담당하는 클래스입니다.
 */
public class UpdatePhoneNumberView {

	/**
     * 사용자에게 변경할 전화번호를 입력받는 메서드입니다.
     *
     * @return 변경할 전화번호
     */
	public static String getPhoneNumber() {
		Scanner scan = new Scanner(System.in);
		System.out.print("변경할 전화번호 입력: ");
		return scan.nextLine();
	}
	
	 /**
     * 전화번호 입력이 올바르지 않을 경우의 에러 메시지를 출력하는 메서드입니다.
     */
	public static void showErrorMessage() {
		System.out.println();
		System.out.println("전화번호를 숫자와 “-”로만 구성하여  [000-0000-0000] 형식으로 작성하십시오");
		System.out.println();
		View.pause();
	}

	 /**
     * 변경할 전화번호를 사용자에게 확인하도록 출력하는 메서드입니다.
     *
     * @param toUpdatePhoneNumber 변경할 전화번호
     */
	public static void showUpdatePhoneNumber(String toUpdatePhoneNumber) {
		System.out.printf("변경할 전화번호가 [%s]가 맞습니까?\n", toUpdatePhoneNumber);
	}

	/**
     * 변경 내용을 사용자에게 확인하도록 출력하는 메서드입니다.
     *
     * @return 사용자의 입력 (Y/N)
     */
	public static String getAnswer() {
		System.out.print("입력 (Y/N): ");
		Scanner scan = new Scanner(System.in);
		String temp = scan.nextLine();
		return temp;
	}

	/**
     * 변경이 취소되었음을 알리는 메시지를 출력하는 메서드입니다.
     */
	public static void showUpdateStopMessage() {
		System.out.println();
		System.out.println("전화번호 변경을 취소하겠습니다.");
		System.out.println("다시 입력해주시길 바랍니다.");
		System.out.println();
		View.pause();
	}

	/**
     * 전화번호 변경이 완료되었음을 알리는 메시지를 출력하는 메서드입니다.
     */
	public static void showUpdatePhoneNumberMessage() {
		System.out.println();
		System.out.println("전화번호가 변경되었습니다.");
		System.out.println();
		View.pause();
	}

}
