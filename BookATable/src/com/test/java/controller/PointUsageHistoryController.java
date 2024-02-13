package com.test.java.controller;

import java.util.ArrayList;
import java.util.Scanner;

import com.test.java.model.Member;
import com.test.java.model.PointUsage;
import com.test.java.model.User;
import com.test.java.repository.Data;
import com.test.java.repository.PointRepository;
import com.test.java.view.PointManagementView;
import com.test.java.view.PointUsageHistoryView;

/**
 * 포인트 사용 내역 조회를 담당하는 Controller 클래스입니다.
 */
public class PointUsageHistoryController {
	
	/**
	 * 포인트 사용 내역을 조회하는 메서드입니다.
	 */
	public void pointUsageHistory() {
		
		String userId = Member.id; 
		String name = findNameById(userId);	
		
		
		PointUsageHistoryView pointUsageHistoryView = new PointUsageHistoryView();
		//제목 출력
		pointUsageHistoryView.showTitle(name);
		
		//포인트 사용내역 조회
		ArrayList<PointUsage> usageList = PointRepository.findAllById(userId);
		
		//포인트 사용 내역이 없을 때
		if(usageList.isEmpty()) {
			pointUsageHistoryView.noHistoryMessage();
		}
		
		//모든 사용 내역 출력
		pointUsageHistoryView.showPointUsageHistoryView(usageList);
		
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
