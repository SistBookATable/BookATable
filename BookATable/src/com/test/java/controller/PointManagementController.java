package com.test.java.controller;

import com.test.java.model.Member;
import com.test.java.model.User;
import com.test.java.repository.Data;
import com.test.java.view.PointChargingView;
import com.test.java.view.PointManagementView;

public class PointManagementController {
	
	public void pointManagement() {
		PointManagementView pointManagementView = new PointManagementView();
		PointManagementView.showPointManagement(findNameById(Member.id), findAccountById(Member.id), findPointById(Member.id));
		int choice = PointManagementView.get();
		
		findNameById(Member.id);
		findAccountById(Member.id);
		findPointById(Member.id);
		
		boolean loop = true;
		
		while (loop) {
			//
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
			case 0 : loop = false;
					
				
			}
			
		}


}
	private String findNameById(String id) {
		
		
		String name = "";
		
		for(Member u : Data.memberList) {
			if(u.getId().equals(id)) {
				return u.getName();
			}
		}
		return null;
	}
	
	
	private String findAccountById(String id)  {
		
		for(Member u : Data.memberList) {
			if(u.getId().equals(id)) {
				return u.getAccount();
				
			}
		}
		return null;
	}
	
	private int findPointById(String id)  {
		
		for(Member u : Data.memberList) {
			if(u.getId().equals(id)) {
				return ((User)u).getBalance();
			}
		}
		return 0;
	}
	
	
	
}
