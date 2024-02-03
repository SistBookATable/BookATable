package com.test.java.controller;

import java.util.ArrayList;
import com.test.java.model.Member;
import com.test.java.model.PointCharging;
import com.test.java.model.User;
import com.test.java.repository.Data;
import com.test.java.view.PointChargingView;
import com.test.java.view.View;

public class PointChargingController {
	
	public static boolean pointCharging() {
		
		int amountCharging = PointChargingView.getAmountCharging();
		String pw = PointChargingView.getPw();
		
		//유효성 검사
		
		System.out.println("포인트 충전이 완료되었습니다.");
		
//      충전포인트 > 보유포인트 추가 작업 필요..
//		Data.memberList.add(amountCharging, null);
		
	
		View.pause();
		
		return true;
	
	}
		
}

