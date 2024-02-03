package com.test.java.controller;

import com.test.java.model.Member;
import com.test.java.model.User;
import com.test.java.repository.Data;
import com.test.java.view.PointManagementView;
import com.test.java.view.PointRefundHistoryView;
import com.test.java.view.View;

public class PointRefundHistoryController {

	public void pointRefundHistory() {
		
		PointRefundHistoryView pointRefundHistoryView = new PointRefundHistoryView(); 
		pointRefundHistoryView.showPointRefundHistory(findNameById(Member.id), findPointById(Member.id));
		
		
	
		boolean loop = true;
		
		while (loop) {
			if (PointRefundHistoryView.get().equalsIgnoreCase("Y")) {
				System.out.println("환불 신청이 취소되었습니다.");
				View.pause();
				loop = false;
				
			} else {
				View.pause();
				loop = false;
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
