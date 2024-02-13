package com.test.java.view;

import java.util.Scanner;

/**
 * UpdateAccountView는 사용자의 출금계좌 정보 변경과 관련된 뷰를 담당하는 클래스입니다.
 */
public class UpdateAccountView {

	 /**
     * 사용자가 변경하려는 은행을 선택하는 메서드입니다.
     *
     * @return 선택한 은행
     */
	public static String getBank() {
		Scanner scan = new Scanner(System.in);
		String tmp = "";
		System.out.println("사용계좌 은행을 선택해 주세요");
		System.out.println("1. SC제일은행");
		System.out.println("2. 신한은행");
		System.out.println("3. 씨티은행");
		System.out.println("4. DGB대구은행");
		System.out.println("5. 케이뱅크");
		System.out.println("6. NH농협은행");
		System.out.println("7. 우리은행");
		System.out.println("8. 부산은행");
		System.out.println("9. 카카오뱅크");
		System.out.println("10. IBK기업은행");
		System.out.println("11. KEB하나은행");
		System.out.print("입력 (번호) : ");
		tmp = scan.nextLine();
		return tmp;
	}

	/**
     * 사용자로부터 새로운 계좌번호를 입력받는 메서드입니다.
     *
     * @return 새로운 계좌번호
     */
	public static String getAccount() {
		System.out.print("새 계좌번호 입력: ");
		Scanner scan = new Scanner(System.in);
		String temp = scan.nextLine();
		return temp;
	}

	 /**
     * 변경하려는 출금계좌가 맞는지 확인하는 메서드입니다.
     *
     * @param toUpdateAccount 변경하려는 출금계좌번호
     */
	public static void showUpdateAccount(String toUpdateAccount) {
		System.out.printf("변경할 출금계좌가 [%s]가 맞습니까?\n", toUpdateAccount);
	}

	 /**
     * 사용자가 변경을 계속할지 여부를 입력받는 메서드입니다.
     *
     * @return 사용자의 입력 (Y/N)
     */
	public static String getAnswer() {
		System.out.print("입력 (Y/N): ");
		Scanner scan = new Scanner(System.in);
		String temp = scan.nextLine();
		return temp;
	}

}
