package com.test.java.controller;

import java.util.ArrayList;
import com.test.java.model.Member;
import com.test.java.model.PointCharging;
import com.test.java.model.User;
import com.test.java.repository.Data;
import com.test.java.view.PointChargingView;
import com.test.java.view.View;
import java.util.Scanner;

public class PointChargingController {
	
//	private PointChargingView pointChargingView;

	
	
	public void pointCharging() {
		
		 PointChargingView pointChargingView = new PointChargingView(); // PointChargingView 인스턴스 생성
		 
		
		int amountCharging = PointChargingView.getAmountCharging();
		String pw = PointChargingView.getPw();
		String result = pointChargingView.showPointCharging(amountCharging);
		
// TODO 유효성 검사
		
//      충전포인트 > 보유포인트 추가 작업 필요..
//		Data.memberList.add(amountCharging, null);
		
	System.out.println(result);
	
	// PointManagement로
	PointManagementController pointManagementController = new PointManagementController();
	pointManagementController.pointManagement();
		
	}
		
}

