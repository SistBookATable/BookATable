package com.test.java.view;

import java.util.ArrayList;

import com.test.java.model.Member;
import com.test.java.model.PointUsage;
import com.test.java.model.Review;
import com.test.java.model.User;
import com.test.java.repository.Data;

public class PointUsageHistoryView {
	
	public static ArrayList<PointUsage> pointList = new ArrayList<>();
	
	public void showPointUsageHistoryView(String name) {
		
		System.out.println("------------------------------------------------------------------------------------------");
		System.out.println();
		System.out.printf("■           %s님 포인트 사용내역		   ■", name);
		System.out.println();
		System.out.println("------------------------------------------------------------------------------------------");
		System.out.println();
		
		
		String header = String.format("%10s%5s%10s%10s", "[사용일자]","[구분]","[포인트사용]","[보유포인트]");
		System.out.println(header);


		
		if(Data.pointList.isEmpty()) {
			System.out.println();
			System.out.println("■           포인트 사용내역이 없습니다.		   ■");
			System.out.println();
			View.pause();
		} else {
			for(PointUsage p : Data.pointList) {
				int userBalance = findBalanceById(p.getUserId()); // 보유포인트찾기
				String tmp = String.format("%10s%15s%10s%10s",
						p.getUseTime(),
						p.getContent(),
						p.getUsagePoint(),
						userBalance);

				System.out.println(tmp);
		


			}}
		
	}
	
	private int findBalanceById(String userId) {
		
		for(Member u : Data.memberList) {
			if(u.getId().equals(userId)) {
				if (u instanceof User) {
				return ((User)u).getBalance();
				}
			}
		}
		
		return 0;
	}
	
	private String findId(String userId) {
		for(PointUsage p : Data.pointList) {
			if (p.getUserId().equals(userId)) {
				return p.getUserId();
			}
		}
		return null;
	} 
	
		
}
