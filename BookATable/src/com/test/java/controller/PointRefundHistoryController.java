package com.test.java.controller;

import java.util.ArrayList;
import java.util.Scanner;

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
		String userName = findNameById(id);
		String refundDate = findRefundDateById(id); 
		int pointAmount = findPointAmountById(id); 
		
		PointRefundHistoryView pointRefundHistoryView = new PointRefundHistoryView();
		pointRefundHistoryView.showPointRefundHistory(userName, refundDate, pointAmount);
		
		String choice = pointRefundHistoryView.get();
		
		String userId = Member.id;
		User currentUser = findUserById(userId);
		
		
		if (currentUser != null) {
		
		if (choice.equalsIgnoreCase("Y")) {				
				currentUser.setBalance(currentUser.getBalance() + pointAmount);
				System.out.println("환불 신청이 취소되었습니다.");
			} else if (choice.equalsIgnoreCase("N")) {
			System.out.println("환불 취소 과정을 중단합니다.");
		} else {
			System.out.println("잘못된 입력입니다.");
		}
		
		
		}
		
		System.out.println("<<엔터를 입력하면, 이전 화면으로 이동합니다.>>");
		
		// 엔터 입력 대기
		waitForEnter();
		
		PointRefundController pointRefundController = new PointRefundController();
		pointRefundController.pointRefund();
		
		
		
	}
		
	
		private void waitForEnter() {
			Scanner scan = new Scanner(System.in);
			scan.nextLine();
		
	}


		private User findUserById(String userId) {
			for (Member member : Data.memberList) {
				if (member instanceof User && member.getId().equals(userId)) {
					return (User) member;
				}
			}
			return null;
		}
	
	
	
			
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

