package com.test.java.controller;

import com.test.java.model.Member;
import com.test.java.repository.Data;
import com.test.java.view.UserMyPageView;

/**
 * 사용자 마이페이지를 관리하는 컨트롤러 클래스입니다.
 */
public class UserMyPageController {
	
	/**
     * 사용자 마이페이지를 표시하고 사용자의 선택에 따라 다양한 기능을 수행합니다.
     */
	public void userMyPage() {
		boolean loop = true;
		while (loop) {
			UserMyPageView.showUserMyPage();	// 사용자 마이페이지를 보여주는 메서드 호출
			int choice = UserMyPageView.get();	// 사용자의 선택을 입력받는 메서드 호출

			// 회원 탈퇴 여부를 확인하는 메서드를 호출하고 결과에 따라 loop 변수 설정
			if (!findSignOutById(Member.id).equals("null")) {
				loop = true;
			} else {
				loop = false;
			}
		
			switch (choice) {
			case 1:
				//예약 관리
				ReservationManagementController reservationManagementController = new ReservationManagementController(); 
				reservationManagementController.reservationManagement();
				break;
			case 2:
				//포인트 관리
				PointManagementController pointManagementController = new PointManagementController();
				pointManagementController.pointManagement();
				break;
			case 3:
				//관심매장 관리
				FavouriteStoreManagementController favouriteStoreManagementController = new FavouriteStoreManagementController();
				favouriteStoreManagementController.favouriteStoreManagement();
				break;

			case 4:
				//개인정보 관리
				UserInformationManagementController userInformationManagementController = new UserInformationManagementController() ;
				userInformationManagementController.userInformationManagement();
				break;

			case 5:
				//회원 탈퇴
				UserCancellationController userCancellationController = new UserCancellationController();
				userCancellationController.UserCancellation();
				break;
			case 6:
				//FAQ 조회
				FaqController faqController = new FaqController();
				faqController.faqController();
				break;

			case 0:
				break;
			
			}
			loop = false;
		}

	}
	
	 /**
     * 주어진 아이디에 해당하는 회원의 탈퇴 여부를 확인합니다.
     * @param id 확인하려는 회원의 아이디
     * @return 회원의 탈퇴 여부를 나타내는 문자열. 탈퇴한 경우 "null"을 반환합니다.
     */
	private String findSignOutById(String id) {
		for(Member u : Data.memberList) {
			if (u.getId().equals(id)) {
				return u.getSignOut();
			}
		}
		
		return null;
	}

}
