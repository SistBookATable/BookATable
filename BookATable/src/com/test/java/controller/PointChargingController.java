package com.test.java.controller;

import com.test.java.model.Member;
import com.test.java.model.User;
import com.test.java.repository.Data;
import com.test.java.view.PointChargingView;
import com.test.java.view.View;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class PointChargingController {
	
	public void pointCharging() {
		
		 PointChargingView pointChargingView = new PointChargingView();		 
		
		int amountCharging = PointChargingView.getAmountCharging();
		String pw = PointChargingView.getPw(); // TODO 유효성 검사
		
		String userId = Member.id;
		User currentUser = findUserById(userId);

		if (currentUser != null) {
			// 보유 포인트 충전값만큼 추가
			currentUser.setBalance(currentUser.getBalance() + amountCharging);
		} else {
			System.out.println("포인트 추가 불가");
		}
	
		String result = pointChargingView.showPointCharging(amountCharging); 
		System.out.println(result);
		
		System.out.println("<<엔터를 입력하면, 이전 화면으로 이동합니다.>>");
		
		// 엔터 입력 대기
		waitForEnter();
		
		PointManagementController pointManagementController = new PointManagementController();
		pointManagementController.pointManagement();
	}

	private User findUserById(String userId) {
		for (Member member : Data.memberList) {
			if (member instanceof User && member.getId().equals(userId)) {
				return (User) member;
			}
		}
		return null;
	}

	private void waitForEnter() {
		Scanner scan = new Scanner(System.in);
		scan.nextLine();
		
	}
	
}
