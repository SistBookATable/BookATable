package com.test.java.controller;

import java.util.Calendar;
import java.util.Scanner;

import com.test.java.model.Member;
import com.test.java.model.PointRefund;
import com.test.java.model.User;
import com.test.java.repository.Data;
import com.test.java.repository.MemberRepository;
import com.test.java.repository.PointRepository;
import com.test.java.view.PointRefundView;

public class PointRefundController {

	public void pointRefund() {

		PointRefundView pointRefundView = new PointRefundView();


		String userId = Member.id;
		User currentUser = (User) MemberRepository.findOneById(userId);

		Scanner scan = new Scanner(System.in);

		boolean loop = true;

		while (loop) {

			pointRefundView.showPointRefund();
			int choice = pointRefundView.get();
			
			switch (choice) {
			// 포인트 환불신청
			case 1:
				
				if (currentUser.getBalance() != 0) {

					int balance = currentUser.getBalance();
					Calendar cur = Calendar.getInstance();
					String today = String.format("%tF", cur);
					
					// 보유 포인트 0
					currentUser.setBalance(currentUser.getBalance() - currentUser.getBalance());
					
					// 환불 완료 메시지
					pointRefundView.showRefund();
					
					// 포인트 사용 내역에 추가
					PointRepository.addOne(balance, today, "포인트환불신청" , userId);

					
				} else {
					System.out.println("환불 가능한 포인트가 존재하지 않습니다.");
					
				}
				break;
			// 포인트 환불신청내역
			case 2:
				PointRefundHistoryController pointRefundHistoryController = new PointRefundHistoryController();
				pointRefundHistoryController.pointRefundHistory();
				break;

			case 0:
				loop = false;
				break;

			}
		}
	}

}
