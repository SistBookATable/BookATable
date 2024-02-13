package com.test.java.controller;

import com.test.java.model.Member;
import com.test.java.model.User;
import com.test.java.repository.Data;
import com.test.java.view.UpdateAccountView;
import com.test.java.view.UpdatePwView;
import com.test.java.view.View;

/**
 * UpdateAccountController는 사용자의 계좌 정보를 변경하는 클래스입니다.
 */
public class UpdateAccountController {
	
	/**
     * 사용자의 계좌 정보를 변경하는 메서드입니다.
     */
	public void updateAccount() {

		boolean loop = true;
		while (loop) {
			String toUpdateAccount = UpdateAccountView.getAccount();
			if (!isValidOfAccount(toUpdateAccount)) {
				loop = true;
			} else {
				UpdateAccountView.showUpdateAccount(toUpdateAccount);
				String answer = UpdateAccountView.getAnswer();
				
				if (answer.equalsIgnoreCase("N")) {
					System.out.println("계좌번호 변경을 취소하겠습니다.\n");
					System.out.println("다시 입력해주시길 바랍니다.\n");
					View.pause();
					loop = true;
				} else if (answer.equalsIgnoreCase("Y")){
					updateAccountToInputAccount(Member.id, toUpdateAccount);
					System.out.println("계좌번호가 변경되었습니다.\n");
					View.pause();
					loop = false;
				}
				
			} //else

		}//while(loop)
	}

	/**
     * 입력된 계좌번호의 유효성을 검사하는 메서드입니다.
     *
     * @param toUpdateAccount 변경하려는 계좌번호
     * @return 계좌번호의 유효성 여부
     */
	private boolean isValidOfAccount(String toUpdateAccount) {
		return false;
	}

	/**
     * 계좌번호를 입력된 계좌번호로 변경하는 메서드입니다.
     *
     * @param id              사용자 ID
     * @param toUpdateAccount 변경하려는 계좌번호
     */
	private void updateAccountToInputAccount(String id, String toUpdateAccount) {
		for (Member u : Data.memberList) {
			if (u.getId().equals(id)) {
				((User) u).setAccount(toUpdateAccount);
			}
		}
	}

}
