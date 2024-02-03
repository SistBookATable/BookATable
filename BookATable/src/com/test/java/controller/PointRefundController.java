package com.test.java.controller;

import com.test.java.view.PointRefundView;

public class PointRefundController {

	
	public void pointRefund() {
		
		PointRefundView pointRefundView = new PointRefundView(); 
		pointRefundView.showPointRefund();
		
		int choice = pointRefundView.get();
		
		switch(choice) {
		// 포인트 환불신청
		case 1: pointRefundView.showRefund();
				break;
		// 포인트 환불신청내역
		case 2: 
			break;
		case 0:
			break;

		}		
		
	}
	
	
}
