package com.test.java.controller;

import java.util.Scanner;

import com.test.java.model.Member;
import com.test.java.model.User;
import com.test.java.repository.Data;
import com.test.java.view.PointRefundHistoryView;
import com.test.java.view.PointRefundView;

public class PointRefundController {

	
	public void pointRefund() {
		
		PointRefundView pointRefundView = new PointRefundView(); 
		pointRefundView.showPointRefund();
		
		int choice = pointRefundView.get();
		Scanner scan = new Scanner(System.in);
		
		boolean loop = true;
		
		while(loop) {
		
		switch(choice) {
		// 포인트 환불신청
		case 1: pointRefundView.showRefund();
				// 엔터 입력 시 이전 화면으로 이동
				if (scan.nextLine().isEmpty()) {
					return;
				}
				break;
		// 포인트 환불신청내역
		case 2: PointRefundHistoryController pointRefundHistoryController = new PointRefundHistoryController();
				pointRefundHistoryController.pointRefundHistory();
			break;
			
		case 0:
			break;

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
