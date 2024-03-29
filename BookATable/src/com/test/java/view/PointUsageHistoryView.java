package com.test.java.view;

import java.util.ArrayList;

import com.test.java.model.Member;
import com.test.java.model.PointUsage;
import com.test.java.model.Review;
import com.test.java.model.User;
import com.test.java.repository.Data;

/**
 * 포인트 사용 내역 조회를 담당하는 View 클래스입니다.
 */

public class PointUsageHistoryView {
	
	public static ArrayList<PointUsage> pointList = new ArrayList<>();
	
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

	/**
	 * 사용자의 포인트 사용 내역의 타이틀을 출력하는 메서드입니다.
	 * @param name 사용자 이름
	 */
	public void showTitle(String name) {
		
		System.out.println("------------------------------------------------------------------------------------------");
		System.out.println();
		System.out.printf("■           %s님 포인트 사용내역		   ■", name);
		System.out.println();
		System.out.println("------------------------------------------------------------------------------------------");
		System.out.println();
		
		
		String header = String.format("%10s\t    %5s\t%10s", "[사용일자]","[구분]","[포인트사용]");
		System.out.println(header);

		
	}



	/**
	 * 포인트 사용내역이 없을 때 출력하는 메서드입니다.
	 */
	public void noHistoryMessage() {
		System.out.println();
		System.out.println("■           포인트 사용내역이 없습니다.		   ■");
		System.out.println();
		View.pause();
	}



	/**
	 * 포인트 사용 내역을 출력하는 메서드입니다. 
	 * @param usageList 포인트 사용 내역 리스트
	 */
	public void showPointUsageHistoryView(ArrayList<PointUsage> usageList) {
		
		for(PointUsage p : usageList) {
			
			String tmp = String.format("%10s %15s %10s",
					p.getUseTime(),
					p.getContent(),
					p.getUsagePoint());

			System.out.println(tmp);
			
		}
		
		View.pause();
	} 
	
		
}
