package com.test.java.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import com.test.java.model.Member;
import com.test.java.model.User;
import com.test.java.repository.Data;
import com.test.java.repository.MemberRepository;
import com.test.java.repository.PointRepository;
import com.test.java.view.PointGiftView;
import com.test.java.view.View;

/**
 * 포인트를 선물하는 기능을 관리하는 Controller 클래스입니다.
 */

public class PointGiftController {

	/**
	 * 포인트를 선물하는 기능의 메서드입니다.
	 */
	public void pointGift() {
		
		PointGiftView pointGiftView = new PointGiftView();
		
		//선물할 사람 ID
		String user = Member.id;
		User currentUser = (User)MemberRepository.findOneById(user);
		
		// 사용자가 입력한 ID
		String id = pointGiftView.getId(); // 사용자가 입력한 ID
		
		// 선물받을 ID에 해당하는 user 찾기
		User other = (User)MemberRepository.findOneById(id);

		// 선물받을 user가 탈퇴 회원일 때
		ArrayList<Member> signOutUsers = MemberRepository.findAllSingOutUser();
		
		boolean isSignOutUser = signOutUsers.contains(other);
		
		if (isSignOutUser) {
			pointGiftView.withDrawal();
			return;
		} 
		//선물할 금액 입력
		int amountGift = pointGiftView.getAmountGift();
		
		//입력한 금액이 현재 잔액보다 많을 때 메시지 출력하고 return;
		if(amountGift > currentUser.getBalance()) {
			pointGiftView.overAmount();
			return;
		}
		
		// 사용자가 입력한 ID에 해당하는 이름 
		String name = other.getName(); 

		// 나의 현재 포인트 감소
		currentUser.setBalance(currentUser.getBalance() - amountGift);
		
		//user(받는 사람) 포인트 증가
		other.setBalance(other.getBalance() + amountGift);
		
		//pointList에 추가 PointRepository.add()
		// 	포인트 사용 내역에 추가
		
		int balance = currentUser.getBalance();
		Calendar cur = Calendar.getInstance();
		String today = String.format("%tF", cur);
		
		PointRepository.addOne(balance, today, "포인트선물" , user);
		
		
		//완료 메시지 출력

		pointGiftView.showPointGift(name);
				
	}

}
