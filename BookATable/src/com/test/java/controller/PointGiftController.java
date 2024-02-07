package com.test.java.controller;

import java.util.Scanner;

import com.test.java.model.Member;
import com.test.java.model.User;
import com.test.java.repository.Data;
import com.test.java.repository.MemberRepository;
import com.test.java.view.PointGiftView;

public class PointGiftController {

	PointGiftView pointGiftView = new PointGiftView();
	
	public void pointGift() {
		
		//선물할 사람 id입력
		String id = pointGiftView.getId(); // 사용자가 입력한 ID
		
		//선물할 금액 입력
		int amountGift = pointGiftView.getAmountGift();
		
		//입력한 금액이 현재 잔액보다 많을 때 메시지 출력하고 return;
		
		//id에 해당하는 user찾기
		User user = (User)MemberRepository.findOneById(id);
		
		//user가 탈퇴 회원일 때 잘못된 아이디 입니다. return;
		
		//
		String name = user.getName(); // 사용자가 입력한 ID에 해당하는 이름 찾기
		
		//현재 로그인한 회원 Member.id 나 찾기
		
		//내 현재 포인트 감소
		
		//user(받는 사람) 포인트 증가
		
		//pointList 에 추가 PointRepository.add()
		
		//완료 메시지 출력
		
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
