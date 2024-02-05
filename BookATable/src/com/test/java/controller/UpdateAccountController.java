package com.test.java.controller;

import com.test.java.model.Member;
import com.test.java.model.User;
import com.test.java.repository.Data;
import com.test.java.view.UpdateAccountView;
import com.test.java.view.UpdatePwView;
import com.test.java.view.View;

public class UpdateAccountController {

	public void updateAccount() {

		boolean loop = true;
		while (loop) {

			String toUpdateAccount = UpdateAccountView.getAccount();

			// TODO 유효성 검사
			// isValidOfAccount(toUpdateAccount);

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

		}
	}

	private void updateAccountToInputAccount(String id, String toUpdateAccount) {
		for (Member u : Data.memberList) {
			if (u.getId().equals(id)) {
				((User) u).setAccount(toUpdateAccount);
			}
		}
	}

}
