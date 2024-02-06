package com.test.java.view;

import java.util.ArrayList;

import com.test.java.model.PointUsage;

public class PointUsageHistoryView {
	
	public static ArrayList<PointUsage> pointList = new ArrayList<>();
	
	public void showPointUsageHistoryView(String name, String useTime, String[] content, int usagePoint, int balance) {
		
		System.out.println("------------------------------------------------------------------------------------------");
		System.out.println();
		System.out.printf("■           %s님 포인트 사용내역		   ■", name);
		System.out.println();
		System.out.println("------------------------------------------------------------------------------------------");
		System.out.println();
		System.out.println("[사용일자]\t[구분]\t[포인트사용]\t[보유포인트]");
		System.out.printf("[%s]\t[%s]\t[%d]\t[%s]\n", useTime, content, usagePoint, balance);
			
	}
		
}
