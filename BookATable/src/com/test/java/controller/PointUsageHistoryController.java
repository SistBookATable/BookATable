package com.test.java.controller;

import java.util.Scanner;

import com.test.java.model.Member;
import com.test.java.model.PointUsage;
import com.test.java.model.User;
import com.test.java.repository.Data;
import com.test.java.view.PointManagementView;
import com.test.java.view.PointUsageHistoryView;

public class PointUsageHistoryController {
	
	public void pointUsageHistory() {
		
		String userId = Member.id; 
		String name = findNameById(userId);	
		
		PointUsageHistoryView pointUsageHistoryView = new PointUsageHistoryView();
		pointUsageHistoryView.showPointUsageHistoryView(name);
		
		
		// 사용자가 엔터를 입력할 때까지 대기
		Scanner scan = new Scanner(System.in);
		System.out.println("<<엔터를 입력하면 이전 화면으로 이동합니다.>>");
		while (scan.nextLine().isEmpty()) {
		    PointManagementView pointManagementView = new PointManagementView();
		    pointManagementView.showPointManagement(findNameById(Member.id), findAccountById(Member.id), findPointById(Member.id));
		}
		
		
	}

	private int findPointById(String userId) {
		
		for(Member u : Data.memberList) {
			if(u.getId().equals(userId)) {
				return ((User)u).getBalance();
			}
		}
		
		return 0;
	}

	private String findAccountById(String userId) {
		
		for(Member u : Data.memberList) {
			if(u.getId().equals(userId)) {
				return u.getAccount();
			}
		}
		return null;
	}

	private String findNameById(String userId) {
		String name = "";
		for(Member u : Data.memberList) {
			if(u.getId().equals(userId)) {
				return u.getName();
			}
		}
		return null;	
	}
	
	

}
