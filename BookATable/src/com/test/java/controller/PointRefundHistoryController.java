
package com.test.java.controller;

import java.util.Calendar;
import java.util.Scanner;

import com.test.java.model.Member;
import com.test.java.model.PointRefund;
import com.test.java.model.PointUsage;
import com.test.java.model.User;
import com.test.java.repository.Data;
import com.test.java.repository.MemberRepository;
import com.test.java.repository.PointRepository;
import com.test.java.view.PointRefundHistoryView;

/**
 * 포인트 환불 내역 조회를 관리하는 Controller 클래스입니다. 
 */
public class PointRefundHistoryController {

	PointRefundHistoryView pointRefundHistoryView = new PointRefundHistoryView();
	
	/**
	 * 포인트 환불 내역 조회 및 환불 취소 메서드입니다. 
	 */
	public void pointRefundHistory() {
		
		String id = Member.id;
		User currentUser = (User)MemberRepository.findOneById(id);
		String userName = currentUser.getName();
		PointUsage usage = PointRepository.findLastRefundById(id);
		
		//환불 내역이 없을 때
		if(usage == null) {
			pointRefundHistoryView.noHistoryMessage();
			return;
		}
		
		String refundDate = usage.getUseTime();
		int pointAmount = usage.getUsagePoint();
		
		//환불 신청 내역 출력
		pointRefundHistoryView.showPointRefundHistory(userName, refundDate, pointAmount);
		
		Calendar cur = Calendar.getInstance();
		String today = String.format("%tF", cur);
		
		//환불신청 날짜가 당일이 아닌경우
		if(!today.equals(refundDate)) {
			pointRefundHistoryView.cannotCancelMessage();
			return;
		}
		
		
		pointRefundHistoryView.showSelectBox();
		String choice = pointRefundHistoryView.get();
		switch (choice.toUpperCase()) {
		case "Y" :
			currentUser.setBalance(currentUser.getBalance() + pointAmount);
			
			// 포인트 사용 내역에서 삭제
			PointRepository.delete(usage);

			pointRefundHistoryView.successMessage();
			
			break;
		case "N":
			pointRefundHistoryView.cancelMessage();
			break;
		default:
			pointRefundHistoryView.incorrectInputMessage();
			break;
		}
	}
		
	
}
