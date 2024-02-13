package com.test.java.controller;

import java.util.ArrayList;
import java.util.Iterator;

import com.test.java.model.BusinessUser;
import com.test.java.model.Member;
import com.test.java.repository.Data;
import com.test.java.view.MainView;
import com.test.java.view.MembershipWithdrawalView;

/**
 * 회원탈퇴 기능을 제공하는 MembershipWithdrawalController 클래스
 */
public class MembershipWithdrawalController {

	private MembershipWithdrawalView membershipWithdrawalView;
	LogOutController logOutController = new LogOutController();
	
	/**
	 * MembershipWithdrawalController의 생성자
	 */
	public MembershipWithdrawalController() {
		this.membershipWithdrawalView = new MembershipWithdrawalView();
	}
	
	/**
	 * 회원탈퇴 후 회원을 제거하고 로그아웃을 하는 membershipWithdrawal 메서드
	 * 회원이 탈퇴할 때 list의 요소를 제거해야 하므로 iterator를 사용하여 다음 요소가 있는지 확인 후
	 * 회원탈퇴 시 입력한 비밀번호와 memberList의 비밀번호와 일치한 값이 있다면 회원을 삭제하고 logOut 시킴
	 */
	public void membershipWithdrawal() {
		membershipWithdrawalView.showdrawalLogo();

		boolean loop = true;
		while(loop) {
			membershipWithdrawalView.inputInfo();
			String inputPassword = membershipWithdrawalView.get();
			for(Iterator<Member> itr = Data.memberList.iterator(); itr.hasNext();) {	// Data.memberList의 iterator() 생성
				Member b = itr.next();													// itr의 다음요소 존재여부 확인
				if(b.getId().equals(Member.id)) {   									// itr의 다음요소를 확인 후 b에 넣음	
					if(b.getPw().equals(inputPassword)) {	
						itr.remove();
						membershipWithdrawalView.withDrawal();
						logOutController.logOut();
						// false가 되면 해당 메서드를 호출한 곳으로 이동
						loop = false;   
					} else {
						membershipWithdrawalView.noneWithDrawal();
						break;
					}
				}
			}
		}
	}
}