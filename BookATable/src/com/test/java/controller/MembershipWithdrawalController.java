package com.test.java.controller;

import java.util.ArrayList;
import java.util.Iterator;

import com.test.java.model.BusinessUser;
import com.test.java.model.Member;
import com.test.java.model.MembershipWithdrawal;
import com.test.java.repository.Data;
import com.test.java.view.MainView;
import com.test.java.view.MembershipWithdrawalView;

public class MembershipWithdrawalController {

	private MembershipWithdrawal membershipWithdrawal;
	private BusinessUser businessUser;
	private MembershipWithdrawalView membershipWithdrawalView;
	LogOutController logOutController = new LogOutController();
	ArrayList<BusinessUser> pw = new ArrayList<BusinessUser>();
	
	public MembershipWithdrawalController() {
		this.membershipWithdrawalView = new MembershipWithdrawalView();
	}
	
	public void membershipWithdrawal() {
		membershipWithdrawalView.showdrawalLogo();

		boolean loop = true;
		while(loop) {

			membershipWithdrawalView.inputInfo();
			String inputPassword = membershipWithdrawalView.get();
			//String businessPw = businessUser.getPw();
			for(Iterator<Member> itr = Data.memberList.iterator(); itr.hasNext();) {	// Data.memberList의 iterator() 생성
				Member b = itr.next();													// itr의 다음요소 존재여부 확인
				if(b.getId().equals(Member.id)) {   		// id돌면서					// itr의 다음요소를 확인 후 b에 넣음	
					if(b.getPw().equals(inputPassword)) {	// member.id가 로그인하면서 계속 돔
						itr.remove();
						membershipWithdrawalView.withDrawal();
						logOutController.logOut();
						
						loop = false;   
					} else {
						membershipWithdrawalView.noneWithDrawal();
						//membershipWithdrawalView.backPage();
						//membershipWithdrawalView.get();
						break;
					}
				}
			}
		}
	}
}
//         for(Member b : Data.memberList) {
//            if(b.getId().equals(Member.id)) {   // id돌면서
//               if(b.getPw().equals(inputPassword)) {
//                  int index=Data.memberList.indexOf(b);
//                                                // member.id가 로그인하면서 계속 돔
//                  Data.memberList.remove(index);
//                  membershipWithdrawalView.withDrawal();
//                  loop = false;   
//               } else {
//                  membershipWithdrawalView.noneWithDrawal();
//                  break;
//               }
//            }
//            if(inputPassword.equals(businessPw)) {
//               System.out.println("회원 탈퇴를 완료했습니다.");
//               loop = false;
//            } else {
//               System.out.println("비밀번호가 일치하지 않습니다.");
//               continue;
//            }

//         for(Member b : Data.memberList) {
//            System.out.println(b.getName());
//         }