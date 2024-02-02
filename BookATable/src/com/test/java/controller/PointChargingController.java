package com.test.java.controller;

import java.util.ArrayList;
import com.test.java.model.Member;
import com.test.java.model.PointCharging;
import com.test.java.repository.Data;
import com.test.java.view.PointChargingView;
import com.test.java.view.View;

public class PointChargingController {
	
	// 지금 모델에 대한 작업이 안됨 
	
	public void pointCharging() {
	
	PointCharging pointCharging = new PointCharging();
	PointChargingView pointChargingView = new PointChargingView();
	// addBalance(); checkPw() 구현 

	
	int amountCharging = pointChargingView.getAmountCharging();
	String pw = pointChargingView.getPw();
	
	
 
	pointChargingView.showPointCharging(amountCharging);
	
		
		
	
		
			
		}
		
		
	



}	