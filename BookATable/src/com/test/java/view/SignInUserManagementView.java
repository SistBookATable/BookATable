package com.test.java.view;

import com.test.java.model.Member;
import com.test.java.model.User;
import com.test.java.repository.Data;

public class SignInUserManagementView {

	public static void findAllUser() {

		System.out.println();
		System.out.println();
		System.out.println("┌───────────────────────────────────────────────────────┐");
		System.out.println("|                  회원 관리 - 가입 회원 조회                 ■");
		System.out.println("└───────────────────────────────────────────────────────┘");
		System.out.println();
		
		String header = String.format("%15s%15s%15s%15s%15s%15s", "[회원ID]","[가입일]","[회원 이름]","[예약 횟수]","[노쇼 횟수]","[정지 여부]");
		System.out.println(header);
		
		for(Member m : Data.memberList) {
			String tmp = "";
			if(m.getUserType() == 1) {
				tmp = String.format("%15s%18s%15s%15d회%15d회%15s", 
						m.getId(),
						m.getSignIn(),
						m.getName(),
						((User)m).getNoshowCount(),
						((User)m).getReservationCount(),
						((User)m).getNoshowCount()>10? "정지회원입니다.":" ");
				System.out.println(tmp);
			}
			
		}
		View.pause();
	}

}
