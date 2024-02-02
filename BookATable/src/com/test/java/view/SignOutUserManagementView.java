package com.test.java.view;

import com.test.java.model.Member;
import com.test.java.model.User;
import com.test.java.repository.Data;

public class SignOutUserManagementView {

	public static void findAllSignOutUser() {

		System.out.println();
		System.out.println();
		System.out.println("┌───────────────────────────────────────────────────────┐");
		System.out.println("|                  회원 관리 - 탈퇴 회원 조회                <");
		System.out.println("└───────────────────────────────────────────────────────┘");
		System.out.println();
		
		String header = String.format("%15s%18s%15s%15s%15s%15s", "[회원ID]","[회원 이름]","[예약 횟수]","[노쇼 횟수]","[탈퇴일]","[정지 여부]");
		System.out.println(header);
		
		for(Member m : Data.memberList) {
			String tmp = "";
			if(m.getUserType() == 1 && !((User)m).getSignOut().equals("null")) {
				tmp = String.format("%15s%17s%15d회%15d회%19s%15s", 
						m.getId(),
						m.getName(),
						((User)m).getReservationCount(),
						((User)m).getNoshowCount(),
						((User)m).getSignOut(),
						(((User)m).getNoshowCount() >= 10)? "정지회원":" ");
				System.out.println(tmp);
			}
			
		}
		
	}

}
