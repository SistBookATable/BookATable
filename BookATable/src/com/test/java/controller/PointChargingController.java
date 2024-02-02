package com.test.java.controller;

import java.util.ArrayList;
import com.test.java.model.Member;
import com.test.java.repository.Data;
import com.test.java.view.PointChargingView;
import com.test.java.view.View;

public class PointChargingController {
	
	public void pointCharging() {
		
		boolean loop = true;
		
		while(loop) {
			
			ArrayList<String> input = PointChargingView.getInput();
			//입력된 값을 가져온다
			int inputPrice = 0;
			
			// 입력된 금액이 숫자인지 검증
			try {
				inputPrice = Integer.parseInt(input.get(0));
				
			} catch (NumberFormatException e) {
				System.out.println("잘못된 입력입니다.");
				continue;
			}
			
			String inputPw = input.get(1);
			//비밀번호 검증을 위한 메서드 호출
			loop = !checkPointCharging(inputPrice, inputPw);
			
			View.pause();
			
		}
	
	}	
	//비밀번호 검증 
	private boolean checkPointCharging(int inputPrice, String inputPw) {
		

		
		for (Member u : Data.memberList) {
			if (inputPw.equals(u.getPw())) {
				System.out.println("포인트 충전이 완료되었습니다.");
				return true;
				
			} 
		}
		
			// 비밀번호가 일치하지 않는 경우 
			System.out.println("비밀번호가 일치하지 않습니다.");
			return false;
			
		}	
	
	}
