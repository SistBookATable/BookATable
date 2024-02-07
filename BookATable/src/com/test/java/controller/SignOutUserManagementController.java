package com.test.java.controller;

import java.util.ArrayList;
import java.util.Collections;

import com.test.java.model.BusinessUser;
import com.test.java.model.Member;
import com.test.java.repository.MemberRepository;
import com.test.java.repository.StoreRepository;
import com.test.java.view.SignOutUserManagementView;

public class SignOutUserManagementController {

	SignOutUserManagementView signOutUserManagementView = new SignOutUserManagementView();
	
	public void signOutUserManagement() {
		
		boolean loop = true;
		while(loop) {
			signOutUserManagementView.showTitle();
			ArrayList<Member> memberList = MemberRepository.findAllSingOutUser();
			Collections.sort(memberList, (o1,o2)->o1.getSignOut().compareTo(o2.getSignOut()));
			
			signOutUserManagementView.showAllSignOutUser(memberList);
			signOutUserManagementView.showSelectBox();
			int choice = signOutUserManagementView.getSelectType();
			
			switch(choice) {
			case 1:
				//탈퇴 회원 정보 삭제 
				
				//아이디 입력 받기
				String id = signOutUserManagementView.getId();
				
				//리스트에서 멤버 조회
				Member selected = find(memberList,id);
				
				if(selected==null) {
					signOutUserManagementView.incorrectIdMessage();
					continue;
				}
				
				
				MemberRepository.deleteUser(id);
			
				if(selected.getUserType()==2) {
					String lisenceNumber = ((BusinessUser)selected).getLicenseNumber();
					StoreRepository.delete(lisenceNumber);
				}
				
				break;
			case 0:
				loop = false;
				break;
			default:
				signOutUserManagementView.incorrectInputMessage();
			}
		}
	}

	private Member find(ArrayList<Member> memberList, String id) {
		for(Member m : memberList) {
			if(m.getId().equals(id)) {
				return m;
			}
		}
		return null;
	}


}
