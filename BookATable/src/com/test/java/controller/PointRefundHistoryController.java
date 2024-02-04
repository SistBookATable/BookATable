package com.test.java.controller;

import com.test.java.model.Member;
import com.test.java.model.User;
import com.test.java.repository.Data;
import com.test.java.view.PointManagementView;
import com.test.java.view.PointRefundHistoryView;
import com.test.java.view.View;

public class PointRefundHistoryController {

	private PointManagementController pointManagementController = new PointManagementController(); // PointManagementController의 인스턴스 생성
	
	
	public void pointRefundHistory() {
		
		PointRefundHistoryView pointRefundHistoryView = new PointRefundHistoryView(); 
		pointRefundHistoryView.showPointRefundHistory(findNameById(Member.id), findPointById(Member.id));
		
		String choice = "";
		while (true) {
			choice = pointRefundHistoryView.get().toUpperCase();
			if (choice.equals("Y")) {
				System.out.println("환불 신청이 취소되었습니다. 포인트 관리 메뉴로 돌아갑니다.");
				pointManagementController.pointManagement(); 
				break; 
			} else if (choice.equals("N")) {
				return;
			} else {
				System.out.println("잘못된 입력입니다. ");
				
			}
		
		}
		
	}

	private String findNameById(String id) {
		String userName = "";
		for (Member u : Data.memberList) {
			if (u.getId().equals(id)) {
				userName = u.getName();
				break;
			}
		}
		return userName;
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
