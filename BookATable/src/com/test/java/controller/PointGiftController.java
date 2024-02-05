package com.test.java.controller;

import java.util.Scanner;

import com.test.java.model.Member;
import com.test.java.model.User;
import com.test.java.repository.Data;
import com.test.java.view.PointGiftView;

public class PointGiftController {
	
	public void pointGift() {
		
		PointGiftView pointGiftView = new PointGiftView();
		
		String id = pointGiftView.getId(); // 사용자가 입력한 ID 
		int amountGift = pointGiftView.getAmountGift();
		String name = findNameById(id); // 사용자가 입력한 ID에 해당하는 이름 찾기 
		String result = pointGiftView.showPointGift(id, name);
		
		findNameById(Member.id);
		
		System.out.println(result);
		
		// 선물한 만큼 포인트 차감!! 
		String userId = Member.id;
		User currentUser = findUserById(userId);

		if (currentUser != null) {
			currentUser.setBalance(currentUser.getBalance() - amountGift);
		} else {
			System.out.println("포인트 선물 불가합니다.");
		}
		
		
		System.out.println("<<엔터를 입력하면, 이전 화면으로 이동합니다.>>");
		
		// 엔터 입력 대기
		waitForEnter();
		

		PointManagementController pointManagementController = new PointManagementController();
		pointManagementController.pointManagement();
	}

	private void waitForEnter() {
		Scanner scan = new Scanner(System.in);
		scan.nextLine();	
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
	
	private User findUserById(String userId) {
		for (Member member : Data.memberList) {
			if (member instanceof User && member.getId().equals(userId)) {
				return (User) member;
			}
		}
		return null;
	}

}
