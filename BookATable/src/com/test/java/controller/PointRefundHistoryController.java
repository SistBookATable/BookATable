package com.test.java.controller;

import java.util.ArrayList;

import com.test.java.model.Member;
import com.test.java.model.PointRefund;
import com.test.java.model.PointUsage;
import com.test.java.model.User;
import com.test.java.repository.Data;
import com.test.java.view.PointManagementView;
import com.test.java.view.PointRefundHistoryView;
import com.test.java.view.View;

public class PointRefundHistoryController {


	public void pointRefundHistory() {
		
		String id = Member.id; 
		String name = findNameById(id);
		String refundDate = findRefundDateById(id); 
		int pointAmount = findPointAmountById(id); 
		
		PointRefundHistoryView pointRefundHistoryView = new PointRefundHistoryView();
		pointRefundHistoryView.showPointRefundHistory(name, refundDate, pointAmount); 
		
		
			
		private String findRefundDateById(String id) {
			String refundDate = "";
			for (PointRefund p : Data.pointRefundList) {
				if (p.getUserId().equals(Member.id)) {
						refundDate = p.getRefundDate(); 
						break;					
				}
			}	
			return refundDate;
		}
		

		private int findPointAmountById(String id) {
			int pointAmount = 0;
			for (PointRefund p : Data.pointRefundList) {
				if (p.getUserId().equals(Member.id)) {		
						pointAmount = p.getPointAmount();
							break;
					}
			}
			return pointAmount;
		}
	
		
		
	

		
//		
//		String choice = pointRefundHistoryView.get();
//		while (true) {
//			
//			if (choice.equalsIgnoreCase("Y")) {
//				System.out.println("환불 신청이 취소되었습니다. 포인트 관리 메뉴로 돌아갑니다.");
//				pointManagementController.pointManagement(); 
//				break; 
//			} else if (choice.equalsIgnoreCase("N")) {
//				break;
//			} else {
//				System.out.println("잘못된 입력입니다. ");
//				break;
//			}
//		
//		}
//		
//	}



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
	
	}	

