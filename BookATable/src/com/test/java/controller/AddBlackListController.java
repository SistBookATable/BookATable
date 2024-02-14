package com.test.java.controller;


import com.test.java.model.BusinessUser;
import com.test.java.model.Member;
import com.test.java.repository.BlackListRepository;
import com.test.java.repository.MemberRepository;
import com.test.java.view.AddBlackListView;

/**
 * 사용자를 블랙리스트에 추가하는 컨트롤러 클래스입니다.
 */
public class AddBlackListController {

	 /**
	  * 사용자 인터페이스를 위한 AddBlackListView 인스턴스입니다.
	*/
	AddBlackListView addBlackListView = new AddBlackListView();
	
	
	/**
     * 사용자를 블랙리스트에 추가하는 프로세스를 처리하는 메서드입니다.
     */
	public void addBlackList() {
		
		boolean loop = true;
		while(loop) {

			// 사용자에게 선택 옵션을 표시합니다.
			addBlackListView.showSelectBox();
			
			// 사용자의 선택을 가져옵니다.
			int choice = addBlackListView.getSelectType();
		
			switch (choice) {
			case 1:
				// 현재 사용자의 라이센스 번호를 가져옵니다.
				String lisenceNumber = ((BusinessUser)MemberRepository.findOneById(Member.id)).getLicenseNumber();
				
				// 블랙리스트에 추가할 사용자의 ID를 입력 받습니다.
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
				
				// 사용자를 블랙리스트에 추가합니다.
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
