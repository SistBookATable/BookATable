package com.test.java.controller;

import com.test.java.model.Member;
import com.test.java.model.User;
import com.test.java.repository.Data;
import com.test.java.repository.MemberRepository;
import com.test.java.view.PointChargingView;
import com.test.java.view.View;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class PointChargingController {
	
	public void pointCharging() {
		
		PointChargingView pointChargingView = new PointChargingView();		 
		
		int amountCharging = PointChargingView.getAmountCharging();
		String pw = PointChargingView.getPw();		
		
		String userId = Member.id;
		User currentUser = (User) MemberRepository.findOneById(userId);	
		
		currentUser.setBalance(currentUser.getBalance() + amountCharging);

		pointChargingView.showPointCharging(amountCharging);
		
	}
}
