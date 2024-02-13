package com.test.java.controller;

import com.test.java.model.Member;
import com.test.java.model.User;
import com.test.java.repository.Data;
import com.test.java.repository.MemberRepository;
import com.test.java.view.PointManagementView;

/**
 * 포인트 관리 기능을 제어하는 Controller 클래스입니다.
 */
public class PointManagementController {
	
	/**
	 * 포인트 관리 메뉴를 실행하는 메서드입니다.
	 */
	public void pointManagement() {
		boolean loop = true;
		
		while (loop) {
			
			User curUser = (User)MemberRepository.findOneById(Member.id);
			PointManagementView.showPointManagement(curUser.getName(), curUser.getAccount(), curUser.getBalance());
			int choice = PointManagementView.get();
			
			switch (choice) {
			// 포인트충전
			case 1 : PointChargingController pointChargingController = new PointChargingController();
					 pointChargingController.pointCharging();
					 break;
			// 포인트환불	
			case 2 : PointRefundController pointRefundController = new PointRefundController();
					 pointRefundController.pointRefund();
					 break;
			// 포인트선물	
			case 3 : PointGiftController pointGiftController = new PointGiftController();
					 pointGiftController.pointGift();
					 break;
			// 포인트사용내역
			case 4 : PointUsageHistoryController pointUsageHistoryController = new PointUsageHistoryController(); 
					 pointUsageHistoryController.pointUsageHistory();
					 break;
			// 이전화면	
			case 0 : 
				loop = false;
				break;
			}
		}

	}
}