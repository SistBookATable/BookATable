package com.test.java.controller;

import com.test.java.model.BusinessUser;
import com.test.java.model.Member;
import com.test.java.repository.BlackListRepository;
import com.test.java.repository.MemberRepository;
import com.test.java.view.AddBlackListView;

public class AddBlackListController {

	AddBlackListView addBlackListView = new AddBlackListView();
	
	public void addBlackList() {
		
		boolean loop = true;
		while(loop) {

			addBlackListView.showSelectBox();
			int choice = addBlackListView.getSelectType();
		
			switch (choice) {
			case 1:
				
				String lisenceNumber = ((BusinessUser)MemberRepository.findOneById(Member.id)).getLicenseNumber();
				
				addBlackListView.showUserIdInputBox();
				String id = addBlackListView.getUserId();
				
				//블랙리스트 등록 취소
				if(id.equals("0")) {
					return;
				}
				
				//이미 블랙리스트 일 때
				if(BlackListRepository.findOne(lisenceNumber, id)) {
					addBlackListView.alreadyBlackListMessage();
					continue;
				}
				
				//아이디가 존재하지 않을 때
				if(MemberRepository.findOneById(id)==null) {
					addBlackListView.incorrectUserIDMessage();
					continue;
				}
				
				
				BlackListRepository.addOne(lisenceNumber, id);
				addBlackListView.successMessage();
				
			case 0:
				loop = false;
				break;
			default:
				addBlackListView.incorrectInputMessgae();
			}
		}
		
		
	}

}
