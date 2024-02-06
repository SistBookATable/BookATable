package com.test.java.controller;

import java.util.Scanner;

import com.test.java.model.Member;
import com.test.java.model.PointRefund;
import com.test.java.model.User;
import com.test.java.repository.Data;
import com.test.java.view.PointRefundHistoryView;

public class PointRefundHistoryController {
	
	public void pointRefundHistory() {
		
		String id = Member.id;
		String userName = findNameById(Member.id);
		String refundDate = findRefundDateById(Member.id);
		int pointAmount = findPointAmountById(Member.id);
		User currentUser = findUserById(Member.id);
		
		PointRefundHistoryView pointRefundHistoryView = new PointRefundHistoryView();
		pointRefundHistoryView.showPointRefundHistory(userName, refundDate, pointAmount);
		
		String choice = pointRefundHistoryView.get();
		
		//

		
		if (choice.equalsIgnoreCase("Y")) {
			if (currentUser != null) {
				currentUser.setBalance(currentUser.getBalance() + pointAmount);
				System.out.println("환불 신청이 취소되었습니다.");
			} else if (choice.equalsIgnoreCase("N")) {
			System.out.println("환불 취소 과정을 중지합니다.");
		} else {
			System.out.println("잘못된 입력입니다.");
		}}
		
		System.out.println("<<엔터를 입력하면, 이전 화면으로 이동합니다>>");
		
		// 엔터 입력 대기
		waitForEnter();
		// 이동
		PointRefundController pointRefundController = new PointRefundController();
		pointRefundController.pointRefund();
		
	}

	private User findUserById(String id) {
		for (Member member : Data.memberList) {
			if (member instanceof User && member.getId().equals(id)) {
				return (User) member;
			}
		}
		return null;
	}

	private void waitForEnter() {
		Scanner scan = new Scanner(System.in);
		scan.nextLine();		
	}

	private int findPointAmountById(String id) {
		int pointAmount = 0;
		for (PointRefund p : Data.pointRefundList) {
			if (p.getUserId().equals(Member.id)) {
				return p.getPointAmount();
			}
		}
		return 0;
	}

	private String findRefundDateById(String id) {
		String refundDate = "";
		for (PointRefund p : Data.pointRefundList) {
			if (p.getUserId().equals(Member.id)) {
				return p.getRefundDate();
			}
		}
		return null;
	}

	private String findNameById(String id) {
		String userName = "";
		for (Member u : Data.memberList) {
			if (u.getId().equals(id)) {
				return u.getName();
				
				}
			}
		return null;
	}
	
}