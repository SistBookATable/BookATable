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
		
		PointUsageHistoryController pointUsageHistoryController = new PointUsageHistoryController();
		String id = Member.id; // 사용자 ID 지정..
		String name = pointUsageHistoryController.findNameById(id);
		String useTime = pointUsageHistoryController.findUseTimeById(id);//사용시간 가져오기
		String[] content = pointUsageHistoryController.findContentById(id); // 내역 
		int usagePoint = pointUsageHistoryController.findUsagePointById(id); // 사용포인트 
		int balance = pointUsageHistoryController.findPointById(id); // 보유포인트 

		
		
		PointUsageHistoryView pointUsageHistoryView = new PointUsageHistoryView();
		pointUsageHistoryView.showPointUsageHistoryView(name, useTime, content, usagePoint, balance);
		
		findNameById(Member.id);
		
		// 사용자가 엔터를 입력할 때까지 대기
		Scanner scan = new Scanner(System.in);
		System.out.println("<<엔터를 입력하면 이전 화면으로 이동합니다.>>");
		while (scan.nextLine().isEmpty()) {
		    PointManagementView pointManagementView = new PointManagementView();
		    pointManagementView.showPointManagement(findNameById(Member.id), findAccountById(Member.id), findPointById(Member.id));
		}
		
		
	}

	private int findPointById(String id) {
		
		for(Member u : Data.memberList) {
			if(u.getId().equals(id)) {
				return ((User)u).getBalance();
			}
		}
		
		return 0;
	}

	private String findAccountById(String id) {
		
		for(Member u : Data.memberList) {
			if(u.getId().equals(id)) {
				return u.getAccount();
			}
		}
		return null;
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
	
	
	private String findUseTimeById(String id) {
		String useTime = "";
		for (PointUsage u : Data.pointList) {
			if (u.getUserId().equals(id)) {
				return u.getUseTime();
			}
		}
		return null;
	}
	
	private int findUsagePointById(String id) {
		int usagePoint = 0;
		for (PointUsage u : Data.pointList) {
			if (u.getUserId().equals(id)) {
				return u.getUsagePoint();
			}
		}
		return 0;
	}
	
	private String[] findContentById(String id) {
		String content = "";
		for (PointUsage u : Data.pointList) {
			if (u.getUserId().equals(id)) {
				return u.getContent();
			}
		}
		return null;
	}
	
	

}
